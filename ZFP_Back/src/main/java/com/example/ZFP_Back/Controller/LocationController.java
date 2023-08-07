package com.example.ZFP_Back.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ZFP_Back.Services.LocationService;
@RestController
@RequestMapping("/api/vi")
@CrossOrigin
public class LocationController {
    @Autowired
    private LocationService locationService;

    @GetMapping("/location")
    public List <?> getAll(){
        return locationService.getAll();
    }
    @GetMapping("/location/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        return ResponseEntity.ok(locationService.getById(id));
    }
}
