import { Component, OnInit, ViewChild } from '@angular/core';
import { deliverer } from '../../../Interfaces/deliverer';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import {MatSort} from '@angular/material/sort';
import { MatDialog } from '@angular/material/dialog';
import { ConfirmDialogModel, ModalConfirmationComponent } from '../../Shared/modal-confirmation/modal-confirmation.component';
import { EditerDialogModel, EditerLivreurComponent } from '../editer-livreur/editer-livreur.component';
import { DetailsLivreurComponent } from '../details-livreur/details-livreur.component';


 


@Component({
  selector: 'app-deliverer',
  templateUrl: './deliverer.component.html',
  styleUrl: './deliverer.component.css'
})
export class DelivererComponent implements OnInit {

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;


  ELEMENT_DATA: deliverer[] = [
    {id: 1, firstName: 'a', lastName: "a", creationDate: new Date(),isAvailable:true , deliveryTours:[]},
    {id: 1, firstName: 'b', lastName: "b", creationDate: new Date(),isAvailable:true , deliveryTours:[]},
    {id: 1, firstName: 'c', lastName: "c", creationDate: new Date(),isAvailable:true , deliveryTours:[]},
    {id: 1, firstName: 'd', lastName: "d", creationDate: new Date(),isAvailable:true , deliveryTours:[]},
    {id: 1, firstName: 'e', lastName: "e", creationDate: new Date(),isAvailable:true , deliveryTours:[]},
    {id: 1, firstName: 'f', lastName: "f", creationDate: new Date(),isAvailable:false , deliveryTours:[]},
    {id: 1, firstName: 'g', lastName: "g", creationDate: new Date(),isAvailable:false , deliveryTours:[]},
    {id: 1, firstName: 'h', lastName: "h", creationDate: new Date(),isAvailable:false , deliveryTours:[]},
    {id: 1, firstName: 'i', lastName: "i", creationDate: new Date(),isAvailable:false , deliveryTours:[]},
    {id: 4, firstName: 'j', lastName: "j", creationDate: new Date(),isAvailable:false , deliveryTours:[]},
    {id: 1, firstName: 'k', lastName: "k", creationDate: new Date(),isAvailable:false , deliveryTours:[]},
    {id: 1, firstName: 'l', lastName: "l", creationDate: new Date(),isAvailable:false , deliveryTours:[]}
  ];

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }
  ngOnInit(): void {
    
  }

  displayedColumns: string[] = ['id', 'firstName', 'lastName', 'creationDate','isAvailable','Actions'];
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
  }
  
  result: string = '';

  constructor(public dialog: MatDialog) {}

  confirmSuppressionDialog(index :number): void {

    console.log(index);
    const message = `Êtes-vous sûr de vouloir supprimer ce livreur? Cette action est irréversible et entraînera la perte définitive des informations associées à ce livreur`;

    const dialogData = new ConfirmDialogModel("Confirmer votre choix", message);

    const dialogRef = this.dialog.open(ModalConfirmationComponent, {
      maxWidth: "400px",
      data: dialogData
    });

    dialogRef.afterClosed().subscribe(dialogResult => {
      this.result = dialogResult;
    });
  }
  

  modifierLivreur() {
    const firstName = "test";
    const lastName = "test";
    const isChecked = true;


    const dialogData = new EditerDialogModel("Modier un livreur", firstName,lastName,isChecked);

    const dialogRef = this.dialog.open(EditerLivreurComponent, {
      maxWidth: "400px",
      data: dialogData
    });

    dialogRef.afterClosed().subscribe(dialogResult => {
      this.result = dialogResult;
    });
  
}

//--------------------------------------------------------------------------------
DetailLivreur() {
  

  const dialogRef = this.dialog.open(DetailsLivreurComponent, {
    maxWidth: "100%",
  });
}
  
}
