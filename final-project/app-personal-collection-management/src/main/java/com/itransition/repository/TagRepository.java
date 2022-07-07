package com.itransition.repository;

import com.itransition.entity.Item;
import com.itransition.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Bekjon Bakhromov
 * @since 30.06.2022
 */
public interface TagRepository extends JpaRepository<Tag,Integer> {

    List<Tag> findAllByItem(Item item);
}
