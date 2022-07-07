package com.itransition.payload.resp;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

/**
 * @author Bekjon Bakhromov
 * @since 05.07.2022
 */
@Getter
@Setter
public class UserRespDto {

    private String firstName;

    private String email;

    private Timestamp registerAt;

    private String roleName;

}
