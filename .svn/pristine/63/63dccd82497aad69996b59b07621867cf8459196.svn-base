package kr.or.batirplan.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.DispatcherType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	@Bean
	protected SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
		/*
		 * # CSRF 설정
		 * CSRF 공격에 방어하기 위한 방안으로 csrf를 설정하는데, REST에서는 왜 csrf를 disable 할까?
		 * 스프링 시큐리티 document에서는 non-borwser clients만을 위한 서비스라면 csrf disable 해도 좋다고
		 * 설명하고 있습니다. 그렇기 때문에 rest api를 이용한 서버라면, session 기반 인증과는 다르게 stateless하기
		 * 때문에 서서버에 인증 정보를 보관하지 않습니다. rest api에서 clients는 권한이 필요한 요청을 하기 위해서는
		 * 요청에 필요한 인증 벙보(OAuth2.0, JWT토큰 등)을 포함시켜야 합니다.
		 * 따라서 서버에 인증정보를 저장하지 않기 때문에 굳이 불필요한 csrf 코드들을 작성할 필요가 없습니다.
		 */
		http.csrf(csrf -> csrf.disable());	// csrf 비활성화
		
		http.authorizeHttpRequests(
			(authorize) ->
				authorize.dispatcherTypeMatchers(DispatcherType.FORWARD, DispatcherType.ASYNC).permitAll()	// forward는 모두 접근 가능
				// 서버쪽에서 정적 자원을 관리한다면 static 하위 정적 파일들을 permitAll로 풀 이유가 생기지만,
				// Rest로 프론트와 백엔드가 분리되어 있는 상황이라면 아래 내용이 굳이 필요하지는 않습니다.
				// 정적 자원을 front 역역에서 관리하고 있기 때문이죠.
				.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
				// 시큐리티 일반게시판 목록, 공지사항 게시판 목록 모두 접근 가능
				.requestMatchers("/security/board/list","/security/notice/list").permitAll()
				// 시큐리티 일반게시판 등록은 회원과 관리자만 접근 가능
//				.requestMatchers("/security/board/register").hasAnyRole("MEMBER","ADMIN")
				// 시큐리티 공지사항 게시판 등록은 관리자만 접근 가능
//				.requestMatchers("/security/notice/register").hasRole("ADMIN")
				.requestMatchers("/").permitAll()
//				.anyRequest().authenticated()	// 인증된 사용자만 접근
				.anyRequest().permitAll()		// 모든 사용자 접근 허용
		);	
		
		return http.build();
	}
}
