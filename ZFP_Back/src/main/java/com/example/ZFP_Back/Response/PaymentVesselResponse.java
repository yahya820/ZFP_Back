package com.example.ZFP_Back.Response;

import java.time.LocalDate;

import com.example.ZFP_Back.Model.User;

import lombok.Data;
@Data
public class PaymentVesselResponse {
    private Long paymentId;
    private String acc_name;
    private int receipt_no;
    private LocalDate date;

    // private Long vesselId;
    private String name_vessel;
    private String type_vessel;
    private String no_vessel;
    private int no_people;
    private String ways;
    private LocalDate start_date;
    private LocalDate finish_date;
    private int meter;

    private User user;
}
