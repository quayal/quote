/**
 * Created by AdrianG on 19.07.2017.
 */

import {Component} from '@angular/core';
import {OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {ClientService} from "./client.service";
import {Client} from "./client";
import {Quotation} from "./quotation";
import {QuotationService} from "./quotation.service";

@Component({
  selector: 'clients',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css'],
  providers: [ClientService]
})

export class ClientComponent implements OnInit {
  clients: Client[];
  selectedClient: Client;
  quotations: Quotation[];
  quotationService: QuotationService;
  client: Client;

  constructor(private clientService: ClientService,
              private router: Router) {
  }

  getClients(): void {
    this.clientService.getAllClients().then(res => {
      this.clients = res
    })
  }
  getClientsDetails(clientID: string): void {
    this.clientService.getClientDetails(clientID).then((res) =>{
      this.client = res;
    })
  }

  gotoClientQuotations(client: Client): void {
    this.selectedClient = client;
    this.router.navigate(['clients', this.selectedClient.id]);
  }


  ngOnInit(){
    return this.getClients()
  }
}
