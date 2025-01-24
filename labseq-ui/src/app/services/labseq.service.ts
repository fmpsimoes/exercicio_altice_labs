import { inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})

export class LabseqService {
  private http: HttpClient = inject(HttpClient);

  private apiUrl = 'http://localhost:8080/labseq';

  constructor() {}

  getCalcLabseq(n: number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/${n}`);
  }
}
