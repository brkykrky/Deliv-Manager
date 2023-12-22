import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { deliverer } from '../Interfaces/deliverer';
import { environment } from '../../environments/environment';


@Injectable({
  providedIn: 'root'
})

export class delivererService {
  

  constructor(private http: HttpClient) { }

  createdeliverer(deliverer: unknown): Observable<unknown> {
   

    return this.http.post<unknown>(`${environment.apiUrl}/deliverer`, deliverer);
  }

  getAlldeliverers(): Observable<deliverer[]> {
   

    return this.http.get<deliverer[]>(`${environment.apiUrl}/deliverer/all`);
  }

  getdelivererById(id: number): Observable<deliverer> {
   

    return this.http.get<deliverer>(`${environment.apiUrl}/deliverer/${id}`);
  }

  updatedeliverer(id: number, updates: unknown): Observable<deliverer> {
   

    return this.http.put<deliverer>(`${environment.apiUrl}/deliverer/${id}`, updates);
  }

  deletedeliverer(id: number): Observable<void> {
   

    return this.http.delete<void>(`${environment.apiUrl}/deliverer/${id}`);
  }

  searchdeliverers(searchParams: unknown): Observable<deliverer[]> {
   

    // Envoyez les paramètres de recherche à votre API
    return this.http.post<deliverer[]>(`${environment.apiUrl}/deliverer/search`, searchParams);
  }

  assignTour(delivererId: number, tourId: number): Observable<deliverer> {
   

    return this.http.post<deliverer>(`${environment.apiUrl}/deliverer/${delivererId}/assign-tour/${tourId}`, {});
  }
}
