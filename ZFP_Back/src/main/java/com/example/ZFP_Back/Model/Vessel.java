package com.example.ZFP_Back.Model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Data
@Entity
@Table( name = "Vessel" )
public class Vessel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long vesselId;
    private String name_vessel;
    private String type_vessel;
    @Column(unique = true)
    private String no_vessel;
    private int no_people;
    private String ways;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate start_date;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate finish_date;
    private int meter;

    @ManyToOne
    @JoinColumn( name = "userId")
    private User user;

    @JsonIgnoreProperties(value = "vessel")
    @OneToMany(mappedBy = "vessel")
    private List <PaymentVessel> payment_vessel_list= new ArrayList<>();
}
