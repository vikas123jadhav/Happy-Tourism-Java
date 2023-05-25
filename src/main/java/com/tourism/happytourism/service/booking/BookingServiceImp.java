package com.tourism.happytourism.service.booking;

import com.tourism.happytourism.entity.BookingEntity;
import com.tourism.happytourism.entity.LocationEntity;
import com.tourism.happytourism.entity.PackageEntity;
import com.tourism.happytourism.exception.InvalidPaymentIDException;
import com.tourism.happytourism.exception.ResourceNotFoundException;
import com.tourism.happytourism.exception.SlotsNotAvailable;
import com.tourism.happytourism.repository.IBookingRepository;
import com.tourism.happytourism.repository.LocationRepo;
import com.tourism.happytourism.service.packages.IPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingServiceImp implements IBookingService {
    @Autowired
    private IBookingRepository bookingRepo;

    @Autowired
    private IPackageService packageService;

    @Autowired
    private LocationRepo locationRepo;

    @Override
    public Double calculateTotalBill(int noOfSlots, int packageId) throws ResourceNotFoundException {
        PackageEntity packageEntity = packageService.getPackageById(packageId);
        Double totalBill = noOfSlots * packageEntity.getCost();
        return totalBill;
    }

    @Override
    public BookingEntity storeBooking(BookingEntity bookingEntity) throws ResourceNotFoundException, SlotsNotAvailable {
        PackageEntity packageEntity = packageService.getPackageById(bookingEntity.getPackageId());
        int availableSlots = packageEntity.getSlots();
        int noOfSlots = bookingEntity.getNoOfSlots();
        if (availableSlots <= 0 || availableSlots < noOfSlots)
            throw new SlotsNotAvailable("Required or selected count of Slots Not available");

        // update -slots in package by subtracting -noOfSlots
        packageEntity.setSlots(packageEntity.getSlots() - noOfSlots);
        packageEntity = packageService.updatePackageWithoutImg(packageEntity);

        bookingEntity.setTotalBill(calculateTotalBill(noOfSlots, packageEntity.getId()));
        BookingEntity bookingEntity1 = setPackageDetailsToBookingEntity(bookingEntity, packageEntity);
        bookingEntity1.setType("purchased");
        BookingEntity bookingEntity2 = bookingRepo.save(bookingEntity1);
        if (bookingEntity2 != null) {
            this.addCountLocation(bookingEntity2.getLocation());
        }
        return bookingEntity2;
    }


    public void addCountLocation(String location) {
        LocationEntity locationEntity = locationRepo.findByLocationEquals(location);
        locationEntity.setCount(locationEntity.getCount() + 1);
        locationRepo.save(locationEntity);
    }

    public BookingEntity setPackageDetailsToBookingEntity(BookingEntity bookingEntity, PackageEntity packageEntity) {
        bookingEntity.setPackageName(packageEntity.getPackageName());
        bookingEntity.setCost(packageEntity.getCost());
        bookingEntity.setImgPath(packageEntity.getImgPath());
        bookingEntity.setLocation(packageEntity.getLocation());
        bookingEntity.setStartDate(packageEntity.getStartDate());
        bookingEntity.setEndDate(packageEntity.getEndDate());
        bookingEntity.setDescription(packageEntity.getDescription());
        bookingEntity.setSlots(packageEntity.getSlots());
        bookingEntity.setNoOfPeoples(packageEntity.getNoOfPeoples());
        bookingEntity.setIsPackageActive(packageEntity.getIsActive());
        return bookingEntity;
    }

    @Override
    public BookingEntity addToCart(BookingEntity bookingEntity) throws ResourceNotFoundException, SlotsNotAvailable {
        PackageEntity packageEntity = packageService.getPackageById(bookingEntity.getPackageId());
        List<BookingEntity> entities = getCartByPackageName(packageEntity.getPackageName(), bookingEntity.getBookedById());
        BookingEntity existCartBooking;
        if (!entities.isEmpty()) {
            existCartBooking = entities.get(0);
            if(packageEntity.getSlots()<= existCartBooking.getNoOfSlots()){
                 throw  new SlotsNotAvailable("Required Slots are not available, Only "+ packageEntity.getSlots()+" are Available");
            }
            else {
                existCartBooking.setNoOfSlots(existCartBooking.getNoOfSlots() + 1);
                existCartBooking.setTotalBill(calculateTotalBill(existCartBooking.getNoOfSlots(), packageEntity.getId()));
                BookingEntity bookingEntity1 = setPackageDetailsToBookingEntity(existCartBooking, packageEntity);
                bookingEntity1.setType("cart");
                return bookingRepo.save(bookingEntity1);
            }

        } else {
            int availableSlots = packageEntity.getSlots();
            int noOfSlots = bookingEntity.getNoOfSlots();
            bookingEntity.setTotalBill(calculateTotalBill(noOfSlots, packageEntity.getId()));
            BookingEntity bookingEntity1 = setPackageDetailsToBookingEntity(bookingEntity, packageEntity);
            bookingEntity1.setType("cart");
            return bookingRepo.save(bookingEntity1);
        }
    }

    @Override
    public List<BookingEntity> getCartByPackageName(String packageName, int bookedById) {
        return bookingRepo.getCart(packageName, bookedById);
    }

    @Override
    public BookingEntity updateCart(BookingEntity bookingEntity) throws ResourceNotFoundException {
        BookingEntity booking = bookingRepo.findById(bookingEntity.getId()).
                orElseThrow(() -> new ResourceNotFoundException("Cart Not Found"));
        if (booking != null)
            bookingRepo.save(bookingEntity);
        return null;
    }


    @Override
    public List<BookingEntity> getAllBookings() {
        return bookingRepo.findByTypeEquals("purchased");
    }

    @Override
    public List<BookingEntity> getAllCartPackagesByBookedById(int bookedById) throws ResourceNotFoundException {
        List<BookingEntity> bookingEntities = bookingRepo.getAllCartPackageByBookedId(bookedById);
        List<BookingEntity> bookingEntityList = new ArrayList<>();
        for (BookingEntity bookingEntity : bookingEntities) {
            PackageEntity packageEntity = packageService.getPackageById(bookingEntity.getPackageId());
            bookingEntityList.add(setPackageDetailsToBookingEntity(bookingEntity, packageEntity));
        }
        return bookingEntityList;
    }

    @Override
    public List<BookingEntity> getAllPurchasedPackagesByBookedById(int bookedById) {
        return bookingRepo.getAllPurchasedPackageByBookedId(bookedById);
    }

    @Override
    public boolean deleteBookingById(int bookingId) throws ResourceNotFoundException {
        BookingEntity bookingEntity = getBooking(bookingId, "");
        if (bookingEntity != null) {
            PackageEntity packageEntity = packageService.getPackageById(bookingEntity.getPackageId());
            packageService.updatePackageWithoutImg(packageEntity);
            bookingRepo.delete(bookingEntity);
            return true;
        }
        return false;
    }

    @Override
    public boolean removeFromCart(int bookingId) throws ResourceNotFoundException {
        BookingEntity bookingEntity = getBooking(bookingId, "In Cart");
        bookingRepo.delete(bookingEntity);
        return false;
    }

    @Override
    public BookingEntity fetchBookingById(int bookingId) throws ResourceNotFoundException {
        BookingEntity bookingEntity = getBooking(bookingId, "");
        return bookingEntity;
    }

    @Override
    public int deleteCartByUserId(int id) {
        return bookingRepo.deleteCartsByUserId(id);
    }

    @Override
    public List<BookingEntity> getReceiptByPaymentId(String paymentId, int bookedById) throws InvalidPaymentIDException {
        List<BookingEntity> list = bookingRepo.findByPaymentIdAndBookedByIdEquals(paymentId, bookedById);
        if (list.size() == 0)
            throw new InvalidPaymentIDException("Incorrect Payment Id, Check Once");
        return list;
    }

    public BookingEntity getBooking(int bookingId, String value) throws ResourceNotFoundException {
        return bookingRepo.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not Available " + value + " with ID - " + bookingId));
    }
}
