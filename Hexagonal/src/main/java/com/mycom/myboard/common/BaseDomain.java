package com.mycom.myboard.common;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "시스템 공통 도메인")
public class BaseDomain {

    @Schema(description="수정여부", example="Y/N")
    private String uptYsno;

}
