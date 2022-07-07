package com.itransition.controller;

import com.itransition.entity.User;
import com.itransition.enums.Topic;
import com.itransition.payload.ApiResult;
import com.itransition.payload.req.CollectionDto;
import com.itransition.payload.req.CollectionEditDto;
import com.itransition.payload.resp.CollectionProjection;
import com.itransition.payload.resp.CollectionResDto;
import com.itransition.service.CollectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;


/**
 * @author Bekjon Bakhromov
 * @since  23.06.2022-1:04 PM
 */
@RestController
@RequiredArgsConstructor
public class CollectionControllerImpl implements CollectionController{

    private final CollectionService collectionService;

    @Override
    public ApiResult<?> addCollection(CollectionDto dto,User user)  {
        return collectionService.add(dto,user);
    }

    @Override
    public ApiResult<CollectionResDto> editCollection(Integer id, CollectionEditDto dto) {
        return collectionService.edit(id,dto);
    }

    @Override
    public ApiResult<?> delete(Integer id) {
        return collectionService.delete(id);
    }

    @Override
    public ApiResult<List<CollectionProjection>> getTopCollections() {
        return collectionService.getTop();
    }

    @Override
    public ApiResult<List<CollectionResDto>> getAllByUser(User user) {
        return collectionService.getAllByUser(user);
    }


}
