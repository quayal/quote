import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import {QuotationService} from "./quotation/quotation.service";
import {AppRoutingModule} from "./app.routing.module";
import {ClientService} from "./client/client.service";
import {ClientModule} from "./client/client.module";
import { ClientsComponent } from './clients/clients.component';
import {ClientsModule} from "./clients/clients.module";


@NgModule({
  declarations: [
    AppComponent,
    ClientsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ClientsModule,
    ClientModule,
    HttpModule
  ],
  providers: [QuotationService,
              ClientService],
  bootstrap: [AppComponent]
})
export class AppModule { }
