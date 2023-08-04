package com.example.ZFP_Back.Request;

import java.time.LocalDate;

import com.example.ZFP_Back.Model.Fisherman;

import lombok.Data;
@Data
public class PaymentFishermanRequest {
     private Long paymentFishermanId;
    private String acc_name;
    private int receipt_no;
    private LocalDate date;
    
    private Long fishermanId;
    // private Fisherman fisherman;
}
