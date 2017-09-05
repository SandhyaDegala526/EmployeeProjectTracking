import {Component, OnInit} from '@angular/core';
import { FormGroup , FormControl} from '@angular/forms';
import {Router} from '@angular/router';
import {EmployeeProjectService} from './employee-project.service';
import {ProjectService} from '../projects/project.service';
import {Title} from '@angular/platform-browser';
@Component({
  templateUrl: './project-allotment.component.html'
})

export class ProjectAllotmentComponent implements OnInit {
  projectDetails= [];
  notAssignedEmployees= [];
  projectList= [];
  employeeRoles = [];
  successFlag;
  invalidFlag;
  failFlag;
  public today;
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
    this.today = new Date().toJSON().split('T')[0];
    }
  public assignProject() {
    console.log('adding project');
    this.successFlag = false;
    this.failFlag = false;
    this.invalidFlag = false;
    this._employeeProjectService.postProjectAllotmentData(this.projectAllotmentForm.value.employeeId,
      this.projectAllotmentForm.value.projectName,
      this.projectAllotmentForm.value.employeeStartDate,
      this.projectAllotmentForm.value.employeeEndDate,
      this.projectAllotmentForm.value.employeeRole)
      .subscribe(response => {
        console.log('================>>' + response);
        if (response === 'success') {
          this.successFlag = true;
        }
        if (response === 'fail') {
          this.failFlag = true;
        }
      },
      dataError => this.postError = dataError
    );
    this.projectAllotmentForm.reset();
    console.log('project details posted successfully');
  }
}

