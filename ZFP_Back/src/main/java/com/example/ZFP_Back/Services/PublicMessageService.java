package com.example.ZFP_Back.Services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ZFP_Back.Model.PublicMessage;
import com.example.ZFP_Back.Repository.PublicMessageRepository;
import com.example.ZFP_Back.Request.PublicMessageRequest;

@Service
public class PublicMessageService {
   @Autowired
   private PublicMessageRepository publicMessageRepository;

   @Autowired
   private ModelMapper modelMapper;
   
   
   //post
   public PublicMessage post(PublicMessageRequest publicMessageRequest){
    PublicMessage publicMessage = modelMapper.map(publicMessageRequest,PublicMessage.class);
    return publicMessageRepository.save(publicMessage);
   }

   //get
   public List <PublicMessage> getMessage(){
    return publicMessageRepository.findAll();
   }

   //delete
   public void deleteById(Long id){
    publicMessageRepository.deleteById(id);
   }
}
