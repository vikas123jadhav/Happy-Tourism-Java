package com.tourism.happytourism.service;

import com.tourism.happytourism.entity.User;
import com.tourism.happytourism.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private IUserRepository userRepository;
    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(Integer id) {
        User user=userRepository.findById(id)
                .orElseThrow(()->new RuntimeException("User not found for this : "+id));
        return user;
    }

    @Override
    public List<User> findAll() {
        return  userRepository.findAll();
    }
}
