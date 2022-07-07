package com.itransition.payload.req;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Set;

/**
 * @author Bekjon Bakhromov
 * @created 23.06.2022-4:42 PM
 */

@Getter
@Setter
public class ItemDto {

    @NotBlank(message = "{ITEM_NAME_REQUIRED}")
    private String name;

    private Integer collectionId;

    private List<CustomFieldDto> customFieldDtoSet;

    private Set<TagDto> tagDtoSet;



}
