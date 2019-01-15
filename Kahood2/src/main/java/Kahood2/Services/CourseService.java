package Kahood2.Services;


import Kahood2.Models.Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
    public Course findCourseById(Long Id);
    public List<Course> findAllCourses();
    public void deleteCourseById(Long id);
    public void createCourse(Course course);
    public void updateCourse(Course course);
}