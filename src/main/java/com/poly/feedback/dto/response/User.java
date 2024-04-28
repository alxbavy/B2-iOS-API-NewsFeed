package com.poly.feedback.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private Integer id;

    private String email;

    AppUserRole appUserRole;

}
