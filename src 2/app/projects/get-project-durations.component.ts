import {Component, OnInit} from '@angular/core';
import {ProjectService} from './project.service';

@Component({
  templateUrl: './get-project-durations.component.html',
  styleUrls: ['./get-project-durations.component.css']
})

export class GetProjectDurationsComponent implements  OnInit {
  projectDurations= [];
  constructor(private _projectService: ProjectService ) {  }
  ngOnInit() {
    this._projectService.getProjectDurations()
      .subscribe(response => this.projectDurations = response);
  }

}
