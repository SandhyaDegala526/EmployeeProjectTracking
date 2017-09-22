import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule} from '@angular/forms';
import { AddEmployeeComponent } from './add-employee.component';
import {EmployeeService} from './add-employee.service';
import {EditEmployeeComponent} from './edit-employee.component';
@NgModule({
  declarations: [
    AddEmployeeComponent,
    EditEmployeeComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [EmployeeService ],
})
export class EmployeeModule {}


