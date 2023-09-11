package com.z5.zcms.frontsys.front.domain;

import com.z5.zcms.admsys.common.domain.CommonVo;


public class MenuStaff extends CommonVo
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5912932638680418968L;
		
	private String cs_id; 
	private String cs_password; 
	private String cs_name; 
	private String dept_nm; 
	private String work_grade; 
	private String work_title; 
	private String cs_email; 
	private String holoff; 
	private String d_join; 
	private String d_retire; 
	private String tel_no;
	public String getCs_id() {
		return cs_id;
	}
	public void setCs_id(String cs_id) {
		this.cs_id = cs_id;
	}
	public String getCs_password() {
		return cs_password;
	}
	public void setCs_password(String cs_password) {
		this.cs_password = cs_password;
	}
	public String getCs_name() {
		return cs_name;
	}
	public void setCs_name(String cs_name) {
		this.cs_name = cs_name;
	}
	public String getDept_nm() {
		return dept_nm;
	}
	public void setDept_nm(String dept_nm) {
		this.dept_nm = dept_nm;
	}
	public String getWork_grade() {
		return work_grade;
	}
	public void setWork_grade(String work_grade) {
		this.work_grade = work_grade;
	}
	public String getWork_title() {
		return work_title;
	}
	public void setWork_title(String work_title) {
		this.work_title = work_title;
	}
	public String getCs_email() {
		return cs_email;
	}
	public void setCs_email(String cs_email) {
		this.cs_email = cs_email;
	}
	public String getHoloff() {
		return holoff;
	}
	public void setHoloff(String holoff) {
		this.holoff = holoff;
	}
	public String getD_join() {
		return d_join;
	}
	public void setD_join(String d_join) {
		this.d_join = d_join;
	}
	public String getD_retire() {
		return d_retire;
	}
	public void setD_retire(String d_retire) {
		this.d_retire = d_retire;
	}
	public String getTel_no() {
		return tel_no;
	}
	public void setTel_no(String tel_no) {
		this.tel_no = tel_no;
	}
	
	
	
}
