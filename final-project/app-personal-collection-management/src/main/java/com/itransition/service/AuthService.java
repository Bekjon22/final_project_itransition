package com.itransition.service;

import com.itransition.payload.ApiResult;
import com.itransition.payload.req.LoginDto;
import com.itransition.payload.req.RegisterDto;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author Bekjon Bakhromov
 * @since 04.07.2022
 */
public interface AuthService extends UserDetailsService {
    ApiResult<?> register(RegisterDto registerDto);

    ApiResult<?> login(LoginDto dto);
}
