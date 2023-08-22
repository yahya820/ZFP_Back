package com.example.ZFP_Back.Controller;

import com.example.ZFP_Back.Dto.UserDTO;
import com.example.ZFP_Back.Exception.ErrorResponse;
import com.example.ZFP_Back.Exception.MesageResponse;
import com.example.ZFP_Back.Model.User;
import com.example.ZFP_Back.Request.UserRequest;
import com.example.ZFP_Back.Services.UserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
    public ResponseEntity<?>create(@RequestBody UserRequest userRequest){
        try {
            return userServices.addUSer(userRequest);
        }
        catch (Error e){
          return new ResponseEntity<>(new ErrorResponse("Error", "Fail to perform operation","500"), HttpStatus.BAD_REQUEST);
        }
        // return ResponseEntity.ok(userServices.addUSer(userRequest));
    }
    @GetMapping("/users")
    public List<User>get(){
        return userServices.ListAllUser();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getByid(@PathVariable long id){
        return ResponseEntity.ok(userServices.getById(id));
    }
    @GetMapping("/users/fisherman/{id}")
    public ResponseEntity<?> getUserIdandFishermanId(@PathVariable Long id){
        return ResponseEntity.ok(userServices.getUserIdandFishermanId(id));
    }
    @GetMapping("/users/user/{name}")
    public ResponseEntity<?> getByname(@PathVariable String name){
        return ResponseEntity.ok(userServices.getByname(name));
    }

    @PutMapping("/users/{id}")
   public ResponseEntity<?> update (@PathVariable long id, @RequestBody UserRequest userRequest){
    return ResponseEntity.ok(userServices.editById(id, userRequest));
   }
   @PutMapping("/users/leader/{id}")
   public ResponseEntity<?> updateleader (@PathVariable long id, @RequestBody UserRequest userRequest){
    return ResponseEntity.ok(userServices.editleader(id, userRequest));
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

   @GetMapping("/users/count")
   public ResponseEntity<?> getCount(){
    return ResponseEntity.ok(userServices.getCount());
   }
}
