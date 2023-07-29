package com.example.ZFP_Back.Repository;

import com.example.ZFP_Back.Model.Fisherman;
import com.example.ZFP_Back.Response.FishermanResponse;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FishermanRepository extends JpaRepository<Fisherman, Long> {
    // @Query(value = "select * from fisherman f INNER JOIN user u WHERE u.user_id = f.user_user_id", nativeQuery = true)
    // List<Fisherman> getAll();

//    List<Fisherman> findByUserId(Long userId);
// @Query(value = "SELECT * FROM fisherman INNER JOIN user ON user.user_id = fisherman.user_id", nativeQuery = true)
//  Optional<Fisherman> findallByFishermanId(long fishermanId);

@Query(value = "SELECT * FROM fisherman fisherman INNER JOIN user user on user.user_id = fisherman.user_id WHERE user.user_id = ?1", nativeQuery = true)
// Optional<Fisherman> findallByFishermanId(Long userId);
Optional<Map<String,Object>>  findallByFishermanId(Long userId);

// @Query(value = "SELECT user.name,fisherman.type,fisherman.ways FROM fisherman fisherman INNER JOIN user user on user.user_id = fisherman.user_id", nativeQuery = true)
// // Optional<Fisherman> findallByFishermanId(Long userId);
// List<Fisherman>  findAll();

// @Query(value = "SELECT * FROM fisherman f INNER JOIN user u ON u.user_id = f.user_id", nativeQuery = true)
// List<Fisherman> findAll();

// @Query(value = "SELECT f.*, u.name, u.user_id AS user_id_fk FROM fisherman f INNER JOIN user u ON u.user_id = f.user_id;", nativeQuery = true)
// @Query (value = "")
// List<Fisherman> findAll();



}

