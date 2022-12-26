package com.jaemoon.base.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jooq.tools.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import lombok.SneakyThrows;

@Component
public class SuccessHandler implements AuthenticationSuccessHandler{

	@Value("${url.allowedOrigins}")
	private String allowedOrigins;

	@SneakyThrows
	@Override
	public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse res,
			Authentication authentication) throws IOException, ServletException {
		System.err.println("onAuthenticationSuccess ");
		
    	String role = authentication.getAuthorities().iterator().next().toString();
    	JSONObject json = new JSONObject();
    	json.put("name", authentication.getName());
    	json.put("role", role);
    	
    	HttpSession session = req.getSession();
    	session.setAttribute("role", role);
    	String s = req.getHeader("origin");
    	res.setHeader("Access-Control-Allow-Origin", s);
    	if(!allowedOrigins.contains(s)) {
    		res.setStatus(HttpStatus.FORBIDDEN.value());
    		String msg = s + " is not allowedOrigins. \nplease check api server \n[application.yml ->  add url.allowedOrigins.]";
    		json.put("msg", msg);
    	}else {
    		res.setStatus(HttpStatus.OK.value());
    	}
		res.getOutputStream().println(json.toString());
		return;
	}
	
}
