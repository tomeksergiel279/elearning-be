package com.example.elearning.dao;

import com.example.elearning.model.Course;
import com.example.elearning.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class UserDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void saveUser(User user){
        String sql = "INSERT INTO User VALUES(?,?,?,?,?)";
        jdbcTemplate.update(sql, new Object[]{
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getLoginStatus(),
                user.getRegisterDate()
        });
    }

    public List<Map<String, Object>> showUserById(long id){
        String sql = "SELECT * FROM User WHERE id LIKE ?";
        return jdbcTemplate.queryForList(sql, new Object[]{id});
    }

    public List<Map<String, Object>> showAllUsers(){
        String sql = "SELECT * FROM User";
        return jdbcTemplate.queryForList(sql);
    }

    public void deleteUserById(long id){

        String sql = "DELETE FROM User WHERE id LIKE ?";
        Object[] user = new Object[]{id};
        jdbcTemplate.update(sql, user);
    }




}