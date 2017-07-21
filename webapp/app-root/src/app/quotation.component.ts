/**
 * Created by AdrianG on 19.07.2017.
 */
import { Component } from '@angular/core';
import { OnInit } from '@angular/core';
import {Router, Route, ActivatedRoute} from '@angular/router';

import { Quotation } from './quotation';
import { QuotationService } from './quotation.service';

@Component({
  selector: 'quotations',
  templateUrl: './quotation.component.html',
  styleUrls:['./quotation.component.css'],
  providers: [ QuotationService ]
})

export class QuotationComponent implements OnInit {
  quotations: Quotation[];
  selectedQuotation: Quotation;
  private sub: any;
  private id: string;


  constructor(
    private quotationService: QuotationService,
    private router: Router,
    private route: ActivatedRoute) {}

  getQuotations(clientID: String): void {
    this.quotationService.getAllQuotations().then((res) =>{
       this.quotations = res;
    })
}

  onSelect(quotation: Quotation) {
    this.selectedQuotation = quotation
  }
  addQuotation(client: String, name : String): void {
    name = name.trim();
    client = client.trim();
    if (!name || !client){return}
    this.quotationService.createQuotation(client, name)
      .then(quotation => {
        this.quotations.push(quotation);
        this.selectedQuotation = null;
      })
  }
  ngOnInit(): void {
    this.sub = this.route.params.subscribe(params => {
      if (params['clientId']) {
        this.id = params['clientId'];
        this.getQuotations(this.id);
      }
    });
  }


}
