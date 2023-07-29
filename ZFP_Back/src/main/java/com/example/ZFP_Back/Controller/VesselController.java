package com.example.ZFP_Back.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ZFP_Back.Dto.vesselDTO;
import com.example.ZFP_Back.Model.Vessel;
import com.example.ZFP_Back.Services.VesselService;

@RestController
@RequestMapping("/api/vi")
@CrossOrigin
public class VesselController {
    @Autowired
    public VesselService vesselService;

    @GetMapping("/vessel")
    public List <Vessel> getAll(){
        return vesselService.getAll();
    }
    @GetMapping("/vessel/{id}")
    public ResponseEntity<?> getBuId (@PathVariable long id){
        return ResponseEntity.ok(vesselService.getById(id));
    }
    // @GetMapping("/vessel/user/{id}")
    // public ResponseEntity<?> getByUserId(@PathVariable long id){
    //     return ResponseEntity.ok(vesselService.getByUserID(id));
    // }
    @PostMapping("/vessel")
    public ResponseEntity <?> post (@RequestBody vesselDTO vDto){
        Vessel vessel = vesselService.post(vDto);
        return ResponseEntity.ok(vessel);
    }
    @PutMapping("/vessel/{id}")
    public ResponseEntity <?> update (@PathVariable long id, @RequestBody vesselDTO vDto){
        return ResponseEntity.ok(vesselService.update(id, vDto));
    }
}
