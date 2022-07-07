package com.itransition.repository;

import com.itransition.entity.Comment;
import com.itransition.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Bekjon Bakhromov
 * @since 26.06.2022
 *
 */
public interface CommentRepository extends JpaRepository<Comment,Integer> {

    List<Comment> getAllByItem(Item item);
}
