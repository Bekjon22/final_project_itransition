package com.itransition.service;


import com.itransition.common.MessageService;
import com.itransition.entity.Item;
import com.itransition.entity.Like;
import com.itransition.entity.User;
import com.itransition.exception.RestException;
import com.itransition.payload.ApiResult;
import com.itransition.payload.req.LikeDto;
import com.itransition.repository.ItemRepository;
import com.itransition.repository.LikeRepository;
import com.itransition.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


/**
 * @author Bekjon Bakhromov
 * @created 23.06.2022-1:08 PM
 */
@Service
@RequiredArgsConstructor
public class LikeServiceImpl implements LikeService {
    private final LikeRepository likeRepository;
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;


    @Override
    public ApiResult<?> add(LikeDto dto) {
        User user = userRepository.findById(dto.getUserId()).orElseThrow(() -> RestException.notFound("USER_NOT_FOUND"));
        Item item = itemRepository.findById(dto.getItemId()).orElseThrow(() -> RestException.notFound("ITEM_NOT_FOUND"));
        Like like = new Like();
        like.setItem(item);
        like.setUser(user);
        likeRepository.save(like);

        return ApiResult.successResponse(MessageService.getMessage("LIKE_SUCCESSFULLY_ADDED"));
    }
}
