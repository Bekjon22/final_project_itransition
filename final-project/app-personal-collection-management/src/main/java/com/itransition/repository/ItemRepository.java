package com.itransition.repository;

import com.itransition.entity.Item;
import com.itransition.payload.resp.LastItemProjection;
import com.itransition.payload.resp.SearchItemProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

/**
 * @author Bekjon Bakhromov
 * @since  23.06.2022-4:56 PM
 */
public interface ItemRepository extends JpaRepository<Item, Integer> {

    @Query(value = "select i.name as itemName,c.name as collectionName,u.first_name as author,i.created_at as createdTime from items i \n" +
            "join collections c on c.id = i.collection_id \n" +
            "join users u on u.id = c.user_id \n" +
            "order by i.created_at desc limit 5", nativeQuery = true)
    List<LastItemProjection> getLastItems();


    @Query(value = "select i.id as itemId \n" +
            "from items i \n" +
            "         left join custom_fields_value cfv on i.id = cfv.item_id \n" +
            "         left join tags t on i.id = t.item_id \n" +
            "         left join collections c on c.id = i.collection_id \n" +
            "         left join comments c2 on i.id = c2.item_id \n" +
            " where i.name ilike ?1 \n" +
            "   or c.name ilike ?1  \n" +
            "   or c.topic ilike ?1  \n" +
            "   or c2.text ilike ?1  \n" +
            "   or t.value ilike ?1  \n" +
            "   or cfv.value ilike ?1 \n" +
            " group by i.id ", nativeQuery = true)
    List<Integer> getItemIds(String text);

    @Query(value = "select i.id ,i.name \n" +
            "from items i \n" +
            "         left join custom_fields_value cfv on i.id = cfv.item_id \n" +
            "         left join tags t on i.id = t.item_id \n" +
            "         left join collections c on c.id = i.collection_id \n" +
            "         left join comments c2 on i.id = c2.item_id \n" +
            " where i.name ilike ?1 \n" +
            "   or c.name ilike ?1  \n" +
            "   or c.topic ilike ?1  \n" +
            "   or c2.text ilike ?1  \n" +
            "   or t.value ilike ?1  \n" +
            "   or cfv.value ilike ?1 \n" +
            " group by i.id ", nativeQuery = true)
    List<SearchItemProjection> getSearchItems(String text);


}
