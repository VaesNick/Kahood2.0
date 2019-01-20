package Kahood2.Controllers;

import Kahood2.Models.Student;
import Kahood2.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping(value = "/student")
    public ResponseEntity<List<Student>> GetAll() {
        List<Student> studentlist = studentService.findAllStudents();
        if (studentlist.isEmpty()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<Student>>(studentlist, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/student/{id}")
    public ResponseEntity<Student> getAttr(@PathVariable(value="id") Long id) {
        try {
            Student student = studentService.findStudentById(id);
            return new ResponseEntity<>(student, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage() ,HttpStatus.NOT_FOUND);
        }
    }
}

