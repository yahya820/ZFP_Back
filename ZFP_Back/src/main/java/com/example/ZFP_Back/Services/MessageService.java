package com.example.ZFP_Back.Services;

import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ZFP_Back.Exception.ResourceNotFoundException;
import com.example.ZFP_Back.Model.Message;
import com.example.ZFP_Back.Model.User;
import com.example.ZFP_Back.Repository.MesaageRepository;
import com.example.ZFP_Back.Repository.UserRepository;
import com.example.ZFP_Back.Request.MessageRequest;

@Service
public class MessageService {
    @Autowired
    private MesaageRepository mesaageRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    //post
    public Message post (Long id,MessageRequest messageRequest){
       User user = userRepository.findById(id)
       .orElseThrow(()-> new ResourceNotFoundException("The user id not found",id));
       Message message = modelMapper.map(messageRequest,Message.class);
       message.setUser(user);
       return mesaageRepository.save(message);
    }

    //get
    public List <Map<String,Object>> getAllByuserId(Long userId){
      return mesaageRepository.getMessage(userId);  
    }
    //get Count
    public Long getCount(){
      return mesaageRepository.count();
    }
}
