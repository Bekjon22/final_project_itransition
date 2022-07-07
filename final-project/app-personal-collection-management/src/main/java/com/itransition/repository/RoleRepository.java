package com.itransition.repository;

import com.itransition.entity.Role;
import com.itransition.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Bekjon Bakhromov
 * @since  24.06.2022-12:35 AM
 */
public interface RoleRepository extends JpaRepository<Role,Integer> {
    Optional<Role> findByType(RoleEnum type);
}
