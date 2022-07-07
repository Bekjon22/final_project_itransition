package com.itransition.repository;

import com.itransition.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Bekjon Bakhromov
 * @created 23.06.2022-2:56 PM
 */
public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User>findByEmail(String email);

    boolean existsByEmail(String email);
}
