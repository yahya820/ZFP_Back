package com.example.ZFP_Back.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ZFP_Back.Model.Vessel;

@Repository
public interface VesselRepository extends JpaRepository<Vessel,Long> {
    @Query(value  = "select v.vessel_id,v.no_vesesel,v.name_vessel,v.type_vessel, u.name from vessel v JOIN user u WHERE u.roles = 'USER';", nativeQuery = true)
    List<Map<String,Object>> getAllVessel();

    @Query( value = "SELECT v.name_vessel,v.type_vessel,v.no_vessel,v.ways,v.vessel_id FROM vessel v JOIN user u ON u.user_id = v.user_id;",nativeQuery = true)
    List<Map<String,Object>> getAllVesselInProfile();
    
}
