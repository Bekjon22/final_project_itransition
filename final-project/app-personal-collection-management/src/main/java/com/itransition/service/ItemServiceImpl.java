package com.itransition.service;

import com.itransition.common.MessageService;
import com.itransition.entity.*;
import com.itransition.enums.FieldType;
import com.itransition.exception.RestException;
import com.itransition.payload.*;
import com.itransition.payload.req.*;
import com.itransition.payload.resp.CommentResDto;
import com.itransition.payload.resp.ItemRespDto;
import com.itransition.payload.resp.LastItemProjection;
import com.itransition.payload.resp.SearchItemProjection;
import com.itransition.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Bekjon Bakhromov
 * @since  23.06.2022-1:08 PM
 */
@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final CollectionRepository collectionRepository;
    private final ItemRepository itemRepository;
    private final CustomFieldValueRepository customFieldValueRepository;
    private final CustomFieldRepository customFieldRepository;
    private final CommentRepository commentRepository;
    private final TagRepository tagRepository;


    @Override
    public ApiResult<?> addItem(ItemDto dto) {
        Collection collection = collectionRepository.findById(dto.getCollectionId()).orElseThrow(() ->
                RestException.notFound(MessageService.getMessage("COLLECTION_NOT_FOUND")));

        Item item = new Item();
        item.setName(dto.getName());
        item.setCollection(collection);

        Set<Tag> tagSet = new HashSet<>();

        for (TagDto tagDto : dto.getTagDtoSet()) {
            Tag tag = new Tag();
            tag.setValue(tagDto.getValue());
            tag.setItem(item);

            tagSet.add(tag);
        }
        item.setTags(tagSet);
        itemRepository.save(item);


        String s = "";

        for (CustomFieldDto customFieldDto : dto.getCustomFieldDtoSet()) {
            s = customFieldDto.getCustomFieldName();
        }


        if (!s.trim().isEmpty()) {

            for (CustomFieldDto customFieldDto : dto.getCustomFieldDtoSet()) {
                CustomFieldValue customFieldValue = new CustomFieldValue();
                CustomField customField = new CustomField();
                customField.setName(customFieldDto.getCustomFieldName());
                customField.setFieldType(FieldType.valueOf(customFieldDto.getFieldType()));
                CustomField savedCustomField = customFieldRepository.save(customField);

                customFieldValue.setValue(customFieldDto.getValue());

                customFieldValue.setCustomField(savedCustomField);
                customFieldValue.setItem(item);
                customFieldValueRepository.save(customFieldValue);
            }

        }

        return ApiResult.successResponse(MessageService.getMessage("ITEM_SUCCESSFULLY_ADDED"));
    }

    @Override
    public ApiResult<List<LastItemProjection>> lastItems() {
        List<LastItemProjection> lastItems = itemRepository.getLastItems();
        return ApiResult.successResponse(lastItems);
    }

    @Override
    public ApiResult<List<ItemRespDto>> textSearch(TextSearchDto textSearchDto) {

        List<ItemRespDto> itemSearchDtoList = new ArrayList<>();
//        List<Integer> itemIds = itemRepository.getItemIds("%".concat(textSearchDto.getSearchText()).concat("%"));
//
//        if (!itemIds.isEmpty()) {
//            List<Item> itemList = itemRepository.findAllById(itemIds);
//
//            for (Item item : itemList) {
//                ItemRespDto itemSearchDto = new ItemRespDto();
////                itemSearchDto.setName(item.getName());
//
//                List<Comment> commentList = commentRepository.getAllByItem(item);
//                if (!commentList.isEmpty()) {
//                    List<CommentResDto> commentResDto = new ArrayList<>();
//                    for (Comment comment : commentList) {
//                        CommentResDto commentResDto1 = new CommentResDto();
//                        commentResDto1.setText(comment.getText());
//                        commentResDto.add(commentResDto1);
//                    }
//                    itemSearchDto.setCommentResDtoList(commentResDto);
//                }
//
//                Set<CustomFieldDto> customFieldDtoSet = new HashSet<>();
//
//                List<CustomFieldProjection> allCustomFields = customFieldValueRepository.getAllCustomFields(item.getId());
//                if (!allCustomFields.isEmpty()){
//                    for (CustomFieldProjection allCustomField : allCustomFields) {
//                        CustomFieldDto customFieldDto = new CustomFieldDto();
//                        customFieldDto.setCustomFieldName(allCustomField.getName());
//                        customFieldDto.setValue(allCustomField.getValue());
//                        customFieldDto.setFieldType(allCustomField.getFieldType());
//                        customFieldDtoSet.add(customFieldDto);
//                    }
//
//                    itemSearchDto.setCustomFieldDtoSet(customFieldDtoSet);
//                }
//
//
//                Set<TagDto> tagDtoSet = new HashSet<>();
//
//                List<Tag> tagList = tagRepository.findAllByItem(item);
//                for (Tag tag : tagList) {
//                    TagDto tagDto = new TagDto();
//                    tagDto.setValue(tag.getValue());
//                    tagDtoSet.add(tagDto);
//                }
//
//                itemSearchDto.setTagDtoSet(tagDtoSet);
//
//                itemSearchDtoList.add(itemSearchDto);
//
//            }
//        }


        return ApiResult.successResponse(itemSearchDtoList);
    }

    @Override
    public ApiResult<List<ItemRespDto>> getAll() {
        return null;
    }

    @Override
    public ApiResult<List<SearchItemProjection>> fullTextSearch(String searchText) {
        List<SearchItemProjection> searchItemProjections = new ArrayList<>();
        if (searchText.trim().isEmpty()) {
            return ApiResult.successResponse(searchItemProjections);
        }

        List<SearchItemProjection> searchItems = itemRepository.getSearchItems("%".concat(searchText).concat("%"));
        return ApiResult.successResponse(searchItems);

    }

    @Override
    public ApiResult<ItemRespDto> getOne(Integer id) {

        ItemRespDto itemRespDto = new ItemRespDto();
        Item item = itemRepository.findById(id).orElseThrow(() -> RestException.notFound(MessageService.getMessage("ITEM_NOT_FOUND")));
        itemRespDto.setName(item.getName());

        List<Comment> commentList = commentRepository.getAllByItem(item);
        if (!commentList.isEmpty()) {
            List<CommentResDto> commentResDto = new ArrayList<>();
            for (Comment comment : commentList) {
                CommentResDto commentResDto1 = new CommentResDto();
                commentResDto1.setText(comment.getText());
                commentResDto.add(commentResDto1);
            }
            itemRespDto.setCommentResDtoList(commentResDto);
        }
        Set<CustomFieldDto> customFieldDtoSet = new HashSet<>();

        List<CustomFieldProjection> allCustomFields = customFieldValueRepository.getAllCustomFields(item.getId());
        if (!allCustomFields.isEmpty()) {
            for (CustomFieldProjection allCustomField : allCustomFields) {
                CustomFieldDto customFieldDto = new CustomFieldDto();
                customFieldDto.setCustomFieldName(allCustomField.getName());
                customFieldDto.setValue(allCustomField.getValue());
                customFieldDto.setFieldType(allCustomField.getFieldType());
                customFieldDtoSet.add(customFieldDto);
            }

            itemRespDto.setCustomFieldDtoSet(customFieldDtoSet);
        }

        Set<TagDto> tagDtoSet = new HashSet<>();

        List<Tag> tagList = tagRepository.findAllByItem(item);
        for (Tag tag : tagList) {
            TagDto tagDto = new TagDto();
            tagDto.setValue(tag.getValue());
            tagDtoSet.add(tagDto);
        }

        itemRespDto.setTagDtoSet(tagDtoSet);

        return ApiResult.successResponse(itemRespDto);
    }


}
