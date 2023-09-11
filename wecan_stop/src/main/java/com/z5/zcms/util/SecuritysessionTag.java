package com.z5.zcms.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class SecuritysessionTag extends TagSupport {

	private static final long serialVersionUID = 1L;

	private String auth;
	
	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}


	@Override
	public int doStartTag() throws JspException {

		if(isSecuritySession(this.auth)){
			return Tag.EVAL_BODY_INCLUDE;
		}else{
			return Tag.SKIP_BODY;
		}
	}

	public boolean isSecuritySession(String auth) {
		
		
			ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		    HttpServletRequest request = sra.getRequest();
			auth = auth.trim();
		    
		    if(auth == null || "".equals(auth) || "null".equals(auth)){
		        return false;
		    }
		    
		    String[] auth_arr = auth.split(","); 
		    
		    List<String> auths = SecuritySessionUtil.getAuths(request);
		    
		    for(String getAuth:auths){
		    	for(int i=0;auth_arr.length > i;i++){
			    	if(auth_arr[i].equals(getAuth)){
			    		return true;
			    	}
		    	}
		    }
		    
		    return false;
	    
	}
}