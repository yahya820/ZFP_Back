package com.example.ZFP_Back.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ZFP_Back.Model.Fisherman;
import com.example.ZFP_Back.Model.PaymentFisherman;
import com.example.ZFP_Back.Repository.PaymentFishermanRepository;
import com.example.ZFP_Back.Request.PaymentFishermanRequest;
import com.example.ZFP_Back.Response.PaymentFishermanResponse;

@Service
public class PaymentFishermanService {
    @Autowired
    private PaymentFishermanRepository paymentFishermanRepository;
    @Autowired
    private ModelMapper modelMapper;

    //post Payment with id of fisherman
    public PaymentFisherman postPayment(PaymentFishermanRequest paymentFishermanRequest){
        Fisherman fisherman = new Fisherman();
        fisherman.setFishermanId(paymentFishermanRequest.getFishermanId());
        PaymentFisherman paymentFisherman = modelMapper.map(paymentFishermanRequest, PaymentFisherman.class);
        paymentFisherman.setFisherman(fisherman);
        return paymentFishermanRepository.save(paymentFisherman);
    }


//      //getAll payment with fisherman and user
//    public List<Map<String,Objects>> getPaymentFishermanAll(){
//     PaymentFishermanResponse paymentFishermanResponse = null;
//     List list = new ArrayList<>();
//     for (Map<String,Objects> data : paymentFishermanRepository.findAllPaymentFisherman()){
//         paymentFishermanResponse = modelMapper.map(data, PaymentFishermanResponse.class);
//         list.add(paymentFishermanResponse);
//     }
//     return list;
//    }


    //getById use userId
    public List<Map<String,Objects>> getByUserId(Long id){
        List list = new ArrayList<>();
        PaymentFishermanResponse paymentFishermanResponse = null;
        for(Map<String,Objects> data : paymentFishermanRepository.findByUserId(id)){
            paymentFishermanResponse = modelMapper.map(data, PaymentFishermanResponse.class);
            list.add(paymentFishermanResponse);
        }
        return list;
    }

    public List<Map<String,Object[]>> getAll(){
        return paymentFishermanRepository.getAll();
    }

    public List<Map<String,Object>>getAllPayment(){
        return paymentFishermanRepository.FindAllPayment();
    }
    // public List<PaymentFishermanResponse> getAllPaymentByUserId(Long id){
    //     return paymentFishermanRepository.getPaymentByUserId(id);
    // }


}
