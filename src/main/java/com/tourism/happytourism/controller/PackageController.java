package com.tourism.happytourism.controller;

import com.tourism.happytourism.entity.PackageEntity;
import com.tourism.happytourism.exception.PackageAlreadyExists;
import com.tourism.happytourism.exception.ResourceNotFoundException;
import com.tourism.happytourism.service.packages.IPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class PackageController {

    @Autowired
    private IPackageService packageService;


    @PostMapping("/storePackage/{packageName}/{cost}/{location}/{startDate}/{endDate}/{description}/{slots}/{noOfPeoples}")
    public PackageEntity storePackage(@RequestParam("file") MultipartFile file,
                                      @PathVariable("packageName") String packageName,
                                      @PathVariable("cost") Double cost,
                                      @PathVariable("location") String location,
                                      @PathVariable("startDate") String startDate,
                                      @PathVariable("endDate") String endDate,
                                      @PathVariable("description") String description,
                                      @PathVariable("slots") Integer slots,
                                      @PathVariable("noOfPeoples") Integer noOfPeoples) throws PackageAlreadyExists, IOException, ParseException {


        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
        Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);

        PackageEntity packageEntity = new PackageEntity(packageName, cost, file.getOriginalFilename(), location, date1, date2, description, slots, noOfPeoples);
        return packageService.storePackage(packageEntity, file);
    }

    @PostMapping("/updatePackage/{id}/{packageName}/{cost}/{location}/{startDate}/{endDate}/{description}/{slots}/{noOfPeoples}")
    public PackageEntity UpdatePackage(@RequestParam("file") MultipartFile file,
                                       @PathVariable("id") String id,
                                       @PathVariable("packageName") String packageName,
                                       @PathVariable("cost") Double cost,
                                       @PathVariable("location") String location,
                                       @PathVariable("startDate") String startDate,
                                       @PathVariable("endDate") String endDate,
                                       @PathVariable("description") String description,
                                       @PathVariable("slots") Integer slots,
                                       @PathVariable("noOfPeoples") Integer noOfPeoples) throws IOException, ParseException, ResourceNotFoundException {

        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
        Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
        int idInt = Integer.parseInt(id);

        PackageEntity packageEntity = new PackageEntity(idInt, packageName, cost, file.getOriginalFilename(), location, date1, date2, description, slots, noOfPeoples);
        return packageService.updatePackage(packageEntity, file);
    }

    @GetMapping("/getAllPackages")
    public List<PackageEntity> getAllPackages() {
        return packageService.getAllPackages();
    }

    @GetMapping("/getActivePackages")
    public List<PackageEntity> getActivePackages() {
        return packageService.getActivePackages();
    }

    @GetMapping("/getDeletedPackages")
    public List<PackageEntity> getDeletedPackages() {
        return packageService.getDeletedPackages();
    }


    @GetMapping("/getPackageById/{id}")
    public PackageEntity getPackageById(@PathVariable("id") int id) throws ResourceNotFoundException {
        return packageService.getPackageById(id);
    }

    @DeleteMapping("/deletePackage/{id}")
    public PackageEntity deletePackage(@PathVariable("id") int id) throws ResourceNotFoundException {
        return packageService.deletePackage(id);
    }

    @GetMapping("/activatePackage/{id}")
    public PackageEntity activatePackage(@PathVariable("id") int id) throws ResourceNotFoundException {
        return packageService.activatePackage(id);
    }

    @GetMapping("/checkSlotsAvailable/{packageId}/{bookingSlots}")
    public boolean IsSlotsAvailable(@PathVariable("packageId") int packageId, @PathVariable("bookingSlots") int bookingSlots) throws ResourceNotFoundException {
        return packageService.IsSlotsAvailable(packageId, bookingSlots);
    }
}
