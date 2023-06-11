package test.learning.nirav.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.learning.nirav.entity.AppointmentEntity;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<AppointmentEntity,Long> {

    boolean existsByAppointmentDateGreaterThanAndDoctorIdAndMobileNo(LocalDateTime appointmentDate, Long id,String mobile);

    List<AppointmentEntity> findAllByMobileNo(String mobile);
}
