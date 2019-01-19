package Kahood2.Repositories;
import Kahood2.Models.Student;
import Kahood2.Models.Team;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface ITeamRepository extends CrudRepository<Team, Long> {
     Team findByCourseIdAndTeamName(Long Id, String teamName);
     void deleteByCourseIdAndTeamName(Long Id, String teamName);
     List<Team> findByCourseId(long courseId);

}

