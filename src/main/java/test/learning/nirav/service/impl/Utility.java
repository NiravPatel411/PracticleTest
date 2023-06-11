package test.learning.nirav.service.impl;

import org.springframework.stereotype.Service;
import test.learning.nirav.dto.AppointmentDto;
import test.learning.nirav.entity.AppointmentEntity;
import test.learning.nirav.entity.DoctorEntity;

@Service
public class Utility {

    public static AppointmentEntity getEntity(AppointmentDto appointmentDto){
        AppointmentEntity appointmentEntity = new AppointmentEntity();
        appointmentEntity.setId(appointmentDto.getId());
        appointmentEntity.setDoctor(new DoctorEntity(appointmentDto.getDoctor()));
        appointmentEntity.setPatientName(appointmentDto.getPatientName());
        appointmentEntity.setEmailId(appointmentDto.getEmailId());
        appointmentEntity.setDateOfBirth(appointmentDto.getDateOfBirth());
        appointmentEntity.setMobileNo(appointmentDto.getMobileNo());
        appointmentEntity.setAppointmentDate(appointmentDto.getAppointmentDate());
        return appointmentEntity;
    }
}
