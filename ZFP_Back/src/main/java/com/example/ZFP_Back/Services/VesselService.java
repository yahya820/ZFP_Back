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

   
   
   // get By Id
   public Optional<Vessel> getById(long id){
    return vesselRepository.findById(id);
   }

   //get by userID 
//    public Optional<Map<String,Object>>getByUserID(long id){
//     return vesselRepository.findbyUserId(id);
//    }
   // update
   public Vessel update(long id, vesselDTO vDto){
    Vessel vessel = vesselRepository.findById(id)
    .orElseThrow(()-> new ResourceNotFoundException("The Id Not Found", id));

    modelMapper.map(vDto, Vessel.class);
    vessel.setFinish_date(vDto.getFinish_date());
    vessel.setMeter(vDto.getMeter());
    vessel.setName_vessel(vDto.getName_vessel());
    vessel.setNo_people(vDto.getNo_people());
    vessel.setNo_vessel(vDto.getNo_vessel());
    vessel.setStart_date(LocalDate.now());
    vessel.setType_vessel(vDto.getType_vessel());
    vessel.setWays(vDto.getWays());
    return vesselRepository.save(vessel);
   }

}
