/**
 * Created by AdrianG on 19.07.2017.
 */

import {Injectable} from '@angular/core';
import  {Headers, Http, Response} from '@angular/http';

import 'rxjs/add/operator/toPromise';

import {Client} from "./client";


@Injectable()
export class ClientService {
  private clientUrl = 'api/clients';
  private headers = new Headers({'Content-Type': 'application/json'})

  constructor(private http: Http) {}

  getAllClients(): Promise<Client[]> {
    return this.http.get(this.clientUrl)
      .toPromise().then((response: Response) => response.json() as Client[])
  }

  getClientDetails(clientId: string): Promise <Client> {
    return this.http.get(this.clientUrl + "/" + clientId)
      .toPromise().then((response: Response) => response.json() as Client)
  }

/*  createClient(name: String):  {
    return this.http
      .post(this.clientUrl + "/new", JSON.stringify({name: name}), {headers: this.headers})
      .toPromise()
      .then((response: Response) => response.json() as Client)
  } */

  createClient(name: String): Promise<Client> {
  return this.http.post(this.clientUrl, {name: name}, {headers: this.headers}).toPromise()
      .then((response: Response) => response.json() as Client)
  }
}
