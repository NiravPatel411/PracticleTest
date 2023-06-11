package test.learning.nirav.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.learning.nirav.entity.DoctorEntity;

import java.util.Optional;

@Repository
public interface DoctorRepository extends JpaRepository<DoctorEntity,Long> {

    Optional<DoctorEntity> findAvilableFromAndAvilableToById(Long id);
}
