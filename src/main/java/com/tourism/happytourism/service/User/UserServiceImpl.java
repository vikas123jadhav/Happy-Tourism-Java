package com.tourism.happytourism.service.User;

import com.tourism.happytourism.entity.User;
import com.tourism.happytourism.exception.ResourceNotFoundException;
import com.tourism.happytourism.exception.UsernameAlreadyExists;
import com.tourism.happytourism.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private IUserRepository userRepository;
    @Override
    public User addUser(User user) throws UsernameAlreadyExists {
         checkUsernameAlreadyExistsOrNot(user.getUserName());
        return userRepository.save(user);
    }

    @Override
    public List<String> getUserNames() {
        return userRepository.getAllUserNames();
    }

    @Override
    public User findById(Integer id) {
        User user=userRepository.findById(id)
                .orElseThrow(()->new RuntimeException("User not found for this : "+id));
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> user =userRepository.findByRole("NORMAL");
        return  user;
    }

    @Override
    public List<User> findActiveUsers() {
        return userRepository.getActiveUsers();
    }

    @Override
    public List<User> findDeletedUsers() {
        return userRepository.getDeletedUsers();
    }

    @Override
    public User updateUser(User user) throws ResourceNotFoundException {
        User user1= checkResource(user.getId());
        User updatedUser = userRepository.save(user);
        return  updatedUser;
    }

    @Override
    public boolean deleteUser(int id) throws ResourceNotFoundException {
        User user= checkResource(id);
        if(user!=null) {
            user.setIsActive(false);
            userRepository.save(user);
            return  true;
        }
        return  false;
    }

    @Override
    public boolean activateUser(int id ) throws ResourceNotFoundException {
        User user= checkResource(id);
        if(user!=null) {
            user.setIsActive(true);
            userRepository.save(user);
            return  true;
        }
        return  false;
    }

    @Override
    public Boolean checkUsernameAlreadyExistsOrNot(String username) throws UsernameAlreadyExists {
        User user = userRepository.findByUserNameEquals(username);
        if(user!=null)
             throw  new UsernameAlreadyExists("User Name is Already exist , Try Different 'UserName'");
        return true;
    }

    public User checkResource(int id) throws ResourceNotFoundException {
        return userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("User Not found with this id "+id) );
    }
}
