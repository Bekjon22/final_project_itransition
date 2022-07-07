package com.itransition.service;

import com.itransition.common.MessageService;
import com.itransition.entity.Attachment;
import com.itransition.entity.AttachmentContent;
import com.itransition.payload.ApiResult;
import com.itransition.repository.AttachmentContentRepository;
import com.itransition.repository.AttachmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.util.Iterator;

/**
 * @author Bekjon Bakhromov
 * @since 07.07.2022
 */
@Service
@RequiredArgsConstructor
public class AttachmentServiceImpl implements AttachmentService{
    private final AttachmentRepository attachmentRepository;
    private final AttachmentContentRepository contentRepository;


    @Override
    public ApiResult<?> upload(MultipartHttpServletRequest request) throws IOException {
        Iterator<String> fileNames = request.getFileNames();
        MultipartFile file = request.getFile(fileNames.next());
        Attachment attachment = Attachment.builder()
                .name(file.getOriginalFilename())
                .size(file.getSize())
                .contentType(file.getContentType()).build();
        Attachment save = attachmentRepository.save(attachment);

        AttachmentContent content = AttachmentContent.builder()
                .attachment(save)
                .bytes(file.getBytes()).build();
        AttachmentContent savedPhoto = contentRepository.save(content);
        return ApiResult.successResponse(savedPhoto.getId());
    }
}
