import {Component, OnInit} from '@angular/core';
import {ProjectService} from './project.service';

@Component({
  templateUrl: './get-project-durations.component.html',
})

export class GetProjectDurationsComponent implements  OnInit {
  projectDurations= [];
  flag= false;
  constructor(private _projectService: ProjectService ) {  }
  ngOnInit() {
    this._projectService.getProjectDurations()
      .subscribe(response => this.projectDurations = response);

  }
}
