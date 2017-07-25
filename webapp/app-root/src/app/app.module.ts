import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import {QuotationService} from "./quotation/quotation.service";
import {QuotationComponent} from "./quotation/quotation.component";
import {AppRoutingModule} from "./app.routing.module";
import {ClientComponent} from "./client/client.component";
import {ClientService} from "./client/client.service";
import {ClientModule} from "./client/client.module";
import {FunctionalityComponent} from "./functionality/functionality.component";
import {ItemComponent} from "./item/item.component";
import {QuotationModule} from "./quotation/quotation.module";
import {FunctionalityModule} from "./functionality/functionality.module";

@NgModule({
  declarations: [
    AppComponent,
    QuotationComponent,
    ClientComponent,
    FunctionalityComponent,
    ItemComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    ClientModule,
    QuotationModule,
    FunctionalityModule,
    AppRoutingModule
  ],
  providers: [QuotationService,
              ClientService],
  bootstrap: [AppComponent]
})
export class AppModule { }
