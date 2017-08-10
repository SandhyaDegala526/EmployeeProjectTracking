import {Component, OnInit} from '@angular/core';
import { FormGroup , FormControl} from '@angular/forms';
import {Router} from '@angular/router';
import {ProjectAllotmentService} from './project-allotment.service';
@Component({
  templateUrl: './project-allotment.component.html'
})

export class ProjectAllotmentComponent implements OnInit{
  projectDetails= [];
  notAssignedEmployees= [];
  projectAllotmentForm = new FormGroup({
    employeeId: new FormControl(),
    projectName: new FormControl(),
    employeeStartDate: new FormControl(),
    employeeEndDate: new FormControl(),
    employeeRole: new FormControl()
  });
  constructor(private _projectAllotmentService: ProjectAllotmentService , private _router: Router) {
  }
  ngOnInit() {
    this._projectAllotmentService.getNotAssignedEmployees()
      .subscribe(response => this.notAssignedEmployees = response);
  }
  public assignProject() {
    console.log('adding project');
    this._projectAllotmentService.postProjectAllotmentData(this.projectAllotmentForm.value.employeeId,
      this.projectAllotmentForm.value.projectName,
      this.projectAllotmentForm.value.employeeStartDate,
      this.projectAllotmentForm.value.employeeEndDate,
      this.projectAllotmentForm.value.employeeRole)
      .subscribe(response => this.projectDetails = response);
    console.log('project details posted successfully');
  }

}
