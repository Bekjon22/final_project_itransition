package com.itransition.payload.req;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Bekjon Bakhromov
 * @since 29.06.2022
 */
@Getter
@Setter
public class CustomFieldDto {

    private String customFieldName;

    private String fieldType;

    private String value;

}
