package com.z5.zcms.frontsys.archv.domain;

public class ArchvCatgryVO extends ArchvCatgry {

	private static final long serialVersionUID = 580709093675334012L;

	private String level;
	private String name_path;
	private String name_1;
	private String name_cont; //실재 컬럼의 이름을 담는다
	private String lang;
	
	

	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public String getName_cont() {
		return name_cont;
	}
	public void setName_cont(String name_cont) {
		this.name_cont = name_cont;
	}
	public String getName_1() {
		return name_1;
	}
	public void setName_1(String name_1) {
		this.name_1 = name_1;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getName_path() {
		return name_path;
	}
	public void setName_path(String name_path) {
		this.name_path = name_path;
	}

}
