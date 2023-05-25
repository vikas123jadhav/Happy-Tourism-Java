package com.tourism.happytourism.service.location;

import com.tourism.happytourism.entity.LocationEntity;
import com.tourism.happytourism.exception.ResourceNotFoundException;
import com.tourism.happytourism.repository.LocationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImp implements  ILocationService{

    @Autowired
    private LocationRepo locationRepo;

    @Override
    public List<LocationEntity> getAllLocations() {
        return locationRepo.findAll();
    }

    @Override
    public LocationEntity storeLocation(LocationEntity location) {
        return locationRepo.save(location);
    }

    @Override
    public LocationEntity deleteLocationById(int id) throws ResourceNotFoundException {
        LocationEntity location = checkLocationResource(id);
        locationRepo.delete(location);
        return  location;
    }


    public LocationEntity checkLocationResource(int id) throws ResourceNotFoundException {
        return locationRepo.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Location Not found with this id "+id) );
    }

}
