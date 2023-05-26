package com.example.ZFP_Back.Dto;

import lombok.Data;

@Data
public class UserDTO {
    private Long userId;
    private String name;
    private byte[] image;
    private String work;
    private String address;
    private int phone;
    private int identity;
    private String nationality;
    private String sex;
    private int age;
    private String username;
    private String pass;
    private String email;
   private Long roleId;
//    private long personalId;


//private PersonalInfo personalInfo;
//private List<Roles> rolesList;

}
