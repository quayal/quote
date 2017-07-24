/**
 * Created by AdrianG on 19.07.2017.
 */
import { Component } from '@angular/core';
import { OnInit } from '@angular/core';
import {Router, Route, ActivatedRoute} from '@angular/router';

import { Quotation } from './quotation';
import { QuotationService } from './quotation.service';
import {ClientService} from "./client.service";

@Component({
  selector: 'quotations',
  templateUrl: './quotation.component.html',
  styleUrls:['./quotation.component.css'],
  providers: [ QuotationService ]
})

export class QuotationComponent implements OnInit {
  clientQuotations: Quotation[];
  selectedQuotation: Quotation;
  private sub: any;
  private id: string;
  private clientName: string;


  constructor(private quotationService: QuotationService,
              private clientService: ClientService,
              private router: Router,
              private route: ActivatedRoute) {}


  getClientDetails(clientId: string): void {
    this.clientService.getClientDetails(clientId).then((res =>{
      this.clientQuotations = res.quotations;
      this.clientName = res.name;
    } ))
  }
  onSelect(quotation: Quotation) {
    this.selectedQuotation = quotation
  }
  addQuotation(client: string, name : string): void {
    name = name.trim();
    client = client.trim();
    if (!name || !client){return}
    this.quotationService.createQuotation(client, name)
      .then(quotation => {
        this.clientQuotations.push(quotation);
        this.selectedQuotation = null;
      })
  }
  ngOnInit(): void {
    this.sub = this.route.params.subscribe(params => {
      if (params['clientId']) {
        this.id = params['clientId'];
        this.getClientDetails(this.id);
      }
    });
  }


}
