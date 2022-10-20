package com.campass.demo;

import javax.sql.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.core.annotation.*;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.method.configuration.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.crypto.password.*;

import com.campass.demo.security.*;

@EnableWebSecurity 
public class SecurityConfig {
	// 관리자는 /adim/**으로 접근한다
	@Order(1)
	@Configuration
	public static class AdminSecurityConfing extends WebSecurityConfigurerAdapter {
		@Autowired
		private PasswordEncoder passwordEncoder;
		
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.inMemoryAuthentication().withUser("system").password(passwordEncoder.encode("1234")).roles("ADMIN");
		}	
		
		// 파라미터 http는 스프링 시큐리티를 이용한 접근 통제 정보를 저장할 객체
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			// /admin/** 경로 중 접근 통제를 하지 않는 예외 경로를 먼저 설정
			http.authorizeRequests().antMatchers("/admin/login").permitAll();
			
			// /admin/**로 들어오는 요청에 대해 ADMIN 권한과 폼 로그인 설정
			http.requestMatchers().antMatchers("/admin/**").and().authorizeRequests().anyRequest().hasRole("ADMIN")
				.and().formLogin().loginPage("/admin/login").loginProcessingUrl("/admin/login")
				.and().logout().logoutUrl("/admin/logout").logoutSuccessUrl("/").invalidateHttpSession(true);
		}
	}
	
	// 관리자가 아니면 @PreAuthorize, @Secured 어노테이션 기반으로 접근 통제
	@Order(2)
	@Configuration
	@EnableGlobalMethodSecurity(prePostEnabled=true, securedEnabled=true)
	public static class MemberSecurityConfig extends WebSecurityConfigurerAdapter {
		@Autowired
		private DataSource dataSource;
		// 로그인에 실패했을 때 뒷처리 -> 로그인실패횟수증가, 5회 실패하면 블록
		@Autowired
		private MemberLoginFailureHandler memberLoginFailureHandler;

		// 로그인에 성공했을 때 뒷처리
		// 로그인 실패 횟수 리셋, 임시비밀번호로 로그인하면 비밀번호 변경창으로 이동
		@Autowired
		private MemberLoginSuccessHandler memberLoginSuccessHandler;
		
		// 권한이 없을 때 뒷처리(403)
		// 403은 컨트롤러 어드바이스가 아니라 스프링 시큐리티가 처리
		@Autowired
		private MemberAccessDeniedHandler accessDeniedHandler;
		

		// 아이디, 비밀번호, enabled를 읽어오는 sql
		// 아이디와 권한 읽어오는 sql
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery("select username, password, enabled from base where username=?") //db에서 아이디, 비번 비교
				.authoritiesByUsernameQuery("select username, role from base where username=?");
		}
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable();
			http.exceptionHandling().accessDeniedHandler(accessDeniedHandler)
				.and().formLogin().loginPage("/member/login").loginProcessingUrl("/member/login").defaultSuccessUrl("/member/home").failureUrl("/member/login").successHandler(memberLoginSuccessHandler).failureHandler(memberLoginFailureHandler)
				.and().logout().logoutUrl("/member/logout").logoutSuccessUrl("/member/home").invalidateHttpSession(true);
		
		
		
		
		}
		
		
	
	       
	    } 
		
	}
