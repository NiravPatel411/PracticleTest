package test.trootech.nirav.service;

import test.trootech.nirav.dto.AppointmentDto;
import test.trootech.nirav.entity.AppointmentEntity;

import java.util.List;

public interface AppointmentService {
    AppointmentDto addAppointment(AppointmentDto appointmentDto);

    AppointmentDto updateAppointment(AppointmentDto appointmentDto);

    List<AppointmentEntity> getAllAppointmentByPhone(String mobileNo);

    AppointmentEntity getAllAppointmentById(Long id);

    List<AppointmentEntity> getAllAppointment();
}
