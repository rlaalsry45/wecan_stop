package com.z5.zcms.frontsys.archv.domain;

import com.z5.zcms.admsys.common.domain.CommonVo;

public class ArchvLang extends CommonVo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1416463278097482542L;

	private String no; 
	private String catgry_cd; 
	private String lang;
	private String name;
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getCatgry_cd() {
		return catgry_cd;
	}
	public void setCatgry_cd(String catgry_cd) {
		this.catgry_cd = catgry_cd;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	} 

	
}
