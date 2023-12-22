import { Component, OnInit, ViewChild } from '@angular/core';
import { deliverer } from '../../../Interfaces/deliverer';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import {MatSort} from '@angular/material/sort';
import { MatDialog } from '@angular/material/dialog';
import { ConfirmDialogModel, ModalConfirmationComponent } from '../../Shared/modal-confirmation/modal-confirmation.component';
import { EditerDialogModel, EditerLivreurComponent } from '../editer-livreur/editer-livreur.component';
import { DetailsLivreurComponent } from '../details-livreur/details-livreur.component';
import { delivererService } from '../../../services/deliverer.service';
import { HttpErrorResponse } from '@angular/common/http';


 


@Component({
  selector: 'app-deliverer',
  templateUrl: './deliverer.component.html',
  styleUrl: './deliverer.component.css'
})
export class DelivererComponent implements OnInit {

  constructor(public dialog: MatDialog, public serviceDeliverer : delivererService) {}

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;


  ELEMENT_DATA: deliverer[] = [];

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  ngOnInit(): void {
    this.getDeliverers();
  }

  public getDeliverers(): void {

    this.serviceDeliverer.getAlldeliverers().subscribe(
      (response: deliverer[]) => {
        this.ELEMENT_DATA = response;
        this.dataSource.data = this.ELEMENT_DATA; // Mettez à jour dataSource ici
        console.log(new MatTableDataSource(this.ELEMENT_DATA));
        console.log(response);
        console.log(this.ELEMENT_DATA);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  displayedColumns: string[] = ['id', 'firstName', 'lastName', 'creationDate','available','Actions'];
  dataSource = new MatTableDataSource(this.ELEMENT_DATA);

  
  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value.toLowerCase();
    // Divisez le filtre en mots
    const filters = filterValue.split(' ');
  
    // Appliquez les filtres aux données
    const filteredData = this.ELEMENT_DATA.filter(item =>
      filters.every(currentValue =>
        item.firstName.toLowerCase().includes(currentValue) ||
        item.lastName.toLowerCase().includes(currentValue) ||
        (item.isAvailable ? 'oui' : 'non').includes(currentValue) || // Convertir la valeur booléenne en chaîne
        item.creationDate.toDateString().toLowerCase().includes(currentValue)
      )
    );
  
    // Mettez à jour la propriété dataSource avec les données filtrées
    this.dataSource = new MatTableDataSource(filteredData);
    console.log (this.dataSource);


  }
  
  result: string = '';

  confirmSuppressionDialog(id :number): void {
    console.log(id);
    const message = `Êtes-vous sûr de vouloir supprimer ce livreur? Cette action est irréversible et entraînera la perte définitive des informations associées à ce livreur`;
    const dialogData = new ConfirmDialogModel("Confirmer votre choix", message,id);

    const dialogRef = this.dialog.open(ModalConfirmationComponent, {
      maxWidth: "400px",
      data: dialogData
    });

    dialogRef.afterClosed().subscribe(dialogResult => {
      this.result = dialogResult;
      console.log(this.result);
    });
    this.getDeliverers();

  }
  

  modifierLivreur(id : number) {

console.log("je sui laaaa :!!!!")
    const dialogData = new EditerDialogModel("Modifier un livreur",id);

    const dialogRef = this.dialog.open(EditerLivreurComponent, {
      maxWidth: "400px",
      data: dialogData
    });

    dialogRef.afterClosed().subscribe(dialogResult => {
      this.result = dialogResult;
    });
  
}

//--------------------------------------------------------------------------------
DetailLivreur(id : number) {
  this.dialog.open(DetailsLivreurComponent, {
    maxWidth: "400px",
    data: id
  });


}
  
}
