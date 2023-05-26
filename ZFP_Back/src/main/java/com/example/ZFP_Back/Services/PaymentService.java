package com.example.ZFP_Back.Services;

import com.example.ZFP_Back.Dto.PaymentDTO;
import com.example.ZFP_Back.Model.Payment;
import com.example.ZFP_Back.Repository.PaymentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private ModelMapper modelMapper;


    public PaymentDTO createPayment(PaymentDTO fishermanDTO) {
        Payment payment = modelMapper.map(fishermanDTO, Payment.class);
        Payment savedFisherman = paymentRepository.save(payment);
        return modelMapper.map(savedFisherman, PaymentDTO.class);
    }
}
