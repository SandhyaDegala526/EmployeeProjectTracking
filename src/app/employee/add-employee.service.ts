import {Injectable} from '@angular/core';
import {Http, Response , Headers} from '@angular/http';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
@Injectable()
export class EmployeeService {
  private _urlAddEmployee = 'http://192.168.35.67:8080/EmployeeProjectTracking-1.0/employee/addEmployee';

  constructor(private _http: Http) {
  }
  postEmployeeData(employee) {
    const employeeData = {
      'employeeId': employee.employeeId,
      'employeeName': employee.employeeName,
      'employeeState': employee.employeeState
    };
    const headers = new Headers();
    headers.append('Content-Type',
      'application/json');
    console.log('employee service method');
    return this._http.post(this._urlAddEmployee, employeeData)
      .map((response: Response) => response.text());

  }

}
