package com.example.ZFP_Back.Response;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentFishermanResponse {
    private int payment_fisherman_id;
    private String acc_name;
    private int receipt_no;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String date;

    private int user_id;
    private String name;
    private String work;
    private String address;
    private String phone;
    private String sex;
    private int identity;
    private String nationality;
    private int age;
    private String email;
    private String leader;
    
    private int fisherman_id;
    private String ways;
    private String diko_usage;
    private String type;
    private String meter;

   
    

}
