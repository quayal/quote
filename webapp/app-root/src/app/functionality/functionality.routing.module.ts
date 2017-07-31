import { NgModule } from '@angular/core';
import { RouterModule, Routes} from '@angular/router';

import { FunctionalityComponent } from './functionality.component';
import { ItemComponent } from '../item/item.component';

const quotationRoutes: Routes = [
  {
    path: '',
    component: FunctionalityComponent,
    children: [
      {
        path:'items',
        component: ItemComponent
      }
    ]
  },


];

@NgModule({
  imports: [ RouterModule.forChild(quotationRoutes) ],
  exports: [ RouterModule ]
})

export class FunctionalityRoutingModule {}
