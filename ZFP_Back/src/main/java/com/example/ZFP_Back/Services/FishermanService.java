package com.example.ZFP_Back.Services;

import com.example.ZFP_Back.Dto.FIshermanDTO;
import com.example.ZFP_Back.Exception.ResourceNotFoundException;
import com.example.ZFP_Back.Model.Fisherman;
import com.example.ZFP_Back.Model.User;
// import com.example.ZFP_Back.Model.User;
import com.example.ZFP_Back.Repository.FishermanRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class FishermanService {

    @Autowired
    private FishermanRepository fishermanRepository;

    @Autowired
    private ModelMapper modelMapper;

//    public List<FishermanDTO> getFishermenByUserId(Long userId) {
//        List<Fisherman> fishermen = fishermanRepository.findByUserId(userId);
//        return fishermen.stream().map(fisherman -> modelMapper.map(fisherman, FishermanDTO.class)).collect(Collectors.toList());
//    }
    //Add fisherman
    public Fisherman create(FIshermanDTO fIshermanDTO){
        User user = new User();
       user.setUserId(fIshermanDTO.getUserId());
        Fisherman fisherman = modelMapper.map(fIshermanDTO, Fisherman.class);
        fisherman.setUser(user);
        return fishermanRepository.save(fisherman);
    }

    //GetAll Fisherman
    public List<Fisherman> getAll(){
        List<Fisherman> fishermanList = fishermanRepository.findAll();
        return fishermanList;
    }

   public Optional <Fisherman> getByFishemanId(long id){
    return fishermanRepository.findallByFishermanId(id);
   }

    
    //get By Id
    public Optional<Fisherman> getById(Long fishermanId){
        return fishermanRepository.findById(fishermanId);
    }
    // update Fisherman
    public void deleteFisherman(Long fishermanId) {
        fishermanRepository.deleteById(fishermanId);
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
        return fishermanRepository.save(fisherman);
    }
}

