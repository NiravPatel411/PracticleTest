import { Component,OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { DatePipe } from '@angular/common';
import { AddAppointmentService } from './../add-appointment/add-appointment.service';
import { Doctors } from './../model/doctors.model';
import { AppointmentList } from './../model/appointmentList.model';
import { Appointment } from './../model/appointment.model';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-edit-appointment',
  templateUrl: './edit-appointment.component.html',
  styleUrls: ['./edit-appointment.component.scss']
})
export class EditAppointmentComponent {

  form: FormGroup = new FormGroup({});
  doctors: Doctors[] = [];
  promiseData: Promise<any> = {} as Promise<any>;
  id:any = undefined;
  appointmentList:AppointmentList = {} as AppointmentList;

    constructor(private service: AddAppointmentService,
                private fb: FormBuilder,
                private router: Router,
                public datepipe: DatePipe,
                private activeRoute: ActivatedRoute) {

         activeRoute.queryParams.subscribe((params:any) => {
            this.id = params.id;
         });
         this.initializeData();
    }

    public initializeData()
    {
         if(this.id !== null || this.id !== undefined){
         this.service.getAppointmentById(this.id).subscribe( (data: AppointmentList) => {
                  this.appointmentList = data;
                  console.log(data);
                  console.log(this.appointmentList);
                   this.form = this.fb.group({
                          name: [this.appointmentList.patientName, [Validators.required, Validators.minLength(2)]],
                          email: [this.appointmentList.emailId, [Validators.required, Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")]],
                          dob: [this.appointmentList.dateOfBirth, [Validators.required]],
                          mobile: [this.appointmentList.mobileNo,[Validators.required,Validators.pattern("^[0-9]{10}$")]],
                          appdate: [this.appointmentList.appointmentDate,[Validators.required]],
                          doctor:[this.appointmentList.doctor.id]
                        });
           });
         }
         this.service.getDoctors().subscribe(data => {
           this.doctors = data;
           console.log(JSON.stringify(this.doctors));
         });
    }

    ngOnInit(): void {

    }


  saveDetails(form: any) {
    let date = new Date(form.get('appdate').value);
    let updatedDate : any = this.datepipe.transform(date,'yyyy-MM-ddTHH:mm:ss');
    let appointment:Appointment = {
        appointmentDate: updatedDate,
        dateOfBirth: form.get('dob').value,
        doctor: form.get('doctor').value,
        emailId: form.get('email').value,
        id:this.id,
        mobileNo: form.get('mobile').value,
        patientName: form.get('name').value
    }
    this.service.updateAppointment(appointment).subscribe((data:any) => {
        alert("Your appointment is updated. Appointment No: "+this.id);
        this.form.reset();
        this.router.navigateByUrl('/list');
    },(error) => {
        alert(error.error.message);
    });
  }
}
