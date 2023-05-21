package com.mycom.myboard.domain.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "유저 조회 결과 도메인")
public class UserRslt {

    @Schema(description = "유저 고유 ID", example="")
    private int userSeq;

    @Schema(description = "유저 이름", example="")
    private String userName;

    @Schema(description = "유저 이메일", example="")
    private String userEmail;

    @Schema(description = "유저 비밀번호", example="")
    private String userPassword;

    @Schema(description = "결과 여부", example="")
    private int result;
}
