import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Like } from '../model/like-model';

@Injectable({
  providedIn: 'root'
})
export class DestinationService {
  baseUrl: String = 'http://localhost:8080/';

  constructor(private http: HttpClient) { }

  findDestinations(username: String, transportationType: String, budget: Number, destinationType: String, 
    weather: String, continent: String) {
    return this.http.get(this.baseUrl + 'destination?username='+username+'&transportationType='+transportationType+
    '&budget='+budget+'&destinationType='+destinationType+'&weather='+weather+'&continent='+continent);
  }

  like(like: Like) {
    return this.http.post(this.baseUrl + 'like', like);
  }
}
