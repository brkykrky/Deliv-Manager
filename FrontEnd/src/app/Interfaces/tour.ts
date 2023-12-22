import { deliverer } from "./deliverer";
import { delivery } from "./delivery";

export interface tour {
    id :number ,
    name : string , 
    startDate : string |undefined , 
    endDate : string |undefined,
    assignedDeliverer : deliverer | null,
    assignedDeliveries : delivery [] 
}