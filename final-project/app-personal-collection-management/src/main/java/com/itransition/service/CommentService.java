package com.itransition.service;

import com.itransition.payload.ApiResult;
import com.itransition.payload.req.CommentDto;

/**
 * @author Bekjon Bakhromov
 * @created 23.06.2022-1:06 PM
 */
public interface CommentService {


    ApiResult<?> add(CommentDto dto);
}
