package com.z5.zcms.frontsys.archv.domain;

import java.io.Serializable;

public class ArchvCatgry implements Serializable {

	private static final long serialVersionUID = 1L;

	private String catgry_cd;
	private String prnt_catgry_cd;
	private String name;
	private String reg_date;
	private String path;
	private String is_sort = null;

	public String getIs_sort() {
		return is_sort;
	}
	public void setIs_sort(String is_sort) {
		this.is_sort = is_sort;
	}
	public String getCatgry_cd() {
		return catgry_cd;
	}
	public void setCatgry_cd(String catgry_cd) {
		this.catgry_cd = catgry_cd;
	}
	public String getPrnt_catgry_cd() {
		return prnt_catgry_cd;
	}
	public void setPrnt_catgry_cd(String prnt_catgry_cd) {
		this.prnt_catgry_cd = prnt_catgry_cd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}

}
