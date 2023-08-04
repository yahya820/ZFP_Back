package com.example.ZFP_Back.Response;

import java.time.LocalDate;

import jakarta.persistence.Lob;
import lombok.Data;
@Data
public class VesselResponse {
    private Long vesselId;
    private String name_vessel;
    private String type_vessel;
    private String no_vessel;
    private int no_people;
    private String ways;
    private LocalDate start_date;
    private LocalDate finish_date;
    private int meter;

    
     private Long userId;
    private String name;
    @Lob
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
}
