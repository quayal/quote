import {Injectable} from "@angular/core";

import {Headers, Http, Response} from '@angular/http';

import 'rxjs/add/operator/toPromise';
import {Functionality} from "./functionality";

@Injectable()
export class FunctionalityService {
  private functionalityUrl = 'api/functionalities'
  private headers = new Headers({'Content-Type': 'application/json'})

  constructor(private http: Http) {
  }

  public getFunctionalityDetails(functionalityId: string): Promise<Functionality> {
    return this.http.get(this.functionalityUrl + "/" + functionalityId)
      .toPromise().then((response: Response) => response.json() as Functionality)
  }
  public getAllFunctionalities(): Promise<Functionality[]> {
    return this.http.get(this.functionalityUrl)
      .toPromise().then((response: Response) => response.json() as Functionality[])
  }
}
