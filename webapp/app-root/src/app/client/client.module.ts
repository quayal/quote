import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {ClientComponent} from "./client.component";
import {ClientService} from "./client.service";
import {ClientRoutingModule} from "./client.routing.module";


@NgModule({
  imports: [
    CommonModule,
    ClientRoutingModule
  ],
  declarations: [
    ClientComponent
  ],
  providers: [ClientService]
})
export class ClientModule { }
