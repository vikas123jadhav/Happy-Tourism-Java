package com.tourism.happytourism.service.location;

import com.tourism.happytourism.entity.LocationEntity;
import com.tourism.happytourism.exception.ResourceNotFoundException;

import java.util.List;

public interface ILocationService {

    List<LocationEntity> getAllLocations();

    LocationEntity storeLocation(LocationEntity location);

    LocationEntity deleteLocationById(int id) throws ResourceNotFoundException;

}
