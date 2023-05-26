package com.example.ZFP_Back.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDate;

@Data
@Entity
@Table( name = "Vessel" )
public class Vessel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long vessel_id;
    @Column ( name = "name_vessel")
    private String name_vessel;
    @Column ( name = "type_vess")
    private String type_vess;
    @Column ( name = "no_vess")
    private String no_vess;
    @Column ( name = "no_people")
    private int no_people;
    @Column ( name = "date")
    private Timestamp start_date;
    private LocalDate finish_date;
    private int meter;


}
