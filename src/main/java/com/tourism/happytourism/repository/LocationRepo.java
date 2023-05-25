package com.tourism.happytourism.repository;

import com.tourism.happytourism.entity.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;

public interface LocationRepo extends JpaRepository<LocationEntity, Serializable> {

    @Query(value = "SELECT * FROM loc WHERE location=?", nativeQuery = true)
    LocationEntity findByLocationEquals(String location);
}
