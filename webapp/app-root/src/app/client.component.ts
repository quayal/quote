/**
 * Created by AdrianG on 19.07.2017.
 */

import {Component} from '@angular/core';
import {OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {ClientService} from "./client.service";
import {Client} from "./client";

@Component({
  selector: 'clients',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css'],
  providers: [ClientService]
})

export class ClientComponent implements OnInit {
  clients: Client[];
  selectedClient: Client;

  constructor(private clientService: ClientService,
              private router: Router) {
  }

  getClients(): void {
    this.clientService.getAllClients().then(res => {
      this.clients = res
    })
  }

  gotoClientQuotations(client: Client): void {
    this.selectedClient = client;
    this.router.navigate([this.selectedClient.id, 'quotations']);
  }


  ngOnInit(){
    return this.getClients()
  }
}
