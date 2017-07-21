/**
 * Created by AdrianG on 19.07.2017.
 */
import { NgModule } from '@angular/core';
import { RouterModule, Routes} from '@angular/router';

import { QuotationComponent } from './quotation.component';
import  { ClientComponent } from './client.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'clients',
    pathMatch: 'full'
  },
  {
    path: 'quotations',
    component: QuotationComponent
  },
  {
    path: 'clients',
    component: ClientComponent
  },
  {
    path: ':clientId/quotations',
    component: QuotationComponent
  },


];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})

export class AppRoutingModule {}
