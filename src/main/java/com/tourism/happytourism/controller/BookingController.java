package com.tourism.happytourism.controller;

import com.tourism.happytourism.entity.BookingEntity;
import com.tourism.happytourism.entity.PackageEntity;
import com.tourism.happytourism.exception.InvalidPaymentIDException;
import com.tourism.happytourism.exception.ResourceNotFoundException;
import com.tourism.happytourism.exception.SlotsNotAvailable;
import com.tourism.happytourism.service.booking.IBookingService;
import com.tourism.happytourism.service.packages.IPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class BookingController {

    @Autowired
    private IBookingService bookingService;

    @Autowired
    private IPackageService packageService;

    @GetMapping("/calculateBill/{noOfSlots}/{packageId}")
    public Double calculateBill(@PathVariable("noOfSlots") int noOfSlots, @PathVariable("packageId") int packageId) throws ResourceNotFoundException {
        return bookingService.calculateTotalBill(noOfSlots, packageId);
    }

    //user
    @PostMapping("/storeBooking")
    public BookingEntity storeBooking(@RequestBody BookingEntity bookingEntity) throws SlotsNotAvailable, ResourceNotFoundException {
        return bookingService.storeBooking(bookingEntity);
    }

    //user
    @PostMapping("/addToCart")
    public BookingEntity addToCart(@RequestBody BookingEntity bookingEntity) throws ResourceNotFoundException, SlotsNotAvailable {
        return bookingService.addToCart(bookingEntity);
    }

    @PostMapping("updateCart")
    public BookingEntity updateCart(@RequestBody BookingEntity bookingEntity) throws ResourceNotFoundException {
        return bookingService.updateCart(bookingEntity);
    }

    //Admin
    @GetMapping("/getAllBookings")
    public List<BookingEntity> getAllBooking() {
        return bookingService.getAllBookings();
    }

    //user
    @GetMapping("/getAllCartsBookingsById/{bookedById}")
    public List<BookingEntity> getAllCartsBookings(@PathVariable("bookedById") int bookedById) throws ResourceNotFoundException {
        return bookingService.getAllCartPackagesByBookedById(bookedById);
    }

    //user
    @GetMapping("/getAllPurchasedBookingsById/{bookedById}")
    public List<BookingEntity> getAllPurchasedBookings(@PathVariable("bookedById") int bookedById) {
        return bookingService.getAllPurchasedPackagesByBookedById(bookedById);
    }

    //user
    @GetMapping("/deleteBooking/{id}")
    public boolean deleteBooking(@PathVariable("id") int id) throws ResourceNotFoundException {
        return bookingService.deleteBookingById(id);
    }

    @GetMapping("/removeFromCart/{id}")
    public boolean removeFromCart(@PathVariable("id") int id) throws ResourceNotFoundException {
        return bookingService.removeFromCart(id);
    }

    //user
    @GetMapping("/getBookingById/{id}")
    public BookingEntity getBookingById(@PathVariable("id") int id) throws ResourceNotFoundException {
        return bookingService.fetchBookingById(id);
    }

    @GetMapping("/deleteAllCartPackage/{userId}")
    public int deleteCartPackages(@PathVariable("userId") int userId) {
        return bookingService.deleteCartByUserId(userId);
    }

    @GetMapping("/getReceipt/{paymentId}/{bookedById}")
    public List<BookingEntity> getReceipt(@PathVariable("paymentId") String paymentId, @PathVariable("bookedById") int bookedById) throws InvalidPaymentIDException {
        return bookingService.getReceiptByPaymentId(paymentId, bookedById);
    }

    @GetMapping("/checkout/{bookedById}/{paymentId}")
    public List<BookingEntity> checkOut(@PathVariable("bookedById") int bookedById, @PathVariable("paymentId") String paymentId) throws ResourceNotFoundException {
        List<BookingEntity> invalidCartPackage = new ArrayList<>();
        List<BookingEntity> list = bookingService.getAllCartPackagesByBookedById(bookedById);
        Date date = new Date();
        for (BookingEntity cart : list) {
            if ((cart.getIsPackageActive() && cart.getSlots() != 0) && (cart.getStartDate().after(date) || cart.getStartDate() == date)) {
                try {
                    cart.setPaymentId(paymentId);
                    BookingEntity booking = bookingService.storeBooking(cart);
                } catch (Exception e) {
                    e.printStackTrace();
                    invalidCartPackage.add(cart);
                }
            } else {
                invalidCartPackage.add(cart);
            }
        }
        return invalidCartPackage;
    }

    @GetMapping("/checkOutTotalBill/{bookedById}")
    public Double getCheckOutTotalBill(@PathVariable("bookedById") int bookedById) throws ResourceNotFoundException, SlotsNotAvailable {
        Double grandTotal = 0.0;
        Date date = new Date();
        List<BookingEntity> list = bookingService.getAllCartPackagesByBookedById(bookedById);
        for (BookingEntity cart : list) {
            PackageEntity packageEntity = packageService.getPackageById(cart.getPackageId());
            if (cart.getNoOfSlots() > packageEntity.getSlots()) {
                throw new SlotsNotAvailable("Some Cart Packages are Not available, Select available Slots counts only");
            } else {
                if (cart.getIsPackageActive() && cart.getSlots() != 0) {
                    try {
                        if (cart.getStartDate().after(date) || cart.getStartDate() == date) {
                            grandTotal = grandTotal + (cart.getTotalBill());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return grandTotal;
    }


}
