import { Component, ViewChild } from '@angular/core';
import { tour } from '../../../Interfaces/tour';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { DetailsLivreurComponent } from '../../DelivererManager/details-livreur/details-livreur.component';
import { EditerDialogModel, EditerLivreurComponent } from '../../DelivererManager/editer-livreur/editer-livreur.component';
import { ConfirmDialogModel, ModalConfirmationComponent } from '../../Shared/modal-confirmation/modal-confirmation.component';



@Component({
  selector: 'app-tours',
  templateUrl: './tours.component.html',
  styleUrl: './tours.component.css'
})
export class ToursComponent {
 
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  ELEMENT_DATA: tour[] = [
    {id: 1, name : "A tour",startDate : new Date(), endDate :new Date(),assignedDeliverer:null,assignedDeliveries:[]},
    {id: 2, name : "B tour",startDate : new Date(), endDate :new Date(),assignedDeliverer:null,assignedDeliveries:[]},
    {id: 3, name : "C tour",startDate : new Date(), endDate :new Date(),assignedDeliverer:null,assignedDeliveries:[]}
  ]

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }
 
  displayedColumns: string[] = ['id', 'name', 'startDate', 'endDate','assignedDeliveries','Actions'];
  dataSource = new MatTableDataSource(this.ELEMENT_DATA);


  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value.toLowerCase();
    // Divisez le filtre en mots
    const filters = filterValue.split(' ');
  
    // Appliquez les filtres aux données
    const filteredData = this.ELEMENT_DATA.filter(item =>
      filters.every(currentValue =>
        item.name.toLowerCase().includes(currentValue) 
        //item.storageAddress.toLowerCase().includes(currentValue) 
      )
    );
  
    // Mettez à jour la propriété dataSource avec les données filtrées
    this.dataSource = new MatTableDataSource(filteredData);
  }
  
  result: string = '';

  constructor(public dialog: MatDialog) {}

  confirmSuppressionDialog(id :number): void {

    console.log(id);
    const message = `Êtes-vous sûr de vouloir supprimer cette tournée ? `;

    const dialogData = new ConfirmDialogModel("Confirmer votre choix", message,id);

    const dialogRef = this.dialog.open(ModalConfirmationComponent, {
      maxWidth: "400px",
      data: dialogData
    });

    dialogRef.afterClosed().subscribe(dialogResult => {
      this.result = dialogResult;
    });
  }
  

  modifiertournee(id :number) {

    const dialogData = new EditerDialogModel("Modifier un livreur", id);

    const dialogRef = this.dialog.open(EditerLivreurComponent, {
      maxWidth: "400px",
      data: dialogData
    });

    dialogRef.afterClosed().subscribe(dialogResult => {
      this.result = dialogResult;
    });
  
}

//--------------------------------------------------------------------------------
Detailtournee() {
  

  this.dialog.open(DetailsLivreurComponent, {
    maxWidth: "100%",
  });
}
}
