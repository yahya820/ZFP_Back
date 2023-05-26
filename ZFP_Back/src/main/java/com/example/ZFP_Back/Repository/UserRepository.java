package com.example.ZFP_Back.Repository;

import com.example.ZFP_Back.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    Optional<User> findByUsername(String username);

//    List<User> findByID(Long UserId);

//    List<User> findByFishermen_Diko(String diko);

//    List<User> findByPayments_AccountNo(String accountNo);
}

