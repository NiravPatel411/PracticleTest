package test.learning.nirav.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.learning.nirav.GlobalConstant;
import test.learning.nirav.dto.AppointmentDto;
import test.learning.nirav.entity.AppointmentEntity;
import test.learning.nirav.exception.AppointmentAlreadyAvailableException;
import test.learning.nirav.exception.DoctorNotAvailableException;
import test.learning.nirav.exception.DoctorNotFoundException;
import test.learning.nirav.exception.InValidRequestException;
import test.learning.nirav.repository.AppointmentRepository;
import test.learning.nirav.repository.DoctorRepository;
import test.learning.nirav.service.AppointmentService;
import test.learning.nirav.service.DoctorService;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    DoctorService doctorService;

    @Override
    public AppointmentDto addAppointment(AppointmentDto appointmentDto) {
        validateAppointmentDto(appointmentDto);
        if(appointmentDto.getId() != null){
            throw new InValidRequestException("Id should be null while adding appointment");
        }
        if(appointmentRepository.existsByAppointmentDateGreaterThanAndDoctorIdAndMobileNo(LocalDateTime.now(), appointmentDto.getDoctor(),appointmentDto.getMobileNo())){
            throw new AppointmentAlreadyAvailableException("Already have an appointment with this doctor");
        }
        AppointmentEntity appointmentEntity = Utility.getEntity(appointmentDto);
        appointmentEntity = appointmentRepository.save(appointmentEntity);
        appointmentDto.setId(appointmentEntity.getId());
        return appointmentDto;
    }

    private void validateAppointmentDto(AppointmentDto appointmentDto) {
        if(appointmentDto == null){
            throw new InValidRequestException("Request Body can not be null.");
        }
        if(!doctorRepository.existsById(appointmentDto.getDoctor())){
            throw new DoctorNotFoundException("Invalid doctor id. doctor can not be found");
        }
        if(appointmentDto.getAppointmentDate().isBefore(LocalDateTime.now())){
            throw new InValidRequestException("Appointment date should be future date");
        }
        if(!isDoctorAvailable(appointmentDto)){
            throw new DoctorNotAvailableException("Doctor is not available on your slot");
        }
    }

    @Override
    public AppointmentDto updateAppointment(AppointmentDto appointmentDto) {
        validateAppointmentDto(appointmentDto);
        if(appointmentDto.getId() == null){
            throw new InValidRequestException("Id can not be null while updating appointment");
        }
        AppointmentEntity appointmentEntity = Utility.getEntity(appointmentDto);
        appointmentEntity = appointmentRepository.save(appointmentEntity);
        appointmentDto.setId(appointmentEntity.getId());
        return appointmentDto;
    }

    @Override
    public List<AppointmentEntity> getAllAppointmentByPhone(String mobileNo) {
        List<AppointmentEntity> appointmentEntities = appointmentRepository.findAllByMobileNo(mobileNo);
        if(appointmentEntities == null || appointmentEntities.isEmpty()){
            throw new InValidRequestException("Either Invalid mobile no or appointment not found");
        }
        return appointmentEntities;
        /*ModelMapper modelMapper = new ModelMapper();
        Type listType = new TypeToken<List<AppointmentDto>>(){}.getType();
        modelMapper.typeMap(AppointmentEntity.class, AppointmentDto.class)
                .addMappings(mapping -> mapping.map(source -> source.getDoctor().getId(),
                        (destination, value) -> destination.setDoctor((Long) value)));
        List<AppointmentDto> appointmentDtos =  modelMapper.map(appointmentEntities,listType);
        return appointmentDtos;*/
    }

    @Override
    public AppointmentEntity getAllAppointmentById(Long id) {
        Optional<AppointmentEntity> optionalAppointment = appointmentRepository.findById(id);
        if(optionalAppointment.isEmpty()){
            throw new InValidRequestException("Invalid Id or appointment does not exist.");
        }
        return optionalAppointment.get();
    }

    @Override
    public List<AppointmentEntity> getAllAppointment() {
        return appointmentRepository.findAll();
    }

    private boolean isDoctorAvailable(AppointmentDto appointmentDto){
        Map<String, Time> doctorAvailability =  doctorService.getDoctorAvailablity(appointmentDto.getDoctor());
        long from = doctorAvailability.get(GlobalConstant.AVILABLEFROM).getTime();
        long to = doctorAvailability.get(GlobalConstant.AVILABLETO).getTime();
        long appointmentTime = Time.valueOf(appointmentDto.getAppointmentDate().toLocalTime()).getTime();;
        return appointmentTime > from && appointmentTime < to;
    }
}
