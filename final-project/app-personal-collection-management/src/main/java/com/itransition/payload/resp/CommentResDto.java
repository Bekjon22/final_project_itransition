package com.itransition.payload.resp;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * @author Bekjon Bakhromov
 * @since 28.06.2022
 */
@Getter
@Setter
public class CommentResDto {
    @NotBlank(message = "{COMMENT_TEXT_REQUIRED}")
    private String text;


}
