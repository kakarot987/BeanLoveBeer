import { Component, OnInit } from '@angular/core';
import { BeerDetailsService } from "../services/beer-details.service";
import { BeerInformation } from "../model/beerDetails.model";
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { HttpClient } from "@angular/common/http";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  jsondata: any;
  arr: BeerInformation[] = [];
  selectedBeer : BeerInformation;
  Beername : String;

  closeResult = '';
  idL;
  url = "http://localhost:8080/beerinfo/addFavroite"

  FavroiteBeer: any;

  constructor(private beerDetails:BeerDetailsService ,private modalService: NgbModal, private http : HttpClient) { 
   
  }

  ngOnInit(): void {
    this.beerDetails.fetchDetails().subscribe(res => {
      this.jsondata = res;
      this.arr = this.jsondata;
      this.Beername = this.jsondata.name; 
    })

    this.beerDetails.fetchFavroite().subscribe(res =>{
      this.FavroiteBeer = res
      console.log("------Favrou=ite Beer------",this.FavroiteBeer);
    })
  }

  forPost(id){
    console.log("id is",id);
    this.idL = id;
    this.http.post(this.url, this.idL).toPromise().then(data =>{
      console.log(data);
    });
  }

  Search(){
    if(this.Beername != ""){
      this.arr = this.arr.filter(res =>{
        return res.name.toLocaleLowerCase().match(this.Beername.toLocaleLowerCase());
      })
    } else if (this.Beername == ""){
      this.ngOnInit();
    }
    }
  
  open(content, beer: BeerInformation) {
    this.selectedBeer = beer;
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }

  favOpen(favContent){
    this.modalService.open(favContent, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }

  
  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }
  }

}
