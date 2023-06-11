package test.learning.nirav.service;

import test.learning.nirav.dto.AppointmentDto;
import test.learning.nirav.entity.AppointmentEntity;

import java.util.List;

public interface AppointmentService {
    AppointmentDto addAppointment(AppointmentDto appointmentDto);

    AppointmentDto updateAppointment(AppointmentDto appointmentDto);

    List<AppointmentEntity> getAllAppointmentByPhone(String mobileNo);

    AppointmentEntity getAllAppointmentById(Long id);

    List<AppointmentEntity> getAllAppointment();
}
