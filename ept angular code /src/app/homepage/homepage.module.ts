import {NgModule } from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';
import {HttpModule} from '@angular/http';
import { HomepageComponent} from './homepage.component';
import { HomepageRoutingModule} from './homepage_routing.module';
import { ProjectsModule } from '../projects/projects.module';
import {EmployeeModule} from '../employee/employee.module';

@NgModule({
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HomepageRoutingModule,
    HttpModule,
   EmployeeModule,
    ProjectsModule
  ],
  providers: [],
  declarations: [
    HomepageComponent
  ],
  bootstrap: [HomepageComponent]
})
export class HomepageModule {}
