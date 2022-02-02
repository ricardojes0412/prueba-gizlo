import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from 'rxjs';
import {Person} from "@angular/cli/utilities/package-json";

@Injectable({
  providedIn: 'root'
})
export class ServService {

  constructor(private http: HttpClient) {
  }

  public getall(): Observable<Person> {
    return this.http.get('http://localhost:8082/findAllPerson');
  }
}
