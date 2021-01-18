package com.example.elearning.api;

import com.example.elearning.dao.CourseDao;
import com.example.elearning.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CourseApi {

    private CourseDao courseDao;

    @Autowired
    public CourseApi(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    //wypisanie wszystkich kursów
    @GetMapping("/course/getCourses")
    public List<Map<String, Object>> GetCourses(){

        return courseDao.showAllCourse();
    }

    //wypisanie kursu po id
    @GetMapping("/course/showCourseById")
    public List<Map<String, Object>> showCourseById(long id){
        return courseDao.showCourseById(id);
    }
    //dodanie kursu do bazy
    @PostMapping("/course/addCourse")
    public void addCourse(@RequestBody Course course){
        courseDao.saveCourse(course);
    }

    //usunięcie kursu o danym id
    @DeleteMapping("/course/deleteCourseById")
    public void DeleteCourseById(long id){

        courseDao.deleteCourseById(id);
    }
}
