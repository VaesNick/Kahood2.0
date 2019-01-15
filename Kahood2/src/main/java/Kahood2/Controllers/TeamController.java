package Kahood2.Controllers;

import Kahood2.Models.Team;
import Kahood2.Services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeamController {

    @Autowired
    TeamService teamService;

    @GetMapping(value = "/team")
    public ResponseEntity<List<Team>> GetAll() {
        List<Team> teamlist = teamService.findAllTeams();
        if (teamlist.isEmpty()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<Team>>(teamlist, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/course/team/{id}/{name}")
    public ResponseEntity<Team> getAttr(@PathVariable(value="id") Long id, @PathVariable(value = "name") String name) {
        try {
            Team team = teamService.findTeamByIdAndName(id, name);
            return new ResponseEntity<>(team, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage() ,HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/course/team/{id}")
    public ResponseEntity<List<Team>> getAttr(@PathVariable(value="id") Long id) {
        List<Team> teamlist = teamService.findAllTeamsByCourseId(id);
        if (teamlist.isEmpty()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<Team>>(teamlist, HttpStatus.OK);
        }
    }

    @PostMapping(value = "/team")
    public ResponseEntity createTeamStudent(@RequestBody Team team){
        teamService.createTeam(team);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

