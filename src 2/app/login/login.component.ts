import {Component} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {LoginService} from './login.service';
import {Router} from '@angular/router';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  postedData: string;
  postError: string;
 valid= false;
  LoginForm = new FormGroup({
    userName: new FormControl(),
    password: new FormControl()
  });
  constructor(private _loginService: LoginService, private router: Router) {

  }

  public onSubmit() {
    console.log('login');
    this._loginService.postData(this.LoginForm.value.userName, this.LoginForm.value.password)
      .subscribe(data => {
      console.log('data');
          if ( data === true) {
            this._loginService.changes.next(true);
            console.log('validation successfull');
            this.router.navigate(['./homepage']);
          }
          else {
            alert('Invaid username or password');
          }
        },
        dataError => this.postError = dataError);
  }
}
