package com.example.ZFP_Back.Services;

import java.time.LocalDate;
import java.util.ArrayList;
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
import com.example.ZFP_Back.Response.PaymentVesselResponse;

@Service
public class PaymentVesselService {
    @Autowired
    private PaymentVesselRepository paymentVesselRepository;
    @Autowired
    private VesselRepository vesselRepository;
    @Autowired
    private ModelMapper modelMapper;

    //post of in tab _vessel
    public PaymentVessel post_tab_vessel(PaymentVesselRequest paymentVesselRequest){
        Vessel vessel = new Vessel();
        vessel.setVesselId(paymentVesselRequest.getVesselId());
        PaymentVessel paymentVessel = modelMapper.map(paymentVesselRequest, PaymentVessel.class);
        paymentVessel.setVessel(vessel);
        return paymentVesselRepository.save(paymentVessel);
    }

    //post of increase payment to the vessel id
    public PaymentVessel post(Long id ,PaymentVesselRequest paymentVesselRequest){
        Vessel vessel = vesselRepository.findById(id)
            .orElseThrow(()-> new ResourceNotFoundException("the Vessel Id Not Found,{}",id));
        PaymentVessel paymentVessel = modelMapper.map(paymentVesselRequest, PaymentVessel.class);
        paymentVessel.setVessel(vessel);
        return paymentVesselRepository.save(paymentVessel);
    }

    //get all payment
   public List getAllPayment(){
    List list = new ArrayList<>();
    PaymentVesselResponse paymentVesselResponse = null ;
    for (Map<String,Object> data : paymentVesselRepository.FindAllPayment()){
        paymentVesselResponse = modelMapper.map(data, PaymentVesselResponse.class);
        list.add(paymentVesselResponse);
    }
    return list;
   }

    //get By vessel ID
    public List<PaymentVessel> getAllPaymentByUserId(Long vesselId){
        return paymentVesselRepository.getAllPaymentByUserId(vesselId);
    }
    
    //get Payment By Date
    public List getPaymentByDate(LocalDate startDate, LocalDate endDate){
        List list = new ArrayList<>();
        PaymentVesselResponse paymentVesselResponse = null;
        for (Map<String,Object> data : paymentVesselRepository.getPaymentByDate(startDate, endDate)){
            paymentVesselResponse = modelMapper.map(data,PaymentVesselResponse.class);
            list.add(paymentVesselResponse);
        }
        return list;
    }
    
}
