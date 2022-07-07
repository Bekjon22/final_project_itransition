package com.itransition.service;

import com.itransition.common.MessageService;
import com.itransition.config.AuditorAwareImpl;
import com.itransition.entity.*;
import com.itransition.enums.Topic;
import com.itransition.exception.RestException;
import com.itransition.mapper.CollectionMapper;
import com.itransition.payload.ApiResult;
import com.itransition.payload.req.CollectionDto;
import com.itransition.payload.req.CollectionEditDto;
import com.itransition.payload.resp.CollectionProjection;
import com.itransition.payload.resp.CollectionResDto;
import com.itransition.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * @author Bekjon Bakhromov
 * @since  23.06.2022-1:08 PM
 */
@Service
@RequiredArgsConstructor
public class CollectionServiceImpl implements CollectionService {

    private final CollectionRepository collectionRepository;
    private final UserRepository userRepository;
    private final CollectionMapper collectionMapper;
    private final AttachmentRepository attachmentRepository;
    private final AttachmentContentRepository contentRepository;


    @Override
    public ApiResult<?> add(CollectionDto dto,User user)  {
        User foundUser = userRepository.findById(user.getId()).orElseThrow(() -> RestException.notFound(MessageService.getMessage("USER_NOT_FOUND")));
        Collection collection = collectionMapper.toCollectionAdd(dto);
        collection.setUser(foundUser);
        Attachment photo = attachmentRepository.findById(dto.getPhotoId()).orElseThrow(() -> RestException.notFound(MessageService.getMessage("PHOTO_NOT_FOUND")));
        collection.setImage(photo);

        collectionRepository.save(collection);
        return ApiResult.successResponse(MessageService.getMessage("COLLECTION_SUCCESSFULLY_ADDED"));
    }

    @Override
    public ApiResult<CollectionResDto> edit(Integer id, CollectionEditDto dto) {
        Collection collection = collectionRepository.findById(id).orElseThrow(() ->
                RestException.notFound(MessageService.getMessage("COLLECTION_NOT_FOUND")));
        Collection saved = collectionRepository.save(collectionMapper.toCollection(collection, dto));
        return ApiResult.successResponse(collectionMapper.toCollectionRespDto(saved));
    }

    @Override
    public ApiResult<?> delete(Integer id) {
        Collection collection = collectionRepository.findById(id).orElseThrow(() ->
                RestException.notFound(MessageService.getMessage("COLLECTION_NOT_FOUND")));

        collectionRepository.delete(collection);
        return ApiResult.successResponse(MessageService.getMessage("COLLECTION_DELETED"));
    }

    @Override
    public ApiResult<List<CollectionProjection>> getTop() {
        List<CollectionProjection> largestCollections = collectionRepository.getLargestCollections();
        return ApiResult.successResponse(largestCollections);
    }

    @Override
    public ApiResult<List<CollectionResDto>> getAllByUser(User user) {

        User one = userRepository.getOne(user.getId());

        List<Collection> allByUser = collectionRepository.findAllByUser(one);

//        List<CollectionResDto> collectionResDtos = collectionMapper.toCollectionRespDtoList(allByUser);

        List<CollectionResDto>collectionResDtos =new ArrayList<>();
        for (Collection collection : allByUser) {
            CollectionResDto collectionResDto = new CollectionResDto();
            collectionResDto.setName(collection.getName());
               collectionResDto.setDescription(collection.getDescription());
                  collectionResDto.setTopic(collection.getTopic().name());
                 collectionResDto.setId( collection.getId());
            collectionResDtos.add(collectionResDto);
        }

        return ApiResult.successResponse(collectionResDtos);
    }




}
