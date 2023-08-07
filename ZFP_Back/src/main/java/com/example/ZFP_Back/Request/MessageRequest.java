package com.example.ZFP_Back.Request;

import lombok.Data;

@Data
public class MessageRequest {
   private Long messageId;
   private String message;
   private Long userId;

}
