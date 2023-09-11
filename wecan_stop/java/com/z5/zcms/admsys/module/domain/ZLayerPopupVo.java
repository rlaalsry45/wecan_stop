package com.z5.zcms.admsys.module.domain;

import com.z5.zcms.admsys.common.domain.CommonVo;

public class ZLayerPopupVo extends CommonVo{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2904533167366016006L;

	private int layerpopupno;
	private String title;
	private String skin;
	private String sdate;
	private String edate;
	private String popupsize;
	private String popupposition;
	private String today;
	private String popupimg;
	private String contstype;
	private String conts;
	private String memo;
	private String datereg;
	private String datemod;
	private String userid;
	private String popupstatus;
	
	

	public String getPopupstatus() {
		return popupstatus;
	}
	public void setPopupstatus(String popupstatus) {
		this.popupstatus = popupstatus;
	}
	public int getLayerpopupno() {
		return layerpopupno;
	}
	public void setLayerpopupno(int layerpopupno) {
		this.layerpopupno = layerpopupno;
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
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public String getEdate() {
		return edate;
	}
	public void setEdate(String edate) {
		this.edate = edate;
	}
	public String getPopupsize() {
		return popupsize;
	}
	public void setPopupsize(String popupsize) {
		this.popupsize = popupsize;
	}
	public String getPopupposition() {
		return popupposition;
	}
	public void setPopupposition(String popupposition) {
		this.popupposition = popupposition;
	}
	public String getToday() {
		return today;
	}
	public void setToday(String today) {
		this.today = today;
	}
	public String getPopupimg() {
		return popupimg;
	}
	public void setPopupimg(String popupimg) {
		this.popupimg = popupimg;
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
