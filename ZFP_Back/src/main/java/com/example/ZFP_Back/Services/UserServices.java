package com.example.ZFP_Back.Services;

import com.example.ZFP_Back.Dto.UserDTO;
import com.example.ZFP_Back.Model.User;
import com.example.ZFP_Back.Repository.RoleRepository;
import com.example.ZFP_Back.Repository.UserRepository;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@Service
public class UserServices {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private ModelMapper modelMapper;


    //create a User and thier Role
    public User addUSer(UserDTO userDTO){
        User user = modelMapper.map(userDTO, User.class);
        return userRepository.save(user);
    }

    //method for get User
    public List<User> ListAllUser() {
        List<User> userList = userRepository.findAll();
////        List <PersonalInfo> personalInfoList = userRepository.findByID()
//        List<User> userDTOS = new ArrayList<>();
//        for (User user : userList) {
//            userDTOS.add(modelMapper.map(user, User.class));
//         }
     //   return userDTOS;
        return userList;
     }

     //get User by Id
    public Optional<User> getById(long id){
        return userRepository.findById(id);
    }

    //Delete by Id
     public void deleteById(long id){
         userRepository.deleteById(id);
     }
  //Update By id
    public User editById(long id, UserDTO userDTO){
      User user = modelMapper.map(userDTO, User.class);
      user.setUserId(id);
      return userRepository.save(user);
    }



}
