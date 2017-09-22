import { NgModule } from '@angular/core';
import { RouterModule , Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { AuthGuard} from './authguard';
import { AddEmployeeComponent} from './employee/add-employee.component';
import { AddProjectComponent} from './projects/add-project.component';
import {ProjectAllotmentComponent} from './EmpProjectDetails/project-allotment.component';
import { ProjectDetailsComponent} from './EmpProjectDetails/project-details.component';
import {GetDatewiseProjectsComponent} from './projects/get-datewise-projects.component';
import { GetProjectDurationsComponent} from './projects/get-project-durations.component';
import {EditEmployeeComponent} from './employee/edit-employee.component';
import { HomepageComponent} from './homepage/homepage.component';
const routes: Routes =
  [ {path: '', redirectTo : '/emp_project_details', pathMatch : 'full'},
    {path: 'login', component: LoginComponent},
    {path: 'add_employee' , component: AddEmployeeComponent ,  canActivate: [AuthGuard]},
    {path: 'add_project' , component: AddProjectComponent ,  canActivate: [AuthGuard]},
    {path: 'assign_employee' , component: ProjectAllotmentComponent,  canActivate: [AuthGuard]},
    {path: 'assign_employee_continue' , component: ProjectAllotmentComponent , canActivate: [AuthGuard]},
    {path: 'emp_project_details' , component: ProjectDetailsComponent,  canActivate: [AuthGuard]},
    {path: 'get_datewise_projects' , component: GetDatewiseProjectsComponent,  canActivate: [AuthGuard]},
    {path: 'get_project_durations' , component: GetProjectDurationsComponent,  canActivate: [AuthGuard]},
    {path: 'employeeList' , component: EditEmployeeComponent, canActivate: [AuthGuard]},
    {path: 'home' , component: HomepageComponent }

  ];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {}
