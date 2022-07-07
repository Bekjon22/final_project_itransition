package com.itransition.repository;

import com.itransition.entity.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Bekjon Bakhromov
 * @since 02.07.2022
 */
public interface AttachmentRepository extends JpaRepository<Attachment,Integer> {
}
