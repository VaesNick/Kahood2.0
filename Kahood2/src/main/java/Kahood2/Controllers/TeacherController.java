package Kahood2.Controllers;

import Kahood2.Models.Teacher;
import Kahood2.Services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @GetMapping(value = "/teacher")
    public ResponseEntity<List<Teacher>> GetAll() {
        List<Teacher> teacherlist = teacherService.findAllTeachers();
        if (teacherlist.isEmpty()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<Teacher>>(teacherlist, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/teacher/{id}")
    public ResponseEntity<Teacher> getAttr(@PathVariable(value="id") Long id) {
        try {
            Teacher teacher = teacherService.findTeacherById(id);
            return new ResponseEntity<>(teacher, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage() ,HttpStatus.NOT_FOUND);
        }
    }
}
