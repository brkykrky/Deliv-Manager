import { NgModule } from "@angular/core";
import { RouteConfigLoadEnd, RouterModule, Routes } from "@angular/router";
import { DeliveryComponent } from "../Components/DeliveriesManager/delivery/delivery.component";
import { ToursComponent } from "../Components/DeliveryTourManager/tours/tours.component";
import { DelivererComponent } from "../Components/DelivererManager/deliverer/deliverer.component";
import { PageNotFoundComponent } from "../Components/Shared/page-not-found/page-not-found.component";


const routes : Routes = [
    {path: '', redirectTo: 'home', pathMatch: 'full'},
    {path: 'deliveries', component: DeliveryComponent},
    {path: 'deliveriesTour', component: ToursComponent},
    {path: 'home', component: DelivererComponent},
    //{path: 'delivererDetails/:id', component: DetailsDelivererComponent},
    {path: '**', component: PageNotFoundComponent}
]

@NgModule({
    imports: [
RouterModule.forRoot(routes)
    ],
    exports : [RouterModule]
})

export class AppRoutesModule {}