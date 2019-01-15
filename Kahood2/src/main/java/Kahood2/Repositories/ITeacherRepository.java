package Kahood2.Repositories;
import Kahood2.Models.Teacher;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface ITeacherRepository extends CrudRepository<Teacher, Long> {
}

