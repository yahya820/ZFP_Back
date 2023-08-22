package com.example.ZFP_Back.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name = "public_Message")
public class PublicMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long public_id;
    private String message;
}
