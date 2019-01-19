package Kahood2.Repositories;
import Kahood2.Models.Course;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface ICourseRepository extends CrudRepository<Course, Long> {
}

