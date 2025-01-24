package org.acme;

/**
 * Interface responsável por definir o contrato para o cálculo da sequência Labseq.
 */
public interface SequenceService {

    /**
     * Calcula o valor correspondente na sequência Labseq.
     * A sequência é definida como: l(n) = l(n-4) + l(n-3), com os primeiros valores fixos.
     *
     * @param n índice da sequência a ser calculado (deve ser >= 0)
     * @return valor da sequência correspondente ao índice fornecido
     * @throws IllegalArgumentException se o índice for negativo
     */
    long calculateLabseq(int n);

}
