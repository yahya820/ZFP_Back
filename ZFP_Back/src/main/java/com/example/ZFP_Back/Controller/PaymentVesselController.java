package com.example.ZFP_Back.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ZFP_Back.Request.PaymentVesselRequest;
import com.example.ZFP_Back.Services.PaymentVesselService;



@RestController
@CrossOrigin
@RequestMapping("/api/vi")
public class PaymentVesselController {
    @Autowired
    private PaymentVesselService paymentVesselService;

    @PostMapping("/payment/vessel/{id}")
    public ResponseEntity <?> post (@PathVariable long id, @RequestBody PaymentVesselRequest paymentVesselRequest){
        return ResponseEntity.ok(paymentVesselService.post(id, paymentVesselRequest));
    }
    @GetMapping("/payment/vessel/UserId/{userId}")
    public ResponseEntity<?> getAllPaymentByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(paymentVesselService.getAllPaymentByUserId(userId));
    }
}
