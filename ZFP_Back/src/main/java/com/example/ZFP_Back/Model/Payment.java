package com.example.ZFP_Back.Model;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table ( name = "Payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long payment_id;
    private String acc_name;
    private int acc_no;
    private int receipt_no;
    @Lob
    private byte [] receipt_image;
    private LocalDate date;

    // @ManyToOne
    // @JoinColumn( name = "FishermanID", referencedColumnName = "fishermanId")
    // private Fisherman fisherman;

}
