package com.mycom.myboard.domain.board;

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
@Schema(description = "게시판 검색 결과 도메인")
public class BoardRslt {

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

    @Schema(description = "결과", example="")
    private int result;
}
