package com.z5.zcms.admsys.js.domain;

import java.io.Serializable;

public class ZjsUseVo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6889630380213697076L;
	private int no;
	private String sitetitle;
	private int siteno;
	private int jsno;
	private String userid;
	private int menuno;
	
	
	public int getMenuno() {
		return menuno;
	}
	public void setMenuno(int menuno) {
		this.menuno = menuno;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getSitetitle() {
		return sitetitle;
	}
	public void setSitetitle(String sitetitle) {
		this.sitetitle = sitetitle;
	}
	public int getSiteno() {
		return siteno;
	}
	public void setSiteno(int siteno) {
		this.siteno = siteno;
	}
	
	public int getJsno() {
		return jsno;
	}
	public void setJsno(int jsno) {
		this.jsno = jsno;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
}
