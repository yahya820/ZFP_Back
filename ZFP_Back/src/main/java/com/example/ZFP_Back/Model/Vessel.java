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
    private Long vessel_id;
    @Column ( name = "name_vessel")
    private String name_vessel;
    @Column ( name = "type_vessel")
    private String type_vessel;
    @Column ( name = "no_vessel")
    private String no_vessel;
    @Column ( name = "no_people")
    private int no_people;
    @Column ( name = "date")
    private String ways;
    private LocalDate start_date;
    private LocalDate finish_date;
    private int meter;


}
