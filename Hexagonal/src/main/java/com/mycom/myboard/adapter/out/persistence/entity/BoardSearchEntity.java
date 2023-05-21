package com.mycom.myboard.adapter.out.persistence.entity;

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
public class BoardSearchEntity {

    /**
     * 게시판 번호
     */
    private int boardId;

    /**
     * 검색어
     */
    private String searchWord;

    /**
     * 페이지 당 row 수
     */
    private int limit;

    /**
     * 페이지 당 시작 번호
     */
    private int offset;
}
