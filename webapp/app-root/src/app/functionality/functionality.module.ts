import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FunctionalityComponent} from "./functionality.component";
import {FunctionalityService} from "./functionality.service";
import {FunctionalityRoutingModule} from "./functionality.routing.module";
import {ItemModule} from "../item/item.module";
import {FormsModule} from "@angular/forms";
import {DropdownModule} from "primeng/primeng";

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    DropdownModule,
    FunctionalityRoutingModule,
    ItemModule
  ],
  declarations: [FunctionalityComponent],
  providers: [FunctionalityService]
})
export class FunctionalityModule { }
