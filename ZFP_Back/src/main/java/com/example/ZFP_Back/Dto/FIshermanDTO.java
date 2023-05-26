package com.example.ZFP_Back.Dto;

import com.example.ZFP_Back.Model.Payment;
import com.example.ZFP_Back.Model.User;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class FIshermanDTO {
    private Long fishernmanId;
    private String ways;
    private Timestamp start_date;
    private LocalDate finish_date;
    private String diko_usage;
    private User user;

    private List<Payment> paymentList = new ArrayList<>();
}
