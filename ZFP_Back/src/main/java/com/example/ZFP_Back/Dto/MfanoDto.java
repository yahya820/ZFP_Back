package com.example.ZFP_Back.Dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
@Data
public class MfanoDto {
    private String email;
  private int  mfano_id;
  @JsonFormat(pattern = "yyyy-MM-dd")
   private String date;
  private String  mfanoname;
}
