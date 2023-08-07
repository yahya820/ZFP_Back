package com.example.ZFP_Back.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ZFP_Back.Model.Location;
import com.example.ZFP_Back.Repository.LocationRepository;
import com.example.ZFP_Back.Request.AlgaeRequest;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;

    //get
    public List <Location> getAll(){
        return locationRepository.findAll();
    }

    //get By Name
    public Optional<Location> getById(Long id){
        return locationRepository.findById(id);
    }

}
