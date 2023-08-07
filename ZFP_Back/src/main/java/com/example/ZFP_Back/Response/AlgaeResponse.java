package com.example.ZFP_Back.Response;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class AlgaeResponse {
      private int algaeId;
    private int no_farm;
    private int no_men;
    private int no_women;
    private int hector;
    private int tones;
    private String type;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private String date;

    private int locationid;
    private String village;
    private String district;
    private String region;
    
}
