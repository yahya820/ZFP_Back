package com.example.ZFP_Back.Controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ZFP_Back.Model.PaymentFisherman;
import com.example.ZFP_Back.Repository.PaymentFishermanRepository;
import com.example.ZFP_Back.Request.PaymentFishermanRequest;
import com.example.ZFP_Back.Services.PaymentFishermanService;

import jakarta.validation.constraints.PastOrPresent;
@RestController
@CrossOrigin
@RequestMapping("/api/vi")
public class PaymentFishermanController {
    @Autowired
    private PaymentFishermanService paymentFishermanService; 
    @Autowired
    private PaymentFishermanRepository paymentFishermanRepository;
    // @GetMapping("/payment/fisherman")
    // public List <?> getPaymentFishermanAll(){
    //     return paymentFishermanService.getPaymentFishermanAll();
    // } 
    @GetMapping("/payment/fisherman")
    public List <?> getPaymentFishermanAll(){
        return paymentFishermanService.getAll();
    } 

    @GetMapping("/payment/fisherman/{id}")
    public List<?> getByUserId(@PathVariable Long id){
        return paymentFishermanService.getByUserId(id);
    }
    @GetMapping("/payment/allPayment")
    public List <?> getAllPayment(){
        return paymentFishermanService.getAllPayment();
    }
    // @GetMapping("/payment/paymentAllByuserID/{id}")
    // public List<?>getPaymentByUserId(@PathVariable Long id){
    //     return paymentFishermanService.getAllPaymentByUserId(id);
    // }
    @PostMapping("payment/fisherman")
    public ResponseEntity<?> post(@RequestBody PaymentFishermanRequest paymentFishermanRequest){
        return ResponseEntity.ok(paymentFishermanService.postPayment(paymentFishermanRequest));
    }
    @GetMapping("/GetCostAndProduced/{startDate}/{endDate}")
    public  List<PaymentFisherman> getCostandProducedDate(@RequestParam LocalDate startDate ,@RequestParam LocalDate endDate){
        return paymentFishermanRepository.getCostandProducedByDate(startDate,endDate);
    }

    @GetMapping("/payment/fisherman/getPaymentByDate/{startDate}/{endDate}")
    public List<?> getVesselByDate(@PathVariable LocalDate startDate, @PathVariable LocalDate endDate){
        return paymentFishermanService.getPaymentByDate(startDate,endDate);
    }
    @GetMapping("/payment/fisherman/count")
    public ResponseEntity<?> count(){
        return ResponseEntity.ok(paymentFishermanService.getCount());
    }
}
