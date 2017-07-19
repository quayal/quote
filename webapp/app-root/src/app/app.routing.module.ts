/**
 * Created by AdrianG on 19.07.2017.
 */
import { NgModule } from '@angular/core';
import { RouterModule, Routes} from '@angular/router';

import { QuotationComponent } from './quotation.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'api/quotations',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})

export class AppRoutingModule {}
