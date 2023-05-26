package com.example.ZFP_Back.Repository;

import com.example.ZFP_Back.Model.Fisherman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FishermanRepository extends JpaRepository<Fisherman, Long> {

//    List<Fisherman> findByUserId(Long userId);
}

