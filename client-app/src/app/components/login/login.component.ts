import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user-model';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user: User = new User();

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
  }

  login() {
    this.userService.login(this.user).subscribe(
      (data: any) => {
        if (data) {
          this.userService.setCurrentUser(data);
          this.router.navigate(['/home']);
        }
      });
  }

}
