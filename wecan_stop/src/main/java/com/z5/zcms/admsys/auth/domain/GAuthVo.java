package com.z5.zcms.admsys.auth.domain;

import java.util.Date;
import java.util.List;

import com.z5.zcms.admsys.common.domain.CommonVo;

public class GAuthVo extends CommonVo {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private int groupno;
	private String groupnm;
	private List<AuthEmp> authemp;
	private String userid;
	private Date datereg;
	private String popType = "";

	public int getGroupno() {
		return groupno;
	}

	public void setGroupno(int groupno) {
		this.groupno = groupno;
	}

	public String getGroupnm() {
		return groupnm;
	}

	public void setGroupnm(String groupnm) {
		this.groupnm = groupnm;
	}

	public List<AuthEmp> getAuthemp() {
		return authemp;
	}

	public void setAuthemp(List<AuthEmp> authemp) {
		this.authemp = authemp;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Date getDatereg() {
		return datereg;
	}

	public void setDatereg(Date datereg) {
		this.datereg = datereg;
	}

	public String getPopType() {
		return popType;
	}

	public void setPopType(String popType) {
		this.popType = popType;
	}

}
