import { DeliveryTour } from "./delivery-tour";

export interface Deliverer {

    id : number;
    firstName : string;
    lastName: string;
    creationDate : Date ;
    isAvailable:boolean;
    deliveryTours : DeliveryTour[] ;


}
