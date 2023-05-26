//package com.example.ZFP_Back.Repository;
//
//import com.example.ZFP_Back.Model.PersonalInfo;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface PersonalRepository extends JpaRepository<PersonalInfo, Long> {
//
////    @Override
////    Optional<PersonalInfo> findById(Long aLong);
//@Query(value = "select * from personalInfo and user where username=?1", nativeQuery = true)
//    List<PersonalInfo> FindByUsername(String name);
//
//}
//
