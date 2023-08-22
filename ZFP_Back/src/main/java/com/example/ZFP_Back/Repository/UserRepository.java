package com.example.ZFP_Back.Repository;

import com.example.ZFP_Back.Model.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;

// import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
    
    boolean existsByIdentity(String identity);

    // @Query ( value = "select * from user where email = ?1", nativeQuery = "" )
    // User getByEmail(String email);

    boolean findByUsername(String name);

    
    @Query ( value = "select * from user where name = ?1", nativeQuery = true)
    Optional<User> getByUsername(String name);

    @Query ( value = "select user.name from user where userId=1", nativeQuery = true)
    Optional<User> getByUserId(long userId);

    @Query (value = " select * from user where roles='USER'", nativeQuery = true)
    List<User> findAll();
    @Query (value = "select * from user u JOIN fisherman f ON f.fisherman_id = u.user_id WHERE u.user_id = ?1", nativeQuery = true)
    Optional<Map<String,Object>>getUserIdandFishermanId(Long userId);

    @Query(value = "select * from user WHERE name = ?1", nativeQuery = true)
    List<User> findByName(String name);
}

