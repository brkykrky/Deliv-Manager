import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { HeaderComponent } from './Components/Shared/header/header.component';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {MatToolbarModule} from '@angular/material/toolbar';
import { DelivererComponent } from './Components/DelivererManager/deliverer/deliverer.component';
import { DeliveryComponent } from './Components/DeliveriesManager/delivery/delivery.component';
import { PageNotFoundComponent } from './Components/Shared/page-not-found/page-not-found.component';
import { AppRoutesModule } from './modules/app.routes';
import {MatTableModule} from '@angular/material/table';
import { ToursComponent } from './Components/DeliveryTourManager/tours/tours.component';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatTooltipModule} from '@angular/material/tooltip';
import {MatFormFieldModule} from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatNativeDateModule} from '@angular/material/core';
import { MatSortModule } from '@angular/material/sort';
import { CreateDelivererModalComponent } from './Components/DelivererManager/create-deliverer-modal/create-deliverer-modal.component';
import {MatDialogModule} from '@angular/material/dialog';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {MatSidenavModule} from '@angular/material/sidenav';
import { ModalConfirmationComponent } from './Components/Shared/modal-confirmation/modal-confirmation.component';
import { EditerLivreurComponent } from './Components/DelivererManager/editer-livreur/editer-livreur.component';
import { DetailsLivreurComponent } from './Components/DelivererManager/details-livreur/details-livreur.component';
import {MatDividerModule} from '@angular/material/divider';
import {MatListModule} from '@angular/material/list';
import { MatTreeModule} from '@angular/material/tree';
import { FiltrerLivreurComponent } from './Components/DelivererManager/filtrer-livreur/filtrer-livreur.component';
import { DeliveryCreationComponent } from './Components/DeliveriesManager/delivery-creation/delivery-creation.component';
import { DeliveryDetailsComponent } from './Components/DeliveriesManager/delivery-details/delivery-details.component';
import { DeliveryEditorComponent } from './Components/DeliveriesManager/delivery-editor/delivery-editor.component';
import { TourCreationComponent } from './Components/DeliveryTourManager/tour-creation/tour-creation.component';
import { ToureditorComponent } from './Components/DeliveryTourManager/toureditor/toureditor.component';
import { TourDetailsComponent } from './Components/DeliveryTourManager/tour-details/tour-details.component';









@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    DelivererComponent,
    DeliveryComponent,
    PageNotFoundComponent,
    ToursComponent,
    CreateDelivererModalComponent,
    ModalConfirmationComponent,
    EditerLivreurComponent,
    DetailsLivreurComponent,
    FiltrerLivreurComponent,
    DeliveryCreationComponent,
    DeliveryDetailsComponent,
    DeliveryEditorComponent,
    TourCreationComponent,
    ToureditorComponent,
    TourDetailsComponent,
    
  ],

  imports: [
    BrowserModule,
    AppRoutingModule,
    AppRoutesModule,
    BrowserAnimationsModule,
    MatSlideToggleModule ,
    MatButtonModule,
    MatIconModule,
    MatToolbarModule,
    MatTableModule,
    MatPaginatorModule,
    MatTooltipModule,
    MatFormFieldModule,
    MatInputModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatSortModule,
    MatDialogModule,
    FormsModule,
    MatSidenavModule,
    MatDividerModule,
    MatListModule,
    MatTreeModule,
    ReactiveFormsModule,
    

    

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
