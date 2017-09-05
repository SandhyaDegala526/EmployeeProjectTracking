import {Component, OnInit} from '@angular/core';
import {LoginService} from './login/login.service';
import { Title} from '@angular/platform-browser';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  isloginers = false;
  postError;
  constructor(private loginservice: LoginService , private titleService: Title) {}


  ngOnInit() {
    this.loginservice.changes.subscribe(status => this.isloginers = status);
    this.loginservice.checkForSession()
      .subscribe(data => {
          if ( data === true) {
            console.log('data is valid');
            this.isloginers = data;

          } else {

            console.log('no session');
          }
        },
        dataError => {this.postError = dataError;
        console.log(this.postError);
      });
  }
  logout() {
    this.loginservice.logout()
      .subscribe(reslogoutData => this.isloginers = reslogoutData);

  }
  public setTitle(title: string) {
    this.titleService.setTitle(title);
  }



}


