import { Component, inject } from '@angular/core';
import { LabseqService } from '../../services/labseq.service';
import { CommonModule } from '@angular/common'; 
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-labseq-tester',
  templateUrl: './labseq-tester.component.html',
  styleUrls: ['./labseq-tester.component.css'],
  standalone: true,
  imports: [CommonModule, FormsModule],
})
export class LabseqTesterComponent {
  inputNumber: number = 0;
  result: string | null = null;
  error: string | null = null;

  private labseqService = inject(LabseqService);

  getCalcLabseq(): void {
    // Validação para garantir que o número é maior ou igual a 0
    if (this.inputNumber < 0) {
      this.error = 'Por favor, insira um número maior ou igual a 0.';
      this.result = null; // Limpa o resultado caso haja erro
      return;
    }

    this.error = null; // Limpa qualquer erro anterior
    this.result = null; // Limpa o resultado anterior

    // Chamada ao serviço para realizar o cálculo
    this.labseqService.getCalcLabseq(this.inputNumber).subscribe(
      (res: any) => {
        this.result = `Resultado: ${res.value}`;
      },
      (err) => {
        this.error = 'Ocorreu um erro ao calcular.';
      }
    );
  }
}
