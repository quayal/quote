import { Component, OnInit } from '@angular/core';
import {Client} from "../client/client";
import {ClientService} from "../client/client.service";
import {Router} from "@angular/router";

@Component({
  templateUrl: './clients.component.html',
  styleUrls: ['./clients.component.css']
})
export class ClientsComponent implements OnInit {

  clients: Client[];
  selectedClient: Client;


  constructor(
    private clientService: ClientService,
    private router: Router
  ) { }

  gotoClientDetails(client: Client): void {
    this.selectedClient = client;
    this.router.navigate(['clients', this.selectedClient.id]);
  }

  checkIfChildUrl(): boolean {
    let regex = new RegExp('^\/clients\/.+$');
    return regex.test(this.router.url);
}

  ngOnInit(){
    this.clientService.getAllClients().then(res => {
      this.clients = res;
    })
  }

}
