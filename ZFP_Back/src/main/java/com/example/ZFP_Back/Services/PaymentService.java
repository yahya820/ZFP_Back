package com.example.ZFP_Back.Services;

import com.example.ZFP_Back.Dto.PaymentDTO;
import com.example.ZFP_Back.Exception.ResourceNotFoundException;
import com.example.ZFP_Back.Model.Fisherman;
import com.example.ZFP_Back.Model.Payment;
import com.example.ZFP_Back.Model.PaymentFisherman;
import com.example.ZFP_Back.Model.PaymentVessel;
import com.example.ZFP_Back.Model.Vessel;
import com.example.ZFP_Back.Repository.PaymentFishermanRepository;
// import com.example.ZFP_Back.Repository.PaymentFishermanRepository;
import com.example.ZFP_Back.Repository.PaymentRepository;
import com.example.ZFP_Back.Repository.PaymentVesselRepository;
import com.example.ZFP_Back.Request.PaymentFishermanRequest;
import com.example.ZFP_Back.Request.PaymentVesselRequest;
import com.example.ZFP_Back.Response.PaymentFishermanResponse;
import com.example.ZFP_Back.Response.PaymentVesselResponse;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentService {
    // @Autowired
    // private PaymentRepository paymentRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PaymentFishermanRepository paymentFishermanRepository;
    @Autowired
    private PaymentVesselRepository paymentVesselRepository;


    //getAll with Vessel
   public List <PaymentVesselResponse> getPaymentVesselAll(){
    List <PaymentVesselResponse> paymentList = new ArrayList<>();
    for (PaymentVessel paymentVessel : paymentVesselRepository.findAll()){
        PaymentVesselResponse paymentVesselResponse = modelMapper.map(paymentVessel, PaymentVesselResponse.class);

        paymentVesselResponse.setAcc_name(paymentVessel.getAcc_name());
        // paymentVesselResponse.setDate(paymentVessel.getDate());
        paymentVesselResponse.setReceipt_no(paymentVessel.getReceipt_no());

        // paymentVesselResponse.setName_vessel(payment.getVessel().getName_vessel());
        // paymentVesselResponse.setMeter(payment.getVessel().getMeter());
        // paymentVesselResponse.setWays(payment.getVessel().getWays());
        paymentList.add(paymentVesselResponse);
    }
    return paymentList;
   }
    //Get By id Payment
    public Optional<PaymentFisherman> getByPaymentId(long id){
        return paymentFishermanRepository.findById(id);
    }


   // Post Payment with Vessel
    public PaymentVessel postVessel(PaymentVesselRequest paymentVesselRequest){
        Vessel vessel = new Vessel();
        vessel.setVesselId(paymentVesselRequest.getVesselId());
        PaymentVessel paymentVessel = modelMapper.map(paymentVesselRequest, PaymentVessel.class);
        paymentVessel.setVessel(vessel);
        return paymentVesselRepository.save(paymentVessel);
    }

   

   

    //Update By Id
    // public Payment updateByid(long id, PaymentDTO paymentDTO){
    //     Payment payment = paymentRepository.findById(id)
    //     .orElseThrow(()-> new ResourceNotFoundException("Payment Id not Found", id));
    //     modelMapper.map(paymentDTO, Payment.class);
    //     payment.setAcc_name(paymentDTO.getAcc_name());
    //     // payment.setAcc_no(paymentDTO.getAcc_no());
    //     payment.setReceipt_no(paymentDTO.getReceipt_no());
    //     // payment.setReceipt_image(paymentDTO.getReceipt_image());

    //     return paymentRepository.save(payment);
    // }

    // //getCount
    // public Long getCount(){
    //     return pa
    // }
}
