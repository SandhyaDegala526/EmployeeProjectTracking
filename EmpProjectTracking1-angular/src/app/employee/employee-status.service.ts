import {Injectable} from '@angular/core';
import {Http, Response , Headers} from '@angular/http';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
@Injectable()
export class EmployeeStatusService {
  private _urlCheckEmpStatus: string = 'http://localhost:8080/EmployeeProjectTracking-1.0/checkEmpStatus';

  constructor(private _http: Http) {
  }

  postEmployeeId(employeeId) {
    const employeeID = {
      'employeeId': employeeId,
    };
    const headers = new Headers();
    headers.append('Content-Type',
      'application/json');
    console.log('employee service method');
    return this._http.post(this._urlCheckEmpStatus, employeeID)
      .map((response: Response) => response.json());

  }

}
