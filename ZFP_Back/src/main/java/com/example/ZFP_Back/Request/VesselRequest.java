package com.example.ZFP_Back.Request;

import java.time.LocalDate;

import lombok.Data;
@Data
public class VesselRequest {
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
}
