package Kahood2.Services;

import Kahood2.Models.TeamStudent;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface TeamStudentService {
    public List<TeamStudent> findAllTeamStudents();
    public void addTeamStudent(TeamStudent ts);
    public void deleteTeamStudent(TeamStudent ts);
    public TeamStudent findByTeamAndStudentId(long teamId, long studentId);
    public List<TeamStudent> findTeamStudentByTeamId(long id);
}

