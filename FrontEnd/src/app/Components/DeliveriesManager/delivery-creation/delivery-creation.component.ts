import { Component } from '@angular/core';
import { delivery } from '../../../Interfaces/delivery';
import { deliveryService } from '../../../services/delivery.service';

@Component({
  selector: 'app-delivery-creation',
  templateUrl: './delivery-creation.component.html',
  styleUrl: './delivery-creation.component.css'
})
export class DeliveryCreationComponent {
isChecked = true;
ramassage = '';
depot =  '';
delivery : delivery = {
  id: 0,
  pickupAddress: '',
  storageAddress: '',
  assignedTour: null
}
constructor(public serviceDelivery : deliveryService){}

onSubmit() {

  this.delivery.pickupAddress=this.ramassage;
  this.delivery.storageAddress=this.depot;
  this.serviceDelivery.createdelivery(this.delivery).subscribe(
    () => {
      console.log('Delivery was added successfully');
      window.location.reload();

    },
    (error) => {
      console.error('Error adding delivery', error);
    }
  );
  }





}
