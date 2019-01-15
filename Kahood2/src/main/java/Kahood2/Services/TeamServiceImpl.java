package Kahood2.Services;

import Kahood2.Models.Team;
import Kahood2.Repositories.ITeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private ITeamRepository teamRepository;

    @Override
    public void deleteTeam(long id, String name) {
        teamRepository.deleteByCourseIdAndTeamName(id, name);
    }

    @Override
    public List<Team> findAllTeams() {
        return (List<Team>) teamRepository.findAll();
    }

    @Override
    public Team findTeamByIdAndName(Long id, String name) {
        return teamRepository.findByCourseIdAndTeamName(id, name);
    }

    @Override
    public void createTeam(Team team) {
        teamRepository.save(team);
    }

    @Override
    public void updateTeam(Team team) {
        teamRepository.save(team);
    }

    @Override
    public List<Team> findAllTeamsByCourseId(long id) {
        return teamRepository.findByCourseId(id);
    }
}