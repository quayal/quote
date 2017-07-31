import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes} from '@angular/router';


import {ClientsComponent} from "./clients.component";

const routes: Routes = [

  {
    path: '',
    component: ClientsComponent,
    children: [
      {
        path:':clientId', loadChildren: 'app/client/client.module#ClientModule'
      }
    ]
  }
];

@NgModule({
  imports: [ RouterModule.forChild(routes) ],
  exports: [ RouterModule ]
})

export class ClientsRoutingModule {}
