import {Component, OnInit} from '@angular/core';
import {EmployeeService} from './add-employee.service';
import {Router} from '@angular/router';
@Component({
  templateUrl: './edit-employee.component.html'
})
export class EditEmployeeComponent implements OnInit {
  employeeDetails = [];
  selectedEmployee = [];
  constructor(private _employeeService: EmployeeService , private _router: Router) {
  }
   ngOnInit() {
    this._employeeService.getEmpList().subscribe(data => {
      this.employeeDetails = data;
    });
  }
  onSelect(selectedEmp) {
    this.selectedEmployee = selectedEmp;
  }
  deleteEmp(employeeId) {
this._employeeService.postDeleteEmpId(employeeId).subscribe(data => {
  if (data === true) {
    location.reload();
  }
});
  }
  }
