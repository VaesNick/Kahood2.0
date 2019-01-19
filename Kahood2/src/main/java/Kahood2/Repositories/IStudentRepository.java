package Kahood2.Repositories;
import Kahood2.Models.Student;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface IStudentRepository extends CrudRepository<Student, Long> {
}

