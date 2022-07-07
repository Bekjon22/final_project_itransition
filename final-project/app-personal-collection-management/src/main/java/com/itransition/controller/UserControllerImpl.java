package com.itransition.controller;

import com.itransition.entity.User;
import com.itransition.payload.ApiResult;
import com.itransition.payload.CustomPage;
import com.itransition.payload.resp.UserRespDto;
import com.itransition.repository.UserRepository;
import com.itransition.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Bekjon Bakhromov
 * @since 05.07.2022
 */
@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController{
    private final UserService userService;

    @Override
    public ApiResult<CustomPage<UserRespDto>> getAllArtists(Integer page, Integer size) {
        return userService.getAll(page,size);
    }
}
