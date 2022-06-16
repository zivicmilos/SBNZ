import { Component, OnInit } from '@angular/core';
import { Destination } from 'src/app/model/destination-model';
import { Like } from 'src/app/model/like-model';
import { DestinationService } from 'src/app/services/destination.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  username: String = 'pera';
  transportationType: String = 'PLANE';
  budget: Number = 400;
  destinationType: String = 'PARTY';
  weather: String = "WARM";
  continent: String = 'Europe';
  destinations : Destination[] = []
  constructor(private destinationService: DestinationService) { }

  ngOnInit(): void {
  }

  findDestinations() {
    this.destinationService.findDestinations(this.username, this.transportationType, this.budget, this.destinationType,
      this.weather, this.continent).subscribe(
        (data: any) => {
          this.destinations = data;
        }
      );
    localStorage.setItem('username', this.username.toString());
  }

  like(destination: String) {
    let username = localStorage.getItem('username');
    if (username != null)
      username = username.toString();
    else 
      username = '';

    let date: Date = new Date();
    date.setHours(date.getHours()+2);
    let like: Like = new Like(username, destination, date);
    this.destinationService.like(like).subscribe(
      (data: any) => {
       if (data === 'Ok') {
        this.destinations.find(d => d.location.city === destination)?.likes.push(like);
       }
      }
    );
  }
}
