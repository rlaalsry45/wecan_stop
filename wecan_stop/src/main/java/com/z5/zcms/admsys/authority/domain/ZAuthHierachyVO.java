package com.z5.zcms.admsys.authority.domain;



public class ZAuthHierachyVO extends ZAuthHierachy {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2401911797622660239L;

	private String isRole;
	private String userid;
	private String cou;
	private String authority;
	private String authcou;

	public String getIsRole() {
		return isRole;
	}

	public void setIsRole(String isRole) {
		this.isRole = isRole;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getCou() {
		return cou;
	}

	public void setCou(String cou) {
		this.cou = cou;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getAuthcou() {
		return authcou;
	}

	public void setAuthcou(String authcou) {
		this.authcou = authcou;
	}
	
	
}

