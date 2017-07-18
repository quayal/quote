/**
 * Created by AdrianG on 17.07.2017.
 */

import { InMemoryDbService } from 'angular-in-memory-web-api';
export class InMemoryDataService implements InMemoryDbService {
  createDb() {
    const heroes = [
      {id: 0, name: 'Zero'},
      {id: 11, name: 'Mr. Nice'},
      {id: 12, name: 'Narco'},
      {id: 13, name: 'Bombasto'},
      {id: 14, name: 'Celeritas'},
      {id: 15, name: 'RubberMan'},
      {id: 16, name: 'Dynama'},
      {id: 17, name: 'Dr IQ'},
      {id: 18, name: 'Magma'},
      {id: 20, name: 'Tornado'}
    ];
    return {heroes};
  }
}
