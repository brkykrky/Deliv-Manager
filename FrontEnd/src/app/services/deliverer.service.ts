import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { deliverer } from '../Interfaces/deliverer';

@Injectable({
  providedIn: 'root'
})
export class delivererService {
  
  private getHeaders(): HttpHeaders {
    // Get the access token from where you stored it
    const accessToken = 'eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJDemNuYTU1a3lwb0dXeDNCN1l6TzJaUHI5Ny1Pc2FzN3ZFUkFDaEZnaV80In0.eyJleHAiOjE3MDMyNDQ0MzAsImlhdCI6MTcwMzIwODQzMCwianRpIjoiYzdhNjUzNTEtZDI3NC00N2NiLWEwNmQtZWNmYWFhMDc2ODFhIiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgxL3JlYWxtcy9tMmdpbCIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiI3MWM3ZjM2Mi0wMTE1LTQ1NjEtODc2Mi1mOWVkNmY0YmE2ZmYiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJkZWxpdi1tYW5hZ2VyIiwic2Vzc2lvbl9zdGF0ZSI6IjM0MzdiNDk2LWUzZWYtNDkzYS1hZjAwLTkyZWVjYWM3MDUwZiIsImFjciI6IjEiLCJhbGxvd2VkLW9yaWdpbnMiOlsiaHR0cDovL2xvY2FsaG9zdDo4MDgwLyoiLCJodHRwOi8vbG9jYWxob3N0OjQyMDAvKiJdLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsib2ZmbGluZV9hY2Nlc3MiLCJ1bWFfYXV0aG9yaXphdGlvbiIsImRlZmF1bHQtcm9sZXMtbTJnaWwiXX0sInJlc291cmNlX2FjY2VzcyI6eyJkZWxpdi1tYW5hZ2VyIjp7InJvbGVzIjpbIkFETUlOIiwiVVNFUiJdfSwiYWNjb3VudCI6eyJyb2xlcyI6WyJtYW5hZ2UtYWNjb3VudCIsIm1hbmFnZS1hY2NvdW50LWxpbmtzIiwidmlldy1wcm9maWxlIl19fSwic2NvcGUiOiJwcm9maWxlIGVtYWlsIiwic2lkIjoiMzQzN2I0OTYtZTNlZi00OTNhLWFmMDAtOTJlZWNhYzcwNTBmIiwiZW1haWxfdmVyaWZpZWQiOnRydWUsIm5hbWUiOiJzYW0ga2VsbG91Y2hhIiwicHJlZmVycmVkX3VzZXJuYW1lIjoidGVzdF9zYW0iLCJnaXZlbl9uYW1lIjoic2FtIiwiZmFtaWx5X25hbWUiOiJrZWxsb3VjaGEiLCJlbWFpbCI6InNhbWFoLmthZGEta2VsbG91Y2hhQHVuaXYtcm91ZW4uZnIifQ.BcRFEfjbaDoSnjVHxWytY1TJ5nxMVK0DtsGNO-RpQJ8ut0dVBKZQih9WT6LjN9EQMdUbNOcKyNy9rNzMw_P9Iir6nr5UXyPszA4Wdp7LQN1jenryp3BKjpM7uXlRI0073pEPLQnjwybf1eSieqqm92vIdyooqs5nbGlf8YV3qCPeNHjaOon9_VBQoyZhbj-E8uqfJA_faFNCsECbmsMJnyZoM2CKQd76dOXmHoSaunR5xg4qSE496FrA7d0unw8JjTZNAZ5cMfboZL9cgqmgBuqSsaY23dIs_Es7uGbLa_N0xnqN6FymDqQyb-7RH-SNX3aall3X0lwz6UpnpPrIlg';
    // Set the Authorization header
    return new HttpHeaders({
      'Content-Type': 'application/json',
      Authorization: `Bearer ${accessToken}`
    });
  }

  constructor(private http: HttpClient) { }

  createdeliverer(deliverer: unknown): Observable<unknown> {
    const headers = this.getHeaders();

    return this.http.post<unknown>(`/api/deliverer`, deliverer,{ headers });
  }

  getAlldeliverers(): Observable<deliverer[]> {
    const headers = this.getHeaders();

    return this.http.get<deliverer[]>(`/api/deliverer/all`,{ headers });
  }

  getdelivererById(id: number): Observable<deliverer> {
    const headers = this.getHeaders();

    return this.http.get<deliverer>(`/api/deliverer/${id}`,{ headers });
  }

  updatedeliverer(id: number, updates: unknown): Observable<deliverer> {
    const headers = this.getHeaders();

    return this.http.put<deliverer>(`/api/deliverer/${id}`, updates,{ headers });
  }

  deletedeliverer(id: number): Observable<void> {
    const headers = this.getHeaders();

    return this.http.delete<void>(`/api/deliverer/${id}`,{ headers });
  }

  searchdeliverers(searchParams: unknown): Observable<deliverer[]> {
    const headers = this.getHeaders();

    // Envoyez les paramètres de recherche à votre API
    return this.http.post<deliverer[]>(`/api/deliverer/search`, searchParams,{ headers });
  }

  assignTour(delivererId: number, tourId: number): Observable<deliverer> {
    const headers = this.getHeaders();

    return this.http.post<deliverer>(`/api/deliverer/${delivererId}/assign-tour/${tourId}`, {},{ headers });
  }
}
