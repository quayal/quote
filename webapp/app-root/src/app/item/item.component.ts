import { Component } from '@angular/core';
import { OnInit } from '@angular/core';
import {Router, Route, ActivatedRoute} from '@angular/router';

import {ItemService} from "./item.service";
import {FunctionalityService} from "../functionality/functionality.service";
import {Item} from "./item";

@Component({
  selector: 'items',
  templateUrl: './item.component.html',
  styleUrls:['./item.component.css'],
  providers: [ ItemService ]
})

export class ItemComponent implements OnInit {
  items: Item[];
  selectedItem: Item;
  private sub: any;
  private id: string;
  private functionalityName: string;


  constructor(
    private functionalityService: FunctionalityService,
              private itemService: ItemService,
              private router: Router,
              private route: ActivatedRoute) {}


  getFunctionalityDetails(functionalityId: string): void {
    this.functionalityService.getFunctionalityDetails(functionalityId).then((res =>{
      this.items = res.items;
      this.functionalityName = res.name;
    } ))
  }
  onSelect(item: Item) {
    this.selectedItem = item;
  }

  addItem(name : string, time: number): void {
    name = name.trim();
    this.itemService.createItem(name, time)
      .then(item => {
        this.items.push(item);
        this.selectedItem = null;
      })
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
