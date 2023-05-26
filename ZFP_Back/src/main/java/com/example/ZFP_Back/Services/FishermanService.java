package com.example.ZFP_Back.Services;

import com.example.ZFP_Back.Dto.FIshermanDTO;
import com.example.ZFP_Back.Model.Fisherman;
import com.example.ZFP_Back.Repository.FishermanRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Fisherman fisherman = modelMapper.map(fIshermanDTO, Fisherman.class);
        return fishermanRepository.save(fisherman);
    }

    //GetAll Fisherman
    public List<Fisherman> getAll(){
        List<Fisherman> fishermanList = fishermanRepository.findAll();
        return fishermanList;
    }
    //get By Id
    public Optional<Fisherman> getById(Long fishermanId){
        return fishermanRepository.findById(fishermanId);
    }

    public void deleteFisherman(Long fishermanId) {
        fishermanRepository.deleteById(fishermanId);
    }
}

