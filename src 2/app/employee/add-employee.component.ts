import { Component } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {EmployeeService} from './add-employee.service';
import {Validators} from '@angular/forms';
@Component({
  templateUrl: './add-employee.component.html'
})
export class AddEmployeeComponent {
  postedData: string;
  postError: string;
 flag = false;
  EmployeeDetails = [];
  employeeForm = new FormGroup({
    employeeId: new FormControl(null,  Validators.required),
    employeeName: new FormControl(),
    employeeState: new FormControl()
  });

  constructor(private _employeeService: EmployeeService) {

  }

  public addEmployee() {
    console.log('adding employee');
    this._employeeService.postEmployeeData(this.employeeForm.value.employeeId,
      this.employeeForm.value.employeeName, this.employeeForm.value.employeeState)
      .subscribe(data => {
          console.log('data');
          if ( data !== null) {
            this.flag = true;
          }
        },
        dataError => this.postError = dataError
      );

    console.log('employee details posted successfully');
  }
  getMessage()
  {
    this.flag = true;
    console.log(this.flag);
  }
}



