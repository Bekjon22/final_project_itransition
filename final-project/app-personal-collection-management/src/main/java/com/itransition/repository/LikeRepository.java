package com.itransition.repository;

import com.itransition.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Bekjon Bakhromov
 * @since 28.06.2022
 */
public interface LikeRepository extends JpaRepository<Like,Integer> {

}
