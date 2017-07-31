import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FunctionalityComponent} from "./functionality.component";
import {FunctionalityService} from "./functionality.service";
import {FunctionalityRoutingModule} from "./functionality.routing.module";
import {ItemModule} from "../item/item.module";

@NgModule({
  imports: [
    CommonModule,
    FunctionalityRoutingModule,
    ItemModule
  ],
  declarations: [FunctionalityComponent],
  providers: [FunctionalityService]
})
export class FunctionalityModule { }
