package Kahood2.Services;

import Kahood2.Models.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    public Student findStudentById(Long Id);
    public List<Student> findAllStudents();
    public void deleteStudentById(Long id);
    public void createStudent(Student student);
    public void updateStudent(Student student);
}