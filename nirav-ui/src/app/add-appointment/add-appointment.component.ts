import { Component,OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { DatePipe } from '@angular/common';
import { AddAppointmentService } from './add-appointment.service';
import { Doctors } from './../model/doctors.model';
import { Appointment } from './../model/appointment.model';
import { Router } from '@angular/router';



@Component({
  selector: 'app-add-appointment',
  templateUrl: './add-appointment.component.html',
  styleUrls: ['./add-appointment.component.scss']
})
export class AddAppointmentComponent {

form: FormGroup = new FormGroup({});
doctors: Doctors[] = [];
error:any;

constructor(private fb: FormBuilder,public datepipe: DatePipe,private service: AddAppointmentService,private router:Router) {
  this.service.getDoctors().subscribe(data => {
  this.doctors = data;
  console.log(JSON.stringify(this.doctors));
  });
}

  ngOnInit(): void {
    this.form = this.fb.group({
      name: [null, [Validators.required, Validators.minLength(2)]],
      email: [null, [Validators.required, Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")]],
      dob: [null, [Validators.required]],
      mobile: [null,[Validators.required,Validators.pattern("^[0-9]{10}$")]],
      appdate: [null,[Validators.required]],
      doctor:[null]
    });
  }


  saveDetails(form: any) {
    let date = new Date(form.get('appdate').value);
    let updatedDate : any = this.datepipe.transform(date,'yyyy-MM-ddTHH:mm:ss');
    let appointment:Appointment = {
        appointmentDate: updatedDate,
        dateOfBirth: form.get('dob').value,
        doctor: form.get('doctor').value,
        emailId: form.get('email').value,
        id:null,
        mobileNo: form.get('mobile').value,
        patientName: form.get('name').value
    }
    this.service.bookAppointment(appointment).subscribe((data:any) => {
        alert("Your appointment is booked. Appointment No: "+data.id);
        this.form.reset();
        this.router.navigateByUrl('/list');
    },(error) => {
        alert(error.error.message);
    });
  }
}
