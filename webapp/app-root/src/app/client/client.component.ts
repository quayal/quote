/**
 * Created by AdrianG on 19.07.2017.
 */

import {Component} from '@angular/core';
import {OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {ClientService} from "./client.service";
import {Client} from "./client";
import {Quotation} from "../quotation/quotation";

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


  constructor(
    private clientService: ClientService,
    private route: ActivatedRoute,
              private router: Router) {
  }

  getClientDetails(clientId): void {
    this.clientService.getClientDetails(clientId).then((res => {
        this.clientName = res.name;
        this.clientQuotations = res.quotations
      }
    ));
  };

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
