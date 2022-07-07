package com.itransition.service;

import com.itransition.common.MessageService;
import com.itransition.entity.Role;
import com.itransition.entity.User;
import com.itransition.enums.RoleEnum;
import com.itransition.exception.RestException;
import com.itransition.payload.ApiResult;
import com.itransition.payload.req.LoginDto;
import com.itransition.payload.req.RegisterDto;
import com.itransition.repository.RoleRepository;
import com.itransition.repository.UserRepository;
import com.itransition.security.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Bekjon Bakhromov
 * @since 04.07.2022
 */
@RestController
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;


    @Autowired
    JwtProvider jwtProvider;

    @Autowired
    @Lazy
    PasswordEncoder passwordEncoder;

    @Autowired
    @Lazy
    AuthenticationManager authenticationManager;


    @Override
    public ApiResult<?> register(RegisterDto registerDto) {
        boolean existsByEmail = userRepository.existsByEmail(registerDto.getEmail());
        if (existsByEmail) {
            throw RestException.restThrow(MessageService.getMessage("EMAIL_ALREADY_EXISTS"), HttpStatus.CONFLICT);
        }
        Role role = roleRepository.findByType(RoleEnum.ROLE_USER).orElseThrow(() -> RestException.notFound(MessageService.getMessage("ROLE_NOT_FOUND")));
        User user = new User();
        user.setFirstName(registerDto.getName());
        user.setEmail(registerDto.getEmail());
        user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
        user.setRole(role);
        userRepository.save(user);

        return ApiResult.successResponse(MessageService.getMessage("SUCCESS_REGISTER"));
    }

    @Override
    public ApiResult<?> login(LoginDto dto) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword()));
            String token = jwtProvider.generateToken(dto.getEmail());
            return ApiResult.successResponse(token);
        } catch (Exception e) {
            throw RestException.restThrow(MessageService.getMessage("WRONG_USERNAME_OR_PASSWORD"), HttpStatus.FORBIDDEN);
        }

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException(MessageService.getMessage("EMAIL_NOT_FOUND") + " " + username));
    }
}
