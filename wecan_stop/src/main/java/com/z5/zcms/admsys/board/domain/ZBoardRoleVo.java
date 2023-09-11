package com.z5.zcms.admsys.board.domain;

import com.z5.zcms.admsys.common.domain.CommonVo;

public class ZBoardRoleVo extends CommonVo {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2904533167366016006L;
	
	private int no;
	private String role;
	private String role_nm;
	private String datereg;
	private String datemod;
	private String userid;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getRole_nm() {
		return role_nm;
	}
	public void setRole_nm(String role_nm) {
		this.role_nm = role_nm;
	}
	public String getDatereg() {
		return datereg;
	}
	public void setDatereg(String datereg) {
		this.datereg = datereg;
	}
	public String getDatemod() {
		return datemod;
	}
	public void setDatemod(String datemod) {
		this.datemod = datemod;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
}
