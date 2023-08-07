package com.example.ZFP_Back.Repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ZFP_Back.Model.Message;
@Repository
public interface MesaageRepository extends JpaRepository<Message,Long> {
    @Query(value = "select m.message from message m JOIN user u ON u.user_id = m.user_user_id WHERE u.user_id = ?1",nativeQuery = true)
    List<Map<String,Object>> getMessage(Long userId);
}
