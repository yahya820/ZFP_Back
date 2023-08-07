package com.example.ZFP_Back.Controller;

import com.example.ZFP_Back.Dto.FIshermanDTO;
import com.example.ZFP_Back.Model.Fisherman;
import com.example.ZFP_Back.Model.User;
import com.example.ZFP_Back.Repository.FishermanRepository;
import com.example.ZFP_Back.Repository.UserRepository;
import com.example.ZFP_Back.Request.FishermanRequest;
import com.example.ZFP_Back.Response.FishermanResponse;
import com.example.ZFP_Back.Services.FishermanService;
import com.example.ZFP_Back.Services.UserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/vi")
public class FishermanController {
    @Autowired
    private FishermanService fishermanService;

    @PostMapping("/fisherman")
    // public ResponseEntity<?> post(@RequestBody Fisherman fisherman){
    //     User user = userRepository.save(fisherman.getUser());
    //     fisherman.setUser(user);
    //     Fisherman fisherman2 = fishermanRepository.save(fisherman);
    //     return ResponseEntity.ok(fisherman2);
    // }
    public ResponseEntity<?> create(@RequestBody FishermanRequest fishermanRequest){
        return ResponseEntity.ok(fishermanService.create(fishermanRequest));
    }


    @GetMapping("/fisherman")
    // public List <Fisherman> getAll(){
    //     return fishermanRepository.findAll();
    // }
    public List<?> getAll(){
        return fishermanService.getAll();
    }
    @GetMapping("/fisherman/By1")
    public List<?> getAllFisherman(){
        return fishermanService.getAllFisherman();
    }

    // @PostMapping("/fisherman")
    // public ResponseEntity<Fisherman> add(@RequestBody FIshermanDTO fIshermanDTO){
    //    Fisherman fisherman = fishermanService.create(fIshermanDTO);
    //    return ResponseEntity.ok(fisherman);
    // }
    // @GetMapping("/fisherman")
    // public List<Fisherman>getAll(){
    //     return fishermanService.getAll();
    // }

   

    @GetMapping("/fisherman/{id}")
    public ResponseEntity<?> getByID(@PathVariable Long id){
        return ResponseEntity.ok(fishermanService.getById(id));
    }
    @GetMapping("/fisherman/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(fishermanService.findById(id));
    }

    @PutMapping("/fisherman/{id}")
    public ResponseEntity <?> update(@PathVariable long id, @RequestBody FIshermanDTO fIshermanDTO){
        return ResponseEntity.ok(fishermanService.update(id, fIshermanDTO));
    }

}
