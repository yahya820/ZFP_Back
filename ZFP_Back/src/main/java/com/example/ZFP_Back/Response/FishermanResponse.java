package com.example.ZFP_Back.Response;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.ZFP_Back.Model.PaymentFisherman;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
@Data
public class FishermanResponse {

    private Long fishermanId;
    private String ways;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String start_date;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String finish_date;
    private String diko_usage;
    private String type;
    private String meter;

    private Long userId;
    private String name;
    private byte[] image;
    private String work;
    private String address;
    private String phone;
    private int identity;
    private String nationality;
    private String sex;
    private int age;
    private String username;
    private String pass;
    private String email;
    private String leader;
    private String roles;

    // private Long paymentId;
    // private String acc_name;
    // private int receipt_no;
    // private LocalDate date;

    private List<PaymentFisherman> paymentFishermans = new ArrayList<>();

    
}
