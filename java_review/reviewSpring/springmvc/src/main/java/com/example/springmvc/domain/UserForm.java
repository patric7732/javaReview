package com.example.springmvc.domain;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserForm {
    @NotEmpty(message = "username은 공백을 허용하지 않습니다.")
    @Size(min = 4, max = 20, message = "최소 4글자, 최대 20글자 내에 입력해야합니다.")
    private String username;

    @NotEmpty(message = "password는 공백을 허용하지 않습니다.")
    @Size(min = 6, message = "password는 최소 6자 이상 입력해야합니다..")
    private String password;

}
