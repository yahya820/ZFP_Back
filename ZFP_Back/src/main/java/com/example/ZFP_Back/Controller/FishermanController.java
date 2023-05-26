package com.example.ZFP_Back.Controller;

import com.example.ZFP_Back.Dto.FIshermanDTO;
import com.example.ZFP_Back.Model.Fisherman;
import com.example.ZFP_Back.Services.FishermanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/fisherman")
public class FishermanController {
    @Autowired
    private FishermanService fishermanService;

    @PostMapping("/post")
    public ResponseEntity<Fisherman> add(@RequestBody FIshermanDTO fIshermanDTO){
       Fisherman fisherman = fishermanService.create(fIshermanDTO);
       return ResponseEntity.ok(fisherman);
    }
    @GetMapping("/get")
    public List<Fisherman>getAll(){
        return fishermanService.getAll();
    }
    @GetMapping("/get{id}")
    public ResponseEntity<?> getByID(@PathVariable Long id){
        return ResponseEntity.ok(fishermanService.getById(id));
    }

}
