import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HeaderComponent } from './header/header.component';
import {MatToolbarModule} from '@angular/material/toolbar';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatNativeDateModule} from '@angular/material/core';
import {HttpClientModule} from '@angular/common/http';
import { AddAppointmentComponent } from './add-appointment/add-appointment.component';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { EditAppointmentComponent } from './edit-appointment/edit-appointment.component';
import { ListAppointmentComponent } from './list-appointment/list-appointment.component';
import {MatFormFieldModule} from '@angular/material/form-field';
import {NgMaterialModule} from './NgMaterialModule.module';
import { MatMomentDateModule, MAT_MOMENT_DATE_ADAPTER_OPTIONS } from '@angular/material-moment-adapter';
import { DateAdapter, MAT_DATE_FORMATS, MAT_DATE_LOCALE } from '@angular/material/core';
import { MomentDateAdapter } from '@angular/material-moment-adapter';
import { DatePipe } from '@angular/common'


import {
           NgxMatDatetimePickerModule,
           NgxMatNativeDateModule,
           NgxMatTimepickerModule
  } from '@angular-material-components/datetime-picker';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    AddAppointmentComponent,
    EditAppointmentComponent,
    ListAppointmentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatSlideToggleModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    FormsModule, ReactiveFormsModule,
    MatNativeDateModule,HttpClientModule,
    MatSidenavModule,MatIconModule,MatButtonModule,MatFormFieldModule,
    NgMaterialModule,NgxMatDatetimePickerModule,NgxMatNativeDateModule,NgxMatTimepickerModule,
    MatMomentDateModule
  ],
  providers: [DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
