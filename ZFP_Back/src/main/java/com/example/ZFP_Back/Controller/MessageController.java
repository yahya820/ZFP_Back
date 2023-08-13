package com.example.ZFP_Back.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ZFP_Back.Request.MessageRequest;
import com.example.ZFP_Back.Services.MessageService;

@RestController
@CrossOrigin
@RequestMapping("/api/vi")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @PostMapping("/message/{id}")
    public ResponseEntity<?> post(@PathVariable Long id,@RequestBody MessageRequest messageRequest){
        return ResponseEntity.ok(messageService.post(id, messageRequest));
    }
    @GetMapping("/message/{userId}")
    public ResponseEntity<?>getMessage(@PathVariable Long userId){
        return ResponseEntity.ok(messageService.getAllByuserId(userId));
    }
    @GetMapping("/message/count")
    public ResponseEntity<?> count(){
        return ResponseEntity.ok(messageService.getCount());
    }
}
