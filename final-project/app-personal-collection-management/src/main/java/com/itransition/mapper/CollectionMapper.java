package com.itransition.mapper;

import com.itransition.entity.Collection;
import com.itransition.payload.req.CollectionDto;
import com.itransition.payload.req.CollectionEditDto;
import com.itransition.payload.resp.CollectionResDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * @author Bekjon Bakhromov
 * @since  24.06.2022-3:03 AM
 */
@Mapper(unmappedTargetPolicy = IGNORE, componentModel = "spring")
@Component
public interface CollectionMapper {

    Collection toCollectionAdd(CollectionDto dto);


    CollectionResDto toCollectionRespDto (Collection collection);
    Collection toCollection(@MappingTarget Collection collection, CollectionEditDto dto);




}
