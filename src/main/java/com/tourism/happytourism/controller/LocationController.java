package com.tourism.happytourism.controller;

import com.tourism.happytourism.entity.LocationEntity;
import com.tourism.happytourism.exception.ResourceNotFoundException;
import com.tourism.happytourism.service.location.ILocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class LocationController {

    @Autowired
    private ILocationService locationService;

    @GetMapping("/getAllLocation")
    public List<LocationEntity> fetchAllLocations() {
        return locationService.getAllLocations();
    }

    @PostMapping("/storeLocation")
    public LocationEntity storeLocation(@RequestBody LocationEntity location) {
        return locationService.storeLocation(location);
    }

    @DeleteMapping("/deleteLocationById/{id}")
    public LocationEntity deleteLocation(@PathVariable("id") int id) throws ResourceNotFoundException {
        return locationService.deleteLocationById(id);
    }
}
