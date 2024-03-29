package com.example.ZFP_Back.Model;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table ( name = "Payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long paymentId;
    private String acc_name;
    private int receipt_no;
    private LocalDate date;
    private String code_name;

    @ManyToOne
    private Vessel vessel;

    @ManyToOne(fetch = FetchType.EAGER)
    private Fisherman fisherman;


}
