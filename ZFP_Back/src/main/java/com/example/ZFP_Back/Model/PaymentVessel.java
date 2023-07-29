package com.example.ZFP_Back.Model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table ( name = "paymentVessel")
public class PaymentVessel {
     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long paymentId;
    private String acc_name;
    private int receipt_no;
    private LocalDate date;

    @ManyToOne
    private Vessel vessel;
}
