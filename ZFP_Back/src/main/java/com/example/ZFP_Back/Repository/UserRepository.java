package com.example.ZFP_Back.Repository;

import com.example.ZFP_Back.Model.User;

import java.util.Optional;

// import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // @Query ( value = "select * from user where email = ?1", nativeQuery = "" )
    // User getByEmail(String email);

    boolean findByUsername(String name);

    @Query ( value = "select * from user where name = ?1", nativeQuery = true)
    Optional<User> getByUsername(String name);
}

