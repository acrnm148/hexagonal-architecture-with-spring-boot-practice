package com.mycom.myboard.domain.board;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@EqualsAndHashCode(callSuper = false)
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "게시판 검색용 도메인")
public class BoardSrch {

    @Schema(description = "제목", example="")
    private String title;

    @Schema(description = "내용", example="")
    private String contents;

    @Schema(description = "게시판 번호", example="")
    private int boardId;

    @Schema(description = "검색어", example="")
    private String searchWord;

    @Schema(description = "limit", example="")
    private int limit;

    @Schema(description = "offset", example="")
    private int offset;
}
