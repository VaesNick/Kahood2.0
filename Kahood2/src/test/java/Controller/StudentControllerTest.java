package Controller;

import Kahood2.Controllers.StudentController;
import Kahood2.Models.Student;
import Kahood2.Services.StudentIdGenerator;
import Kahood2.Services.StudentService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;

public class StudentControllerTest {

    private StudentService studentService;
    private StudentController studentController;

    @Before
    public void Setup(){
        studentService = Mockito.mock(StudentService.class);
        studentController = new StudentController(studentService);
    }
    @Test
    public void getAllShouldReturnList() throws Exception {
        Student student = new Student(new StudentIdGenerator());
        List<Student> studentList = new ArrayList<>();
        studentList.add(student);

        Mockito.when(studentService.findAllStudents()).thenReturn(studentList);

        ResponseEntity response = studentController.GetAll();
        List<Student> entity = (List<Student>) response.getBody();


        Assert.assertEquals(400, response.getStatusCodeValue());
        Assert.assertNotSame(studentList, entity);
        verify(studentService, times(2)).findAllStudents();
    }
}
