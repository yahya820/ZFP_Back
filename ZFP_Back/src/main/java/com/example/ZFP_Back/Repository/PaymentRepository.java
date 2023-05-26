package com.example.ZFP_Back.Repository;

import com.example.ZFP_Back.Model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

//    List<Payment> findByUserId(Long userId);
}

