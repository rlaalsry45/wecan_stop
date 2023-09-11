package com.z5.zcms.admsys.common.domain;

import java.io.Serializable;
import java.util.List;

public class CommonUseVo implements Serializable{


	private static final long serialVersionUID = -4910334249967087494L;

	private int no;
	private String sitetitle;
	private int siteno;
	private int tablenameno;
	private String userid;
	private int menuno;
	private String table;		//table name
	private String cond1;		//조건절1
	private String cond2;		//조건절2
	private String cond3;		//조건절3
	private List<String> tblnames;
	private String keyname;
	
	public int getMenuno() {
		return menuno;
	}
	public void setMenuno(int menuno) {
		this.menuno = menuno;
	}
	public String getTable() {
		return table;
	}
	public void setTable(String table) {
		this.table = table;
	}
	public String getCond1() {
		return cond1;
	}
	public void setCond1(String cond1) {
		this.cond1 = cond1;
	}
	public String getCond2() {
		return cond2;
	}
	public void setCond2(String cond2) {
		this.cond2 = cond2;
	}
	public String getCond3() {
		return cond3;
	}
	public void setCond3(String cond3) {
		this.cond3 = cond3;
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
	
	public int getTablenameno() {
		return tablenameno;
	}
	public void setTablenameno(int tablenameno) {
		this.tablenameno = tablenameno;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public List<String> getTblnames() {
		return tblnames;
	}
	public void setTblnames(List<String> tblnames) {
		this.tblnames = tblnames;
	}
	public String getKeyname() {
		return keyname;
	}
	public void setKeyname(String keyname) {
		this.keyname = keyname;
	}
}
