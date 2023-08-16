package com.example.ZFP_Back.Request;

import java.time.LocalDate;

import lombok.Data;
@Data
public class AlgaeRequest {
     private Long algaeId;
    private int no_farm;
    private int no_men;
    private int no_women;
    private int hector;
    private int tones;
    private String type;
    private LocalDate date;
    private String region;
    private String district;
    private String ward;

    private Long locationid;
   

}
