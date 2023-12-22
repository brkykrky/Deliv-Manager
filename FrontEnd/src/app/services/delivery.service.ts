import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { delivery } from '../Interfaces/delivery';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';


@Injectable({
  providedIn: 'root'
})
export class deliveryService {

  constructor(private http: HttpClient) { }

  createdelivery(delivery: delivery): Observable<delivery> {
    return this.http.post<delivery>(`${environment.apiUrl}/api`, delivery)
      .pipe(
        catchError(this.handleError)
      );
  }

  getdelivery(id: number): Observable<delivery> {
    return this.http.get<delivery>(`${environment.apiUrl}/api/${id}`)
      .pipe(
        catchError(this.handleError)
      );
  }

  getAllDeliveries(): Observable<delivery[]> {
    return this.http.get<delivery[]>(`${environment.apiUrl}/api/all`)
      .pipe(
        catchError(this.handleError)
      );
  }

  updatedelivery(id: number, updateddelivery: delivery): Observable<delivery> {
    return this.http.patch<delivery>(`${environment.apiUrl}/api/${id}`, updateddelivery)
      .pipe(
        catchError(this.handleError)
      );
  }

  deletedelivery(id: number): Observable<void> {
    return this.http.delete<void>(`${environment.apiUrl}/api/${id}`)
      .pipe(
        catchError(this.handleError)
      );
  }


  private handleError(error: unknown) {
    console.error(error);
    return throwError(error);
  }
}
