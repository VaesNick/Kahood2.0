package Kahood2.Services;

import Kahood2.Models.Teacher;
import Kahood2.Repositories.ITeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService{

    @Autowired
    ITeacherRepository teacherRepository;

    @Override
    public Teacher findTeacherById(Long Id) {
        return teacherRepository.findById(Id).get();
    }

    @Override
    public List<Teacher> findAllTeachers() {
       return (List<Teacher>) teacherRepository.findAll();
    }

    @Override
    public void deleteTeacherById(Long id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public void createTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }
}
