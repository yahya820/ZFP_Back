package com.example.ZFP_Back.Repository;

import com.example.ZFP_Back.Model.Payment;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

//    List<Payment> findByUserId(Long userId);
@Query ("select * from payment where payment_id = ?1")
Optional<Payment> getByPaymentId(long paymentId);
}

