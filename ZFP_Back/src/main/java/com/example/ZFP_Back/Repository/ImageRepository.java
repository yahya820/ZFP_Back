package com.example.ZFP_Back.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ZFP_Back.Model.Image;
@Repository
public interface ImageRepository extends JpaRepository<Image,Integer> {
    @Query(value = "select * from image WHERE user_id = ?1",nativeQuery = true)
    Optional<Image>getImageyUserId(Integer userId);
}
