package com.example.ZFP_Back.Repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ZFP_Back.Model.Algae;
@Repository
public interface AlgaeRepositoty extends JpaRepository<Algae,Long> {
    @Query (value = "select al.*, l.village from algae al JOIN location l ON l.locationid = al.location_locationid", nativeQuery = true)
    List<Map<String,Object>> getAll();

    @Query(value = "select *from algae a ORDER BY a.time DESC", nativeQuery = true)
    List<Algae> getAllByTime();
}
