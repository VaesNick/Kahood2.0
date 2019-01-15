package Kahood2.Services;

import Kahood2.Models.Team;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeamService {
    public void deleteTeam(long id, String name);
    public List<Team> findAllTeams();
    public Team findTeamByIdAndName(Long id, String name);
    public void createTeam(Team team);
    public void updateTeam(Team team);
}