import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {QuotationService} from "./quotation.service";

@NgModule({
  imports: [
    CommonModule,

  ],
  declarations: [QuotationModule],
  providers: [QuotationService]
})
export class QuotationModule { }
