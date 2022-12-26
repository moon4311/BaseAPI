package com.jaemoon.base;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.jaemoon.cmm.service.UserService;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class AuthProvider implements AuthenticationProvider {

	@Resource
	UserService userService;

	@Override
	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {

		//1. 사용자 조회
		UserDetails user = userService.loadUserByUsername(authentication.getName());
		
	    //2. 비밀번호 일치 확인
		String password = authentication.getCredentials().toString();
	    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	    String storedPwd = user.getPassword();
	    if(!bCryptPasswordEncoder.matches(password, storedPwd)){
	    	log.info("user loging info fail password : "+ password);
	    	return null;
	    }
	    //3. 권한 추가
	    List<GrantedAuthority> grantedAuthorityList = new ArrayList<GrantedAuthority>();
	    grantedAuthorityList.add(new SimpleGrantedAuthority("admin"));
	    return new UsernamePasswordAuthenticationToken(authentication.getName(), authentication.getCredentials(), grantedAuthorityList );
	}

	@Override
	public boolean supports(Class<?> aClass) {
		return aClass.equals(UsernamePasswordAuthenticationToken.class);

	}
}
