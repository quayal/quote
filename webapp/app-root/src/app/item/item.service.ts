import {Injectable} from "@angular/core";
import {Http, Response, Headers} from "@angular/http";

import {Item} from './item';

@Injectable()
export class ItemService {
  private itemUrl = 'api/items';
  private headers = new Headers({'Content-Type': 'application/json'})


  constructor (private http: Http){}

  public getAllItems() : Promise<Item[]> {
    return this.http.get(this.itemUrl)
      .toPromise().then((response: Response) => response.json() as Item[])
  }

  public createItem(name: string, time: number) : Promise<Item> {
    return this.http
      .post(this.itemUrl, JSON.stringify({name, time}), {headers: this.headers})
      .toPromise()
      .then((response: Response) => response.json() as Item)
  }
}
