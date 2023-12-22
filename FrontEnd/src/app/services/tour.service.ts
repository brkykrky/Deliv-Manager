import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { tour } from '../Interfaces/tour';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class DeliveryTourService {

  constructor(private http: HttpClient) { }

  createTour(tour: tour): Observable<tour> {
    return this.http.post<tour>(`${environment.apiUrl}`, tour)
      .pipe(
        catchError(this.handleError)
      );
  }

  gettour(id: number): Observable<tour> {
    return this.http.get<tour>(`${environment.apiUrl}/${id}`)
      .pipe(
        catchError(this.handleError)
      );
  }

  getAlltours(): Observable<tour[]> {
    return this.http.get<tour[]>(`${environment.apiUrl}/all`)
      .pipe(
        catchError(this.handleError)
      );
  }

  updatetour(id: number, updatedtour: tour): Observable<tour> {
    return this.http.patch<tour>(`${environment.apiUrl}/${id}`, updatedtour)
      .pipe(
        catchError(this.handleError)
      );
  }

  searchtours(searchCriteria: tour): Observable<tour[]> {
    return this.http.post<tour[]>(`${environment.apiUrl}/search`, searchCriteria)
      .pipe(
        catchError(this.handleError)
      );
  }

  assignDeliveryTotour(id: number, addDeliveryDTO: tour): Observable<tour> {
    return this.http.post<tour>(`${environment.apiUrl}/${id}/assign-delivery`, addDeliveryDTO)
      .pipe(
        catchError(this.handleError)
      );
  }

  searchtoursByDate(searchCriteria: tour): Observable<tour[]> {
    return this.http.post<tour[]>(`${environment.apiUrl}/search-by-date`, searchCriteria)
      .pipe(
        catchError(this.handleError)
      );
  }

  private handleError(error: unknown) {
    console.error(error);
    return throwError(error);
  }
}
