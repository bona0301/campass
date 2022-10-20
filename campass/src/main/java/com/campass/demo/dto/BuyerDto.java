package com.campass.demo.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.web.multipart.MultipartFile;

import com.campass.demo.dto.BuyerDto;
import com.campass.demo.entity.Buyer;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BuyerDto {
	@Data
	public static class IdCheck {
		@Pattern(regexp="^[A-Z0-9]{8,10}$", message = "아이디는 대문자와 숫자 8~10자입니다")
		@NotEmpty(message="아이디는 필수입력입니다")
		private String username;
	}
	
	@Data
	public static class EmailCheck {
		@Email
		@NotEmpty(message="이메일은 필수입력입니다")
		private String bemail;
	}
	
	@Data
	@Builder
	public static class Join {
//		@Pattern(regexp="^[A-Z0-9]{8,10}$", message = "아이디는 대문자와 숫자 8~10자입니다")
		@NotEmpty(message="아이디는 필수입력입니다")
		private String username;
		
		@NotEmpty(message="이름은 필수입력입니다")
		private String bname;
		
		@NotEmpty(message="비밀번호는 필수입력입니다")
		private String bpassword;
		
		@Email
		@NotEmpty(message="이메일은 필수입력입니다")
		private String bemail;
		
		
		private MultipartFile bprofile;
		
		private String bnickname;
		private Integer btel;
		private String badress;

		private Integer enabled;
		private String role;
		
		
		public Buyer toEntity() {
			return Buyer.builder().username(username).bpassword(bpassword).bname(bname)
					.bemail(bemail).build();
		}
	}
	
	@Data
	public static class FindbId {
		@NotEmpty(message="이메일는 필수입력입니다")
		@Email(message="잘못된 이메일 형식입니다")
		private String bemail;
		private String bname;
	}
	
	@Data
	public static class ResetPassword {
		//@Pattern(regexp="^[A-Z0-9]{8,10}$", message = "아이디는 대문자와 숫자 8~10자입니다")
		@NotEmpty(message="아이디는 필수입력입니다")
		private String username;
		
		@Email
		@NotEmpty(message="이메일은 필수입력입니다")
		private String bemail;
	}

	@Data
	public static class ChangePassword {	
		@NotEmpty(message="비밀번호는 필수입력입니다")
		private String bpassword;
		
		@NotEmpty(message="새 비밀번호는 필수입력입니다")
		private String newPassword;
	}

	@Data
	@Builder
	public static class Read {
		private String username;
		private String bname;
		private String bemail;
		private String bnickname;
		private Integer btel;
		private LocalDate bjoinday;
		private Long bdays;
		
		private String bprofile;
	}

	@Data
	public static class Update {
		private String bemail;
		private MultipartFile bprofile;
	}
}
