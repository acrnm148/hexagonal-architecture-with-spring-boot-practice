package com.mycom.myboard.adapter.out.persistence;

import com.mycom.myboard.adapter.out.persistence.entity.BoardEntity;
import com.mycom.myboard.adapter.out.persistence.entity.BoardSearchEntity;
import com.mycom.myboard.biz.port.out.BoardPersistencePort;
import com.mycom.myboard.common.annotation.RedisCached;
import com.mycom.myboard.common.annotation.RedisCachedKeyParam;
import com.mycom.myboard.domain.board.BoardRslt;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@MapperScan(value="com.mycom.myboard.adapter.out.persistence")
public class BoardAdapter implements BoardPersistencePort {

    private final BoardMapper boardMapper;

    public BoardAdapter(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }

    @RedisCached(key = "list", expire = 36000)
    @Override
    public List<BoardRslt> selectBoardList(@RedisCachedKeyParam(key = "key") String key, BoardSearchEntity boardSearchEntity) { //@RedisCachedKeyParam(key = "searchWord") String searchWord,

        System.out.println("key: "+key);
        List<BoardRslt> list = new ArrayList<>();
        boardMapper.selectBoardList(boardSearchEntity).stream().forEach(
                  entity -> {
                      list.add(BoardRslt.builder()
                              .boardId(entity.getBoardId())
                              .title(entity.getTitle())
                              .contents(entity.getContents())
                              .regDttm(entity.getRegDttm())
                              .author(entity.getAuthor())
                      .build());
                  });
        return list;
    }

    @Override
    public int selectBoardCnt() {
        return boardMapper.selectBoardCnt();
    }

    @Override
    public BoardRslt selectBoardDetail(BoardSearchEntity boardSearchEntity) {
        BoardEntity entity = boardMapper.selectBoardDetail(boardSearchEntity);
        return BoardRslt.builder()
                    .boardId(entity.getBoardId())
                    .title(entity.getTitle())
                    .contents(entity.getContents())
                    .regDttm(entity.getRegDttm())
                    .author(entity.getAuthor())
                .build();
    }

    @Override
    public int deleteBoard(BoardSearchEntity boardSearchEntity) {
        return boardMapper.deleteBoard(boardSearchEntity);
    }

    @Override
    public int insertBoard(BoardEntity boardEntity) {
        return boardMapper.insertBoard(boardEntity);
    }

    @Override
    public int updateBoard(BoardEntity boardEntity) {
        return boardMapper.updateBoard(boardEntity);
    }
}
