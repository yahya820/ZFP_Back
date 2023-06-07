package com.example.ZFP_Back.Model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table( name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long userId;
    @Column ( name ="name")
    private String name;
    @Lob
    private byte[] image;
    @Column ( name = "work")
    private String work;
    @Column ( name = "address")
    private String address;
    @Column ( name = "phone")
    private int phone;
    @Column ( name = "identity")
    private int identity;
    @Column ( name = "nationality")
    private String nationality;
    @Column ( name = "sex")
    private String sex;
    @Column ( name = "age")
    private int age;
    @Column (name = "username")
    private String username;
    @Column  ( name = "pass")
    private String pass;
    private String email;
    private int leader;
    private String roles;
}
