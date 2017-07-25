/**
 * Created by AdrianG on 18.07.2017.
 */
import { Injectable } from '@angular/core';
import { Headers, Http, Response } from '@angular/http';

import 'rxjs/add/operator/toPromise';
import { Quotation } from './quotation';
import {Functionality} from "../functionality/functionality";

@Injectable()
export class QuotationService {
  private quotationUrl = 'api/quotations';
  private headers = new Headers({'Content-Type': 'application/json'})

  constructor(private http: Http){}

  getQuotationDetails(quotationId: string): Promise<Quotation>{
    return this.http.get(this.quotationUrl + "/" + quotationId)
      .toPromise().then((response: Response) => response.json() as Quotation)
  }

  createQuotation(client: String, name: String): Promise<Quotation> {
    return this.http
      .post(this.quotationUrl, JSON.stringify({client: client, name: name}), {headers: this.headers})
      .toPromise()
      .then((response: Response) => response.json() as Quotation)
  }


}


