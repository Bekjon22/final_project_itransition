package com.itransition.payload.req;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Bekjon Bakhromov
 * @since 28.06.2022
 */
@Getter
@Setter
public class LikeDto {

    private Integer userId;

    private Integer itemId;
}
