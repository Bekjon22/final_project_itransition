package com.itransition.payload.resp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Bekjon Bakhromov
 * @since  24.06.2022-1:42 AM
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CollectionResDto {
    private String name;

    private String description;

    private String topic;

    private Integer id;

}
