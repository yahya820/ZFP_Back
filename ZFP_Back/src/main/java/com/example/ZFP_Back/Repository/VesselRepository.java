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

    @Query( value = "Select v.vessel_id,v.name_vessel,v.type_vessel,no_vessel,v.ways from vessel v JOIN user u ON u.user_id = v.user_id where u.user_id = ?1", nativeQuery = true)
    List<Map<String,Object>> getVesselByUserId(Long userId);

    @Query(value = "Select u.user_id, v.vessel_id,v.name_vessel,v.type_vessel,no_vessel,v.ways from vessel v JOIN user u ON u.user_id = v.user_id where u.user_id = ?1",nativeQuery = true)
    List<Map<String,Object>> getVesselInProfile(Long userId);

    // @Query(value = "SELECT pa.payment_id,pa.acc_name,pa.receipt_no,pa.date,u.user_id,u.address,u.age,u.email,u.identity,u.leader,u.nationality,u.phone,u.work,u.sex,u.name,v.name_vessel,v.meter,v.finish_date,v.no_people,v.start_date,v.no_vessel,v.type_vessel,v.ways,v.vessel_id FROM payment_vessel pa JOIN vessel v JOIN user u ON u.user_id = v.user_id and v.vessel_id = pa.vessel_vessel_id WHERE v.vessel_id = ?1",nativeQuery = true)
    // Optional<Vessel> findById(Long vesselId);
    
}
