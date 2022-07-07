package com.itransition.service;

import com.itransition.payload.*;
import com.itransition.payload.req.ItemDto;
import com.itransition.payload.req.TextSearchDto;
import com.itransition.payload.resp.ItemRespDto;
import com.itransition.payload.resp.LastItemProjection;
import com.itransition.payload.resp.SearchItemProjection;

import java.util.List;

/**
 * @author Bekjon Bakhromov
 * @created 23.06.2022-1:06 PM
 */
public interface ItemService {

    ApiResult<?> addItem(ItemDto dto);

    ApiResult<List<LastItemProjection>> lastItems();

    ApiResult<List<ItemRespDto>> textSearch(TextSearchDto textSearchDto);

    ApiResult<List<ItemRespDto>> getAll();

    ApiResult<List<SearchItemProjection>> fullTextSearch(String searchText);

    ApiResult<ItemRespDto> getOne(Integer id);
}
