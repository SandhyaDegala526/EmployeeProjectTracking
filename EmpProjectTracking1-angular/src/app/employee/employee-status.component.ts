import { Component } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {Router} from '@angular/router';
import {EmployeeStatusService} from './employee-status.service';
@Component({
  templateUrl: './employee-status.component.html'
})
export class EmployeeStatusComponent {
  postedData: string;
  postError: string;
  assigned: boolean;
  notAssigned: boolean;
  empStatusCheckForm = new FormGroup({
    employeeId: new FormControl(),
    employeeName: new FormControl(),
    employeeState: new FormControl()
  });

  constructor(private _employeeStatusService: EmployeeStatusService, private router: Router) {

  }

  public checkEmpstatus() {
    console.log('adding employee');
    this._employeeStatusService.postEmployeeId(this.empStatusCheckForm.value.employeeId)
      .subscribe(status => {
          console.log('status');
          if ( status === true) {
            this.assigned = true;
            this.router.navigate(['./assign_employee']);
            console.log('validation successfull');
          }
          else {
            this.notAssigned = true;
          }
        },
        dataError => this.postError = dataError);
    console.log('returned employee status');
  }
}



