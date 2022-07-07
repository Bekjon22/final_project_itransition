package com.itransition.controller;

import com.itransition.payload.ApiResult;
import com.itransition.payload.req.CommentDto;
import com.itransition.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Bekjon Bakhromov
 * @since 28.06.2022
 */
@RestController
@RequiredArgsConstructor
public class CommentControllerImpl implements CommentController {

    private final CommentService commentService;

    @Override
    public ApiResult<?> addCollection(CommentDto dto) {
        return commentService.add(dto);
    }
}
