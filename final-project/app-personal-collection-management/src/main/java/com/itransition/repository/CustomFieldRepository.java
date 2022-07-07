package com.itransition.repository;

import com.itransition.entity.CustomField;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Bekjon Bakhromov
 * @since 27.06.2022
 */
public interface CustomFieldRepository extends JpaRepository<CustomField,Integer> {
}
