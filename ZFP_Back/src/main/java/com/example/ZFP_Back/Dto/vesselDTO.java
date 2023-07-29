package com.example.ZFP_Back.Dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class vesselDTO {
    private Long vessel_id;
    private String name_vessel;
    private String type_vessel;
    private String no_vessel;
    private int no_people;
    private String ways;
    private LocalDate start_date;
    private LocalDate finish_date;
    private int meter;


    private Long userId;
}
