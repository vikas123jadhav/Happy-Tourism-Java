package com.tourism.happytourism.controller;


import com.tourism.happytourism.entity.User;
import com.tourism.happytourism.exception.ResourceNotFoundException;
import com.tourism.happytourism.exception.UsernameAlreadyExists;
import com.tourism.happytourism.service.User.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) throws UsernameAlreadyExists {
        return userService.addUser(user);
    }

    @GetMapping("/getAllUserNames")
    public List<String> getUserNames() {
        return userService.getUserNames();
    }

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id") Integer id) {
        return userService.findById(id);
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/getActiveUsers")
    public List<User> getAllActiveUsers() {
        return userService.findActiveUsers();
    }

    @GetMapping("/getDeletedUsers")
    public List<User> getAllDeletedUsers() {
        return userService.findDeletedUsers();
    }

    @PostMapping("/updateProfile")
    public User updateProfile(@RequestBody User user) throws ResourceNotFoundException {
        return userService.updateUser(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public boolean deleteUserById(@PathVariable("id") int id) throws ResourceNotFoundException {
        return userService.deleteUser(id);
    }

    @GetMapping("/activateUser/{id}")
    public boolean activateUser(@PathVariable("id") int id) throws ResourceNotFoundException {
        return userService.activateUser(id);
    }
}
