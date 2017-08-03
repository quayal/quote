import {Component, OnInit} from "@angular/core";
import {Functionality} from "./functionality";
import {FunctionalityService} from "./functionality.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Item} from "../item/item";
import {SelectItem} from "primeng/primeng";
import {ItemService} from "../item/item.service";

@Component({
  selector: 'functionalities',
  templateUrl: './functionality.component.html',
  styleUrls:['./functionality.component.css'],
  providers: [ FunctionalityService,
  ItemService]
})

export class FunctionalityComponent implements OnInit {

  private quotationName: string;
  functionalityName: string;
  functionalityWorkload: number;
  functionalityItems: Item[];
  itemToAdd: Item;
  items: SelectItem[];
  private selectedFunctionality: Functionality;
  private sub: any;
  private id: string;

  constructor(
    private functionalityService: FunctionalityService,
    private itemService: ItemService,
    private router: Router,
    private route: ActivatedRoute){
    this.items = [];

    this.itemService.getAllItems().then(res => {
      let arr = new Array<SelectItem>();
      for (let i of res) {
        arr.push({label: i.name, value: {name: i.name, workload: i.workload}});
      }
      this.items = arr;
    });
  }



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
