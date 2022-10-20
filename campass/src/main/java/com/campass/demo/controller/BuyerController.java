package com.campass.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.campass.demo.dto.BuyerDto;
import com.campass.demo.dto.RestResponse;
import com.campass.demo.service.*;

public class BuyerController {

@Autowired	
private BuyerService service;

// job1. 아이디 중복 확인 - 예외상황을 if문 처리
@GetMapping(path="/buyer/check/id", produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<RestResponse> checkId(String userbname) {
	//service.idAvailable(id);
	//return ResponseEntity.ok(new RestResponse("OK", "사용할 수 있는 아이디입니다", null));
	
	if(service.idAvailable(userbname) == true) {
		return ResponseEntity.ok(new RestResponse("FAIL", "사용할 수 없는 아이디입니다", null));
	}
	return ResponseEntity.ok(new RestResponse("OK", "사용할 수 있는 아이디입니다", null));
}

// job2. 이메일 중복 확인
	@GetMapping(path="/buyer/check/bemail", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RestResponse> checkbemail(String bemail) {
		
		if(service.emailAvailable(bemail) == true) {
		return ResponseEntity.ok(new RestResponse("FAIL", "사용할 수 없는 이메일입니다", null));
	}
	return ResponseEntity.ok(new RestResponse("OK", "사용할 수 있는 이메일입니다", null));
}

	// job3. 닉네임 중복 확인
		@GetMapping(path="/buyer/check/nickbname", produces=MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<RestResponse> checkNickname (String bnickname) {
			
			if(service.nicknameAvailable(bnickname) == true) {
			return ResponseEntity.ok(new RestResponse("FAIL", "사용할 수 없는 닉네임입니다", null));
		}
			return ResponseEntity.ok(new RestResponse("OK", "사용할 수 있는 닉네임입니다", null));
		}


	
//회원가입
@PostMapping(value = "/buyer/new", produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<RestResponse> join(BuyerDto.Join dto) {
	service.join(dto);
	return ResponseEntity.ok(new RestResponse("OK", "가입 성공", "/buyer/login"));
}

//로그인
/*
@PostMapping(value = "/buyer/login", produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<RestResponse> login(buyerDto.Join dto) {
	return ResponseEntity.ok(new RestResponse("OK", "로그인 성공", "/home"));
}
*/
//내정보 읽기
@GetMapping(value = "/buyer/read", produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<RestResponse> read(String bemail, String bname) {
	BuyerDto.Read dto = service.read(bemail, bname);
	return ResponseEntity.ok(new RestResponse("OK", dto, "/buyer/read"));
}

}