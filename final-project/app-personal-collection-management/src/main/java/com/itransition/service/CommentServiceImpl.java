package com.itransition.service;

import com.itransition.common.MessageService;
import com.itransition.entity.Comment;
import com.itransition.entity.Item;
import com.itransition.exception.RestException;
import com.itransition.payload.ApiResult;
import com.itransition.payload.req.CommentDto;
import com.itransition.repository.CommentRepository;
import com.itransition.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Bekjon Bakhromov
 * @since 28.06.2022
 */
@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService{

    private final CommentRepository commentRepository;
    private final ItemRepository itemRepository;

    @Override
    public ApiResult<?> add(CommentDto dto) {
        Item item = itemRepository.findById(dto.getItemId()).orElseThrow(() -> RestException.notFound("ITEM_NOT_FOUND"));
        Comment comment = new Comment();
        comment.setText(dto.getText());
        comment.setItem(item);
        commentRepository.save(comment);
        return ApiResult.successResponse(MessageService.getMessage("COMMENT_SUCCESSFULLY_ADDED"));
    }
}
