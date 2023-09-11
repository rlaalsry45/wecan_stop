package com.z5.zcms.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class ZUrlLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(javax.servlet.http.HttpServletRequest request,
                                javax.servlet.http.HttpServletResponse response,
                                Authentication authentication)
        throws java.io.IOException, javax.servlet.ServletException {

    	
    	/*//폴더방식에 대한 고려
        HttpSession session = request.getSession();
        String subname = "";
        if(session.getAttribute("subname") != null){
        	subname ="/" + (String) session.getAttribute("subname") +"/";
        }*/
    	request.getSession().invalidate();

        String subname = "";
        if (request.getParameter("subname") != null) {
            subname = (String) request.getParameter("subname");
        }
        
        //SSO를 사용하지 않을 겨우의 로직
        subname = subname.equals("") ? subname : subname + "/";
        String type = request.getParameter("type");
        String to = request.getParameter("to");
        
        if(to != null) subname += to;
        
        if("manage".equals(type)) {
        	response.sendRedirect("/login.html");    //로그인으로 이동
        }else {
        	response.sendRedirect("/" + subname);
        }


        //SSO 를 사용할 경우의 로직. 모든 사이트를 돌면사 사용할 경우
        /*
    	subname = subname+"^";
        String serverName = request.getServerName();
        int counter =  StringUtils.countOccurrencesOf(subname,"^");
        if( counter == 1 || counter == 2 ||counter ==3){
        	if(serverName.equals("www.ginue.ac.kr")){
        		subname= "http://sub.ginue.ac.kr/j_spring_security_logout?subname="+subname;
        	}else if(serverName.equals("sub.ginue.ac.kr")){
        		subname= "http://edu.ginue.ac.kr/j_spring_security_logout?subname="+subname;
        	}else if(serverName.equals("edu.ginue.ac.kr")){
        		subname= "http://www.ginue.ac.kr/j_spring_security_logout?subname="+subname;
        	}

        }else{
        	subname = subname.substring(0,subname.length()-4);
        }


        if(counter ==1 || counter ==2 ||counter ==3){
        	response.sendRedirect(subname);
        }else // 여기까지 SSO 사용하는 경우에 주석을 풀고 사용할것
        	{
        	subname = subname.equals("")?subname:subname+"/";
        	if(admin == null){
	    		response.sendRedirect("/"+subname);
	    	}else if(admin.equals("admin")){
	    		//response.sendRedirect("/login.html");
	    		response.sendRedirect("/"+subname);
	    	}else{
	    		response.sendRedirect("/"+subname);
	    	}
        }
        */

    }
}