import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {ClientComponent} from "./client.component";
import {ClientService} from "./client.service";
import {ClientRoutingModule} from "./client.routing.module";
import {QuotationModule} from "../quotation/quotation.module";
import {FormsModule} from "@angular/forms";


@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ClientRoutingModule,
    QuotationModule
  ],
  declarations: [
    ClientComponent
  ],
  providers: [ClientService]
})
export class ClientModule { }
