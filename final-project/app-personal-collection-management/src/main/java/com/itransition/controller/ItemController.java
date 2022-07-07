package com.itransition.controller;

import com.itransition.payload.*;
import com.itransition.payload.req.ItemDto;
import com.itransition.payload.req.TextSearchDto;
import com.itransition.payload.resp.ItemRespDto;
import com.itransition.payload.resp.LastItemProjection;
import com.itransition.payload.resp.SearchItemProjection;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static com.itransition.utils.AppConstant.BASE_PATH;

/**
 * @author Bekjon Bakhromov
 * @created 23.06.2022-11:03 AM
 */
@RequestMapping(ItemController.ITEM_CONTROLLER)
public interface ItemController {
    String ITEM_CONTROLLER = BASE_PATH + "/item";

    @PostMapping("/add")
    ApiResult<?> addItem(@RequestBody @Valid ItemDto dto);

    @GetMapping("/last-items")
    ApiResult<List<LastItemProjection>> lastItems();

    @GetMapping("/text-search-teo")
    ApiResult<List<ItemRespDto>> textSearch(@RequestBody @Valid TextSearchDto textSearchDto);

     @GetMapping("/get-all")
    ApiResult<List<ItemRespDto>> getAll();

     @GetMapping("/text-search")
    ApiResult<List<SearchItemProjection>> fullTextSearch(@RequestParam(name = "text") String searchText);

     @GetMapping("/get-one/{id}")
    ApiResult<ItemRespDto> getOne(@PathVariable(name = "id") Integer id);
}
