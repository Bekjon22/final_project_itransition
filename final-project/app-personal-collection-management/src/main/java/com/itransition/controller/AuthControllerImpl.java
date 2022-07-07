package com.itransition.controller;

import com.itransition.payload.ApiResult;
import com.itransition.payload.req.LoginDto;
import com.itransition.payload.req.RegisterDto;
import com.itransition.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Bekjon Bakhromov
 * @since  02.06.2022-6:20 PM
 */
@RestController
@RequiredArgsConstructor
public class AuthControllerImpl implements AuthController {
    private final AuthService authService;


    @Override
    public ApiResult<?> register(RegisterDto registerDto) {
        return authService.register(registerDto);
    }

    @Override
    public ApiResult<?> login(LoginDto dto) {
        return authService.login(dto);
    }
}
