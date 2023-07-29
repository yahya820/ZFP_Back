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

import com.example.ZFP_Back.Request.PaymentFishermanRequest;
import com.example.ZFP_Back.Services.PaymentFishermanService;
@RestController
@CrossOrigin
@RequestMapping("/api/vi")
public class PaymentFishermanController {
    @Autowired
    private PaymentFishermanService paymentFishermanService; 
   @PostMapping("/payment/fisherman")
    public ResponseEntity<?> post(@RequestBody PaymentFishermanRequest paymentFishermanRequest){
        return ResponseEntity.ok(paymentFishermanService.postFisherman(paymentFishermanRequest));
    }

    @GetMapping("/payment/fisherman")
    public List <?> getPaymentFishermanAll(){
        return paymentFishermanService.getPaymentFishermanAll();
    } 

    @GetMapping("/payment/fisherman/{id}")
    public List<?> getByUserId(@PathVariable Long id){
        return paymentFishermanService.getByUserId(id);
    }
}
