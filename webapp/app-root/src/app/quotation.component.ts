/**
 * Created by AdrianG on 19.07.2017.
 */
import { Component } from '@angular/core';
import { OnInit } from '@angular/core';
import { Router } from '@angular/router';

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

  constructor(
    private quotationService: QuotationService,
    private router: Router) {}

  getQuotations(): void {
    this.quotationService.getQuotations().then((res) =>{
       this.quotations = res;
    })
}
  onSelect(quotation: Quotation) {
    this.selectedQuotation = quotation
  }
  add(client: String, name : String): void {
    name = name.trim();
    client = client.trim();
    if (!name || !client){return}
    this.quotationService.create(client, name)
      .then(quotation => {
        this.quotations.push(quotation);
        this.selectedQuotation = null;
      })
  }
  ngOnInit(): void {
    this.getQuotations();
  }


}
