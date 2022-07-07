package com.itransition.controller;

import com.itransition.payload.ApiResult;
import com.itransition.payload.req.LikeDto;
import com.itransition.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Bekjon Bakhromov
 * @since 28.06.2022
 */
@RestController
@RequiredArgsConstructor
public class LikeControllerImpl implements LikeController{

    private final LikeService likeService;

    @Override
    public ApiResult<?> addLike(LikeDto dto) {
        return likeService.add(dto);
    }


}
