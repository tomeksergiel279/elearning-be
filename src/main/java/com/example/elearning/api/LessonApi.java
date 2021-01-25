package com.example.elearning.api;

import com.example.elearning.dao.LessonDao;
import com.example.elearning.model.Course;
import com.example.elearning.model.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class LessonApi {

    private LessonDao lessonDao;

    @Autowired
    public LessonApi(LessonDao lessonDao) {
        this.lessonDao = lessonDao;
    }

    @GetMapping("/lesson/getLessons")
    public List<Map<String, Object>> GetLessons(){
        return lessonDao.showAllLessons();
    }

    @GetMapping("/lesson/showLessonById")
    public List<Map<String, Object>> showLessonById(long id){

        return lessonDao.showLessonById(id);
    }


    @PostMapping("/lesson/addLesson")
    public void addLesson(@RequestBody Lesson lesson){

        lessonDao.saveLesson(lesson);
    }

    @DeleteMapping("/lesson/deleteLessonById")
    public void DeleteLessonById(long id){

        lessonDao.deleteLessonById(id);
    }
}
