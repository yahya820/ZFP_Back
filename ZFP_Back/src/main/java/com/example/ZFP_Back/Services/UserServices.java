package com.example.ZFP_Back.Services;

import com.example.ZFP_Back.Exception.ErrorResponse;
import com.example.ZFP_Back.Exception.MesageResponse;
import com.example.ZFP_Back.Exception.ResourceNotFoundException;
import com.example.ZFP_Back.Model.User;
// import com.example.ZFP_Back.Repository.RoleRepository;
import com.example.ZFP_Back.Repository.UserRepository;
import com.example.ZFP_Back.Request.UserRequest;

// import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

// import javax.crypto.EncryptedPrivateKeyInfo;

@Service
public class UserServices {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;


    //create a User and thier Role
    public ResponseEntity<?> addUSer(UserRequest userRequest){
        if(userRepository.existsByEmail(userRequest.getEmail())){
            return ResponseEntity.badRequest().body(new ErrorResponse("Fail", "Error: Anuani Inatumika"));
        }
        if(userRepository.existsByIdentity(userRequest.getIdentity())){
                return ResponseEntity.badRequest().body(new ErrorResponse("Fail", "Error:  Namba ya kitambilisho ishasajiliwa"));
            }
        User user = modelMapper.map(userRequest, User.class);
        String name  = user.getName();
        String pass = user.getPass();
        int nameLength = name.length();
        String encryptedPassword = encryptPassword(pass,nameLength);
        user.setPass(encryptedPassword);
        return ResponseEntity.ok(userRepository.save(user));
    }

    //get Count
    public Long getCount(){
        return userRepository.count();
    }

    //update
    // public User update(UserDTO userDTO){
    //     User user = modelMapper.map(userDTO, User.class);
    //     return userRepository.save(user);
    // }
  
    
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

    // getUser and Fisherman
    public Optional<Map<String,Object>> getUserIdandFishermanId(Long id){
        return userRepository.getUserIdandFishermanId(id);
    }

    // get User by Username
    public Optional<User> getByUsername(String name) {
        return userRepository.getByUsername(name);
    }
    //Delete by Id
     public void deleteById(long id){
         userRepository.deleteById(id);
     }
  //Update By id
    public User editById(long id, UserRequest userRequest){
        User user = userRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("User Not Found",id));
        modelMapper.map(userRequest, User.class);
        user.setSex(userRequest.getSex());
        user.setWork(userRequest.getWork());
        user.setEmail(userRequest.getEmail());
        user.setAddress(userRequest.getAddress());
        user.setAge(userRequest.getAge());
        user.setIdentity(userRequest.getIdentity());
        // user.setLeader(userDTO.getLeader());
        // user.setName(userDTO.getName());
        user.setNationality(userRequest.getNationality());
        user.setPhone(userRequest.getPhone());
        // user.setUsername(userDTO.getUsername()); 
        // user.setImage(userDTO.getImage());
      return userRepository.save(user);
    }

    //Update By leader Only
    public User editleader(long id, UserRequest userRequest){
        User user = userRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("User Not Found",id));
        modelMapper.map(userRequest, User.class);
        user.setLeader(userRequest.getLeader());
      return userRepository.save(user);
    }

    //get bY name 
    public List <User> getByname(String name){
        return userRepository.findByName(name);
    }

    
    //Login
    public boolean authenticate(String name, String pass) {
        Optional<User> optionalLogin = userRepository.getByUsername(name);
        if (optionalLogin.isPresent()) {
            User user = optionalLogin.get();
            String encryptedPassword = encryptPassword(pass, name.length());
            if (encryptedPassword.equals(user.getPass())) {
                return true; // Authentication successful
            }
        }
        return false; // Authentication failed
    }

    public String encryptPassword(String pass, int nameLength){
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            String data = pass + nameLength;
            byte[] hash = digest.digest(data.getBytes(StandardCharsets.UTF_8));

            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            // Handle the exception appropriately
            e.printStackTrace();
            return null;
        }
    }
     



}
