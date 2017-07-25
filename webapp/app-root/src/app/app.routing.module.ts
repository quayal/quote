/**
 * Created by AdrianG on 19.07.2017.
 */
import { NgModule } from '@angular/core';
import { RouterModule, Routes} from '@angular/router';

import { QuotationComponent } from './quotation/quotation.component';
import  { ClientComponent } from './client/client.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'clients',
    pathMatch: 'full'
  },
  {
    path: 'clients',
    component: ClientComponent
  }
  ];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})

export class AppRoutingModule {}
