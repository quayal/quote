/**
 * Created by AdrianG on 18.07.2017.
 */
import { Injectable } from '@angular/core';
import { Headers, Http, Response } from '@angular/http';

import 'rxjs/add/operator/toPromise';
import { Quotation } from './quotation';

@Injectable()
export class QuotationService {
  private quotationUrl = 'api/quotations';
  private headers = new Headers({'Content-Type': 'application/json'})

  constructor(private http: Http){}

  getClientQuotations(client: string): Promise<Quotation[]>{
    const clientQuotationUrl = this.quotationUrl + "/" + client;
    return this.http.get(clientQuotationUrl)
      .toPromise().then((response: Response) => response.json() as Quotation[])
  }

  createQuotation(client: String, name: String): Promise<Quotation> {
    return this.http
      .post(this.quotationUrl, JSON.stringify({client: client, name: name}), {headers: this.headers})
      .toPromise()
      .then((response: Response) => response.json() as Quotation)
  }


}


