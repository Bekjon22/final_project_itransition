package com.itransition.service;

import com.itransition.payload.ApiResult;
import com.itransition.payload.req.LikeDto;

/**
 * @author Bekjon Bakhromov
 * @created 23.06.2022-1:06 PM
 */
public interface LikeService {

    ApiResult<?> add(LikeDto dto);
}
