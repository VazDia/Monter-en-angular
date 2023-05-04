import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PersonneService {

  private baseUrl = '/personnes/'

  constructor(private http : HttpClient) { }

  getPersonnes() : Observable<Object> {
    return this.http.get(this.baseUrl+"getAll");
  }

  createPersonne(personne : any): Observable<Object> {
    return this.http.post(this.baseUrl+"create", personne);
  }

  updatePersonne(id: number, personne: any): Observable<Object> {
    return this.http.put(this.baseUrl + 'update/' + id, personne);
  }

  deletePersonne(id:number) : Observable<Object>{
    return this.http.delete(this.baseUrl + 'delete/' + id);
  }
}
