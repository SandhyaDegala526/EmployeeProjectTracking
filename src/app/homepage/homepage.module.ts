import {NgModule } from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';
import {HttpModule} from '@angular/http';
import { HomepageComponent} from './homepage.component';
import { ProjectsModule } from '../projects/projects.module';
import {EmployeeModule} from '../employee/employee.module';
import { ProjectAllotmentModule} from '../EmpProjectDetails/employee-project.module';

@NgModule({
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HttpModule,
   EmployeeModule,
    ProjectsModule,
    ProjectAllotmentModule
  ],
  providers: [],
  declarations: [
    HomepageComponent
  ],
  bootstrap: [HomepageComponent]
})
export class HomepageModule {}
