package com.campass.demo.entity;

import java.time.LocalDate;

import com.campass.demo.dto.*;
import com.campass.demo.dto.BuyerDto.Read;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Buyer {
	private String username; // 사용자 입력
	private String bpassword; // 서버에서 암호화해서 추가
	private String bemail;
	private String bnickname;
	private String bname;
	private Integer btel;
	private String badress;
//	private String bprofile;			


	private LocalDate bjoinday;
	private Integer enabled;
	private String role;
	
	public void addJoinInfo( String encodedPassword) {
		this.bpassword = encodedPassword;
	}
	
	public Read toDto() {
		return BuyerDto.Read.builder().username(username).bname(bname).bemail(bemail).bnickname(bnickname).bjoinday(bjoinday).btel(btel)
				.build();
	}
}
