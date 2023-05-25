package com.tourism.happytourism.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String userName;
    private String password;
    private String role = "NORMAL";
    private String email;
    private Long age;
    private String mobile;
    private Boolean isActive = true;
    private LocalDateTime createdOn;

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    @PrePersist
    public void setCreatedOn() {
        this.createdOn = LocalDateTime.now();
    }
}


