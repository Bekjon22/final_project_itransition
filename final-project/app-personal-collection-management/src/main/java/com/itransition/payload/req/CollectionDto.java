package com.itransition.payload.req;


import com.itransition.enums.Topic;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Bekjon Bakhromov
 * @since  23.06.2022-12:40 PM
 */

@Getter
@Setter
public class CollectionDto {
    @NotBlank(message = "{CONTROLLER_NAME_REQUIRED}")
    private String name;

    private String description;

    @NotBlank(message = "{TOPIC_REQUIRED}")
    private String topic;

    private Integer photoId;




}
