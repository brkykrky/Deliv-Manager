import { tour } from "./tour";

export interface delivery {
    id :number ,
    pickupAddress : string, 
    storageAddress : string,
    assignedTour : tour | null

}