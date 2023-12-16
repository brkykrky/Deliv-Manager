import { Component } from '@angular/core';

@Component({
  selector: 'app-footer',
  standalone: true,
  imports: [],
  templateUrl : './footer.component.html',
  styleUrl: './footer.component.css'
})
export class FooterComponent {

  currentyear : number = new Date().getFullYear();

}
