package com.example.ZFP_Back.Services;

import com.example.ZFP_Back.Dto.PaymentDTO;
import com.example.ZFP_Back.Exception.ResourceNotFoundException;
import com.example.ZFP_Back.Model.Payment;
import com.example.ZFP_Back.Repository.PaymentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private ModelMapper modelMapper;

    //getAll
    public List <Payment> getAll(){
        List <Payment> payList = paymentRepository.findAll();
        return payList;
    }

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
        Payment payment = paymentRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Payment Id not Found", id));
        modelMapper.map(paymentDTO, Payment.class);
        payment.setAcc_name(paymentDTO.getAcc_name());
        payment.setAcc_no(paymentDTO.getAcc_no());
        payment.setReceipt_no(paymentDTO.getReceipt_no());
        // payment.setReceipt_image(paymentDTO.getReceipt_image());

        return paymentRepository.save(payment);
    }
}
