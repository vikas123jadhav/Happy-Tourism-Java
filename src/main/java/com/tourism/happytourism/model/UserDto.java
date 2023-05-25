package com.tourism.happytourism.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Setter
@Getter
public class UserDto {

    private int id;
    private String name;
    private String userName;
    private String role ;
    private String email;
    private Long age;
    private String mobile;
    private Boolean isActive;
    private LocalDateTime createdOn;

}
