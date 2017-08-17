import {Component, OnInit} from '@angular/core';
import { FormGroup , FormControl} from '@angular/forms';
import {Router} from '@angular/router';
import {EmployeeProjectService} from './employee-project.service';
import {ProjectService} from '../projects/project.service';
@Component({
  templateUrl: './project-allotment.component.html'
})

export class ProjectAllotmentComponent implements OnInit {
  projectDetails= [];
  notAssignedEmployees= [];
  projectList= [];
  employeeRoles = [];
  flag= false;
  postError: string;
  projectAllotmentForm = new FormGroup({
    employeeId: new FormControl(),
    projectName: new FormControl(),
    employeeStartDate: new FormControl(),
    employeeEndDate: new FormControl(),
    employeeRole: new FormControl()
  });
  constructor(private _employeeProjectService: EmployeeProjectService , private _projectService: ProjectService) {
  }
  ngOnInit() {
    this._employeeProjectService.getNotAssignedEmployees()
      .subscribe(response => this.notAssignedEmployees = response);
      this._projectService.getProjectList()
        .subscribe(response => this.projectList = response);
    this._employeeProjectService.getProjectDetails()
      .subscribe(response => this.projectDetails = response);
    this._employeeProjectService.getEmployeeRoles()
      .subscribe(response => this.employeeRoles = response);
    }
  public assignProject() {
    console.log('adding project');
    let employeeName;
    for ( let i = 0; i < this.notAssignedEmployees.length; i++) {
      if (this.notAssignedEmployees[i].employeeId === this.projectAllotmentForm.value.employeeId) {
        employeeName = this.notAssignedEmployees[i].employeeName;
        console.log(employeeName);
      }
    }
    this._employeeProjectService.postProjectAllotmentData(this.projectAllotmentForm.value.employeeId,
      employeeName,
      this.projectAllotmentForm.value.projectName,
      this.projectAllotmentForm.value.employeeStartDate,
      this.projectAllotmentForm.value.employeeEndDate,
      this.projectAllotmentForm.value.employeeRole)
      .subscribe(response => {
        console.log('response');
        if ( response !== null) {
          this.flag = true;
        }
      },
      dataError => this.postError = dataError
    );
    this.projectAllotmentForm.reset();
    console.log('project details posted successfully');
  }
  getMessage() {
    this.flag = true;
  }


}
