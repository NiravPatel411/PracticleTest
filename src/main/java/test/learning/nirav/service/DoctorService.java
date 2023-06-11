package test.learning.nirav.service;

import test.learning.nirav.entity.DoctorEntity;

import java.sql.Time;
import java.util.List;
import java.util.Map;

public interface DoctorService {
    Map<String, Time> getDoctorAvailablity(Long id);
    List<DoctorEntity> getAllDoctores();
}
