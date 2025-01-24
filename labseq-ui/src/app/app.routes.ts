import { Routes } from '@angular/router';
import { LabseqTesterComponent } from './components/labseq-tester/labseq-tester.component';

export const routes: Routes = [
  { path: '', redirectTo: '/labseq', pathMatch: 'full' },
  { path: 'labseq', component: LabseqTesterComponent },
];
