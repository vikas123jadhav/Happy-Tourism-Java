package com.tourism.happytourism.service.User;


import com.tourism.happytourism.entity.User;
import com.tourism.happytourism.exception.ResourceNotFoundException;
import com.tourism.happytourism.exception.UsernameAlreadyExists;

import java.util.List;

public interface IUserService {
    User addUser(User user) throws UsernameAlreadyExists;

    List<String> getUserNames();

    User findById(Integer id);

    List<User> findAll();

    List<User> findActiveUsers();

    List<User> findDeletedUsers();

    User updateUser(User user) throws ResourceNotFoundException;

    boolean deleteUser(int id) throws ResourceNotFoundException;

    boolean activateUser(int id) throws ResourceNotFoundException;

    Boolean checkUsernameAlreadyExistsOrNot(String username) throws UsernameAlreadyExists;
}
