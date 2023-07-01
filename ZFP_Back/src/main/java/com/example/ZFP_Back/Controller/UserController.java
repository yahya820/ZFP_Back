package com.example.ZFP_Back.Controller;

import com.example.ZFP_Back.Dto.UserDTO;
import com.example.ZFP_Back.Model.User;
import com.example.ZFP_Back.Services.UserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @GetMapping("/users/user/{id}")
    public ResponseEntity<?> getByUserId(@PathVariable long id){
        return ResponseEntity.ok(userServices.getByUserId(id));
    }

    @PutMapping("/users/{id}")
   public ResponseEntity<?> update (@PathVariable long id, @RequestBody UserDTO userDTO){
    return ResponseEntity.ok(userServices.editById(id, userDTO));
   }
   
   @DeleteMapping("/users/{id}")
   public void deleteById (@PathVariable long id){
     userServices.deleteById(id);
   }
   @PostMapping("users/login")
   public ResponseEntity<Object> authenticate(@RequestParam("name") String name,
                                              @RequestParam("pass") String pass) {
       if (userServices.authenticate(name, pass)) {
           Optional<User> user = userServices.getByUsername(name);
        
           if(user.isPresent()){
               UserDTO userDTO = new UserDTO();
               userDTO.setUserId(user.get().getUserId());
               userDTO.setName(user.get().getName());
               userDTO.setRoles(user.get().getRoles());
               return ResponseEntity.ok(userDTO);
           }
       }
       return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
   }
}
