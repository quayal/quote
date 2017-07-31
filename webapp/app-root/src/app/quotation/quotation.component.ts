/**
 * Created by AdrianG on 19.07.2017.
 */
import { Component } from '@angular/core';
import { OnInit } from '@angular/core';
import {Router, Route, ActivatedRoute} from '@angular/router';

import { Quotation } from './quotation';
import { QuotationService } from './quotation.service';
import {ClientService} from "../client/client.service";
import {Functionality} from "../functionality/functionality";

@Component({
  selector: 'quotations',
  templateUrl: './quotation.component.html',
  styleUrls:['./quotation.component.css'],
  providers: [ QuotationService ]
})

export class QuotationComponent implements OnInit {
  quotationName: string;
  quotationFunctionalities: Functionality[];
  selectedQuotation: Quotation;
  selectedFunctionality: Functionality;
  sub: any;
  id: string;


  constructor(private quotationService: QuotationService,
              private router: Router,
              private route: ActivatedRoute) {}


  getQuotationDetails(quotationId): void {
    this.quotationService.getQuotationDetails(quotationId).then((res => {
        this.quotationName = res.name;
        this.quotationFunctionalities = res.functionalities
      }
    ));
  };


  gotoFunctionalityDetails(functionality: Functionality): void {
    this.selectedFunctionality = functionality;
    this.router.navigate(['../functionalities', this.selectedFunctionality.id], {relativeTo: this.route});
  }
  onSelect(quotation: Quotation) {
    this.selectedQuotation = quotation
  }

/*  addQuotation(client: string, name : string): void {
    name = name.trim();
    client = client.trim();
    if (!name || !client){return}
    this.quotationService.createQuotation(client, name)
      .then(quotation => {
        this.clientQuotations.push(quotation);
        this.selectedQuotation = null;
      })
  }*/

  ngOnInit(): void {
    this.sub = this.route.params.subscribe(params => {
      if (params['quotationId']) {
        this.id = params['quotationId'];
        this.getQuotationDetails(this.id);
      }
    });
  }


}
