import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CommonModule } from '@angular/common';

import {AddAppointmentComponent} from './add-appointment/add-appointment.component'
import {EditAppointmentComponent} from './edit-appointment/edit-appointment.component'
import {ListAppointmentComponent} from './list-appointment/list-appointment.component'

const routes: Routes = [
  { path: 'home', component: AddAppointmentComponent},
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'add', redirectTo: '/home', pathMatch: 'full' },
  { path: 'edit', component: EditAppointmentComponent },
  { path: 'list', component: ListAppointmentComponent }
];

@NgModule({
  imports: [CommonModule,RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
