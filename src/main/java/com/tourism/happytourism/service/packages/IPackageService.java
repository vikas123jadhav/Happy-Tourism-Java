package com.tourism.happytourism.service.packages;

import com.tourism.happytourism.entity.PackageEntity;
import com.tourism.happytourism.exception.PackageAlreadyExists;
import com.tourism.happytourism.exception.ResourceNotFoundException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IPackageService {

    PackageEntity storePackage(PackageEntity packageEntity, MultipartFile file) throws PackageAlreadyExists, IOException;
    PackageEntity updatePackage(PackageEntity packageEntity, MultipartFile file) throws ResourceNotFoundException, IOException;
    PackageEntity updatePackageWithoutImg(PackageEntity packageEntity) throws ResourceNotFoundException ;
    PackageEntity  getPackageById(int id) throws  ResourceNotFoundException;
    List<PackageEntity> getAllPackages();
    List<PackageEntity> getActivePackages();
    List<PackageEntity> getDeletedPackages();
    PackageEntity  deletePackage(int id) throws ResourceNotFoundException;
    PackageEntity  activatePackage(int id) throws ResourceNotFoundException;
    Boolean   checkPackageNameExistOrNot(String packageName) throws PackageAlreadyExists;
    Boolean  IsSlotsAvailable(int packageId, int bookingSlots) throws ResourceNotFoundException;
}
