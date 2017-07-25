import {Component, OnInit} from "@angular/core";
import {Functionality} from "./functionality";
import {FunctionalityService} from "./functionality.service";
import {QuotationService} from "../quotation/quotation.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'functionalities',
  templateUrl: './functionalites.component.html',
  styleUrls:['./functionalities.component.css'],
  providers: [ FunctionalityService ]
})

export class FunctionalityComponent implements OnInit {

  private quotationName: string;
  private quotationFunctionalities: Functionality[];
  private selectedFunctionality: Functionality;
  private sub: any;
  private id: string;

  constructor(
    private functionalityService: FunctionalityService,
    private quotationService: QuotationService,
    private router: Router,
    private route: ActivatedRoute
  ){}

  gotoFunctionalityItems(functionality: Functionality){
      this.selectedFunctionality = functionality;
      this.router.navigate(['functionalities', this.selectedFunctionality.id])
        }

  getQuotationDetails(quotationId): void {
    this.quotationService.getQuotationDetails(quotationId).then((res => {
        this.quotationName = res.name;
        this.quotationFunctionalities = res.functionalities
      }
      ));
    };

  ngOnInit(): void {
    this.sub = this.route.params.subscribe(params => {
      if (params['quotationId']) {
        this.id = params['quotationId'];
        this.getQuotationDetails(this.id);
      }
    });
  }


}
