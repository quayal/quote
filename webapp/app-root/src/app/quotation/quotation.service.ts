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
  private clientUrl = 'api/clients';
  private headers = new Headers({'Content-Type': 'application/json'})

  constructor(private http: Http){}

  getQuotationDetails(quotationId: string): Promise<Quotation>{
    return this.http.get(this.quotationUrl + "/" + quotationId)
      .toPromise().then((response: Response) => response.json() as Quotation)
  }

  createQuotation(clientId: string, name: string): Promise<Quotation> {
    return this.http
      .post(this.clientUrl + "/" +  clientId, {clientId: parseInt(clientId), name: name}, {headers: this.headers})
      .toPromise()
      .then((response: Response) => response.json() as Quotation)
  }


}


