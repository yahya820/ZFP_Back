package com.example.ZFP_Back.Services;

import java.util.ArrayList;
import java.util.List;
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


     //getAll payment with fisherman and user
   public List<PaymentFishermanResponse> getPaymentFishermanAll(){
    // List<PaymentFishermanResponse> list = new ArrayList<>();
    // for (PaymentFisherman paymentFisherman : paymentFishermanRepository.findAll()){
    //     PaymentFishermanResponse paymentFishermanResponse = modelMapper.map(paymentFisherman,PaymentFishermanResponse.class);

    //     paymentFishermanResponse.setAcc_name(paymentFisherman.getAcc_name());
    //     paymentFishermanResponse.setReceipt_no(paymentFisherman.getReceipt_no());
    //     paymentFishermanResponse.setDate(paymentFisherman.getDate());

    //     paymentFishermanResponse.setUserId(paymentFisherman.getFisherman().getUser().getUserId());
    //     paymentFishermanResponse.setName(paymentFisherman.getFisherman().getUser().getName());
    //     paymentFishermanResponse.setWork(paymentFisherman.getFisherman().getUser().getWork());
    //     paymentFishermanResponse.setAddress(paymentFisherman.getFisherman().getUser().getAddress());
    //     paymentFishermanResponse.setPhone(paymentFisherman.getFisherman().getUser().getPhone());
    //     paymentFishermanResponse.setIdentity(paymentFisherman.getFisherman().getUser().getIdentity());

    //     paymentFishermanResponse.setDiko_usage(paymentFisherman.getFisherman().getDiko_usage());
    //     paymentFishermanResponse.setMeter(paymentFisherman.getFisherman().getMeter());
    //     paymentFishermanResponse.setType(paymentFisherman.getFisherman().getType());
    //     paymentFishermanResponse.setWays(paymentFisherman.getFisherman().getWays());

    //     list.add(paymentFishermanResponse);
    // }
    // return list;
    return paymentFishermanRepository.findAllPaymentFisherman();
   }

    //post payment with fisherman
    public PaymentFisherman postFisherman(PaymentFishermanRequest paymentFishermanRequest){
        Fisherman fisherman = new Fisherman();
        fisherman.setFishermanId(paymentFishermanRequest.getFishermanId());
        PaymentFisherman paymentFisherman = modelMapper.map(paymentFishermanRequest,PaymentFisherman.class);
        paymentFisherman.setFisherman(fisherman);
        return paymentFishermanRepository.save(paymentFisherman);
    }

    //getById use userId
    public List<PaymentFishermanResponse> getByUserId(Long id){
        return paymentFishermanRepository.findByUserId(id);
    }

}
