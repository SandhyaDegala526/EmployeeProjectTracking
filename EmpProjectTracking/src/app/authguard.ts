import {ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot} from '@angular/router';
import {Injectable} from '@angular/core';
import {Router} from '@angular/router';
import {Http, Response} from '@angular/http';
import {Headers} from '@angular/http';

@Injectable()
export class AuthGuard implements CanActivate {
  validUser = false;
  result = false;
  private errorMsg;
  private flag;

  constructor(private router: Router, private _http: Http) {
  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return new Promise<boolean>((resolve, reject) =>
      this._http.get('http://192.168.35.67:8080/EmployeeProjectTracking-1.0/login/session',
        {headers: headers, withCredentials: true
      })
        .map((response: Response) => response.json())
        .subscribe(data => {
            this.flag = data;
            if (this.flag === true) {

            } else if (this.flag === false) {
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
  }
}
/*
@Injectable()
export class AuthGuard implements CanActivate {
  validUser = false;
  result = false;

  constructor(private router: Router, private _http: Http) {
  }
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    const headers = new Headers();
    headers.append('Content-Type',
      'application/json');
    this._http.get('http://192.168.35.67:8080/EmployeeProjectTracking-1.0/login/session',
      {headers: headers, withCredentials: true })
      .map((response: Response ) => response.json())
      .subscribe(
        data => this.validUser = data,
        error => {},
        () => {
          if (this.validUser === true) {
            this.result = true;
          } else {
            this.router.navigate(['/login']);
            this.result = false;
          }
        }
      );
    return this.result;
  }
}
*/
