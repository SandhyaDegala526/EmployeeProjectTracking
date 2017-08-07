import {NgModule} from '@angular/core';
import {RouterModule , Routes} from '@angular/router';
import {AddEmployeeComponent} from '../employee/add_employee.component';

const routes: Routes =
  [
    {path: ' ' , redirectTo: 'homepage' , pathMatch: 'full'},
/*
    {path: 'add_employee' , component: AddEmployeeComponent}
*/
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
