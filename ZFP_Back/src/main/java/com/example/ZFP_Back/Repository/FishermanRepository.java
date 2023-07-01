package com.example.ZFP_Back.Repository;

import com.example.ZFP_Back.Model.Fisherman;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FishermanRepository extends JpaRepository<Fisherman, Long> {

//    List<Fisherman> findByUserId(Long userId);
@Query(value = "SELECT * from fisherman where fisherman_id = ?1 and user_user_id = ?1", nativeQuery = true)
 Optional<Fisherman> findallByFishermanId(long fishermanId);
}

