import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import {QuotationService} from "./quotation.service";
import {QuotationComponent} from "./quotation.component";
import {AppRoutingModule} from "./app.routing.module";
import {ClientComponent} from "./client.component";
import {ClientService} from "./client.service";

@NgModule({
  declarations: [
    AppComponent,
    QuotationComponent,
    ClientComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    AppRoutingModule
  ],
  providers: [QuotationService,
              ClientService],
  bootstrap: [AppComponent]
})
export class AppModule { }
