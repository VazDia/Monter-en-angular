import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DepartementService {

  private baseUrl = '/departements/'

  constructor(private http : HttpClient) { }

  getDepartements() : Observable<Object> {
    return this.http.get(this.baseUrl+"getAll");
  }

}
