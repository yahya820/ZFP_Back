package com.example.ZFP_Back.Services;

import com.example.ZFP_Back.Dto.PaymentDTO;
import com.example.ZFP_Back.Model.Payment;
import com.example.ZFP_Back.Repository.PaymentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private ModelMapper modelMapper;


   // Post Payment
    public Payment post(PaymentDTO paymentDTO){
        Payment payment = modelMapper.map(paymentDTO,  Payment.class);
        return paymentRepository.save(payment);
    }

    // Get By id Payment
    public Optional<Payment> ByID(long id){
        return paymentRepository.findById(id);
    }

    //Update By Id
    public Payment updateByid(long id, PaymentDTO paymentDTO){
        Payment payment = modelMapper.map(paymentDTO, Payment.class);
        payment.setPayment_id(id);
        return paymentRepository.save(payment);
    }
}
