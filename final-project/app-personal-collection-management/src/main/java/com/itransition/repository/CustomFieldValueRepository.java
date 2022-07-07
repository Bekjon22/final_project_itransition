package com.itransition.repository;

import com.itransition.entity.CustomFieldValue;
import com.itransition.entity.Item;
import com.itransition.payload.req.CustomFieldProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author Bekjon Bakhromov
 * @since 27.06.2022
 */
public interface CustomFieldValueRepository extends JpaRepository<CustomFieldValue,Integer> {

    List<CustomFieldValue> getAllByItem(Item item);

@Query(value = " select cfv.value,cf.name,cf.field_type as fieldType from custom_fields_value cfv \n" +
        " left join custom_fields cf on cf.id = cfv.custom_field_id \n" +
        " where cfv.item_id=:itemId",nativeQuery = true)
    List<CustomFieldProjection> getAllCustomFields(Integer itemId);

}
