package com.example.ZFP_Back.Services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.ZFP_Back.Exception.MesageResponse;
import com.example.ZFP_Back.Model.Mfano;
import com.example.ZFP_Back.Repository.MfanoRepository;
import com.example.ZFP_Back.Request.MfanoRequest;

@Service
public class MfanoService {
    @Autowired
    private MfanoRepository mfanoRepository;
    @Autowired
    private ModelMapper modelMapper;

    //post
    public ResponseEntity<?> post(MfanoRequest mfanoRequest) {
      if (mfanoRepository.existsByName(mfanoRequest.getName())){
        return ResponseEntity.ok( new MesageResponse("Name is already registed"));
      }
  
      Mfano mfano = modelMapper.map(mfanoRequest, Mfano.class);
      return ResponseEntity.ok(mfanoRepository.save(mfano));
  }
  


}
