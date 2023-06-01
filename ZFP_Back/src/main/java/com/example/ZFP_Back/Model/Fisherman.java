package com.example.ZFP_Back.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table( name ="Fisherman")
public class Fisherman {
    @Id
    @GeneratedValue ( strategy = GenerationType.AUTO)
    private Long fishernmanId;
    private String ways;
    private LocalDate start_date;
    private LocalDate finish_date;
    private String diko_usage;

//    @ManyToOne
//    @JoinColumn( name = "userID", referencedColumnName = "user_id")
//    private User user;

    @OneToMany (mappedBy = "fisherman")
    private List<Payment> paymentList = new ArrayList<>();
}
