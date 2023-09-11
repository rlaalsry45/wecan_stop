package com.z5.zcms.admsys.authority.domain;

import com.z5.zcms.admsys.common.domain.CommonVo;

public class ZAuthorities extends CommonVo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2696026584256961237L;

	private String id; 
	private String userid; 
	private String authority;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	
}
