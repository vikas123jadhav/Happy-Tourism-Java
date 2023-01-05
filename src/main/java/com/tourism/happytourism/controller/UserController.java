package com.example.security.controller;

import com.example.security.entity.User;
import com.example.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        return  userService.addUser(user);
    }
    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id")Integer id){
        return userService.findById(id);
    }
    @GetMapping("/findAllUsers")
    public List<User> findAll(){
        return userService.findAll();
    }
}
