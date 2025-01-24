package org.acme;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
/*
 * Implementação do serviço de cálculo da sequência Labseq.
 * Armazena os valores já calculados para otimizar futuras consultas.
 * Garantido como thread-safe pelo uso do modificador synchronized.
 */
public class SequenceServiceImpl implements SequenceService {

    // Lista para armazenar os valores calculados da sequência Labseq.
    // Declarada como 'final' para impedir a reatribuição da referência, 
    private final List<Long> sequence;

    /**
     * Construtor que inicializa os valores base da sequência Labseq.
     */
    public SequenceServiceImpl() {
        sequence = new ArrayList<>(Arrays.asList(0L, 1L, 0L, 1L, 1L));
    }

    @Override
    public synchronized long calculateLabseq(int n) {

        // Valida se o índice é negativo e lança uma exceção apropriada
        if (n < 0) {
            throw new IllegalArgumentException("Input cannot be negative");
        }
        // Expande a lista até o tamanho necessário para incluir o índice 'n'.
        while (sequence.size() <= n) {
            sequence.add(sequence.get(sequence.size() - 4) + sequence.get(sequence.size() - 3));
        }

        return sequence.get(n);
    }
    
}
