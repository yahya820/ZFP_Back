package com.example.ZFP_Back.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.Data;


// import java.util.ArrayList;
// import java.util.Date;
// import java.util.List;

@Data
@Entity
@Table( name ="Fisherman")
public class Fisherman {
    @Id
    @GeneratedValue ( strategy = GenerationType.AUTO)
    private Long fishermanId;
    private String ways;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate start_date;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate finish_date;
    private String diko_usage;
    private String type;
    private String meter;
    
    @OneToOne
    @JoinColumn(unique = true)
    private User user;

    // private Long paymentFishermanId;
    @JsonIgnoreProperties(value = "fisherman")
    @OneToMany(mappedBy = "fisherman")
    private List<PaymentFisherman> paymentFishermans = new ArrayList<>();

}