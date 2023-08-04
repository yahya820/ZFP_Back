package com.example.ZFP_Back.Controller;

import java.util.List;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ZFP_Back.Model.mfano;
import com.example.ZFP_Back.Services.MfanoService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@CrossOrigin
@RequestMapping("/api/vi")
public class MfanoController {
    @Autowired
    private MfanoService mfanoService;

    @GetMapping("/mfano")
    public List getAll(){
        return mfanoService.getAll();
    }
    @GetMapping("/mfano/{id}")
    public ResponseEntity <?> findById(@PathVariable Long id){
        return ResponseEntity.ok(mfanoService.findbyId(id));
    }
}
