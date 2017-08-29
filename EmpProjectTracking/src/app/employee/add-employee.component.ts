import {Component} from '@angular/core';
import {EmployeeService} from './add-employee.service';
import {HTTPConstants} from '../constants/httpconstants';

@Component({
  templateUrl: './add-employee.component.html'
})
export class AddEmployeeComponent {
  duplicateFlag;
  sucessFlag;
  failFlag;
  employeeValues = {
    employeeId: '',
    employeeName: '',
    employeeState: ''
  }

  constructor(private _employeeService: EmployeeService) {

  }

  public addEmployee(value) {
    console.log('adding employee');
    this.sucessFlag = false;
    this.duplicateFlag = false;
    this.failFlag = false;
    this.employeeValues.employeeId = value.employeeId;
    this.employeeValues.employeeName = value.employeeName;
    this.employeeValues.employeeState = value.employeeState;
    this._employeeService.postEmployeeData(this.employeeValues)
      .subscribe(data => {
          let responsecode = data[HTTPConstants.EPT_APP_HEADER_RESPONSE_CODE];
          let reasoncode = data[HTTPConstants.EPT_APP_HEADER_REASON_CODE];
          if (responsecode === HTTPConstants.EPT_STATUS_CODE_SUCCESS) {
            if (reasoncode === HTTPConstants.EPT_APP_REASON_CODE_EMPLOYEE_ADDED) {
              this.sucessFlag = true;
            }
          } else if (responsecode == HTTPConstants.EPT_STATUS_CODE_FAILURE) {
            if (reasoncode == HTTPConstants.EPT_APP_REASON_CODE_EMPLOYEE_EXISTS) {
              this.duplicateFlag = true;
            } else if (reasoncode == HTTPConstants.EPT_APP_REASON_CODE_INTERNAL_ERROR) {
              this.failFlag = true;
            }
          }
        }
        ,
        error => {
          console.log('Error!!', error);
        }
      )
    ;
  }
}


