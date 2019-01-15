package Kahood2.Services;

import Kahood2.Models.TeamStudent;
import Kahood2.Repositories.ITeamStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamStudentServiceImpl implements TeamStudentService {

    @Autowired
    ITeamStudentRepository teamStudentRepository;
    @Override
    public List<TeamStudent> findAllTeamStudents() {
        return (List<TeamStudent>) teamStudentRepository.findAll();
    }

    @Override
    public void addTeamStudent(TeamStudent ts) {
        teamStudentRepository.save(ts);
    }

    @Override
    public void deleteTeamStudent(TeamStudent ts) {
        teamStudentRepository.deleteById(ts.getId());
    }

    @Override
    public TeamStudent findByTeamAndStudentId(long teamId, long studentId) {
         return teamStudentRepository.findByTeamIdAndStudentId(teamId, studentId);
    }

    @Override
    public List<TeamStudent> findTeamStudentByTeamId(long id) {
        return teamStudentRepository.findTeamStudentsByTeamId(id);
    }
}
