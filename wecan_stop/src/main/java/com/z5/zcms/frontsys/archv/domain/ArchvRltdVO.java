package com.z5.zcms.frontsys.archv.domain;

import java.util.ArrayList;
import java.util.List;

public class ArchvRltdVO extends ArchvRltd { 

	private static final long serialVersionUID = -2833131597758555048L;

	private int opt_no;
	private int catgry_cd;
	private String catgry_name_list;
	private String title;
	private List<String> insert_archv_no;
	
	
	public List<String> getInsert_archv_no() {
		return insert_archv_no;
	}
	public void setInsert_archv_no(List<String> insert_archv_no) {
		this.insert_archv_no = insert_archv_no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getOpt_no() {
		return opt_no;
	}
	public void setOpt_no(int opt_no) {
		this.opt_no = opt_no;
	}
	public int getCatgry_cd() {
		return catgry_cd;
	}
	public void setCatgry_cd(int catgry_cd) {
		this.catgry_cd = catgry_cd;
	}
	public String getCatgry_name_list() {
		return catgry_name_list;
	}
	public void setCatgry_name_list(String catgry_name_list) {
		this.catgry_name_list = catgry_name_list;
	}
	
	
	
	

}
