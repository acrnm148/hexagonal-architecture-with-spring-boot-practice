package com.mycom.myboard.domain.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Schema(description = "유저 로그인 도메인")
public class UserSrch {

    @Schema(description = "유저 이메일")
    private String userEmail;

    @Schema(description = "유저 비밀번호")
    private String userPassword;

}
