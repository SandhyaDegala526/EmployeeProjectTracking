import {Injectable} from '@angular/core';
import {Http, Response, Headers} from '@angular/http';
import {URLConstant} from '../constants/urlconstant';

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';

@Injectable()
export class EmployeeService {
  private _urlAddEmployee = URLConstant.EPT_URL + 'employee/addEmployee';
  private _urlIsEmpIdExist = URLConstant.EPT_URL + 'employee/checkEmpId';
  private _urlEmpList = URLConstant.EPT_URL + 'employee/employeeList';
private _urlDeleteEmp = URLConstant.EPT_URL + 'employee/deleteEmployee';

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
    return this._http.post(this._urlAddEmployee, employeeData, headers)
      .map((response: Response) => response.json());

  }
  postEmpId(employeeId) {
    const headers = new Headers();
    headers.append('Content-Type',
      'text/plain');
    return this._http.post(this._urlIsEmpIdExist, employeeId)
      .map((response: Response) => response.json());
  }
  getEmpList() {
    return this._http.get(this._urlEmpList). map((response: Response) => response.json());
  }
postDeleteEmpId(employeeId) {
    const headers = new Headers();
    headers.append('Content-Type' , 'text/plain');
    return this._http.post(this._urlDeleteEmp , employeeId , headers)
      .map((response: Response) => response.json());
}

}
