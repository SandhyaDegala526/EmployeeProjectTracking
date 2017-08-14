import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpModule} from '@angular/http';
import {FormsModule , ReactiveFormsModule} from '@angular/forms';
import { AddProjectComponent } from './add-project.component';
import {ProjectService} from './project.service';
import { GetDatewiseProjectsComponent} from './get-datewise-projects.component';
import { GetProjectDurationsComponent} from './get-project-durations.component';
@NgModule({
  declarations: [
    AddProjectComponent,
    GetDatewiseProjectsComponent,
    GetProjectDurationsComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [ProjectService],
  bootstrap: [AddProjectComponent]
})
export class ProjectsModule {}

