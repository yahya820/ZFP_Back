package com.example.ZFP_Back.Request;

import lombok.Data;

@Data
public class LocationRequest {
    private Long locationid;
    private String village;
    private String district;
    private String region;

}
