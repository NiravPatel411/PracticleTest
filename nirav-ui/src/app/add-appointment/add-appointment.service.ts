import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { Doctors } from './../model/doctors.model';
import { Appointment } from './../model/appointment.model';
import { AppointmentList } from './../model/appointmentList.model';
import { HttpEvent, HttpInterceptor, HttpHandler, HttpRequest, HttpResponse,
         HttpErrorResponse } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AddAppointmentService {

  getAllDoctors:any = 'http://localhost:8080/doctor/';
  getAllAppointments:any = 'http://localhost:8080/appointment/';
  getAppointmentByIdURL:any = 'http://localhost:8080/appointment/';
  bookAppointmentURL:any = 'http://localhost:8080/appointment/';

  constructor(private http: HttpClient) { }

  getDoctors():Observable<Doctors[]>{
      return this.http.get<Doctors[]>(this.getAllDoctors);
  }

  bookAppointment(appointment:Appointment):Observable<HttpEvent<any>>{
      const headers = { 'content-type': 'application/json'}
      const body=JSON.stringify(appointment);
      return this.http.post<any>(this.bookAppointmentURL,body,{'headers':headers});
  }

    updateAppointment(appointment:Appointment):Observable<HttpEvent<any>>{
        const headers = { 'content-type': 'application/json'}
        const body=JSON.stringify(appointment);
        return this.http.put<any>(this.bookAppointmentURL,body,{'headers':headers});
    }

  getAllAppointment():Observable<AppointmentList[]>{
    return this.http.get<AppointmentList[]>(this.getAllAppointments);
  }

   getAppointmentById(id:number):Observable<AppointmentList>{
      return this.http.get<AppointmentList>(this.getAppointmentByIdURL+id);
  }

}
