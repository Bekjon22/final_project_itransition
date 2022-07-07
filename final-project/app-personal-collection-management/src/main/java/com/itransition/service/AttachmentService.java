package com.itransition.service;

import com.itransition.payload.ApiResult;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;

/**
 * @author Bekjon Bakhromov
 * @since 07.07.2022
 */

public interface AttachmentService {

    ApiResult<?> upload(MultipartHttpServletRequest request) throws IOException;
}
