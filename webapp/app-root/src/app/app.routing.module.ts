/**
 * Created by AdrianG on 19.07.2017.
 */
import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes} from '@angular/router';


import {ClientsComponent} from "./clients/clients.component";

const routes: Routes = [
  {
    path: '',
    redirectTo: 'clients',
    pathMatch: 'full'
  },
  {
    path: 'clients',
    component: ClientsComponent,
    children: [
      {
        path:':clientId', loadChildren: 'app/client/client.module#ClientModule'
      }
    ]
  }
  ];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})

export class AppRoutingModule {}
