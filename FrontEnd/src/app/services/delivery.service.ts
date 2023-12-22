import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { delivery } from '../Interfaces/delivery';

@Injectable({
  providedIn: 'root'
})
export class deliveryService {

  constructor(private http: HttpClient) { }

  createdelivery(delivery: delivery): Observable<delivery> {
    return this.http.post<delivery>(`/api`, delivery)
      .pipe(
        catchError(this.handleError)
      );
  }

  getdelivery(id: number): Observable<delivery> {
    return this.http.get<delivery>(`/api/${id}`)
      .pipe(
        catchError(this.handleError)
      );
  }

  getAllDeliveries(): Observable<delivery[]> {
    return this.http.get<delivery[]>(`/api/all`)
      .pipe(
        catchError(this.handleError)
      );
  }

  updatedelivery(id: number, updateddelivery: delivery): Observable<delivery> {
    return this.http.patch<delivery>(`/api/${id}`, updateddelivery)
      .pipe(
        catchError(this.handleError)
      );
  }

  deletedelivery(id: number): Observable<void> {
    return this.http.delete<void>(`/api/${id}`)
      .pipe(
        catchError(this.handleError)
      );
  }


  private handleError(error: unknown) {
    console.error(error);
    return throwError(error);
  }
}
