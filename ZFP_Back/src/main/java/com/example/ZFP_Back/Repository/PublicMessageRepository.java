package com.example.ZFP_Back.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ZFP_Back.Model.PublicMessage;

@Repository
public interface PublicMessageRepository extends JpaRepository<PublicMessage,Long> {
    
}
