import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { delivererService } from '../../../services/deliverer.service';


@Component({
  selector: 'app-modal-confirmation',
  templateUrl: './modal-confirmation.component.html',
  styleUrl: './modal-confirmation.component.css'
})
export class ModalConfirmationComponent {
  title!: string;
  message!: string;
  id! :number;


  constructor(public serviceDeliverer: delivererService,public dialogRef: MatDialogRef<ModalConfirmationComponent>,@Inject(MAT_DIALOG_DATA) public data: ModalConfirmationComponent) {
    this.title = data.title;
    this.message = data.message;
    this.id = data.id;
  }
 
  onConfirm(): void {

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

  onDismiss(): void {
    this.dialogRef.close(false);
  }
}
export class ConfirmDialogModel {

  constructor(public title: string, public message: string,public id : number) {
  }


  
}
