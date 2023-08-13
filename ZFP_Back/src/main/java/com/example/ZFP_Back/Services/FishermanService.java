package com.example.ZFP_Back.Services;

import com.example.ZFP_Back.Dto.FIshermanDTO;
import com.example.ZFP_Back.Exception.ResourceNotFoundException;
import com.example.ZFP_Back.Model.Fisherman;
import com.example.ZFP_Back.Model.Payment;
import com.example.ZFP_Back.Model.PaymentFisherman;
import com.example.ZFP_Back.Model.User;
// import com.example.ZFP_Back.Model.User;
import com.example.ZFP_Back.Repository.FishermanRepository;
import com.example.ZFP_Back.Repository.PaymentFishermanRepository;
import com.example.ZFP_Back.Repository.PaymentRepository;
import com.example.ZFP_Back.Request.FishermanRequest;
import com.example.ZFP_Back.Response.FishermanResponse;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class FishermanService {

    @Autowired
    private FishermanRepository fishermanRepository;
    @Autowired
    private PaymentFishermanRepository paymentFishermanRepository;

    @Autowired
    private ModelMapper modelMapper;

//    public List<FishermanDTO> getFishermenByUserId(Long userId) {
//        List<Fisherman> fishermen = fishermanRepository.findByUserId(userId);
//        return fishermen.stream().map(fisherman -> modelMapper.map(fisherman, FishermanDTO.class)).collect(Collectors.toList());
//    }
    //Add fisherman
    public Fisherman create(FishermanRequest fishermanRequest){
        User user = new User();
        user.setUserId(fishermanRequest.getUserId());
        
        Fisherman fisherman = modelMapper.map(fishermanRequest, Fisherman.class);
        // fisherman.setPaymentFishermans(fishermanRequest.getPaymentFishermans());
    //   List  <PaymentFisherman> paymentFisherman = paymentFishermanRepository.save(fisherman);
        fisherman.setUser(user);
        return fishermanRepository.save(fisherman);
    }

    //GetAll Fisherman
    public List<Map<String,Object>> getAll(){
         return fishermanRepository.getAll();
    }

    //getAllFisherman
    public List<Fisherman> getAllFisherman(){
        return fishermanRepository.findAll();
    }

    


   public Optional <Map<String,Object>> getByFishemanId(long id){
    return fishermanRepository.findallByFishermanId(id);
   }
    
    //get By Id
    public Optional<Map<String,Object>> getById(Long fishermanId){
        return fishermanRepository.findByFisherId(fishermanId);
    }

    // update Fisherman
    public void deleteFisherman(Long fishermanId) {
        fishermanRepository.deleteById(fishermanId);
    }

    //getby fishermanId
    public Optional<Fisherman> findById(Long id){
        return fishermanRepository.findById(id);
    }
    public Fisherman update(long id, FIshermanDTO fIshermanDTO){
        Fisherman fisherman = fishermanRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Fisherman id not Found",id));
        modelMapper.map(fIshermanDTO, Fisherman.class);
        fisherman.setDiko_usage(fIshermanDTO.getDiko_usage());
        fisherman.setFinish_date(fIshermanDTO.getFinish_date());
        fisherman.setStart_date(LocalDate.now());
        fisherman.setMeter(fIshermanDTO.getMeter());
        fisherman.setWays(fIshermanDTO.getWays());
        fisherman.setType(fIshermanDTO.getType());
        return fishermanRepository.save(fisherman);
    }

    //get Count
    public long getCount(){
        return fishermanRepository.count();
    }
}

