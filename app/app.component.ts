import {Component, OnInit} from '@angular/core';
import {LoginService} from './login/login.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  isloginers = false;
  constructor(private loginservice: LoginService) {}

  ngOnInit() {
    this.loginservice.changes.subscribe(status => this.isloginers = status);
  }
  logout() {
    this.isloginers = false;
  }


}


