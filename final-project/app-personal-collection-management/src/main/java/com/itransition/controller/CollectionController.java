package com.itransition.controller;

import com.itransition.annotation.CurrentUser;
import com.itransition.entity.User;
import com.itransition.enums.Topic;
import com.itransition.payload.ApiResult;
import com.itransition.payload.req.CollectionDto;
import com.itransition.payload.req.CollectionEditDto;
import com.itransition.payload.resp.CollectionProjection;
import com.itransition.payload.resp.CollectionResDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

import static com.itransition.utils.AppConstant.BASE_PATH;

/**
 * @author Bekjon Bakhromov
 * @since  23.06.2022-11:03 AM
 */
@RequestMapping(CollectionController.COLLECTION_CONTROLLER)
public interface CollectionController {

    String COLLECTION_CONTROLLER = BASE_PATH + "/collection";

    @PostMapping("/add")
    ApiResult<?> addCollection(@RequestBody CollectionDto dto,@CurrentUser User user);

    @PutMapping("{id}")
    ApiResult<CollectionResDto> editCollection(@PathVariable(name = "id") Integer id, CollectionEditDto dto);

    @DeleteMapping("{id}")
    ApiResult<?> delete(@PathVariable(name = "id") Integer id);

    @GetMapping("/get-top")
    ApiResult<List<CollectionProjection>> getTopCollections();

    @GetMapping("/get-all-by-user")
    ApiResult<List<CollectionResDto>>getAllByUser(@CurrentUser User user);



//    @GetMapping("/get-all")
//    ApiResult<List<CollectionResDto>>getAll()



}
