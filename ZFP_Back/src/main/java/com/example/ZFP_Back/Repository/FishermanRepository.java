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

    Boolean existsByUser(Long userId);
    
    @Query(value = "SELECT pa.payment_fisherman_id, pa.acc_name, pa.receipt_no, pa.date, u.user_id,u.email,u.leader,u.name, u.work, u.address,u.nationality, u.phone, u.sex, u.identity, f.ways, f.diko_usage, f.type, f.meter FROM Payment_fisherman pa JOIN fisherman f JOIN user u WHERE u.user_id = f.user_user_id;", nativeQuery = true)
    List<Map<String,Object>> getAll();
    // @Query("SELECT new com.example.ZFP_Back.Response.FishermanResponse(u.name,f.ways,pa.paymentFishermans) FROM fisherman f JOIN user u JOIN payment_fisherman pa")
    // List<FishermanResponse>getAll();

//    List<Fisherman> findByUserId(Long userIds);
// @Query(value = "SELECT * FROM fisherman INNER JOIN user ON user.user_id = fisherman.user_id", nativeQuery = true)
//  Optional<Fisherman> findallByFishermanId(long fishermanId);

@Query(value = "SELECT pa.payment_fisherman_id, pa.acc_name, pa.receipt_no, pa.date, u.user_id,u.email,u.leader,u.name, u.work, u.address,u.nationality, u.phone, u.sex, u.identity, f.ways, f.diko_usage, f.type, f.meter FROM Payment_fisherman pa JOIN fisherman f JOIN user u WHERE f.fisherman_id = ?1", nativeQuery = true)
// Optional<Fisherman> findallByFishermanId(Long userId);
Optional<Map<String,Object>>  findallByFishermanId(Long fishermanId);

// @Query(value = "SELECT user.name,fisherman.type,fisherman.ways FROM fisherman fisherman INNER JOIN user user on user.user_id = fisherman.user_id", nativeQuery = true)
// // Optional<Fisherman> findallByFishermanId(Long userId);
// List<Fisherman>  findAll();

// @Query(value = "SELECT * FROM fisherman f INNER JOIN user u ON u.user_id = f.user_id", nativeQuery = true)
// List<Fisherman> findAll();

// @Query(value = "SELECT f.*, u.name, u.user_id AS user_id_fk FROM fisherman f INNER JOIN user u ON u.user_id = f.user_id;", nativeQuery = true)
// @Query (value = "")
// List<Fisherman> findAll();
@Query( value = "select f.fisherman_id,f.diko_usage,f.ways,f.meter,f.type,f.start_date,f.finish_date,u.name,u.identity,u.address,u.identity,u.sex,u.nationality,u.phone,u.age,u.work,u.email from fisherman f JOIN user u ON u.user_id = f.user_user_id WHERE u.user_id = ?1", nativeQuery = true)
Optional<Map<String,Object>>findByFisherId(Long fishermanId);




}

