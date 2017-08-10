import {Injectable} from '@angular/core';
import {Http, Response} from '@angular/http';

import {Headers} from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
@Injectable()
export class LoginService {
  private _urlLogIn: string = 'http://localhost:8080/EmployeeProjectTracking-1.0/verify';

  constructor(private _http: Http) {
  }

  postData(userName, password) {
    const postData = {
      'empId': userName,
      'password': password,
    };
    const headers = new Headers();
    headers.append('Content-Type',
      'application/json');

    return this._http.post(this._urlLogIn, postData)
      .map((response: Response) => response.json());

  }
}
