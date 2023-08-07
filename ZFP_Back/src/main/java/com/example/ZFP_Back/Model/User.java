package com.example.ZFP_Back.Model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table (name = "User")
public class User {
     @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    private String name;
    @Lob
    private byte[] image;
    private String work;
    private String address;
    private String phone;
    private int identity;
    private String nationality;
    private String sex;
    private int age;
    private String username;
    private String pass;
    private String email;
    private String leader;
    private String roles;
    private String message;

    
}
