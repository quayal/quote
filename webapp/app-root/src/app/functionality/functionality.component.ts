import {Component, OnInit} from "@angular/core";
import {Functionality} from "./functionality";
import {FunctionalityService} from "./functionality.service";
import {QuotationService} from "../quotation/quotation.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Item} from "../item/item";

@Component({
  selector: 'functionalities',
  templateUrl: './functionality.component.html',
  styleUrls:['./functionality.component.css'],
  providers: [ FunctionalityService ]
})

export class FunctionalityComponent implements OnInit {

  private quotationName: string;
  functionalityName: string;
  functionalityWorkload: number;
  functionalityItems: Item[];
  private selectedFunctionality: Functionality;
  private sub: any;
  private id: string;

  constructor(
    private functionalityService: FunctionalityService,
    private quotationService: QuotationService,
    private router: Router,
    private route: ActivatedRoute
  ){}

 getFunctionalityDetails(functionalityId): void {
      this.functionalityService.getFunctionalityDetails(functionalityId).then((res => {
        this.functionalityName = res.name;
        this.functionalityWorkload = res.workload;
        this.functionalityItems = res.items;
      }))

 }

  ngOnInit(): void {
    this.sub = this.route.params.subscribe(params => {
      if (params['functionalityId']) {
        this.id = params['functionalityId'];
        this.getFunctionalityDetails(this.id);
      }
    });
  }


}
