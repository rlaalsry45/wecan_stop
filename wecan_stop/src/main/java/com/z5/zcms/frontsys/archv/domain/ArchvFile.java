package com.z5.zcms.frontsys.archv.domain;

import java.io.Serializable;

public class ArchvFile implements Serializable {

	private static final long serialVersionUID = -5449269486169664840L;

	private String archv_no;
	private String name;
	private String filesz;
	private String reg_date;
	private String file_no;
	private String realname;
	private String evnt_no;
	private String userid;
	private String archv_category_type = "";

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getEvnt_no() {
		return evnt_no;
	}

	public void setEvnt_no(String evnt_no) {
		this.evnt_no = evnt_no;
	}

	public String getArchv_no() {
		return archv_no;
	}

	public void setArchv_no(String archv_no) {
		this.archv_no = archv_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFilesz() {
		return filesz;
	}

	public void setFilesz(String filesz) {
		this.filesz = filesz;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	public String getFile_no() {
		return file_no;
	}

	public void setFile_no(String file_no) {
		this.file_no = file_no;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public String getArchv_category_type() {
		return archv_category_type;
	}

	public void setArchv_category_type(String archv_category_type) {
		this.archv_category_type = archv_category_type;
	}

}
