package com.mycom.myboard.biz.port.out;

import com.mycom.myboard.adapter.out.persistence.entity.BoardEntity;
import com.mycom.myboard.adapter.out.persistence.entity.BoardSearchEntity;
import com.mycom.myboard.domain.board.BoardRslt;

import java.util.List;

public interface BoardPersistencePort {

    /**
     * @description 게시판 목록 조회
     */
    List<BoardRslt> selectBoardList(String key, BoardSearchEntity boardSearchEntity);

    /**
     * @description 게시판 총 개수
     */
    int selectBoardCnt();

    /**
     * @description 게시판 상세
     */
    BoardRslt selectBoardDetail(BoardSearchEntity boardSearchEntity);

    /**
     * @description 게시판 삭제
     */
    int deleteBoard(BoardSearchEntity boardSearchEntity);

    /**
     * @description 게시판 등록
     */
    int insertBoard(BoardEntity boardEntity);

    /**
     * @description 게시판 수정
     */
    int updateBoard(BoardEntity boardEntity);
}
