import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class DashboardService {

  constructor(private http:HttpClient) { }

  fetchBeer(){
    let url="http://localhost:8080/beerinfo/all"
    return this.http.get(url);
  }
}