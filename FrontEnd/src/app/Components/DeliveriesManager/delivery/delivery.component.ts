import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { DetailsLivreurComponent } from '../../DelivererManager/details-livreur/details-livreur.component';
import { EditerDialogModel, EditerLivreurComponent } from '../../DelivererManager/editer-livreur/editer-livreur.component';
import { ConfirmDialogModel, ModalConfirmationComponent } from '../../Shared/modal-confirmation/modal-confirmation.component';
import { delivery } from '../../../Interfaces/delivery';
import { deliveryService } from '../../../services/delivery.service';
import { HttpErrorResponse } from '@angular/common/http';




@Component({
  selector: 'app-delivery',
  templateUrl: './delivery.component.html',
  styleUrl: './delivery.component.css'
})
export class DeliveryComponent implements OnInit{
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;


  
  constructor(public dialog: MatDialog, public serviceDelivery : deliveryService) {}

  ELEMENT_DATA: delivery[] = []

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }
  ngOnInit(): void {
    this.getDeliveries();
  }



public getDeliveries(){
  this.serviceDelivery.getAllDeliveries().subscribe(
    (response: delivery[]) => {
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



  displayedColumns: string[] = ['id', 'pickupAddress', 'storageAddress', 'assignedTour','Actions'];
  dataSource = new MatTableDataSource(this.ELEMENT_DATA);


  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value.toLowerCase();
    // Divisez le filtre en mots
    const filters = filterValue.split(' ');
  
    // Appliquez les filtres aux données
    const filteredData = this.ELEMENT_DATA.filter(item =>
      filters.every(currentValue =>
        item.pickupAddress.toLowerCase().includes(currentValue) ||
        item.storageAddress.toLowerCase().includes(currentValue) 
      )
    );
  
    // Mettez à jour la propriété dataSource avec les données filtrées
    this.dataSource = new MatTableDataSource(filteredData);
  }
  
  result: string = '';


  confirmSuppressionDialog(id :number): void {

    console.log(id);
    const message = `Êtes-vous sûr de vouloir supprimer cette livraison ? `;

    const dialogData = new ConfirmDialogModel("Confirmer votre choix", message,id);

    const dialogRef = this.dialog.open(ModalConfirmationComponent, {
      maxWidth: "400px",
      data: dialogData
    });

    dialogRef.afterClosed().subscribe(dialogResult => {
      this.result = dialogResult;
    });
  }
  

  modifierlivraison(id : number) {


    const dialogData = new EditerDialogModel("Modier un livreur",id);

    const dialogRef = this.dialog.open(EditerLivreurComponent, {
      maxWidth: "400px",
      data: dialogData
    });

    dialogRef.afterClosed().subscribe(dialogResult => {
      this.result = dialogResult;
    });
  
}

//--------------------------------------------------------------------------------
Detaillivraison() {
  

this.dialog.open(DetailsLivreurComponent, {
    maxWidth: "100%",
  });
}
}
