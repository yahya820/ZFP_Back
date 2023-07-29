package com.example.ZFP_Back.Model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table( name = "Vessel" )
public class Vessel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long vesselId;
    private String name_vessel;
    private String type_vessel;
    private String no_vessel;
    private int no_people;
    private String ways;
    private LocalDate start_date;
    private LocalDate finish_date;
    private int meter;


    private Long userId;
    
    // private String roles;


}
