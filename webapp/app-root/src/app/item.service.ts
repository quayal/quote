import {Injectable} from "@angular/core";
import {Http} from "@angular/http";

import {Item} from './item';
import {containsInlineSourceMap} from "tsickle/build/definitions/source_map_utils";

@Injectable
export class ItemService {
  private itemUrl = 'api/items';
  private headers = new Headers({'Content-Type': 'application/json'})


  constructor (http: Http){}

  public getAllItems() : Promise<Item[]> {
    return this.http.get(this.itemUrl)
      .toPromise().then((response: Response) => response.json() as Item[];
  }

  public getFunctionalityItems(functionalityId: string) : Promise<Item[]> {
    const functionalityitemsUrl = this.itemUrl + "/" + )
    return this.http.get(this.)

  }
}
