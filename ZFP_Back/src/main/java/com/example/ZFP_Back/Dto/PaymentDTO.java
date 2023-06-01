package com.example.ZFP_Back.Dto;

import com.example.ZFP_Back.Model.Fisherman;
import lombok.Data;

@Data
public class PaymentDTO {
    private Long payment_id;
    private String acc_name;
    private int acc_no;
    private int receipt_no;
    private String receipt_image;
    private Long fishernmanId;
}
