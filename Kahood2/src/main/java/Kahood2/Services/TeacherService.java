package Kahood2.Services;

import Kahood2.Models.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TeacherService {
    public Teacher findTeacherById(Long Id);

    public List<Teacher> findAllTeachers();

    public void deleteTeacherById(Long id);

    public void createTeacher(Teacher Teacher);

    public void updateTeacher(Teacher teacher);
}