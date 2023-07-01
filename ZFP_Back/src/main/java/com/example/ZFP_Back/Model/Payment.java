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
@Table ( name = "Payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long paymentId;
    private String acc_name;
    private int receipt_no;
    private LocalDate date;

    // @ManyToOne
    // @JoinColumn( name = "FishermanID", referencedColumnName = "fishermanId")
    // private Fisherman fisherman;


    // private Long fishermanId;
    // private Long vessel_id;
    // private Long userId;

    @ManyToOne
    private Fisherman fisherman;

    @ManyToOne
    private Vessel vessel;


}
