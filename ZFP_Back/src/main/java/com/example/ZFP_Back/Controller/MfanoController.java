package com.example.ZFP_Back.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ZFP_Back.Request.MfanoRequest;
import com.example.ZFP_Back.Services.MfanoService;

@RestController
@CrossOrigin
@RequestMapping("/api/vi")
public class MfanoController {
    @Autowired
    private MfanoService mfanoService;

    @PostMapping("mfano")
    public ResponseEntity<?> post(@RequestBody MfanoRequest mfanoRequest){
       try {
        return mfanoService.post(mfanoRequest);
       } catch (Exception e) {
            return new ResponseEntity<>(new Error("Errotrr500 500"),HttpStatus.BAD_REQUEST);
       }
        // return ResponseEntity.ok(mfanoService.post(mfanoRequest));
    }
    
}
