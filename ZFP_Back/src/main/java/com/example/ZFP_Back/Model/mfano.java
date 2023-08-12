package com.example.ZFP_Back.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Data
@Table( name = "mfano")
public class Mfano {
    @Id
    @GeneratedValue ( strategy = GenerationType.AUTO)
    private Long mfanoId;
    @Column(unique = true)
    private String name;
}
