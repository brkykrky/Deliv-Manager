import { Component } from '@angular/core';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { CreateDelivererModalComponent } from '../../DelivererManager/create-deliverer-modal/create-deliverer-modal.component';
import { FiltrerLivreurComponent } from '../../DelivererManager/filtrer-livreur/filtrer-livreur.component';
import { Router } from '@angular/router';
import { DeliveryCreationComponent } from '../../DeliveriesManager/delivery-creation/delivery-creation.component';
import { TourCreationComponent } from '../../DeliveryTourManager/tour-creation/tour-creation.component';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrl: './header.component.css'
})
export class HeaderComponent {

  constructor(public dialogLivreur : MatDialog,private router: Router) {}
 


//----------------  Gestion des tournées--------------------

OpenDialogTournee() {
  let dialogRef = this.dialogLivreur.open(TourCreationComponent);
}



//Gestion des livraison --------------------
OpenDialogLivraison() {
  
  this.dialogLivreur.open(DeliveryCreationComponent);
}




//------------gestion des livreurs ------------------------
OpenDialogLivreur() {
 let dialogRef = this.dialogLivreur.open(CreateDelivererModalComponent);
}

filtrerUnLivreur() {
  let dialogRef = this.dialogLivreur.open(FiltrerLivreurComponent);

}






// -------------------------------------- Les chemins pour les boutton --------------
isHomeRoute(): boolean {
  return this.router.url === '/home';
}

isDRoute(): boolean {
return this.router.url === '/deliveries';
}

isDTRoute(): boolean {
return this.router.url === '/deliveriesTour';
}
}