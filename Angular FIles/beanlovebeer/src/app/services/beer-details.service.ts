import { Injectable } from '@angular/core';
import { Observable, of} from 'rxjs';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { map } from "rxjs/operators";



@Injectable({
  providedIn: 'root'
})
export class BeerDetailsService {

  constructor(private http:HttpClient) {}

  fetchDetails(){
    console.log("----------------------Service Start------------------------------------------")
    let url = "http://localhost:8080/beerinfo/beerinfo"
    return this.http.get(url);
  }

  fetchFavroite(){
    let url = "http://localhost:8080/beerinfo/getFavrote"
    return this.http.get(url);
  }
}
