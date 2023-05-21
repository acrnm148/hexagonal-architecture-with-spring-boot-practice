package com.mycom.myboard.adapter.in.controller;


import com.mycom.myboard.biz.port.in.UserServicePort;
import com.mycom.myboard.common.Constants;
import com.mycom.myboard.common.ResponseMessage;
import com.mycom.myboard.domain.user.UserSrch;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin(
		// localhost:5500 과 127.0.0.1 구분
		origins = "http://localhost:5500", // allowCredentials = "true" 일 경우, orogins="*" 는 X
		allowCredentials = "true", 
		allowedHeaders = "*", 
		methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT,RequestMethod.HEAD,RequestMethod.OPTIONS}
	)
@RequestMapping("/login")
@Slf4j
@Tag(name="login", description = "로그인 컨트롤러")
public class LoginController {

	private final UserServicePort userServicePort;

	public LoginController(UserServicePort userServicePort){
		this.userServicePort = userServicePort;
	}

	@PostMapping(value="")
	public ResponseEntity<ResponseMessage> login(@RequestBody UserSrch userSrch, HttpSession session) {// vue에서 json 이 아닌 방식으로 넘길 경우, @RequestBody 제거
		System.out.println("login 메소드 진입 : " + userSrch);
//		UserDto userDto = service.login(dto);
//		Map<String, String> map = new HashMap<>();
//		System.out.println(userDto);
//		if( userDto != null ) {
//			session.setAttribute("userDto", userDto);
//
//		    map.put("result", "success");
//		    map.put("userName", userDto.getUserName());
//		    map.put("userProfileImageUrl", userDto.getUserProfileImageUrl());
//			return new ResponseEntity<Map<String, String>>(map, HttpStatus.OK);
//		}
//		map.put("result", "fail");
//		return new ResponseEntity<Map<String, String>>(map, HttpStatus.NOT_FOUND);
		return new ResponseEntity<ResponseMessage> (ResponseMessage.builder()
				.data(userServicePort.login(userSrch))
				.statusCode(HttpStatus.OK.value())
				.build(), HttpStatus.OK);
	}
}
