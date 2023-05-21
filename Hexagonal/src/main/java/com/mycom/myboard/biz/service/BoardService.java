package com.mycom.myboard.biz.service;

import com.mycom.myboard.adapter.out.persistence.entity.BoardEntity;
import com.mycom.myboard.adapter.out.persistence.entity.BoardSearchEntity;
import com.mycom.myboard.biz.port.in.BoardServicePort;
import com.mycom.myboard.biz.port.out.BoardPersistencePort;
import com.mycom.myboard.domain.board.BoardM;
import com.mycom.myboard.domain.board.BoardRslt;
import com.mycom.myboard.domain.board.BoardSrch;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService implements BoardServicePort {

    private final BoardPersistencePort boardPersistencePort;

    public BoardService(BoardPersistencePort boardPersistencePort) { //생성자 주입 시 파라미터에 빨간줄 뜨는 이유 : Bean으로 등록되지 않았기 때문.
        this.boardPersistencePort = boardPersistencePort;
    }

    @Override
    public List<BoardRslt> selectBoardList(BoardSrch boardSrch) {
        String key = boardSrch.getSearchWord() + boardSrch.getLimit() + boardSrch.getOffset();
        if (boardSrch.getSearchWord() == null) {
            return boardPersistencePort.selectBoardList(key, BoardSearchEntity.builder()
                        .boardId(boardSrch.getBoardId())
                        .limit(boardSrch.getLimit())
                        .offset(boardSrch.getOffset())
                    .build());
        }
        else {
            return boardPersistencePort.selectBoardList(key, BoardSearchEntity.builder()
                        .searchWord(boardSrch.getSearchWord())
                        .boardId(boardSrch.getBoardId())
                        .limit(boardSrch.getLimit())
                        .offset(boardSrch.getOffset())
                    .build());
        }
    }

    @Override
    public int selectBoardCnt() {
        return boardPersistencePort.selectBoardCnt();
    }

    @Override
    public BoardRslt selectBoardDetail(BoardSrch boardSrch) {
        return boardPersistencePort.selectBoardDetail(BoardSearchEntity.builder()
                        .boardId(boardSrch.getBoardId())
                .build());
    }

    @Override
    public int deleteBoard(BoardSrch boardSrch) {
        return boardPersistencePort.deleteBoard(BoardSearchEntity.builder()
                        .boardId(boardSrch.getBoardId())
                .build());
    }

    @Override
    public int insertBoard(BoardM boardM) {
        return boardPersistencePort.insertBoard(BoardEntity.builder()
                        .boardId(boardM.getBoardId())
                        .title(boardM.getTitle())
                        .contents(boardM.getContents())
                        .author(boardM.getAuthor())
                .build());
    }

    @Override
    public int updateBoard(BoardM boardM) {
        return boardPersistencePort.updateBoard(BoardEntity.builder()
                .boardId(boardM.getBoardId())
                .title(boardM.getTitle())
                .contents(boardM.getContents())
                .author(boardM.getAuthor())
                .build());
    }
}
