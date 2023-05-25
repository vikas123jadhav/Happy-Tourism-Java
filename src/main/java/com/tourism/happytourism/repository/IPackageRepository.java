package com.tourism.happytourism.repository;

import com.tourism.happytourism.entity.PackageEntity;
import com.tourism.happytourism.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;
import java.util.List;

public interface IPackageRepository extends JpaRepository<PackageEntity, Serializable> {

    @Query(value = "SELECT * FROM package WHERE is_active=true", nativeQuery = true)
    List<PackageEntity> getActiveUsers();

    @Query(value = "SELECT * FROM package WHERE is_active=false", nativeQuery = true)
    List<PackageEntity> getDeletedUsers();

    PackageEntity findByPackageNameEquals(String packageName);


}
