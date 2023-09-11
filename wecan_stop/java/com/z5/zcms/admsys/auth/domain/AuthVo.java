package com.z5.zcms.admsys.auth.domain;

import java.util.List;
import com.z5.zcms.admsys.common.domain.CommonVo;

public class AuthVo extends CommonVo
{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	private int menuno;
	private int menutopno;
	private int menulevel;
	private int menustep;
	private int menuparentno;
	private int siteno;
	private String menutitle;
	private String menutype;
	private String menustatus;
	private List<AuthEmp> authemp;
	
	public int getMenuno() {
		return menuno;
	}
	public void setMenuno(int menuno) {
		this.menuno = menuno;
	}
	public int getMenutopno() {
		return menutopno;
	}
	public void setMenutopno(int menutopno) {
		this.menutopno = menutopno;
	}
	public int getMenulevel() {
		return menulevel;
	}
	public void setMenulevel(int menulevel) {
		this.menulevel = menulevel;
	}
	public int getMenustep() {
		return menustep;
	}
	public void setMenustep(int menustep) {
		this.menustep = menustep;
	}
	public int getMenuparentno() {
		return menuparentno;
	}
	public void setMenuparentno(int menuparentno) {
		this.menuparentno = menuparentno;
	}
	public int getSiteno() {
		return siteno;
	}
	public void setSiteno(int siteno) {
		this.siteno = siteno;
	}
	public String getMenutitle() {
		return menutitle;
	}
	public void setMenutitle(String menutitle) {
		this.menutitle = menutitle;
	}
	public String getMenutype() {
		return menutype;
	}
	public void setMenutype(String menutype) {
		this.menutype = menutype;
	}
	public String getMenustatus() {
		return menustatus;
	}
	public void setMenustatus(String menustatus) {
		this.menustatus = menustatus;
	}
	public List<AuthEmp> getAuthemp() {
		return authemp;
	}
	public void setAuthemp(List<AuthEmp> authemp) {
		this.authemp = authemp;
	}
}
