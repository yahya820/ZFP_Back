package com.example.ZFP_Back.Model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    // @JsonIgnoreProperties( value = "paymentFishermans")
    @ManyToOne
    @JoinColumn(name = "id")
    private Fisherman fisherman;

    
}
