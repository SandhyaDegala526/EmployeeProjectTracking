import {NgModule } from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {HttpModule} from '@angular/http';
import { HomepageComponent} from './homepage.component';
import { HomepageRoutingModule} from './homepage_routing.module';
/*
import {EmployeeModule} from '../employee/employee.module';
*/
import { CommonModule} from '@angular/common';
@NgModule({
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HomepageRoutingModule,
    FormsModule,
    HttpModule,
    /*EmployeeModule,*/
    CommonModule
  ],
  providers: [],
  declarations: [
    HomepageComponent
  ],
  bootstrap: [HomepageComponent]
})
export class HomepageModule {}
