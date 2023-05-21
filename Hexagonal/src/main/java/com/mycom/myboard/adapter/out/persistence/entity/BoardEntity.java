package com.mycom.myboard.adapter.out.persistence.entity;

import com.mycom.myboard.common.BaseEntity;
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
public class BoardEntity extends BaseEntity {

    /**
     * 게시판 번호
     */
    private int boardId;

    /**
     * 제목
     */
    private String title;

    /**
     * 내용
     */
    private String contents;

    /**
     * 작성자
     */
    private String author;

    /**
     * 작성일자
     */
    private String regDttm;
}
