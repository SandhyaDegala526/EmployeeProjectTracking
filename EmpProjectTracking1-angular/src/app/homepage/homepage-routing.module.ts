import {NgModule} from '@angular/core';
import {RouterModule , Routes} from '@angular/router';
import {AddEmployeeComponent} from '../employee/add-employee.component';
import {AddProjectComponent} from '../projects/add_project.component';
import {EmployeeStatusComponent} from '../employee/employee-status.component';
import {ProjectAllotmentComponent} from '../EmpProjectDetails/project-allotment.component';
import {ProjectDetailsComponent} from '../EmpProjectDetails/project-details.component';
const routes: Routes =
  [
    {path: ' ' , redirectTo: 'homepage' , pathMatch: 'full'},
    {path: 'add_employee' , component: AddEmployeeComponent},
    {path: 'add_project' , component: AddProjectComponent},
    {path: 'employee_status' , component: EmployeeStatusComponent},
    {path: 'assign_employee' , component: ProjectAllotmentComponent},
    {path: 'emp_project_details' , component: ProjectDetailsComponent}

  ];
@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class HomepageRoutingModule {}
