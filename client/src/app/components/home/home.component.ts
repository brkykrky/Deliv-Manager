import { Component, OnInit } from '@angular/core';
import { Deliverer } from '../../model/deliverer';
import { DeliverersService } from '../../service/deliverers.service';
import { HttpErrorResponse } from '@angular/common/http';
import { HttpClientModule } from '@angular/common/http';
import { DetailsDelivererComponent } from '../details-deliverer/details-deliverer.component';
import { CommonModule } from '@angular/common';



@Component({
  selector: 'app-home',
  standalone: true,
  imports: [HttpClientModule,DetailsDelivererComponent,CommonModule],
  templateUrl: './home.component.html',
  styleUrl : './home.component.css'
})
export class HomeComponent implements OnInit{

  public deliverers: Deliverer[] = [];

  constructor(private delivererService : DeliverersService) {}
  ngOnInit(): void {
    this.getDeliverers();
  }

    public getDeliverers() : void {
      this.delivererService.getDeliverers().subscribe(
        (response : Deliverer[]) => {
          this.deliverers = response ;
        },
        (error : HttpErrorResponse) => {
          alert(error.message);
        }
      );
    }
  
}
