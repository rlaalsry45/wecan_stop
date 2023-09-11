package com.z5.zcms.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class ZNonTargetAuthenticationSuccessHandler extends AbstractAuthenticationTargetUrlRequestHandler implements AuthenticationSuccessHandler{ 

         public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) 

        		 throws IOException, ServletException { 

                // 로그인 완료후 처리할 내용
        	 	System.out.println("AbstractAuthenticationTargetUrlRequestHandler");
        	 	
        	 	System.out.println(("request.getContextPath()"+request.getContextPath()));
        	 	System.out.println(request.toString());

                handle(request, response, authentication); 

        } 

} 
