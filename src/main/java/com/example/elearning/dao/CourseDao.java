package com.example.elearning.dao;

import com.example.elearning.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public class CourseDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CourseDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveCourse(Course course){
        String sql = "INSERT INTO Course VALUES(?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{
                course.getId(),
                course.getPrice(),
                course.getName(),
                course.getDescription()
        });
    }

    public List<Map<String, Object>> showCourseById(long id){               //pokazuje auta wpisanej marki
        String sql = "SELECT * FROM Course WHERE id LIKE ?";
        return jdbcTemplate.queryForList(sql, new Object[]{id});
    }

    public List<Map<String, Object>> showAllCourse(){                          //pokazuje wszystkie auta
        String sql = "SELECT * FROM Course";
        return jdbcTemplate.queryForList(sql);
    }

    public void deleteCourseById(long id){

        String sql = "DELETE FROM Course WHERE id LIKE ?";
        Object[] course = new Object[]{id};
        jdbcTemplate.update(sql, course);
    }

}
