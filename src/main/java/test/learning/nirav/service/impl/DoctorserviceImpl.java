package test.learning.nirav.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.learning.nirav.GlobalConstant;
import test.learning.nirav.entity.DoctorEntity;
import test.learning.nirav.exception.DoctorNotFoundException;
import test.learning.nirav.repository.DoctorRepository;
import test.learning.nirav.service.DoctorService;

import java.sql.Time;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DoctorserviceImpl implements DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    @Override
    public Map<String, Time> getDoctorAvailablity(Long id) {
        Optional<DoctorEntity> doctorCont = doctorRepository.findAvilableFromAndAvilableToById(id);
        if(doctorCont.isEmpty()){
            throw new DoctorNotFoundException("Doctor with id "+id+" Not Found.");
        } else {
            DoctorEntity doctor = doctorCont.get();
            Map<String, Time> map = new HashMap<>();
            map.put(GlobalConstant.AVILABLEFROM, doctor.getAvilableFrom());
            map.put(GlobalConstant.AVILABLETO, doctor.getAvilableTo());
            return map;
        }
    }

    @Override
    public List<DoctorEntity> getAllDoctores() {
        List<DoctorEntity> doctorEntities = doctorRepository.findAll();
        if(doctorEntities.isEmpty()){
            throw new DoctorNotFoundException("Doctors Not Found.");
        } else {
            return doctorEntities;
        }
    }

}
