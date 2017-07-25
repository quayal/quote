import { NgModule } from '@angular/core';
import { RouterModule, Routes} from '@angular/router';

import { QuotationComponent } from '../quotation/quotation.component';
import  { ClientComponent } from './client.component';

const clientRoutes: Routes = [
  {
    path: 'clients',
    component: ClientComponent,
    children: [
      {
        path:':clientId',
        component: QuotationComponent
      }
    ]
  },


];

@NgModule({
  imports: [ RouterModule.forChild(clientRoutes) ],
  exports: [ RouterModule ]
})

export class ClientRoutingModule {}
