package com.example.ZFP_Back.Services;

import java.util.List;
import java.util.Optional;

// import javax.swing.text.html.Option;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ZFP_Back.Dto.AlgaeDTO;
import com.example.ZFP_Back.Model.Algae;
import com.example.ZFP_Back.Repository.AlgaeRepositoty;

@Service
public class AlgaeService {
    @Autowired
    private AlgaeRepositoty algaeRepositoty;
    @Autowired
    private ModelMapper modelMapper;

    //post
    public Algae post (AlgaeDTO algaeDTO){
        Algae algae = modelMapper.map(algaeDTO, Algae.class);
        return algaeRepositoty.save(algae);
    }
    
    // GetAll
    public List <Algae> getAll(){
        List <Algae> list = algaeRepositoty.findAll();
        return list;
    }

    // getById
    public Optional <Algae> getById(long id){
        return algaeRepositoty.findById(id);
    }

}
