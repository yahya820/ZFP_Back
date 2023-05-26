package com.example.ZFP_Back.Repository;

import com.example.ZFP_Back.Model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Roles, Long> {
//    @Override
//    Optional<Roles> findById(Long role_id);

     public List<Roles> findByRoleId(long roleId);
}
