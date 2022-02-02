import {Injectable} from '@angular/core';
import {HttpClient, HttpResponse} from "@angular/common/http";
import {Observable} from 'rxjs';
import {Person} from "@angular/cli/utilities/package-json";

@Injectable({
  providedIn: 'root'
})
export class ServService {

  constructor(private http: HttpClient) {
  }

  async getAll() {
    try {
      const data: any = await this.http.get('http://localhost:8082/findAllPerson');
      return data;
      //return this.http.get<Person[]>('http://localhost:8082/findAllPerson', {observe: 'response'});
    } catch (error) {
      console.error('Error ocurred ' + error);
    }
  }
}
