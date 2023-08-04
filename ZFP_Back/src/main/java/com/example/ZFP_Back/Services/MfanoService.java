package com.example.ZFP_Back.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ZFP_Back.Dto.MfanoDto;
import com.example.ZFP_Back.Model.User;
import com.example.ZFP_Back.Model.mfano;
import com.example.ZFP_Back.Repository.MfaRepsoitory;
import com.example.ZFP_Back.Request.MfanoRequest;

@Service
public class MfanoService {
    @Autowired
    private MfaRepsoitory mfaRepsoitory;
    @Autowired
    private ModelMapper modelMapper;

    public List getAll(){
        List list = new ArrayList<>();
        MfanoDto mfanoDto = null;
        for(Map<String,Objects> data :  mfaRepsoitory.getAll() ){
                mfanoDto = modelMapper.map(data, MfanoDto.class);
                list.add(mfanoDto);
        }
        return list;
    }
    public List findbyId(Long id){
          List list = new ArrayList<>();
          MfanoDto mfanoDto = null;
        for(Map<String,Objects> data :  mfaRepsoitory.findByMfanoId(id) ){
                mfanoDto = modelMapper.map(data, MfanoDto.class);
                list.add(mfanoDto);
        }
        return list;
    }
}
