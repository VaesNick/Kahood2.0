package Kahood2.Services;

import Kahood2.Models.Student;
import Kahood2.Repositories.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public Student findStudentById(Long Id) {
        return studentRepository.findById(Id).get();
    }

    @Override
    public List<Student> findAllStudents() {
        return (List<Student>)studentRepository.findAll();
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void updateStudent(Student student) {
        studentRepository.save(student);
    }
}
