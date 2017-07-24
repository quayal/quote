import {Component, OnInit} from "@angular/core";
import {Functionality} from "./functionality";

@Component({
  selector: 'funtionalities',
  templateUrl: './functionalites.component.html',
  styleUrls:['./functionalities.component.css'],
  providers: [FunctionalityService]
})

export class FunctionalityComponent implements OnInit {
  quotationFunctionalities: Functionality[];



}
