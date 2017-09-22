import {ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot} from '@angular/router';
import {Injectable} from '@angular/core';
import {Router} from '@angular/router';
import {Http} from '@angular/http';
import {Headers} from '@angular/http';
import {AuthService} from './AuthService/auth.service';
import {LoginService} from './login/login.service';
@Injectable()
export class AuthGuard implements CanActivate {
  private errorMsg;
  private flag;
  private authFlag: boolean;

  constructor(private router: Router, private _http: Http, private auth: AuthService,
              private loginService: LoginService) {
  }

  canActivate (route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    console.log('==============> AuthGuard start');
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    this.authFlag = this.auth.isAuthenticated();
    console.log('authenticate value in authguard=' + this.authFlag);
  /*  if (!this.authFlag) {*/
      return new Promise<boolean>((resolve, reject) =>
        this.loginService.checkForSession()
          .subscribe(data => {
              this.flag = data;
              if (this.flag === true) {

              } else if (this.flag === false) {
                console.log('above alert msg please login in authguard');
                alert('please login ');
                this.router.navigate(['/login']);
              }
              resolve(true);
            }
            ,
            dataError => {
              this.errorMsg = dataError;
              resolve(false);
            }
          )
      );
    /*} else if (this.authFlag) {
      console.log('else if in authguard');
      return new Promise<boolean>((resolve, reject) =>
      this.auth.isAuthenticated());
    }*/
  }
}

