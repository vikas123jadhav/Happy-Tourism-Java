package com.tourism.happytourism.service;


import com.tourism.happytourism.entity.User;

import java.util.List;

public interface IUserService {
    User addUser(User user);

    User findById(Integer id);

     List<User> findAll();

}
