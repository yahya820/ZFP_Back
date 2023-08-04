package com.example.ZFP_Back.Response;

import lombok.Data;

@Data
public class MfanoResponse {
    private Long mfanoId;
    private String name;

    private Long userId;
    private String email;
}
