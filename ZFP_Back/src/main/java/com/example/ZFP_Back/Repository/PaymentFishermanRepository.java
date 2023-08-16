package com.example.ZFP_Back.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.relational.core.sql.TrueCondition;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ZFP_Back.Model.PaymentFisherman;
import com.example.ZFP_Back.Response.PaymentFishermanResponse;
@Repository
public interface PaymentFishermanRepository extends JpaRepository<PaymentFisherman,Long>{
    // @Query(value = "select p1_0.payment_fisherman_id,p1_0.acc_name,p1_0.date,f1_0.fisherman_id,f1_0.diko_usage,f1_0.finish_date,f1_0.meter,f1_0.start_date,f1_0.type,u1_0.user_id,u1_0.address,u1_0.age,u1_0.email,u1_0.identity,u1_0.image,u1_0.leader,u1_0.name,u1_0.nationality,u1_0.pass,u1_0.phone,u1_0.roles,u1_0.sex,u1_0.username,u1_0.work,f1_0.ways,p1_0.receipt_no from payment_fisherman p1_0 left join fisherman f1_0 on f1_0.fisherman_id=p1_0.fisherman_fisherman_id left join user u1_0 on u1_0.user_id=f1_0.user_user_id where p1_0.payment_fisherman_id=1", nativeQuery = true)
    // @Query("SELECT new com.example.ZFP_Back.Response.PaymentFishermanResponse(pa.paymentFishermanId, pa.acc_name, pa.receipt_no, pa.date, f.user.userId, f.user.name, f.user.work, f.user.address, f.user.phone, f.user.sex, f.user.identity, f.ways, f.diko_usage, f.type, f.meter) "
    //     + "FROM PaymentFisherman pa JOIN pa.fisherman f WHERE f.user.userId = 2")
    // @Query("SELECT new com.example.ZFP_Back.Response.PaymentFishermanResponse(pa.paymentFishermanId, pa.acc_name, pa.receipt_no, pa.date, f.user.userId, f.user.name, f.user.work, f.user.address, f.user.phone, f.user.sex, f.user.identity, f.ways, f.diko_usage, f.type, f.meter) "
    //     + "FROM PaymentFisherman pa JOIN pa.fisherman f JOIN f.user u WHERE f.fishermanId = ?1")
    @Query(value = "SELECT pa.payment_fisherman_id, pa.acc_name, pa.receipt_no, pa.date, u.user_id,u.email,u.leader,u.name, u.work, u.address,u.nationality, u.phone, u.sex, u.identity, f.ways, f.diko_usage, f.type, f.meter FROM Payment_fisherman pa JOIN fisherman f JOIN user u ON pa.id = f.fisherman_id and u.user_id = f.user_user_id WHERE u.user_id = ?1",nativeQuery = true)
    List<Map<String,Objects>> findByUserId(Long fishermanId);
     @Query(value ="SELECT pa.payment_fisherman_id, pa.acc_name, pa.receipt_no, pa.date, u.user_id,u.email,u.leader,u.name, u.work, u.address,u.nationality, u.phone, u.sex, u.identity, f.ways, f.diko_usage, f.type, f.meter FROM Payment_fisherman pa JOIN fisherman f JOIN user u ",nativeQuery = true)
    List<Map<String,Objects>> findAllPaymentFisherman();
    @Query(value ="SELECT DISTINCT pa.payment_fisherman_id, pa.acc_name, pa.receipt_no, pa.date, " +
    "u.user_id, u.email, u.leader, u.name, u.work, u.address, u.nationality, " +
    "u.phone, u.sex, u.identity, f.ways, f.diko_usage, f.type, f.meter " +
    "FROM User u " +
    "JOIN fisherman f " +
    "JOIN payment_fisherman pa WHERE u.user_id = f.fisherman_id and f.fisherman_id = pa.fisherman_fisherman_id",nativeQuery = true)   
     List<Map<String,Object[]>> getAll();
    
     @Query(value = "select u.name,pa.acc_name,pa.receipt_no,pa.date from payment_fisherman pa JOIN user u JOIN fisherman f ON f.fisherman_id = pa.id and u.user_id = f.user_user_id ",nativeQuery = true)
     List<Map<String,Object>>FindAllPayment();

     @Query( value = "SELECT * FROM payment_fisherman WHERE date BETWEEN ?1 and ?2",nativeQuery = true)
     List<PaymentFisherman> getCostandProducedByDate(LocalDate starDate , LocalDate enDate); 

    @Query( value = "SELECT u.name,pa.receipt_no,pa.date, pa.acc_name from payment_fisherman pa JOIN user u JOIN fisherman f ON f.fisherman_id = pa.id and u.user_id = f.user_user_id  WHERE pa.date BETWEEN ?1 and ?2",nativeQuery = true)
     List<Map<String,Object>> getPaymentByDate(LocalDate startDate , LocalDate endDate);

    //   @Query("SELECT a.* FROM Payment_fisherman a WHERE a.date >= ?1 AND a.date <= ?2")
    // List<PaymentFisherman> findActivitiesByDateRange(
    //     @Param("startDate") LocalDate startDate,
    //     @Param("finishDate") LocalDate finishDate
    // );
}
