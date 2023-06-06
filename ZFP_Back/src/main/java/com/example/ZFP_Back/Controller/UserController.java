package com.example.ZFP_Back.Controller;

import com.example.ZFP_Back.Dto.UserDTO;
import com.example.ZFP_Back.Model.User;
import com.example.ZFP_Back.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/vi")
public class UserController {
    @Autowired
    private UserServices userServices;
    @PostMapping("/users")
    public ResponseEntity<User>create(@RequestBody UserDTO userDTO){
        User user = userServices.addUSer(userDTO);
        return ResponseEntity.ok(user);
    }
    @GetMapping("/users")
    public List<User>get(){
        return userServices.ListAllUser();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getByid(@PathVariable long id){
        return ResponseEntity.ok(userServices.getById(id));
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<?> updateUser(@PathVariable long id, UserDTO userDTO){
       return ResponseEntity.ok(userServices.editById(id,userDTO));
    }
//    @DeleteMapping("/user/{id}")
//    public void deleteById (@PathVariable long id){
//      userServices.deleteById(id);
//    }
}
