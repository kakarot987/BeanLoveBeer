export interface BeerInformation {
    alcohol:      string;
    id:           number;
    invented:     number;
    manufacturer: string;
    name:         string;
    description: string;
    img : string;
}

// Converts JSON strings to/from your types
export class Convert {
    public static toBeerInformation(json: string): BeerInformation {
        return JSON.parse(json);
    }

    public static beerInformationToJson(value: BeerInformation): string {
        return JSON.stringify(value);
    }
}
