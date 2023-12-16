import { Deliverer } from "./deliverer";
import { Delivery } from "./delivery";

export interface DeliveryTour {

    id: number;
    name : String;
    startDate: Date;
    endDate: Date;
    assignedDeliverer : Deliverer;
    deliveries : Delivery[];

}
