package com.example.ZFP_Back.Response;

import java.time.LocalDate;

import lombok.Data;
@Data
public class FishermanResponse {

    private Long fishermanId;
    private String ways;
    private LocalDate start_date;
    private LocalDate finish_date;
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

    private Long paymentId;
    private String acc_name;
    private int receipt_no;
    private LocalDate date;

    
}
