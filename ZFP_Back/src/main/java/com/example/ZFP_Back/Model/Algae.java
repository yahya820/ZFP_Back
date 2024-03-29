package com.example.ZFP_Back.Model;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table (name = "Algae")
public class Algae {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long algaeId;
    private int no_farm;
    private String region;
    private String district;
    private String ward;
    private int no_men;
    private int no_women;
    private int hector;
    private int tones;
    private String type;
    @JsonFormat(pattern = "d-M-yyyy")
    private LocalDate date;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private Timestamp time;

    @ManyToOne
    private Location location;
}
