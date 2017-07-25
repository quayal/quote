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
  selector: 'clients',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css'],
  providers: [ClientService]
})

export class ClientComponent implements OnInit {
  id: string;
  selectedClient: Client;
  quotations: Quotation[];
  client: Client;
  clients: Client[];

  constructor(
    private clientService: ClientService,
    private route: ActivatedRoute,
              private router: Router) {
  }

  getClients(): void {
    this.clientService.getAllClients().then(res => {
      this.clients = res;
    })
  }

  gotoClientQuotations(client: Client): void {
    this.selectedClient = client;
    this.router.navigate(['clients', this.selectedClient.id]);
  }

  ngOnInit() {
    this.getClients()
  }
}
