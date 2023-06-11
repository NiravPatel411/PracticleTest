package test.learning.nirav.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.learning.nirav.dto.AppointmentDto;
import test.learning.nirav.entity.AppointmentEntity;
import test.learning.nirav.service.AppointmentService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @CrossOrigin
    @PostMapping("/")
    public ResponseEntity<AppointmentDto> addAppointment(@RequestBody @Valid AppointmentDto appointmentDto){
        return new ResponseEntity<AppointmentDto>(appointmentService.addAppointment(appointmentDto), HttpStatus.CREATED);
    }

    @CrossOrigin
    @PutMapping("/")
    public ResponseEntity<AppointmentDto> UpdateAppointment(@RequestBody @Valid AppointmentDto appointmentDto){
        return new ResponseEntity<AppointmentDto>(appointmentService.updateAppointment(appointmentDto), HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/mobile/{mobileNo}")
    public ResponseEntity<List<AppointmentEntity>> getAllAppointmentByPhone(@PathVariable String mobileNo){
        return new ResponseEntity<List<AppointmentEntity>>(appointmentService.getAllAppointmentByPhone(mobileNo),HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<AppointmentEntity> getAllAppointmentById(@PathVariable Long id){
        return new ResponseEntity<AppointmentEntity>(appointmentService.getAllAppointmentById(id),HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/")
    public ResponseEntity<List<AppointmentEntity>> getAllAppointment(){
        return new ResponseEntity<List<AppointmentEntity>>(appointmentService.getAllAppointment(),HttpStatus.OK);
    }
}
