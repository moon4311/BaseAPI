package com.jaemoon.base.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jooq.tools.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class SuccessHandler implements AuthenticationSuccessHandler{

	@Value("${url.allowedOrigins}")
	private String allowedOrigins;

	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse res,
			Authentication authentication) throws IOException, ServletException {
		System.err.println("onAuthenticationSuccess ");
		
		String s = req.getHeader("origin");
    	res.setHeader("Access-Control-Allow-Origin", s);
    	JSONObject json = new JSONObject();
    	json.put("name", authentication.getName());

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
