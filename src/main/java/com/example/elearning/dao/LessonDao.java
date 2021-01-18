package com.example.elearning.dao;

import com.example.elearning.model.Course;
import com.example.elearning.model.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class LessonDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public LessonDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveLesson(Lesson lesson){
        String sql = "INSERT INTO Lesson VALUES(?,?,?)";
        jdbcTemplate.update(sql, new Object[]{
                lesson.getId(),
                lesson.getDurationTime(),
                lesson.getNotes()
        });
    }

    public List<Map<String, Object>> showLessonById(long id){
        String sql = "SELECT * FROM Lesson WHERE id LIKE ?";
        return jdbcTemplate.queryForList(sql, new Object[]{id});
    }

    public List<Map<String, Object>> showAllLessons(){
        String sql = "SELECT * FROM Lesson";
        return jdbcTemplate.queryForList(sql);
    }

    public void deleteLessonById(long id){

        String sql = "DELETE FROM Lesson WHERE id LIKE ?";
        Object[] lesson = new Object[]{id};
        jdbcTemplate.update(sql, lesson);
    }







}
