import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { tour } from '../Interfaces/tour';

@Injectable({
  providedIn: 'root'
})
export class DeliveryTourService {
  private apiURL = 'http://localhost:8080/api/delivery-tour';

  constructor(private http: HttpClient) { }

  createTour(tour: tour): Observable<tour> {
    return this.http.post<tour>(`${this.apiURL}`, tour)
      .pipe(
        catchError(this.handleError)
      );
  }

  gettour(id: number): Observable<tour> {
    return this.http.get<tour>(`${this.apiURL}/${id}`)
      .pipe(
        catchError(this.handleError)
      );
  }

  getAlltours(): Observable<tour[]> {
    return this.http.get<tour[]>(`${this.apiURL}/all`)
      .pipe(
        catchError(this.handleError)
      );
  }

  updatetour(id: number, updatedtour: tour): Observable<tour> {
    return this.http.patch<tour>(`${this.apiURL}/${id}`, updatedtour)
      .pipe(
        catchError(this.handleError)
      );
  }

  searchtours(searchCriteria: tour): Observable<tour[]> {
    return this.http.post<tour[]>(`${this.apiURL}/search`, searchCriteria)
      .pipe(
        catchError(this.handleError)
      );
  }

  assignDeliveryTotour(id: number, addDeliveryDTO: tour): Observable<tour> {
    return this.http.post<tour>(`${this.apiURL}/${id}/assign-delivery`, addDeliveryDTO)
      .pipe(
        catchError(this.handleError)
      );
  }

  searchtoursByDate(searchCriteria: tour): Observable<tour[]> {
    return this.http.post<tour[]>(`${this.apiURL}/search-by-date`, searchCriteria)
      .pipe(
        catchError(this.handleError)
      );
  }

  private handleError(error: unknown) {
    console.error(error);
    return throwError(error);
  }
}
