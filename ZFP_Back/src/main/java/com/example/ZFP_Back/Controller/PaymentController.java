package com.example.ZFP_Back.Controller;

import com.example.ZFP_Back.Dto.PaymentDTO;
import com.example.ZFP_Back.Model.Payment;
import com.example.ZFP_Back.Services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/vi")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment")
    public ResponseEntity<Payment> post (@RequestBody PaymentDTO paymentDTO){
        Payment payment = paymentService.post(paymentDTO);
        return ResponseEntity.ok(payment);
    }
    @GetMapping("/payment/{id}")
    public ResponseEntity<?> getById(@PathVariable long id){
        return ResponseEntity.ok(paymentService.ByID(id));
    }
    @PutMapping("/payment/{id}")
    public ResponseEntity<?> update (@PathVariable long id, PaymentDTO paymentDTO){
        return ResponseEntity.ok(paymentService.updateByid(id, paymentDTO));
    }
}