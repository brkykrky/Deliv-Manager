import { tour } from "./tour";

export interface deliverer {
    id : number,
    firstName : String,
    lastName : String,
    isAvailable : boolean,
    creationDate : Date , 
    deliveryTours : tour []
}