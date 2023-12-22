import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { delivererService } from '../../../services/deliverer.service';
import { deliverer } from '../../../Interfaces/deliverer';


@Component({
  selector: 'app-editer-livreur',
  templateUrl: './editer-livreur.component.html',
  styleUrl: './editer-livreur.component.css'
})
export class EditerLivreurComponent {
  id!: number;
  title! : string;
  firstName!: string;
  lastName!: string;
  isChecked!: boolean;
deliverer! : deliverer;

  constructor(public serviceDeliverer : delivererService, public dialogRef: MatDialogRef<EditerLivreurComponent>,@Inject(MAT_DIALOG_DATA) public data: EditerLivreurComponent) {
    this.id=data.id;
    this.title = data.title;

  }
 
  onConfirm(): void {
    this.dialogRef.close(true);
    this.serviceDeliverer.getdelivererById(this.id).subscribe(
      (result: deliverer) => {

        this.deliverer = result;
        this.firstName = this.deliverer.firstName;
        this.lastName = this.deliverer.lastName;
        this.isChecked = this.deliverer.isAvailable;
      },
      (error) => {

        console.error('Une erreur s\'est produite : ', error);
      }
    );    this.serviceDeliverer.updatedeliverer(this.id,this.serviceDeliverer.getdelivererById(this.id)).subscribe(
      () => {

        console.log('Deliverer edited successfully');
        window.location.reload();

      },
      (error) => {

        console.error('Error editing deliverer', error);
      }
    );
  }

  onDismiss(): void {
    this.dialogRef.close(false);
  }
}
export class EditerDialogModel {

  constructor(public title: string,public id : number)
  {
  }
}
