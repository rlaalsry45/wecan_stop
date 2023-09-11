package com.z5.zcms.security.SSO.domain;

import com.z5.zcms.admsys.common.domain.CommonVo;

public class ZSSO extends CommonVo{	

	
	private static final long serialVersionUID = -3250174457708342439L;

	String userid;
	String userpasswd;
	String username;
	String enabled;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpasswd() {
		return userpasswd;
	}
	public void setUserpasswd(String userpasswd) {
		this.userpasswd = userpasswd;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEnabled() {
		return enabled;
	}
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	
	
	
		
}
