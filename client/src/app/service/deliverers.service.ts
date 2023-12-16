import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable, NgModule } from '@angular/core';
import { Observable, catchError } from 'rxjs';
import { Deliverer } from '../model/deliverer';


@NgModule({
  imports:[HttpClientModule]
})
@Injectable({
  providedIn: 'root'
})
export class DeliverersService {

  private apiServerUrl = '';

  constructor(private http: HttpClient) { }

  public getDeliverers(): Observable<Deliverer[]> {
      return this.http.get<Deliverer[]>(`${this.apiServerUrl}/deliverer/all`);
  }

 /* public addDeliverer(deliverer : Deliverer): Observable<Deliverer> {
      return this.http.post<Deliverer>(`${this.apiServerUrl}/deliverer`, deliverer);
  }*/

  public addDeliverer(deliverer: Deliverer): Observable<Deliverer> {
      return this.http.post<Deliverer>(`${this.apiServerUrl}/deliverer`, deliverer)
       
    }
    

  public updateDeliverer(delivererID : number, deliverer :Deliverer): Observable<Deliverer> {
      return this.http.put<Deliverer>(`${this.apiServerUrl}/deliverer/${delivererID}`,deliverer);
  }
  
 /* public patchDeliverer(id: number, updateDto: UpdateDelivererDTO): Observable<Deliverer> {
      return this.http.patch<Deliverer>(`${this.apiServerUrl}/deliverer/${id}`, updateDto);
    }*/
    

  public deleteDeliverer(delivererID : number): Observable<void> {
      return this.http.request<void>("Delete",`${this.apiServerUrl}/deliverer/${delivererID}`);
  }
}

