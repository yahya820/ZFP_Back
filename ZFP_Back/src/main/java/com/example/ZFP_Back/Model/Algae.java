package com.example.ZFP_Back.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table (name = "Algae")
public class Algae {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long algae_id;
}
