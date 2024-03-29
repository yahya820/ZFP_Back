package com.example.ZFP_Back.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ZFP_Back.Model.PaymentVessel;
@Repository
public interface PaymentVesselRepository extends JpaRepository<PaymentVessel,Long> {
    // @Query(value = "SELECT pa.payment_id,pa.acc_name,pa.receipt_no,pa.date,u.user_id,u.address,u.age,u.email,u.identity,u.leader,u.nationality,u.phone,u.work,u.sex,u.name,v.name_vessel,v.meter,v.finish_date,v.no_people,v.start_date,v.no_vessel,v.type_vessel,v.ways,v.vessel_id FROM payment_vessel pa JOIN vessel v JOIN user u ON u.user_id = v.user_id and v.vessel_id = pa.vessel_vessel_id WHERE v.vessel_id = ?1",nativeQuery = true)
    @Query(value = "select pa.*,u.*,v.* from payment_vessel pa JOIN vessel v JOIN user u ON u.user_id = v.user_id and v.vessel_id = pa.vessel_vessel_id WHERE v.vessel_id = ?1",nativeQuery = true)
    List<PaymentVessel>getAllPaymentByUserId(Long userId);

    @Query(value = "select u.name,pa.acc_name,pa.receipt_no,pa.date from payment_vessel pa JOIN user u JOIN vessel v ON u.user_id = v.user_id and v.vessel_id = pa.vessel_vessel_id;",nativeQuery = true)
    List<Map<String,Object>>FindAllPayment();

    @Query(value = "select u.name,pa.acc_name,pa.receipt_no,pa.date from payment_vessel pa JOIN user u JOIN vessel v ON u.user_id = v.user_id and v.vessel_id = pa.vessel_vessel_id WHERE pa.date BETWEEN ?1 and ?2", nativeQuery = true)
    List<Map<String,Object>>getPaymentByDate(LocalDate startDate,LocalDate endDate);


}
