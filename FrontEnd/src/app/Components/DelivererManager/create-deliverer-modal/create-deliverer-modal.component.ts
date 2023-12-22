import { Component } from '@angular/core';
import { delivererService } from '../../../services/deliverer.service';
import { deliverer } from '../../../Interfaces/deliverer';

@Component({
  selector: 'app-create-deliverer-modal',
  templateUrl: './create-deliverer-modal.component.html',
  styleUrl: './create-deliverer-modal.component.css'
})
export class CreateDelivererModalComponent {

value :unknown ;
available = true;
  firstName!: string;
  lastName!: string;
  deliverer: deliverer = {
    id : 0,
    firstName : "",
    lastName : "",
    creationDate : new Date(),
    isAvailable :true,
    deliveryTours : []
  };

constructor(public serviceDeliverer : delivererService){}

onSubmit() {

  this.deliverer.firstName=this.firstName;
  this.deliverer.lastName=this.lastName;
  this.deliverer.isAvailable=this.available;
  console.log(this.available);
  this.deliverer.creationDate = new Date();
console.log(this.deliverer);
  this.serviceDeliverer.createdeliverer(this.deliverer).subscribe(
    () => {
      console.log('Deliverer was added successfully');
      window.location.reload();

    },
    (error) => {
      console.error('Error adding deliverer', error);
    }
  );
  }






}
