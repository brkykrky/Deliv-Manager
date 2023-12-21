import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import {JsonPipe} from '@angular/common';


@Component({
  selector: 'app-filtrer-livreur',
  templateUrl: './filtrer-livreur.component.html',
  styleUrl: './filtrer-livreur.component.css'
})
export class FiltrerLivreurComponent {
isChecked = true;
range = new FormGroup({
  start: new FormControl<Date | null>(null),
  end: new FormControl<Date | null>(null),
});

}
