package com.z5.zcms.admsys.module.domain;

import com.z5.zcms.admsys.common.domain.CommonVo;

public class ZBannerVo extends CommonVo{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2904533167366016006L;

	private int bannerno;
	private String title;
	private String skin;
	private String linktype;
	private String imgsize;
	private String conts;
	private String memo;
	private String datereg;
	private String datemod;
	private String userid;
	private String rankno;
	private String random;
	
	private String seq;
	private String regdate;
	private String click;
	private String url;
	

	public String getRandom() {
		return random;
	}
	public void setRandom(String random) {
		this.random = random;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getClick() {
		return click;
	}
	public void setClick(String click) {
		this.click = click;
	}
	public int getBannerno() {
		return bannerno;
	}
	public void setBannerno(int bannerno) {
		this.bannerno = bannerno;
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
	public String getLinktype() {
		return linktype;
	}
	public void setLinktype(String linktype) {
		this.linktype = linktype;
	}
	public String getImgsize() {
		return imgsize;
	}
	public void setImgsize(String imgsize) {
		this.imgsize = imgsize;
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
	public String getRankno() {
		return rankno;
	}
	public void setRankno(String rankno) {
		this.rankno = rankno;
	}
}
