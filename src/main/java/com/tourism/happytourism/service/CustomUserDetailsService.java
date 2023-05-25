package com.tourism.happytourism.service;

import com.tourism.happytourism.entity.User;
import com.tourism.happytourism.model.UserDto;
import com.tourism.happytourism.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private IUserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

       User user= userRepository.findByUserName(username);
        return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),new ArrayList<>());
    }

    public UserDto getUserByUserName(String username){
          User user =userRepository.findByUserName(username);
          return  new UserDto(
                    user.getId(),
                    user.getName(),
                    user.getUserName(),
                    user.getRole(),
                    user.getEmail(),
                    user.getAge(),
                    user.getMobile(),
                    user.getIsActive(),
                    user.getCreatedOn()
          );
    }




}
