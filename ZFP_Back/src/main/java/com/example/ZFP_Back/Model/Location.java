package com.example.ZFP_Back.Model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table( name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long locationid;
    private String village;
    private String district;
    private String region;

    @JsonIgnoreProperties(value = "location")
    @OneToMany(mappedBy = "location")
    private List <Algae> algaeList = new ArrayList<>();

}
