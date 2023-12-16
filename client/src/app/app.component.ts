import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import {HeaderComponent} from './components/shared/header/header.component';
import {FooterComponent} from './components/shared/footer/footer.component';
import {LoginComponent} from './components/login/login/login.component';
import { DeliveriesComponent } from './components/deliveries/deliveries/deliveries.component';
import { DetailsDelivererComponent } from './components/details-deliverer/details-deliverer.component';
import { HttpClientModule } from '@angular/common/http';

 
@Component({
  selector: 'app-root',
  standalone: true,
  imports: 
  [DetailsDelivererComponent,
    RouterOutlet,
    HomeComponent,
    FooterComponent,
    HeaderComponent,
    LoginComponent,
    DeliveriesComponent,
    HttpClientModule,
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Deliverer\'s manager';
  
}
