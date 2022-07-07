package com.itransition.controller;

import com.itransition.payload.ApiResult;
import com.itransition.utils.AppConstant;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;

/**
 * @author Bekjon Bakhromov
 * @since 07.07.2022
 */
@RequestMapping(AttachmentController.ATTACHMENT_CONTROLLER)
public interface AttachmentController {
    String ATTACHMENT_CONTROLLER = AppConstant.BASE_PATH + "/attachment";

    @PostMapping("/upload")
    ApiResult<?> upload(MultipartHttpServletRequest request) throws IOException;


}
