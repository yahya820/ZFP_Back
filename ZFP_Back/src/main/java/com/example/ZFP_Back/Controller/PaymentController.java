package com.example.ZFP_Back.Controller;

import com.example.ZFP_Back.Dto.PaymentDTO;
import com.example.ZFP_Back.Model.Payment;
import com.example.ZFP_Back.Model.PaymentVessel;
import com.example.ZFP_Back.Request.PaymentFishermanRequest;
import com.example.ZFP_Back.Request.PaymentVesselRequest;
import com.example.ZFP_Back.Services.PaymentService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/vi")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment/vessel")
    public ResponseEntity<?> post (@RequestBody PaymentVesselRequest paymentVesselRequest){
        PaymentVessel paymentVessel = paymentService.postVessel(paymentVesselRequest);
        return ResponseEntity.ok(paymentVessel);
    }
    
    @GetMapping("/payment/vessel")
    public List <?> getPaymentVesselAll(){
        return paymentService.getPaymentVesselAll();
    }
   

    // @GetMapping("/payment/fisherman/{id}")
    // public ResponseEntity<?> getById(@PathVariable long id){
    //     return ResponseEntity.ok(paymentService.getByPaymentId(id));
    // }
    // @PutMapping("/payment/{id}")
    // public ResponseEntity<?> update (@PathVariable long id, PaymentDTO paymentDTO){
    //     return ResponseEntity.ok(paymentService.updateByid(id, paymentDTO));
    // }
}