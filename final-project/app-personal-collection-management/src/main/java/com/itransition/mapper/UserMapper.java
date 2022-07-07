package com.itransition.mapper;

import com.itransition.entity.User;
import com.itransition.entity.template.AbsEntity;
import com.itransition.payload.resp.UserRespDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.SubclassMapping;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

import static org.mapstruct.ReportingPolicy.IGNORE;

/**
 * @author Bekjon Bakhromov
 * @since 05.07.2022
 */
@Mapper(unmappedTargetPolicy = IGNORE, componentModel = "spring")
@Component
public interface UserMapper {



    UserRespDto toUserRespDto(User user , Timestamp createdAt);

}
