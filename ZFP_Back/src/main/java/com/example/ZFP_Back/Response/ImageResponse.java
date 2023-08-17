package com.example.ZFP_Back.Response;

import lombok.Data;

@Data
public class ImageResponse {
    private int image_id;
    private String image_name;
    private byte[] image; 
    private Long user_id;


}
