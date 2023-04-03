package springboot.studentMIS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.studentMIS.model.student;
@Repository
public interface StudentRepository extends JpaRepository <student, Long>{

}
