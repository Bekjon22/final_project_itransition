package com.itransition.service;

import com.itransition.entity.User;
import com.itransition.mapper.UserMapper;
import com.itransition.payload.ApiResult;
import com.itransition.payload.CustomPage;
import com.itransition.payload.resp.UserRespDto;
import com.itransition.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Bekjon Bakhromov
 * @since 05.07.2022
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public ApiResult<CustomPage<UserRespDto>> getAll(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Order.asc("firstName")));
        Page<User> allUsers = userRepository.findAll(pageable);
        return ApiResult.successResponse(makeCustomPage(allUsers));
    }

    @Override
    public CustomPage<UserRespDto> makeCustomPage(Page<User> users) {
        List<UserRespDto> userRespDtos = new ArrayList<>();
        for (User user : users.getContent()) {
            UserRespDto userRespDto = new UserRespDto();
            userRespDto.setFirstName(user.getFirstName());
            userRespDto.setEmail(user.getEmail());
            userRespDto.setRegisterAt(user.getCreatedAt());
            userRespDto.setRoleName(user.getRole().getName());
            userRespDtos.add(userRespDto);
        }
        return new CustomPage<>(
                userRespDtos,
                users.getNumberOfElements(),
                users.getNumber(),
                users.getTotalElements(),
                users.getTotalPages(),
                users.getSize()
        );
    }
}
