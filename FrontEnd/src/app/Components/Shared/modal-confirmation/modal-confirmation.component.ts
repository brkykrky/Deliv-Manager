import { Component, Inject } from '@angular/core';
import { MAT_DIALOG_DATA, MatDialog, MatDialogRef } from '@angular/material/dialog';


@Component({
  selector: 'app-modal-confirmation',
  templateUrl: './modal-confirmation.component.html',
  styleUrl: './modal-confirmation.component.css'
})
export class ModalConfirmationComponent {
  title!: string;
  message!: string;

  constructor(public dialogRef: MatDialogRef<ModalConfirmationComponent>,@Inject(MAT_DIALOG_DATA) public data: ModalConfirmationComponent) {
    this.title = data.title;
    this.message = data.message;
  }
 
  onConfirm(): void {
    this.dialogRef.close(true);
  }

  onDismiss(): void {
    this.dialogRef.close(false);
  }
}
export class ConfirmDialogModel {

  constructor(public title: string, public message: string) {
  }
}
