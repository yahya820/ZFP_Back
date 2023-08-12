package com.example.ZFP_Back.Services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.ZFP_Back.Model.Mfano;
import com.example.ZFP_Back.Model.User;
import com.example.ZFP_Back.Repository.MfanoRepository;
import com.example.ZFP_Back.Request.MfanoRequest;

@Service
public class MfanoService {
    @Autowired
    private MfanoRepository mfanoRepository;
    @Autowired
    private ModelMapper modelMapper;

    //post
    public ResponseEntity<?> post(MfanoRequest mfanoRequest){
        Mfano mfano = modelMapper.map(mfanoRequest, Mfano.class);
        if (mfanoRepository.findByName(mfanoRequest.getName())){
          return ResponseEntity.badRequest().body(new Error("Name already registed"));
        }
        return ResponseEntity.ok(mfanoRepository.save(mfano));
    }


}
