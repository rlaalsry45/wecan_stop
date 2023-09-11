package com.z5.zcms.admsys.board.domain;

import java.util.List;

import com.z5.zcms.admsys.common.domain.CommonVo;

public class ZCateVo extends CommonVo{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2904533167366016006L;
	
	private int cno;
	private int boardno;
	private String cname;
	private String cstatus;
	private String datereg;
	private String datemod;
	private String userid;
	private int ctopno;
	private int clevel;
	private int cstep;
	private int cparentno;
	private String confirmyn;
	private List<ZCateVo> zCatevoList;
	private List<String> cnos;
	
	private int cnonew      = 0;
	private int cnoorg      = 0;
	private int csteporg    = 0;

	private int cstepmin1   = 0;
	private int cstepmax1   = 0;
	private int cstepmin2   = 0;
	private int cstepmax2   = 0;

	private int step           = 0;
	private int mno            = 0;
	
	private String type;
	private String mark;
	
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public int getCnonew() {
		return cnonew;
	}
	public void setCnonew(int cnonew) {
		this.cnonew = cnonew;
	}
	public int getCnoorg() {
		return cnoorg;
	}
	public void setCnoorg(int cnoorg) {
		this.cnoorg = cnoorg;
	}
	public int getCsteporg() {
		return csteporg;
	}
	public void setCsteporg(int csteporg) {
		this.csteporg = csteporg;
	}
	public int getCstepmin1() {
		return cstepmin1;
	}
	public void setCstepmin1(int cstepmin1) {
		this.cstepmin1 = cstepmin1;
	}
	public int getCstepmax1() {
		return cstepmax1;
	}
	public void setCstepmax1(int cstepmax1) {
		this.cstepmax1 = cstepmax1;
	}
	public int getCstepmin2() {
		return cstepmin2;
	}
	public void setCstepmin2(int cstepmin2) {
		this.cstepmin2 = cstepmin2;
	}
	public int getCstepmax2() {
		return cstepmax2;
	}
	public void setCstepmax2(int cstepmax2) {
		this.cstepmax2 = cstepmax2;
	}
	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public List<String> getCnos() {
		return cnos;
	}
	public void setCnos(List<String> cnos) {
		this.cnos = cnos;
	}
	public List<ZCateVo> getzCatevoList() {
		return zCatevoList;
	}
	public void setzCatevoList(List<ZCateVo> zCatevoList) {
		this.zCatevoList = zCatevoList;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public int getBoardno() {
		return boardno;
	}
	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCstatus() {
		return cstatus;
	}
	public void setCstatus(String cstatus) {
		this.cstatus = cstatus;
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
	public int getCtopno() {
		return ctopno;
	}
	public void setCtopno(int ctopno) {
		this.ctopno = ctopno;
	}
	public int getClevel() {
		return clevel;
	}
	public void setClevel(int clevel) {
		this.clevel = clevel;
	}
	public int getCstep() {
		return cstep;
	}
	public void setCstep(int cstep) {
		this.cstep = cstep;
	}
	public int getCparentno() {
		return cparentno;
	}
	public void setCparentno(int cparentno) {
		this.cparentno = cparentno;
	}
	public String getConfirmyn() {
		return confirmyn;
	}
	public void setConfirmyn(String confirmyn) {
		this.confirmyn = confirmyn;
	}
}
