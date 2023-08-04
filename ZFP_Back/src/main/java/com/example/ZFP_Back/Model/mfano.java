package com.example.ZFP_Back.Model;


import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table( name = "mfano")
public class mfano {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long mfanoId;
    private String mfanoname;
    private LocalDate date;

}
