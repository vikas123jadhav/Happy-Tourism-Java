package com.tourism.happytourism.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BOOKING")
public class BookingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int bookedById;
    private int packageId;
    private int noOfSlots;
    private String paymentId;
    private String type;
    private Double totalBill;
    private String packageName;
    private Double cost;
    private String imgPath;
    private String location;
    private Date startDate;
    private Date endDate;
    private String description;
    private Integer slots;
    private Integer noOfPeoples;
    private Boolean isPackageActive;

    @Column(name = "BOOKED_DATE", insertable = true)
    @UpdateTimestamp
    @Temporal(TemporalType.DATE)
    private Date bookedDate;

    @UpdateTimestamp
    @Temporal(TemporalType.DATE)
    @Column(name = "UPDATED_DATE", insertable = false)
    private Date updatedDate;
}
