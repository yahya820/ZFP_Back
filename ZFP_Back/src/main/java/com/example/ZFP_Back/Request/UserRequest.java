package com.example.ZFP_Back.Request;

import lombok.Data;

@Data
public class UserRequest {
    private Long userId;
    private String name;
    private byte[] image;
    private String work;
    private String address;
    private String phone;
    private String identity;
    private String nationality;
    private String sex;
    private int age;
    private String username;
    private String pass;
    private String email;
    private String leader;
    private String roles;
}
