import {Component, OnInit} from '@angular/core';
import {LoginService} from './login/login.service';
import { Title} from '@angular/platform-browser';
import {AuthService} from './AuthService/auth.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  isloginers = false;
  postError;
  authenticateFlag: boolean;
  constructor(private loginservice: LoginService , private titleService: Title ,
              private auth: AuthService) {
    auth.handleAuthentication();
  }


  ngOnInit() {
  /*  this. auth.handleAuthentication();*/
    this.loginservice.changes.subscribe(status => this.isloginers = status);
    console.log('======session value in app component' + this.isloginers);
    this.loginservice.checkForSession()
      .subscribe(data => {
        this.isloginers = data;
          if ( this.isloginers === true) {
            console.log('+++>session exist');
            this.isloginers = data;

          } else {

            console.log('===no session');
          }
        },
        dataError => {this.postError = dataError;
        console.log(this.postError);
      });
   this.authenticateFlag = this.auth.isAuthenticated();
   console.log('auth0 isAuthenticated() value in app component ngOnInit method' + this.authenticateFlag);
  }
  logout() {
    this.loginservice.logout()
      .subscribe(reslogoutData => this.isloginers = reslogoutData);

  }
  public setTitle(title: string) {
    this.titleService.setTitle(title);
  }
}


