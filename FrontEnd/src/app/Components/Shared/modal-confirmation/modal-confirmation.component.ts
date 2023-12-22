import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { delivererService } from '../../../services/deliverer.service';
import { Router } from '@angular/router';
import { deliveryService } from '../../../services/delivery.service';
import { DeliveryTourService } from '../../../services/tour.service';


@Component({
  selector: 'app-modal-confirmation',
  templateUrl: './modal-confirmation.component.html',
  styleUrl: './modal-confirmation.component.css'
})
export class ModalConfirmationComponent {

  title!: string;
  message!: string;
  id! :number;


  constructor(private router: Router,public serviceDelivery: deliveryService,public serviceTour: DeliveryTourService,public serviceDeliverer: delivererService,public dialogRef: MatDialogRef<ModalConfirmationComponent>,@Inject(MAT_DIALOG_DATA) public data: ModalConfirmationComponent) {
    this.title = data.title;
    this.message = data.message;
    this.id = data.id;
  }
 
  onConfirmDeliverer(): void {

    this.dialogRef.close(true);
    
    this.serviceDeliverer.deletedeliverer(this.id).subscribe(
      () => {
        // Handle success if needed
        console.log('Deliverer deleted successfully');
        window.location.reload();

      },
      (error) => {
        // Handle error if needed
        console.error('Error deleting deliverer', error);
      }
    );
  }

  onConfirmDelivery() {
    this.dialogRef.close(true);
    
    this.serviceDelivery.deletedelivery(this.id).subscribe(
      () => {
        // Handle success if needed
        console.log('Delivery deleted successfully');
        window.location.reload();

      },
      (error) => {
        // Handle error if needed
        console.error('Error deleting delivery', error);
      }
    );    }


    
    onConfirmTour() {
      this.dialogRef.close(true);
    
      this.serviceTour.deleteTour(this.id).subscribe(
        () => {
          // Handle success if needed
          console.log('Deliverer deleted successfully');
          window.location.reload();
  
        },
        (error) => {
          // Handle error if needed
          console.error('Error deleting deliverer', error);
        }
      );    }
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

  onDismiss(): void {
    this.dialogRef.close(false);
  }
}
export class ConfirmDialogModel {

  constructor(public title: string, public message: string,public id : number) {
  }
  
}
