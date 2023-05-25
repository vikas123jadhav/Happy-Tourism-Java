package com.tourism.happytourism.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "LOC")
public class LocationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int  id;
    private String location;
    private long count;
}
