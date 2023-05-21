package com.mycom.myboard.adapter.in.controller;

import com.mycom.myboard.biz.port.in.BoardServicePort;
import com.mycom.myboard.common.ResponseMessage;
import com.mycom.myboard.common.annotation.RedisCached;
import com.mycom.myboard.common.annotation.Timer;
import com.mycom.myboard.domain.board.BoardM;
import com.mycom.myboard.domain.board.BoardRslt;
import com.mycom.myboard.domain.board.BoardSrch;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.StopWatch;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@CrossOrigin(
		origins = "http://localhost:5500", // allowCredentials = "true" 일 경우, orogins="*" 는 X
		allowCredentials = "true", 
		allowedHeaders = "*", 
		methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.HEAD,RequestMethod.OPTIONS}
	)
@RequestMapping("/boards")
@Slf4j
@Tag(name = "CRUD 게시판", description = "CRUD 게시판")
public class BoardController {

	private final BoardServicePort boardServicePort;

	public BoardController(BoardServicePort boardServicePort) {
		this.boardServicePort = boardServicePort;
	}

	/**
	 * @description 목록 조회
	 */
	//@Timer
	@Operation(summary = "목록 조회", description = "목록 조회")
	@GetMapping(value="")
	public ResponseEntity<ResponseMessage> boardList(BoardSrch boardSrch) {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		log.debug("BoardController.boardList = {}", boardSrch);

		// DB 접근 부분 -> 병목지점
		List<BoardRslt> list = boardServicePort.selectBoardList(boardSrch);
		System.out.println(list);
		ResponseEntity<ResponseMessage> response = new ResponseEntity<ResponseMessage> (ResponseMessage.builder()
				.data(list)
				.statusCode(HttpStatus.OK.value())
				.build(), HttpStatus.OK);
		stopWatch.stop();
		System.out.println("실행메소드: boardList, 수행시간: "+ stopWatch.getTime()+"ms");
		return response;
	}

	/**
	 * @description 상세
	 */
	@Operation(summary = "상세", description = "상세")
	@GetMapping(value="/{boardId}")
	public ResponseEntity<ResponseMessage> boardDetail(@PathVariable int boardId, HttpSession session){
		log.debug("BoardController.boardDetail = {}", boardId);

		return new ResponseEntity<>(ResponseMessage.builder()
				.data(boardServicePort.selectBoardDetail(BoardSrch.builder().boardId(boardId).build()))
				.statusCode(HttpStatus.OK.value())
				.build(), HttpStatus.OK);
	}

	/**
	 * @description 삭제
	 */
	@Operation(summary = "삭제", description = "삭제")
	@DeleteMapping(value="/{boardId}")
	public ResponseEntity<ResponseMessage> boardDelete(@PathVariable(value="boardId") int boardId){
		log.debug("BoardController.boardDelete = {}", boardId);

		return new ResponseEntity<>(ResponseMessage.builder()
				.data(boardServicePort.deleteBoard(BoardSrch.builder().boardId(boardId).build()))
				.statusCode(HttpStatus.OK.value())
				.build(), HttpStatus.OK);
	}

	/**
	 * @description 등록
	 */
	@Operation(summary = "등록", description = "등록")
	@PostMapping(value="")
	public ResponseEntity<ResponseMessage> boardInsert(@RequestBody BoardM boardM){ //, MultipartHttpServletRequest request) {
		log.debug("BoardController.boardInsert = {}", boardM);

		return new ResponseEntity<>(ResponseMessage.builder()
				.data(boardServicePort.insertBoard(boardM))
				.statusCode(HttpStatus.OK.value())
				.build(), HttpStatus.OK);
	}

	/**
	 * @description 수정
	 */
	@Operation(summary = "수정", description = "수정")
	@PutMapping(value="")
	public ResponseEntity<ResponseMessage> boardUpdate(@RequestBody BoardM boardM){
		log.debug("BoardController.boardUpdate = {}", boardM);

		return new ResponseEntity<>(ResponseMessage.builder()
				.data(boardServicePort.updateBoard(boardM))
				.statusCode(HttpStatus.OK.value())
				.build(), HttpStatus.OK);
	}
}
