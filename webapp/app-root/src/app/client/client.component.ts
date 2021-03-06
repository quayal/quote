/**
 * Created by AdrianG on 19.07.2017.
 */

import {Component} from '@angular/core';
import {OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {ClientService} from "./client.service";
import {Client} from "./client";
import {Quotation} from "../quotation/quotation";
import {QuotationService} from "../quotation/quotation.service";

@Component({
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css'],
  providers: [ClientService]
})

export class ClientComponent implements OnInit {
  id: string;
  sub: any;
  selectedQuotation: Quotation;
  client: Client;
  clients: Client[];
  clientName: string;
  clientQuotations: Quotation[];
  newQuotationName: string;


  constructor(private clientService: ClientService,
              private route: ActivatedRoute,
              private router: Router,
              private quotationService: QuotationService) {
  }

  getClientDetails(clientId): void {
    this.clientService.getClientDetails(clientId).then((res => {
        this.clientName = res.name;
        this.clientQuotations = res.quotations
      }
    ));
  };

  addQuotation(): void {
    this.quotationService.createQuotation(this.id, this.newQuotationName).then(() => this.getClientDetails(this.id))
  }


  gotoQuotationDetails(quotation: Quotation): void {
    this.selectedQuotation = quotation;
    this.router.navigate(['../quotations', this.selectedQuotation.id], {relativeTo: this.route});
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
