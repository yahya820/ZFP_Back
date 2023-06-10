package com.example.ZFP_Back.Dto;
import lombok.Data;
import java.time.LocalDate;
// import java.util.ArrayList;
// import java.util.List;

@Data
public class FIshermanDTO {
    private Long fishernmanId;
    private String ways;
    private LocalDate start_date;
    private LocalDate finish_date;
    private String diko_usage;
    private String type;
    private String meter;

    // private List<Payment> paymentList = new ArrayList<>();
}
