package com.campass.demo.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.campass.demo.dao.*;
import com.campass.demo.dto.*;
import com.campass.demo.dto.BuyerDto.Read;
import com.campass.demo.dto.BuyerDto.Update;
import com.campass.demo.entity.*;
import com.campass.demo.exception.*;
import com.campass.demo.service.*;
import lombok.Data;

@Data
@Service
public class BuyerService {
	@Autowired
	private BuyerDao dao;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Value("c:/upload/profile")
	private String profileFolder;
	@Value("http://localhost:8087/profile/")
	private String profilePath;

	// 서블릿의 생명주기 : init() -> service() -> destroy()
	// 스프링의 생명주기 어노테이션 : @PostConstruct, @PreDestory

	// 아이디 사용여부 확인
	/*
	public void idAvailable(String id) {
		if (memberDao.existsById(id))
			throw new JobFailException("사용중인 아이디입니다");
	}
	*/
	public Boolean idAvailable(String username) {
		return (dao.existsBybId(username));
	}
			
	
	// 이메일 사용여부 확인
	public Boolean emailAvailable(String bemail) {
		return (dao.existsBybEmail(bemail));
	}

	// 닉네임 사용여부 확인
	public Boolean nicknameAvailable(String bnickname) {
		return (dao.existsBybNickname(bnickname));
	}


	// 회원 가입
	public void join(BuyerDto.Join dto) {
		if (dao.existsBybId(dto.getUsername()))
			throw new JobFailException("사용중인 아이디입니다");
		if (dao.existsBybEmail(dto.getBemail()))
			throw new JobFailException("사용중인 이메일입니다");
		if (dao.existsBybNickname(dto.getBnickname()))
			throw new JobFailException("사용중인 닉네임입니다");

		Buyer buyer = dto.toEntity();
	//	MultipartFile profile = dto.getProfile();

//		String profileName = "default.jpg";
//		// 프로필 사진이 있으면 저장하고 변경
//		if (profile != null && profile.isEmpty() == false) {
//			// 폴더명, 파일명으로 빈 파일을 생성한다
//			File file = new File(profileFolder, profile.getOriginalFilename());
//			try {
//				profile.transferTo(file); // ?
//				profileName = profile.getOriginalFilename();
//			} catch (IllegalStateException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
	
		// 비밀번호 암호화
		String encodedPassword = passwordEncoder.encode(buyer.getBpassword());
		buyer.addJoinInfo(encodedPassword);
		dao.save(buyer);
	}

	// 아이디 찾기
	public void findbId(BuyerDto.FindbId dto) {
		Buyer buyer = dao.findBybId(dto.getBemail(), dto.getBname()).orElseThrow(() -> new MemberNotFoundException());
		// mailUtil.sendFindIdMail("admin@icia.com", dto.getEmail(), member.getId());

	}
	// -> 아이디찾기 메일로 전송?
	//이메일, 아이디 입력 -> 임시비밀번호 전송
	// 비밀번호 리셋
	// 아이디로 검색 -> 없으면 MemberNotFoundException
	// 이메일을 확인 -> 틀리면 MemberNotFoundException
	// 20글자 임시비밀번호 생성 -> 암호화 -> 비번 변경 -> 메일 발송
/*	public void resetPassword(MemberDto.ResetPassword dto) {
		Member member = memberDao.findById(dto.getEmail(),dto.getName()).orElseThrow(() -> new MemberNotFoundException());
		if (member.getEmail().equals(dto.getEmail()) == false)
			throw new MemberNotFoundException();
		String newPassword = RandomStringUtils.randomAlphanumeric(20); // 랜덤된 임시비밀번호
		memberDao.update(Member.builder().email(dto.getEmail()).name(dto.getName()).password(passwordEncoder.encode(newPassword)).build());
		mailUtil.sendResetPasswordMail("admin@icia.com", dto.getEmail(), newPassword);

	}
	//로그인 상태 -> 비밀번호 변경
	// 비밀번호 변경
	// 아이디로 검색 -> 없으면 MemberNotFoundException
	// 비밀번호를 맞춰본다 -> passwordEncoder.matches() -> 실패하면 예외처리
	// 새비밀번호를 암호화 후 저장
	public void changePassword(MemberDto.ChangePassword dto, String email, String name) {
		Member member = memberDao.findById(email, name).orElseThrow(() -> new MemberNotFoundException());
		String encodedPassword = member.getPassword();
		if (passwordEncoder.matches(dto.getPassword(), encodedPassword) == false)
			throw new JobFailException("비밀번호를 변경하지 못했습니다");
		memberDao.update(Member.builder().email(email).name(name).password(passwordEncoder.encode(dto.getNewPassword())).build());
	}*/
	//정보읽기
	public Read read(String bemail, String bname) {
		// 메소드 참조
		Buyer buyer = dao.findBybId(bemail, bname).get(); // 내정보 찾아봐야되니까 아이디에 맞는 정보 가져옴
				//.orElseThrow(MemberNotFoundException::new);
		BuyerDto.Read dto = buyer.toDto();
		//Long days = ChronoUnit.DAYS.between(dto.getJoinday(), LocalDate.now());// 가입일, 오늘날짜 사이값을 days라고 하고 dto에 극 값을
																				// 집어넣음 (날짜값-날짜값 계산)
		//dto.setDays(days);
		//dto.setProfile(profilePath + dto.getProfile());// 파일+파일이름
		return dto;
	}

	// 정보 변경 - 이메일, 프사 변경
	// 이메일과 프사가 모두 비었으면 작업 중지
	// 프사만 비었으면 이메일만 변경
	// 이메일만 비었으면 프사만 변경
	// 이메일, 프사 모두 들었으면 모두 변경

	// 1. 이메일, 프사 모두 비었으면 작업 중지
	// 2. 아이디로 검색 -> 없으면 MemberNotFoundException
	// 3. String newEmail -> 이메일을 변경하면 저장, 안하면 기존 이메일 저장
	// 4. 프사 삭제 저장 후 저장
	public Integer update(Update dto, String bname, String bemail) {
		String newEmail = dto.getBemail();
		if (newEmail == null)
			throw new JobFailException("변경할 값이 없습니다");
		Buyer buyer= dao.findBybId(bemail, bname).orElseThrow(MemberNotFoundException::new);
		if (newEmail == null)
			newEmail = buyer.getBemail();
		return dao.update(Buyer.builder().bemail(bemail).bname(bname).build());
	}
	// 정보변경 - 비밀번호 변경
	// 정보변경 - 닉네임 변경
//	public void update(MemberDto.update dto, MemberDao dao, String nickname) {
//		String newNickname = dto.getNickname();
//		if(newNickname==null && (dao.existsByNickname(newNickname))==true) {
///			throw new JobFailException("");
//		}
		
//	}
	
	
	
	// 정보변경 - 이메일 변경
	// 정보변경 - 사업자번호 변경
	
	
	
	
	// 회원 탈퇴
	// findById -> 없으면 MemberNotFoundException해도 되는데...
	// existsById -> resultType이 true/false인 예제
	public Integer resign(String username) {
		if (dao.existsBybId(username) == false)
			throw new MemberNotFoundException();
		return dao.deleteById(username);
	}

}
