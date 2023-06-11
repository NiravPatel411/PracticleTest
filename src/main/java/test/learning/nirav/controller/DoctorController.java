package test.learning.nirav.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.learning.nirav.service.DoctorService;

import java.sql.Time;
import java.util.Map;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @CrossOrigin
    @GetMapping("/getAvailability/{id}")
    public ResponseEntity<?> getDoctorAvailablity(@PathVariable Long id){
        Map<String,Time> availability =  doctorService.getDoctorAvailablity(id);
        return new ResponseEntity<>(availability,HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping("/")
    public ResponseEntity<?> getAllDoctors(){
        return new ResponseEntity<>(doctorService.getAllDoctores(),HttpStatus.OK);
    }

}
