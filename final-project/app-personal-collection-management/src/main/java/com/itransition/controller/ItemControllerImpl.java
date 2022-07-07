package com.itransition.controller;

import com.itransition.payload.*;
import com.itransition.payload.req.ItemDto;
import com.itransition.payload.req.TextSearchDto;
import com.itransition.payload.resp.ItemRespDto;
import com.itransition.payload.resp.LastItemProjection;
import com.itransition.payload.resp.SearchItemProjection;
import com.itransition.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Bekjon Bakhromov
 * @since  23.06.2022-1:04 PM
 */
@RestController
@RequiredArgsConstructor
public class ItemControllerImpl implements ItemController{

    private final ItemService itemService;

    @Override
    public ApiResult<?> addItem(ItemDto dto) {
        return itemService.addItem(dto);
    }

    @Override
    public ApiResult<List<LastItemProjection>> lastItems() {
        return itemService.lastItems();
    }

    @Override
    public ApiResult<List<ItemRespDto>> textSearch(TextSearchDto textSearchDto) {
        return itemService.textSearch(textSearchDto);
    }

    @Override
    public ApiResult<List<ItemRespDto>> getAll() {
        return itemService.getAll();
    }

    @Override
    public ApiResult<List<SearchItemProjection>> fullTextSearch(String searchText) {
        return itemService.fullTextSearch(searchText);
    }

    @Override
    public ApiResult<ItemRespDto> getOne(Integer id) {
        return itemService.getOne(id);
    }
}
