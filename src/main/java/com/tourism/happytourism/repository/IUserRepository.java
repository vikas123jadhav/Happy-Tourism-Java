package com.tourism.happytourism.repository;


import com.tourism.happytourism.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IUserRepository extends JpaRepository<User, Integer> {
    User findByUserName(String username);

    @Query(value = "SELECT * FROM user WHERE is_active=true", nativeQuery = true)
    List<User> getActiveUsers();

    @Query(value = "SELECT * FROM user WHERE is_active=false", nativeQuery = true)
    List<User> getDeletedUsers();

    User findByUserNameEquals(String username);

    @Query(value = "SELECT user_name FROM user ", nativeQuery = true)
    List<String> getAllUserNames();

    List<User> findByRole(String role);
}
