package com.example.ZFP_Back.Services;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ZFP_Back.Exception.ResourceNotFoundException;
import com.example.ZFP_Back.Model.PaymentVessel;
import com.example.ZFP_Back.Model.Vessel;
import com.example.ZFP_Back.Repository.PaymentVesselRepository;
import com.example.ZFP_Back.Repository.VesselRepository;
import com.example.ZFP_Back.Request.PaymentVesselRequest;

@Service
public class PaymentVesselService {
    @Autowired
    private PaymentVesselRepository paymentVesselRepository;
    @Autowired
    private VesselRepository vesselRepository;
    @Autowired
    private ModelMapper modelMapper;

    //post
    public PaymentVessel post(Long id ,PaymentVesselRequest paymentVesselRequest){
        Vessel vessel = vesselRepository.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("the Vessel Id Not Found,{}",id));
        PaymentVessel paymentVessel = modelMapper.map(paymentVesselRequest, PaymentVessel.class);
        paymentVessel.setVessel(vessel);
        return paymentVesselRepository.save(paymentVessel);
    }

    //get 
    public List<Map<String,Object>>getAllPaymentByUserId(Long userId){
        return paymentVesselRepository.getAllPaymentByUserId(userId);
    }
    
}
