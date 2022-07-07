package com.itransition.repository;

import com.itransition.entity.Collection;
import com.itransition.entity.User;
import com.itransition.enums.Topic;
import com.itransition.payload.resp.CollectionProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Bekjon Bakhromov
 * @since  23.06.2022-2:46 PM
 */
public interface CollectionRepository extends JpaRepository<Collection,Integer> {

    @Query(nativeQuery = true,value = "select  c.name,c.description,c.topic \n" +
            "from collections c \n" +
            "         join items i on c.id = i.collection_id \n" +
            "group by  c.id \n" +
            "order by count(i.id) desc limit 5")
    List<CollectionProjection> getLargestCollections();


    List<Collection>findAllByUser(User user);


}
