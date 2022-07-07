package com.itransition.payload.req;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * @author Bekjon Bakhromov
 * @since  05.06.2022-1:04 AM
 */
@Getter
@Setter
public class LoginDto {
    @Email(message = "{VALID_EMAIL_REQUIRED}")
    @NotBlank(message = "{EMAIL_REQUIRED}")
    private String email;

    @NotBlank(message = "{PASSWORD_REQUIRED}")
    private String password;


}
