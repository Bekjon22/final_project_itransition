package com.itransition.payload.resp;

import com.itransition.payload.req.CustomFieldDto;
import com.itransition.payload.req.TagDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

/**
 * @author Bekjon Bakhromov
 * @since 30.06.2022
 */
@Getter
@Setter
public class ItemRespDto {

    private String name;

    private List<CommentResDto> commentResDtoList;

    private Set<CustomFieldDto> customFieldDtoSet;

    private Set<TagDto> tagDtoSet;
}
