package com.itransition.controller;


import com.itransition.payload.ApiResult;
import com.itransition.service.AttachmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;


import java.io.IOException;

/**
 * @author Bekjon Bakhromov
 * @since 07.07.2022
 */
@RestController
@RequiredArgsConstructor
public class AttachmentControllerImpl implements AttachmentController{

    private final AttachmentService service;


    @Override
    public ApiResult<?> upload(MultipartHttpServletRequest request) throws IOException {
        return service.upload(request);
    }
}
