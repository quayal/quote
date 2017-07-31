import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {QuotationService} from "./quotation.service";
import {QuotationComponent} from "./quotation.component";
import {QuotationRoutingModule} from "./quotation.routing.module";
import {FunctionalityModule} from "../functionality/functionality.module";

@NgModule({
  imports: [
    CommonModule,
    QuotationRoutingModule,
    FunctionalityModule
  ],
  declarations: [QuotationComponent],
  providers: [QuotationService]
})
export class QuotationModule { }
