package com.example.ZFP_Back.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ZFP_Back.Model.Mfano;
@Repository
public interface MfanoRepository extends JpaRepository<Mfano, Long> {
    
    Boolean existsByName(String name);
}
