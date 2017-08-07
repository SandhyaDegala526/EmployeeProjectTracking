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
 notValid= false;
  managerForm = new FormGroup({
    userName: new FormControl(),
    password: new FormControl()
  });
  constructor(private _loginService: LoginService, private router: Router) {

  }

  public onSubmit() {
    console.log('login');
    this._loginService.postData(this.managerForm.value.userName, this.managerForm.value.password)
      .subscribe(data => {
      console.log('data');
          if ( data === true) {
           this.valid = true;
            console.log('validation successfull');
            this.router.navigate(['./homepage']);
          }
          else {
            this.notValid = true;
          }
        },
        dataError => this.postError = dataError);
  }
}

