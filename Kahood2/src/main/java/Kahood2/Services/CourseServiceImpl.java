package Kahood2.Services;

import Kahood2.Models.Course;
import Kahood2.Repositories.ICourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private ICourseRepository courseRepository;

    @Override
    public Course findCourseById(Long Id) {
        return courseRepository.findById(Id).get();
    }

    @Override
    public List<Course> findAllCourses() {
        return (List<Course>) courseRepository.findAll();
    }

    @Override
    public void deleteCourseById(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public void createCourse(Course course) {
        courseRepository.save(course);
    }

    @Override
    public void updateCourse(Course course) {
        courseRepository.save(course);
    }
}