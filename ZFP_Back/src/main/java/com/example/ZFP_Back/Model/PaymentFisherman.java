package com.example.ZFP_Back.Model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table (name = "paymentFisherman")
public class PaymentFisherman {
     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long paymentFishermanId;
    private String acc_name;
    private int receipt_no;
    private LocalDate date;

    @ManyToOne
    private Fisherman fisherman;

    
}
