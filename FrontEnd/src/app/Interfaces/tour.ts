import { deliverer } from "./deliverer";
import { delivery } from "./delivery";

export interface tour {
    id :number ,
    name : string , 
    startDate : Date , 
    endDate : Date,
    assignedDeliverer : deliverer | null,
    assignedDeliveries : delivery [] 
}