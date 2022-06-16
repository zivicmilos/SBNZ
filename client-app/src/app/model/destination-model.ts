import { Location } from "./location-model";

export class Destination {
    constructor(
        public weather: string = '',
        public transportationTypes: string[] = [],
        public destinationTypes: string[] = [],
        public location: Location = new Location(),
        public recommendedTransportationType: String = '',
        public likes: any[] = [],
        public cost: Number = 0,
        public grade: Number = 0
    ) { }
}