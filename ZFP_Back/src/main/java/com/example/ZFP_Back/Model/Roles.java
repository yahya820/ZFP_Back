package com.example.ZFP_Back.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table( name = "Roles")
public class Roles {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long roleId;
    private String roleName;
}
