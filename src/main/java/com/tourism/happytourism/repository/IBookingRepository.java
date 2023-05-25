package com.tourism.happytourism.repository;

import com.tourism.happytourism.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

public interface IBookingRepository extends JpaRepository<BookingEntity , Serializable> {

    @Query(value = "SELECT * FROM booking WHERE booked_by_id=? AND type='cart'", nativeQuery = true)
    List<BookingEntity> getAllCartPackageByBookedId(int bookedId);

    @Query(value = "SELECT * FROM booking WHERE booked_by_id=? AND type='purchased'", nativeQuery = true)
    List<BookingEntity> getAllPurchasedPackageByBookedId(int bookedId);

    @Query(value = "SELECT * FROM booking WHERE package_name=? AND booked_by_id=? AND type='cart'", nativeQuery = true)
    List<BookingEntity> getCart(String packageName , int bookedById);

    List<BookingEntity> findByTypeEquals(String type);
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM booking WHERE booked_by_id=? AND type='cart'", nativeQuery = true)
    int deleteCartsByUserId(int bookedBId);

    List<BookingEntity> findByPaymentIdAndBookedByIdEquals(String paymentId , int bookedById);
}
