package com.itransition.controller;

import com.itransition.payload.ApiResult;
import com.itransition.payload.CustomPage;
import com.itransition.payload.resp.UserRespDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static com.itransition.utils.AppConstant.*;

/**
 * @author Bekjon Bakhromov
 * @since 05.07.2022
 */
@RequestMapping(UserController.USER_CONTROLLER)
public interface UserController {
    String USER_CONTROLLER = BASE_PATH + "/user";

    @GetMapping("get-all")
    ApiResult<CustomPage<UserRespDto>> getAllArtists(@RequestParam(name = "page", defaultValue = DEFAULT_PAGE_NUMBER, required = false) Integer page,
                                                     @RequestParam(name = "size", defaultValue = DEFAULT_PAGE_SIZE, required = false) Integer size);


}
