package com.itransition.controller;

import com.itransition.payload.ApiResult;
import com.itransition.payload.req.LikeDto;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.itransition.utils.AppConstant.BASE_PATH;

/**
 * @author Bekjon Bakhromov
 * @created 23.06.2022-11:03 AM
 */
@RequestMapping(LikeController.LIKE_CONTROLLER)
public interface LikeController {
    String LIKE_CONTROLLER = BASE_PATH + "/like";

    @PostMapping("/add")
    ApiResult<?> addLike(@RequestBody @Valid LikeDto dto);


}
