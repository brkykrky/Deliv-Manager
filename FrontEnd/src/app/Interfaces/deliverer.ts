import { tour } from "./tour";

export interface deliverer {
    id : number,
    firstName : string,
    lastName : string,
    isAvailable : boolean,
    creationDate : Date , 
    deliveryTours : tour []
}