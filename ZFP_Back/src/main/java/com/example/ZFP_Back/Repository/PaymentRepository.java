package com.example.ZFP_Back.Repository;

import com.example.ZFP_Back.Model.Payment;
import com.example.ZFP_Back.Response.PaymentVesselResponse;

import java.util.List;


// import java.util.Optional;

// import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
// import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

//    List<Payment> findByUserId(Long userId);
// @Query ("select * from payment where payment_id = ?1")
// Optional<Payment> getByPaymentId(long paymentId);
// @Query ("SELECT new com.example.ZFP_Back.Response.PaymentVesselResponse(py.acc_name,py.receipt_no,py.date) FROM payment py")
// List<PaymentVesselResponse> getAllPayment();
@Query( value = "SELECT * FROM payment WHERE code_name = 'fisherman'", nativeQuery = true)
List<Payment> getPaymentFishermanAll();

@Query( value = "SELECT * FROM payment WHERE code_name = 'vessel'", nativeQuery = true)
List<Payment> getPaymentVesselAll();
}

