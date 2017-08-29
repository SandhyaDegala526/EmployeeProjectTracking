import {Injectable} from '@angular/core';
import {Http, Response} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import {Headers} from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import {BehaviorSubject} from 'rxjs/BehaviorSubject';

@Injectable()
export class LoginService {
  changes: BehaviorSubject <any> = new BehaviorSubject(false);
  private _urlLogIn = 'http://192.168.35.67:8080/EmployeeProjectTracking-1.0/login/verifyLoginDetails';
  private _urlLogout = 'http://192.168.35.67:8080/EmployeeProjectTracking-1.0/login/sessionDestroy';
  private _urlCheckSession = 'http://192.168.35.67:8080/EmployeeProjectTracking-1.0/login/session';

  constructor(private _http: Http) {
  }

  postData(userName, password) {
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    const postData = {
      'empId': userName,
      'password': password,
    };
    return this._http.post(this._urlLogIn, postData , {headers: headers, withCredentials: true})
      .map((response: Response) => response.json())
      .catch(this._errorHandler);

  }
  checkForSession() {
   var headers = new Headers();
   headers.append('Content-Type', ' application/json');

    return this._http.get(this._urlCheckSession, {headers: headers, withCredentials: true })
      .map((response: Response) => response.json());

  }
  logout() {
    var headers = new Headers();
    headers.append('Content-Type', ' application/json');

    return this._http.get(this._urlLogout, {headers: headers, withCredentials: true })
      .map((response: Response) => response.json());
  }

  _errorHandler(error: Response) {
    return Observable.throw(error || 'json url not found');
  }
}
