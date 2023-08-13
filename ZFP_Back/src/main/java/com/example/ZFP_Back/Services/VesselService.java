package com.example.ZFP_Back.Services;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ZFP_Back.Dto.vesselDTO;
import com.example.ZFP_Back.Exception.ResourceNotFoundException;
import com.example.ZFP_Back.Model.User;
import com.example.ZFP_Back.Model.Vessel;
import com.example.ZFP_Back.Repository.VesselRepository;
import com.example.ZFP_Back.Request.VesselRequest;
import com.example.ZFP_Back.Response.VesselResponse;

@Service
public class VesselService {
    @Autowired
    private VesselRepository vesselRepository;
    @Autowired
    private ModelMapper modelMapper;

    //get all
    public List <Vessel> getAll(){
        List <Vessel> vesselList = vesselRepository.findAll();
        return vesselList;
    }
    // getAllVesselinProfile
    public List<Map<String,Object>> getAllVesselInProfile(){
        return vesselRepository.getAllVesselInProfile();
    }
    // post vessel
   public Vessel post(VesselRequest vesselRequest){
    User user = new User();
    user.setUserId(vesselRequest.getUserId());
    Vessel vessel = modelMapper.map(vesselRequest, Vessel.class);
    vessel.setUser(user);
    return vesselRepository.save(vessel);
   }

  //get Vessel  In profile
  public List<Map<String,Object>> getVesselInProfile(Long userId){
    return vesselRepository.getVesselInProfile(userId);
  }
   // get By Id
   public Optional<Vessel> getById(long id){
    return vesselRepository.findById(id);
   }

   // Get Vessel by userID
   public List <Map<String,Object>> getVesselByuserId(Long userid){
    return vesselRepository.getVesselByUserId(userid);
   }
   
   // update
   public Vessel update(long id, VesselResponse vesselResponse){
    Vessel vessel = vesselRepository.findById(id)
    .orElseThrow(()-> new ResourceNotFoundException("The Id Not Found", id));

    modelMapper.map(vesselResponse, Vessel.class);
    vessel.setFinish_date(vesselResponse.getFinish_date());
    vessel.setMeter(vesselResponse.getMeter());
    vessel.setName_vessel(vesselResponse.getName_vessel());
    vessel.setNo_people(vesselResponse.getNo_people());
    vessel.setNo_vessel(vesselResponse.getNo_vessel());
    vessel.setStart_date(LocalDate.now());
    vessel.setType_vessel(vesselResponse.getType_vessel());
    vessel.setWays(vesselResponse.getWays());
    return vesselRepository.save(vessel);
   }

   //get Count
   public Long getCount(){
    return vesselRepository.count();
   }

}
