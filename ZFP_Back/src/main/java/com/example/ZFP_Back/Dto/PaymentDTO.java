package com.example.ZFP_Back.Dto;
import java.time.LocalDate;

import lombok.Data;
@Data
public class PaymentDTO {
    private Long payment_id;
    private String acc_name;
    private int acc_no;
    private int receipt_no;
    private byte [] receipt_image;
    private LocalDate date;
    
}
