import { Doctors } from './doctors.model';

export interface AppointmentList {
  appointmentDate: string,
  dateOfBirth: string,
  doctor: Doctors,
  emailId: string,
  id: number | null,
  mobileNo: string,
  patientName: string

}
