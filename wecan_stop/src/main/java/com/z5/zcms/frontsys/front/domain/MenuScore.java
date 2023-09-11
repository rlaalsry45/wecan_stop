package com.z5.zcms.frontsys.front.domain;

import java.io.Serializable;

import com.z5.zcms.admsys.common.domain.CommonVo;

public class MenuScore extends CommonVo implements Serializable
{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8955565923076197031L;
	
	private String no;
	private int menuno;
	private int siteno;
	private String regdate;
	private String userip;
	private int score;
	private int total;
	private double avg;
	
	public double getScore() {
		return score;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(int avg) {
		this.avg = avg;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	
	public int getMenuno() {
		return menuno;
	}
	public void setMenuno(int menuno) {
		this.menuno = menuno;
	}
	public int getSiteno() {
		return siteno;
	}
	public void setSiteno(int siteno) {
		this.siteno = siteno;
	}
	
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getUserip() {
		return userip;
	}
	public void setUserip(String userip) {
		this.userip = userip;
	}
	
}
