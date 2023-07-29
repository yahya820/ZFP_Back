package com.example.ZFP_Back.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ZFP_Back.Model.PaymentFisherman;
import com.example.ZFP_Back.Response.PaymentFishermanResponse;
@Repository
public interface PaymentFishermanRepository extends JpaRepository<PaymentFisherman,Long>{
    // @Query(value = "select p1_0.payment_fisherman_id,p1_0.acc_name,p1_0.date,f1_0.fisherman_id,f1_0.diko_usage,f1_0.finish_date,f1_0.meter,f1_0.start_date,f1_0.type,u1_0.user_id,u1_0.address,u1_0.age,u1_0.email,u1_0.identity,u1_0.image,u1_0.leader,u1_0.name,u1_0.nationality,u1_0.pass,u1_0.phone,u1_0.roles,u1_0.sex,u1_0.username,u1_0.work,f1_0.ways,p1_0.receipt_no from payment_fisherman p1_0 left join fisherman f1_0 on f1_0.fisherman_id=p1_0.fisherman_fisherman_id left join user u1_0 on u1_0.user_id=f1_0.user_user_id where p1_0.payment_fisherman_id=1", nativeQuery = true)
    // @Query("SELECT new com.example.ZFP_Back.Response.PaymentFishermanResponse(pa.paymentFishermanId, pa.acc_name, pa.receipt_no, pa.date, f.user.userId, f.user.name, f.user.work, f.user.address, f.user.phone, f.user.sex, f.user.identity, f.ways, f.diko_usage, f.type, f.meter) "
    //     + "FROM PaymentFisherman pa JOIN pa.fisherman f WHERE f.user.userId = 2")
    @Query("SELECT new com.example.ZFP_Back.Response.PaymentFishermanResponse(pa.paymentFishermanId, pa.acc_name, pa.receipt_no, pa.date, f.user.userId, f.user.name, f.user.work, f.user.address, f.user.phone, f.user.sex, f.user.identity, f.ways, f.diko_usage, f.type, f.meter) "
        + "FROM PaymentFisherman pa JOIN pa.fisherman f JOIN f.user u WHERE f.fishermanId = ?1")
    List<PaymentFishermanResponse> findByUserId(Long userId);
     @Query("SELECT new com.example.ZFP_Back.Response.PaymentFishermanResponse(pa.paymentFishermanId, pa.acc_name, pa.receipt_no, pa.date, f.user.userId, f.user.name, f.user.work, f.user.address, f.user.phone, f.user.sex, f.user.identity, f.ways, f.diko_usage, f.type, f.meter) "
        + "FROM PaymentFisherman pa JOIN pa.fisherman f JOIN f.user u")
    List<PaymentFishermanResponse> findAllPaymentFisherman();

    
}
