import { Component,OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { DatePipe } from '@angular/common';
import { AddAppointmentService } from './../add-appointment/add-appointment.service';
import { Doctors } from './../model/doctors.model';
import { AppointmentList } from './../model/appointmentList.model';
import { Router } from '@angular/router';


@Component({
  selector: 'app-list-appointment',
  templateUrl: './list-appointment.component.html',
  styleUrls: ['./list-appointment.component.scss']
})
export class ListAppointmentComponent {

appointments: AppointmentList[] = [];


  constructor(private service: AddAppointmentService,private router:Router) {
    this.service.getAllAppointment().subscribe(data => {
    this.appointments = data;
    console.log(JSON.stringify(this.appointments));
    });
  }

  redirectToEdit(id:number | null){
    this.router.navigate(['/edit'],{queryParams: {
        id: id,
      }});
  }
}
