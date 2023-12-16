import { DeliveryTour } from "./delivery-tour";

export interface Delivery {
    id : number;
    pickupAddress : String;
    storageAddress : String;
    assignedTour : DeliveryTour;
}
