package com.mycom.myboard.domain.board;

import com.mycom.myboard.common.BaseDomain;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "게시판 기본 도메인")
public class BoardM extends BaseDomain { //basedomain 명시 - 기본 도메인 명시 효과 + 상속으로 공통 도메인 기능 사용 가능

    @Schema(description = "게시판ID", example="")
    private int boardId;

    @Schema(description = "제목", example="")
    private String title;

    @Schema(description = "내용", example="")
    private String contents;

    @Schema(description = "작성일시", example="")
    private String regDttm;

    @Schema(description = "작성자", example="")
    private String author;
}
