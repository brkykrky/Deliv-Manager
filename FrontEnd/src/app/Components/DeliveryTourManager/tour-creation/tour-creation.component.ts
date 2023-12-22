import { Component } from '@angular/core';
import { tour } from '../../../Interfaces/tour';
import { FormGroup, FormControl } from '@angular/forms';
import { DeliveryTourService } from '../../../services/tour.service';

@Component({
  selector: 'app-tour-creation',
  templateUrl: './tour-creation.component.html',
  styleUrl: './tour-creation.component.css'
})
export class TourCreationComponent  {

  constructor(public serviceTour : DeliveryTourService){}

nom = '';
tourne : tour ={
  id: 0,
  name: '',
  startDate: undefined,
  endDate: undefined,
  assignedDeliverer: null,
  assignedDeliveries: []
}
range = new FormGroup({
  start: new FormControl<Date | null>(null),
  end: new FormControl<Date | null>(null),
});

onSubmit() {
this.tourne.name = this.nom;

this.tourne.startDate = this.range.value.start?.toJSON();
this.tourne.endDate = this.range.value.end?.toJSON();

this.serviceTour.createTour(this.tourne).subscribe(
  () => {
    console.log('Tour was added successfully');
    window.location.reload();

  },
  (error) => {
    console.error('Error adding tour', error);
  }
);

  }


}
