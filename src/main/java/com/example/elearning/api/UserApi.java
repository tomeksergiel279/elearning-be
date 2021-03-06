package com.example.elearning.api;

import com.example.elearning.dao.UserDao;
import com.example.elearning.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class UserApi {

    private UserDao userDao;

    @Autowired
    public UserApi(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/user/getUsers")
    public List<Map<String, Object>> GetUsers(){

        return userDao.showAllUsers();
    }


    @GetMapping("/user/showUserById")
    public List<Map<String, Object>> showUserById(long id){
        return userDao.showUserById(id);
    }

    @PostMapping("/user/addUser")
    public void addUser(@RequestBody User user){
        userDao.saveUser(user);
    }

    @PostMapping("/user/addCourseToUser")
    public void addCourseToUser(long courseId, long userId){
        userDao.addCourseToUser(courseId, userId);
    }

    @PostMapping("user/loginRequest")
    public List<Map<String, Object>> login(@RequestBody User user){
        List<Map<String, Object>> returnedClient =  userDao.loadUserByLoginAndPassword(user.getUsername(), user.getPassword());
        return returnedClient;
    }

    @DeleteMapping("/user/deleteUserById")
    public void DeleteUserById(long id){

        userDao.deleteUserById(id);
    }



}
