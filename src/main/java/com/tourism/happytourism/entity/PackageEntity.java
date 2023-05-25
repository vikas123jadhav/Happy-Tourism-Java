package com.tourism.happytourism.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PACKAGE")
public class PackageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String packageName;
    private Double cost;
    private String imgPath;
    private String location;
    private Date startDate;
    private Date endDate;
    private String description;
    private Integer slots;
    private Integer noOfPeoples;
    private Boolean isActive = true;
    @Column(name = "STORED_DATE", updatable = false)
    @Temporal(TemporalType.DATE)
    @CreationTimestamp
    private Date storedDate;

    @UpdateTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "UPDATED_DATE", insertable = false)
    private Date updatedDate;

    public PackageEntity(int id, String packageName, Double cost, String imgPath, String location, Date startDate, Date endDate, String description, Integer slots, Integer noOfPeoples) {
        this.id = id;
        this.packageName = packageName;
        this.cost = cost;
        this.imgPath = imgPath;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.slots = slots;
        this.noOfPeoples = noOfPeoples;
    }

    public PackageEntity(String packageName, Double cost, String imgPath, String location, Date startDate, Date endDate, String description, Integer slots, Integer noOfPeoples) {
        this.packageName = packageName;
        this.cost = cost;
        this.imgPath = imgPath;
        this.location = location;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.slots = slots;
        this.noOfPeoples = noOfPeoples;
    }
}
