package com.z5.zcms.security.SSO.domain;

public class GinueSSOVO extends ZSSO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9202840871358609065L;

	private String authority;
	private String usersex;

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getUsersex() {
		return usersex;
	}

	public void setUsersex(String usersex) {
		this.usersex = usersex;
	}
	
	
	
}
