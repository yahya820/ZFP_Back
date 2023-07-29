package com.example.ZFP_Back.Repository;

import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ZFP_Back.Model.Vessel;

@Repository
public interface VesselRepository extends JpaRepository<Vessel,Long> {
// @Query(value = "SELECT * from vessel vessel INNER JOIN user user ON user.user_id = vessel.user_id WHERE user.user_id = ?1", nativeQuery = true)
// Optional<Map<String,Object>> findbyUserId(Long userId);
    
}
