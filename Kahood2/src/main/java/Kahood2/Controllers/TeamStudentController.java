package Kahood2.Controllers;

import Kahood2.Models.TeamStudent;
import Kahood2.Services.TeamStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class TeamStudentController {

    @Autowired
    TeamStudentService teamStudentService;

    @GetMapping(value = "/teamStudent")
    public ResponseEntity<List<TeamStudent>> GetAll() {
        List<TeamStudent> teamlist = teamStudentService.findAllTeamStudents();
        if (teamlist.isEmpty()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<TeamStudent>>(teamlist, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/teamStudent/{id}")
    public ResponseEntity<List<TeamStudent>> getAttr(@PathVariable(value="id") Long id) {
           List<TeamStudent> teamList = teamStudentService.findTeamStudentByTeamId(id);
        if (teamList.isEmpty()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<TeamStudent>>(teamList, HttpStatus.OK);
        }
    }

    @PostMapping(value = "/teamStudent/{teamId}/{studentId}")
    public ResponseEntity createTeamStudent(@PathVariable(value="teamId") long teamId, @PathVariable(value="studentId") long studentId){
        TeamStudent ts = new TeamStudent();
        ts.setTeamId(teamId);
        ts.setStudentId(studentId);
        teamStudentService.addTeamStudent(ts);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/teamStudent/{teamId}/{studentId}")
    public ResponseEntity deleteQuiz(@PathVariable(value="teamId") long teamId, @PathVariable(value="studentId") long studentId) {
        TeamStudent ts = new TeamStudent();
        ts = teamStudentService.findByTeamAndStudentId(teamId, studentId);
        teamStudentService.deleteTeamStudent(ts);
        return new ResponseEntity("Object with id :" + studentId + " was deleted", HttpStatus.OK);
    }
}
