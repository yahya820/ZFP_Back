package com.example.ZFP_Back.Dto;

import java.time.LocalDate;

import lombok.Data;


@Data
public class AlgaeDTO {
    private Long algaeId;
    private int no_farm;
    private int no_men;
    private int no_women;
    private int hector;
    private int tones;
    private String type;
    private LocalDate date;
    
}
