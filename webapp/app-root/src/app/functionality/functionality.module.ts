import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {FunctionalityComponent} from "./functionality.component";
import {FunctionalityService} from "./functionality.service";

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [FunctionalityComponent],
  providers: [FunctionalityService]
})
export class FunctionalityModule { }
