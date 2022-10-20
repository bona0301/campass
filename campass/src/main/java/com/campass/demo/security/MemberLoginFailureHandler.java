package com.campass.demo.security;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import org.springframework.security.web.*;
import org.springframework.security.web.authentication.*;
import org.springframework.stereotype.*;

import com.campass.demo.dao.BuyerDao;
import com.campass.demo.entity.Buyer;


// 로그인에 성공했다면 SS가 Authentication을 생성...but
// 로그인 실패 처리 - 아이디를 request에서 꺼낸다
// 로그인 실패 횟수 증가
// 5회이상 실패면 계정 블록
// 오류메시지를 세션에 담은 다음 이동
@Component
public class MemberLoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {
	@Autowired
	private BuyerDao dao;
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
		String bemail = request.getParameter("bemail");
		String bname = request.getParameter("bname");
		// member를 읽어오는 이유는 로그인 실패 횟수가 필요해서다
		// ??? 아이디가 틀리면 member가 없잔아?? 그래서 없으면 null로 바꾼다
		Buyer buyer= dao.findBybId(bemail, bname).orElse(null);
		HttpSession session = request.getSession();
		
		// AuthenticationException의 구체적인 이유를 확인
		// BadCredentialsException - 아이디 또는 비밀번호가 틀렸다
		// DisabledException - 계정이 블록되었다
		if(exception instanceof BadCredentialsException) {
			if(buyer!=null) {
				
			}
				// 아이디가 틀렸다면
				else 
				session.setAttribute("msg", "로그인에 실패했습니다");
		} 
		
		new DefaultRedirectStrategy().sendRedirect(request, response, "/member/loginfail");
	}
}






