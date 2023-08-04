package com.example.ZFP_Back.Request;

import java.time.LocalDate;
import java.util.List;

import com.example.ZFP_Back.Model.PaymentFisherman;

import lombok.Data;

@Data
public class FishermanRequest {
    private Long fishermanId;
    private String ways;
    private LocalDate start_date;
    private LocalDate finish_date;
    private String diko_usage;
    private String type;
    private String meter;

    private Long userId;

    // private User user;
    // private Long paymentFishermanId;
    private List<PaymentFisherman> paymentFishermans;
}
