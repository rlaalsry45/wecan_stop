package com.z5.zcms.admsys.authority.domain;

import java.util.ArrayList;
import java.util.List;

public class ZAuthoritiesVO extends ZAuthorities{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2140308111746730307L;

	private String authno;
	private String[] authnoArray;
	private List<String> userids = new ArrayList<String>();
	
	
	public List<String> getUserids() {
		return userids;
	}
	public void setUserids(List<String> userids) {
		this.userids = userids;
	}
	public String getAuthno() {
		return authno;
	}
	public void setAuthno(String authno) {
		this.authno = authno;
	}
	public String[] getAuthnoArray() {
		return authnoArray;
	}
	public void setAuthnoArray(String[] authnoArray) {
		this.authnoArray = authnoArray;
	}
	
	

	
	
	
}
