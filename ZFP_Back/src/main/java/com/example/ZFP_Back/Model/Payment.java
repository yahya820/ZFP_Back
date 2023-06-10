package com.example.ZFP_Back.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table ( name = "Payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long payment_id;
    @Column ( name = "acc_name")
    private String acc_name;
    @Column ( name = "acc_no")
    private int acc_no;
    @Column ( name = "receipt_no")
    private int receipt_no;
    @Column ( name = "receipt_image")
    @Lob
    private byte [] receipt_image;

    // @ManyToOne
    // @JoinColumn( name = "FishermanID", referencedColumnName = "fishermanId")
    // private Fisherman fisherman;

}
