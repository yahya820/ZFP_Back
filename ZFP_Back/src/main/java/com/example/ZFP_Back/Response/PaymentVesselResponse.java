package com.example.ZFP_Back.Response;

import java.time.LocalDate;

import com.example.ZFP_Back.Model.User;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Lob;
import lombok.Data;
@Data
public class PaymentVesselResponse {
    private Long paymentId;
    private String acc_name;
    private int receipt_no;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String date;

    // private Long vesselId;
    private String name_vessel;
    private String type_vessel;
    private String no_vessel;
    private int no_people;
    private String ways;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String start_date;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String finish_date;
    private int meter;

    private String name;
    private String work;
    private String address;
    private String phone;
    private int identity;
    private String nationality;
    private String sex;
    private int age;
    private String email;
}
