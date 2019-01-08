package Kahood2.Controllers;

import Kahood2.Models.Course;
import Kahood2.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping(value = "/course")
    public ResponseEntity<List<Course>> GetAll() {
        List<Course> courselist = courseService.findAllCourses();
        if (courselist.isEmpty()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<Course>>(courselist, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/course/{id}")
    public ResponseEntity<Course> getAttr(@PathVariable(value="id") Long id) {
        try {
            Course course = courseService.findCourseById(id);
            return new ResponseEntity<>(course, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage() ,HttpStatus.NOT_FOUND);
        }
    }
}

