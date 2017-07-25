import { NgModule } from '@angular/core';
import { RouterModule, Routes} from '@angular/router';

import { FunctionalityComponent } from '../functionality/functionality.component';
import {QuotationComponent} from "./quotation.component";

const quotationRoutes: Routes = [
  {
    path: '',
    component: QuotationComponent,
    children: [
      {
        path:'quotations/:quotationId',
        component: FunctionalityComponent
      }
    ]
  },


];

@NgModule({
  imports: [ RouterModule.forChild(quotationRoutes) ],
  exports: [ RouterModule ]
})

export class QuotationRoutingModule {}
