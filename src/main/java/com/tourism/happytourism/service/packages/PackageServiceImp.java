package com.tourism.happytourism.service.packages;

import com.tourism.happytourism.entity.PackageEntity;
import com.tourism.happytourism.exception.FileStorageException;
import com.tourism.happytourism.exception.PackageAlreadyExists;
import com.tourism.happytourism.exception.ResourceNotFoundException;
import com.tourism.happytourism.repository.IPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static java.nio.file.Files.copy;
import static java.nio.file.Paths.get;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

@Service
public class PackageServiceImp implements IPackageService {

    @Autowired
    private IPackageRepository packageRepo;

    public static final String DIRECTORY = "E:/HT/Happy-Tourism-Angular/src/assets/";

    @Override
    public PackageEntity storePackage(PackageEntity packageEntity, MultipartFile file) throws PackageAlreadyExists, IOException {
        checkPackageNameExistOrNot(packageEntity.getPackageName());
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Path fileStorage = get(DIRECTORY, fileName).toAbsolutePath().normalize();
        copy(file.getInputStream(), fileStorage, REPLACE_EXISTING);

        PackageEntity package1 = new PackageEntity();
        try {
            if (fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            package1 = packageRepo.save(packageEntity);
        } catch (Exception ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
        return package1;
    }

    @Override
    public PackageEntity updatePackage(PackageEntity packageEntity, MultipartFile file) throws ResourceNotFoundException, IOException {
        PackageEntity existPackage = checkPackage(packageEntity.getId());
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Path fileStorage = get(DIRECTORY, fileName).toAbsolutePath().normalize();
        copy(file.getInputStream(), fileStorage, REPLACE_EXISTING);

        PackageEntity package1 = new PackageEntity();
        try {
            if (fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            package1 = packageRepo.save(packageEntity);
        } catch (Exception ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
        return package1;
    }

    @Override
    public PackageEntity updatePackageWithoutImg(PackageEntity packageEntity) throws ResourceNotFoundException {
        PackageEntity existPackage = checkPackage(packageEntity.getId());
        return packageRepo.save(packageEntity);
    }

    @Override
    public PackageEntity getPackageById(int id) throws ResourceNotFoundException {
        return checkPackage(id);
    }

    @Override
    public List<PackageEntity> getAllPackages() {
        return packageRepo.findAll();
    }

    @Override
    public List<PackageEntity> getActivePackages() {
        Date date = new Date();
        return packageRepo.getActiveUsers().stream().
                filter((packageEntity) -> {
                    return (packageEntity.getStartDate().after(date)
                            || packageEntity.getStartDate() == date);
                }).collect(Collectors.toList());
    }

    @Override
    public List<PackageEntity> getDeletedPackages() {
        return packageRepo.getDeletedUsers();
    }

    @Override
    public PackageEntity deletePackage(int id) throws ResourceNotFoundException {
        PackageEntity packageEntity = checkPackage(id);
        packageEntity.setIsActive(false);
        packageRepo.save(packageEntity);
        return packageEntity;
    }

    @Override
    public PackageEntity activatePackage(int id) throws ResourceNotFoundException {
        PackageEntity packageEntity = checkPackage(id);
        packageEntity.setIsActive(true);
        packageRepo.save(packageEntity);
        return packageEntity;
    }

    @Override
    public Boolean checkPackageNameExistOrNot(String packageName) throws PackageAlreadyExists {
        PackageEntity packageEntity = packageRepo.findByPackageNameEquals(packageName);
        if (packageEntity != null)
            throw new PackageAlreadyExists("Package Already Available , Try to store another Package");
        return true;
    }

    @Override
    public Boolean IsSlotsAvailable(int packageId, int bookingSlots) throws ResourceNotFoundException {
        PackageEntity packageEntity = checkPackage(packageId);
        if (bookingSlots <= packageEntity.getSlots())
            return true;
        return false;
    }

    public PackageEntity checkPackage(int id) throws ResourceNotFoundException {
        PackageEntity packageEntity = packageRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Package Not available in Data Base with id - " + id));
        return packageEntity;
    }
}


