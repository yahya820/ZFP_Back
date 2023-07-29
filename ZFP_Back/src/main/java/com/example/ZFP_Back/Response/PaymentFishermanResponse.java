package com.example.ZFP_Back.Response;

import java.time.LocalDate;

import com.example.ZFP_Back.Model.User;

import jakarta.persistence.Lob;
import lombok.Data;
@Data
public class PaymentFishermanResponse {
    private Long paymentFishermanId;
    private String acc_name;
    private int receipt_no;
    private LocalDate date;

    private Long userId;
    private String name;
    private String work;
    private String address;
    private String phone;
    private String sex;
    private int identity;
    

    private String ways;
    private String diko_usage;
    private String type;
    private String meter;

    public PaymentFishermanResponse(Long paymentFishermanId, String acc_name, int receipt_no, LocalDate date,
            Long userId, String name, String work, String address, String phone, String sex, int identity, String ways,
            String diko_usage, String type, String meter) {
        this.paymentFishermanId = paymentFishermanId;
        this.acc_name = acc_name;
        this.receipt_no = receipt_no;
        this.date = date;
        this.userId = userId;
        this.name = name;
        this.work = work;
        this.address = address;
        this.phone = phone;
        this.sex = sex;
        this.identity = identity;
        this.ways = ways;
        this.diko_usage = diko_usage;
        this.type = type;
        this.meter = meter;
    }

    

}
