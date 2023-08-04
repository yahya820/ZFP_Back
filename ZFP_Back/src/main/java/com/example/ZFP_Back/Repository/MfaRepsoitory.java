package com.example.ZFP_Back.Repository;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ZFP_Back.Model.mfano;
@Repository
public interface MfaRepsoitory extends JpaRepository <mfano,Long>{
    @Query(value = "select m.mfano_id, m.date,m.mfanoname,u.email FROM mfano m JOIN user u", nativeQuery = true)
    List<Map<String,Objects>> getAll();
    //  @Query(value = "select * FROM mfano m JOIN user u WHERE m.mfano_id =?1", nativeQuery = true)
    // Optional<mfano> findByMfanoId(Long mfanoId);
    @Query(value = "select mfano_id, date,mfanoname FROM mfano WHERE mfano_id = ?1", nativeQuery = true)
    List<Map<String,Objects>> findByMfanoId(Long mfano_id);
}
