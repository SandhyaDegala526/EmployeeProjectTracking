import { Component } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {Router} from '@angular/router';
import {EmployeeService} from './add-employee.service';
@Component({
  templateUrl: './add-employee.component.html'
})
export class AddEmployeeComponent {
  postedData: string;
  postError: string;
  EmployeeDetails = [];
  employeeForm = new FormGroup({
    employeeId: new FormControl(),
    employeeName: new FormControl(),
    employeeState: new FormControl()
  });

  constructor(private _employeeService: EmployeeService, private router: Router) {

  }

  public addEmployee() {
    console.log('adding employee');
    this._employeeService.postEmployeeData(this.employeeForm.value.employeeId,
      this.employeeForm.value.employeeName, this.employeeForm.value.employeeState)
      .subscribe(response => this.EmployeeDetails = response);
    console.log('employee details posted successfully');
  }
}



