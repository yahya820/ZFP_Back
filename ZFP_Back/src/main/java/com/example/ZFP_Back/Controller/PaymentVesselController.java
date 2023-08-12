package com.example.ZFP_Back.Controller;

import java.time.LocalDate;
import java.util.List;

import org.apache.catalina.connector.Response;
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

    //post in the tabs_vessel
    @PostMapping("/payment/tab_vessel")
    public ResponseEntity<?> post_tab_vessel(@RequestBody PaymentVesselRequest paymentVesselRequest){
        return ResponseEntity.ok(paymentVesselService.post_tab_vessel(paymentVesselRequest));
    }

    @PostMapping("/payment/vessel/{id}")
    public ResponseEntity <?> post (@PathVariable long id, @RequestBody PaymentVesselRequest paymentVesselRequest){
        return ResponseEntity.ok(paymentVesselService.post(id, paymentVesselRequest));
    }
    @GetMapping("/payment/vessel/UserId/{userId}")
    public ResponseEntity<?> getAllPaymentByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(paymentVesselService.getAllPaymentByUserId(userId));
    }
    @GetMapping("/payment/vessel/getAllPayment")
    public List <?> getAllPayment(){
        return paymentVesselService.getAllPayment();
    }
    @GetMapping("/payment/vessel/{startDate}/{endDate}")
    public ResponseEntity<?> getPaymentByDate(@PathVariable LocalDate startDate, @PathVariable LocalDate endDate){
        return ResponseEntity.ok(paymentVesselService.getPaymentByDate(startDate, endDate));
    }
}
