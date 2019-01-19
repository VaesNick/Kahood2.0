package Kahood2.Controllers;

import Kahood2.Models.Student;
import Kahood2.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class StudentController {

    StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    public StudentController(){

    }

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

