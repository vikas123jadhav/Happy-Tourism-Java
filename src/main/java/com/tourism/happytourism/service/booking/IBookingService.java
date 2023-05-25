package com.tourism.happytourism.service.booking;

import com.tourism.happytourism.entity.BookingEntity;
import com.tourism.happytourism.exception.InvalidPaymentIDException;
import com.tourism.happytourism.exception.ResourceNotFoundException;
import com.tourism.happytourism.exception.SlotsNotAvailable;

import java.util.List;

public interface IBookingService {

    Double calculateTotalBill(int noOfSolts, int packageId) throws ResourceNotFoundException;

    BookingEntity storeBooking(BookingEntity bookingEntity) throws ResourceNotFoundException, SlotsNotAvailable;

    BookingEntity addToCart(BookingEntity bookingEntity) throws ResourceNotFoundException, SlotsNotAvailable;

    List<BookingEntity> getCartByPackageName(String packageName, int bookedById);


    BookingEntity updateCart(BookingEntity bookingEntity) throws ResourceNotFoundException;

    List<BookingEntity> getAllBookings();

    List<BookingEntity> getAllCartPackagesByBookedById(int bookedById) throws ResourceNotFoundException;

    List<BookingEntity> getAllPurchasedPackagesByBookedById(int bookedById);

    boolean deleteBookingById(int id) throws ResourceNotFoundException;

    boolean removeFromCart(int bookingId) throws ResourceNotFoundException;

    BookingEntity fetchBookingById(int bookingId) throws ResourceNotFoundException;

    int deleteCartByUserId(int id);

    List<BookingEntity> getReceiptByPaymentId(String paymentId, int bookedById) throws InvalidPaymentIDException;
}
