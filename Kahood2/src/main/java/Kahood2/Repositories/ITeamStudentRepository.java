package Kahood2.Repositories;
import Kahood2.Models.TeamStudent;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

@Repository
public interface ITeamStudentRepository extends CrudRepository<TeamStudent, Long> {
    TeamStudent findByTeamIdAndStudentId(long teamId, long studentId);
    List<TeamStudent> findTeamStudentsByTeamId(long id);
}
