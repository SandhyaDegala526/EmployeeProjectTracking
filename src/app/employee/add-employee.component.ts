import {Component} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {EmployeeService} from './add-employee.service';

@Component({
  templateUrl: './add-employee.component.html'
})
export class AddEmployeeComponent {
  postedData: string;
  postError: string;
  duplicateFlag;
  sucessFlag;
  failFlag;
  employeeValues = {employeeId: '',
    employeeName: '',
    employeeState: ''}
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
          console.log(data);
          if (data === 'success') {
            this.sucessFlag = true;
          }
          if (data === 'fail') {
            this.failFlag = true;
          }
          if (data === 'isAlreadyExist') {
            this.duplicateFlag = true;
          }
        },
        dataError => this.postError = dataError
      );
    /*value.employeeForm = null;*/

    console
      .log(
        'employee details posted successfully'
      );
  }
}



