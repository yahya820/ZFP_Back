package com.example.ZFP_Back.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ZFP_Back.Request.PublicMessageRequest;
import com.example.ZFP_Back.Services.PublicMessageService;



@RestController
@RequestMapping("/api/vi")
@CrossOrigin
public class PublicMessageController {
   @Autowired
   private PublicMessageService publicMessageService;
   
   @PostMapping("/public")
   public ResponseEntity<?> post (@RequestBody PublicMessageRequest publicMessageRequest){
    return ResponseEntity.ok(publicMessageService.post(publicMessageRequest));
   }

   @GetMapping("/public")
   public List <?> getMessage(){
    return publicMessageService.getMessage();
   }
   @DeleteMapping("/public/{id}")
   public void deleteById(@PathVariable Long id){
    publicMessageService.deleteById(id);
   }
}
