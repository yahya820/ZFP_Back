package com.example.ZFP_Back.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.ZFP_Back.Model.Algae;
import com.example.ZFP_Back.Request.AlgaeRequest;
import com.example.ZFP_Back.Services.AlgaeService;


@RestController
@CrossOrigin
@RequestMapping("/api/vi")
public class AlgaeController {
    @Autowired
    private AlgaeService algaeService;

    // @PostMapping("/algae")
    // public ResponseEntity<?> post(AlgaeDTO algaeDTO){
    //     return ResponseEntity.ok(algaeService.post(algaeDTO));
    // }
    // @GetMapping("/algae")
    // public List getAll(){
    //     return algaeService.getAll();
    // }
    @GetMapping("algae/findAll")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(algaeService.findAll());
    }
   @GetMapping("/algae/{id}")
   public ResponseEntity <?> getById(@PathVariable long id){
    return ResponseEntity.ok(algaeService.getById(id));
   }
   @PostMapping("/algae/location")
   public ResponseEntity<?> post (@RequestBody AlgaeRequest algaeRequest){
    return ResponseEntity.ok(algaeService.post(algaeRequest));
   }
   @GetMapping("/algae/count")
   public ResponseEntity<?> count(){
    return ResponseEntity.ok(algaeService.getCount());
   }
   @GetMapping("/algae/getAllByTime")
   public ResponseEntity<?> getAllByTime(){
    return ResponseEntity.ok(algaeService.getAllByTime());
   }
}
