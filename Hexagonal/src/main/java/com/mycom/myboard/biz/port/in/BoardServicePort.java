package com.mycom.myboard.biz.port.in;

import com.mycom.myboard.adapter.out.persistence.entity.BoardEntity;
import com.mycom.myboard.adapter.out.persistence.entity.BoardSearchEntity;
import com.mycom.myboard.domain.board.BoardM;
import com.mycom.myboard.domain.board.BoardRslt;
import com.mycom.myboard.domain.board.BoardSrch;

import java.util.List;

public interface BoardServicePort {

    /**
     * @description 목록 조회
     */
    List<BoardRslt> selectBoardList(BoardSrch boardSrch);

    /**
     * @description 게시글 총 개수
     */
    int selectBoardCnt();

    /**
     * @description 상세
     */
    BoardRslt selectBoardDetail(BoardSrch boardSrch);

    /**
     * @description 삭제
     */
    int deleteBoard(BoardSrch boardSrch);

    /**
     * @description 등록
     */
    int insertBoard(BoardM boardM);

    /**
     * @description 수정
     */
    int updateBoard(BoardM boardM);
}
