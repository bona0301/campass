package com.campass.demo.dao;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.campass.demo.entity.Buyer;
@Mapper
public interface BuyerDao {
	public Boolean existsBybId(String username); //존재하는지? // 중복검사
	
	public Boolean existsBybEmail(String bemail);

	public Boolean existsBybNickname(String bnickname);
	
	public Integer save(Buyer buyer);

	public Optional<Buyer> findBybId(String bemail, String bname); //아이디찾기
	
	public Integer update(Buyer buyer);
	
	public Integer deleteById(String username);
	
	public Optional<Buyer> read(String username);
								//입력될값
	//public Optional<Member> findByCheckcode(String checkcode);
	//체크코드 입력하면 member를 가져옴
	
	public List<String> findByCheckcodeIsNotEmpty();
	
	public Integer deleteByUsernames(List<String> usernames);
	
	
	
	
	
}
