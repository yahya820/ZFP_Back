package com.example.ZFP_Back.Dto;
import lombok.Data;
import java.time.LocalDate;
// import java.util.ArrayList;
// import java.util.List;

@Data
public class FIshermanDTO {
    private Long fishernmanId;
    private String ways;
    private LocalDate start_date;
    private LocalDate finish_date;
    private String diko_usage;
    private String type;
    private String meter;


    private Long userId;
    // private String name;
    // private byte[] image;
    // private String work;
    // private String address;
    // private String phone;
    // private int identity;
    // private String nationality;
    // private String sex;
    // private int age;
    // private String username;
    // private String pass;
    // private String email;
    // private String leader;
    // private String roles;

    // private List<Payment> paymentList = new ArrayList<>();

    // private Long userId;
}
