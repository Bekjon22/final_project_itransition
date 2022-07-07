package com.itransition.controller;

import com.itransition.payload.ApiResult;
import com.itransition.payload.req.CommentDto;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.itransition.utils.AppConstant.BASE_PATH;

/**
 * @author Bekjon Bakhromov
 * @since  23.06.2022-11:03 AM
 */
@RequestMapping(CommentController.COMMENT_CONTROLLER)
public interface CommentController {
    String COMMENT_CONTROLLER = BASE_PATH + "/comment";

    @PostMapping("/add")
    ApiResult<?> addCollection(@RequestBody @Valid CommentDto dto);



}
