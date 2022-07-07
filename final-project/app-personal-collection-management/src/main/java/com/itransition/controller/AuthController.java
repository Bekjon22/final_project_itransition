package com.itransition.controller;

import com.itransition.payload.ApiResult;
import com.itransition.payload.req.LoginDto;
import com.itransition.payload.req.RegisterDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import static com.itransition.utils.AppConstant.BASE_PATH;

/**
 * @author Bekjon Bakhromov
 * @since 04.07.2022
 */
@RequestMapping(AuthController.AUTH_CONTROLLER)
public interface AuthController {
    String AUTH_CONTROLLER = BASE_PATH + "/auth";

    @PostMapping("/register")
    ApiResult<?> register(@RequestBody @Valid RegisterDto registerDto);

    @PostMapping(value = "/login")
    ApiResult<?> login(@RequestBody @Valid LoginDto dto);
}
