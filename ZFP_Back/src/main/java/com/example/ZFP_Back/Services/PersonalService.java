//package com.example.ZFP_Back.Services;
//
//import com.example.ZFP_Back.Dto.PersonalDTO;
//import com.example.ZFP_Back.Model.PersonalInfo;
//import com.example.ZFP_Back.Model.User;
//import com.example.ZFP_Back.Repository.PersonalRepository;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class PersonalService {
//
//    @Autowired
//    private PersonalRepository personalRepository;
//
//    @Autowired
//    private ModelMapper modelMapper;
//
//
////Add persoanl Info
//    public PersonalInfo addInformation(PersonalDTO personalDTO){
//        User user = new User();
//        user.setUserId(personalDTO.getUserId());
//        PersonalInfo personalInfo = modelMapper.map(personalDTO, PersonalInfo.class);
//        personalInfo.setUser(user);
//        return personalInfo;
//    }
//
//    //get All Information
//    public List<PersonalInfo> getInfo(){
//        List<PersonalInfo> personalInfoList = personalRepository.findAll();
//        return personalInfoList;
//    }
//
//    //get Information By id
//    public Optional<PersonalInfo> findId(long id){
//        return personalRepository.findById(id);
//    }
//    //GET INFORMATION BY USERNAME
//    public List<PersonalInfo> findByusername(String username){
//        return personalRepository.FindByUsername(username);
//    }
//
//
//    public void deletePersonal(Long personalId) {
//        personalRepository.deleteById(personalId);
//    }
//}