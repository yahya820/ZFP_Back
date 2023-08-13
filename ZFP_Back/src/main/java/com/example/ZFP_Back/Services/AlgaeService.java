package com.example.ZFP_Back.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

// import javax.swing.text.html.Option;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ZFP_Back.Dto.AlgaeDTO;
import com.example.ZFP_Back.Dto.MfanoDto;
import com.example.ZFP_Back.Model.Algae;
import com.example.ZFP_Back.Model.Location;
import com.example.ZFP_Back.Repository.AlgaeRepositoty;
import com.example.ZFP_Back.Request.AlgaeRequest;
import com.example.ZFP_Back.Response.AlgaeResponse;

@Service
public class AlgaeService {
    @Autowired
    private AlgaeRepositoty algaeRepositoty;
    @Autowired
    private ModelMapper modelMapper;

    //post to location
    public Algae post (AlgaeRequest algaeRequest){
        Location location = new Location();
        location.setLocationid(algaeRequest.getLocationid());
        Algae algae = modelMapper.map(algaeRequest,Algae.class);
        algae.setLocation(location);
        return algaeRepositoty.save(algae);
    }
    
    // GetAll
    public List getAll(){
        List list = new ArrayList<>();
        AlgaeResponse algaeResponse = null;
        for(Map<String,Object> data : algaeRepositoty.getAll()){
            algaeResponse = modelMapper.map(data, AlgaeResponse.class);
            list.add(algaeResponse);
        }
        return list;
    }


    // getById
    public Optional <Algae> getById(long id){
        return algaeRepositoty.findById(id);
    }

    //get Count
    public Long getCount(){
        return algaeRepositoty.count();
    }

}
