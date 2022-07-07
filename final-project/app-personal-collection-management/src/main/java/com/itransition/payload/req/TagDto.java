package com.itransition.payload.req;

import com.itransition.entity.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.ManyToOne;

/**
 * @author Bekjon Bakhromov
 * @created 23.06.2022-4:44 PM
 */
@Getter
@Setter
public class TagDto {
    private String value;

}
