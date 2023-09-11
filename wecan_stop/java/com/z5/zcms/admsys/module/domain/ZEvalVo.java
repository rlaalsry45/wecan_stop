package com.z5.zcms.admsys.module.domain;

import com.z5.zcms.admsys.common.domain.CommonVo;

public class ZEvalVo extends CommonVo{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2904533167366016006L;

	private int evalno;
	private String title;
	private String skin;
	private String contstype;
	private String conts;
	private String memo;
	private String datereg;
	private String datemod;
	private String userid;

	public int getEvalno() {
		return evalno;
	}
	public void setEvalno(int evalno) {
		this.evalno = evalno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSkin() {
		return skin;
	}
	public void setSkin(String skin) {
		this.skin = skin;
	}
	public String getContstype() {
		return contstype;
	}
	public void setContstype(String contstype) {
		this.contstype = contstype;
	}
	public String getConts() {
		return conts;
	}
	public void setConts(String conts) {
		this.conts = conts;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
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
