import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialog, MatDialogRef } from '@angular/material/dialog';


@Component({
  selector: 'app-editer-livreur',
  templateUrl: './editer-livreur.component.html',
  styleUrl: './editer-livreur.component.css'
})
export class EditerLivreurComponent {
  title! : string;
  firstName!: string;
  lastName!: string;
  isChecked!: boolean;

  constructor(public dialogRef: MatDialogRef<EditerLivreurComponent>,@Inject(MAT_DIALOG_DATA) public data: EditerLivreurComponent) {
    this.title = data.title;
    this.firstName = data.firstName;
    this.lastName = data.lastName;
    this.isChecked = data.isChecked;
  }
 
  onConfirm(): void {
    this.dialogRef.close(true);
  }

  onDismiss(): void {
    this.dialogRef.close(false);
  }
}
export class EditerDialogModel {

  constructor(public title: string, public firstName : string , public lastName :string ,  public isChecked :boolean)
  {
  }
}
