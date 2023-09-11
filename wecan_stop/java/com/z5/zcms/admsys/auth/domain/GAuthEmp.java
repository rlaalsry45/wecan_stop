package com.z5.zcms.admsys.auth.domain;

import java.util.List;

import com.z5.zcms.admsys.common.domain.CommonVo;

public class GAuthEmp extends CommonVo
{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private String emp_no;
	private String emp_nm;
	private String hq_cd;
	private String hq_nm;
	private String dept_cd;
	private String dept_nm;
	private String dept_full_nm;
	private String holoff_cls;
	private String tel_offc;
	private List<GAuth> gAuth;
	private String emp_id;
	
	public String getEmp_no() {
		return emp_no;
	}
	public void setEmp_no(String emp_no) {
		this.emp_no = emp_no;
	}
	public String getEmp_nm() {
		return emp_nm;
	}
	public void setEmp_nm(String emp_nm) {
		this.emp_nm = emp_nm;
	}
	public String getHq_cd() {
		return hq_cd;
	}
	public void setHq_cd(String hq_cd) {
		this.hq_cd = hq_cd;
	}
	public String getHq_nm() {
		return hq_nm;
	}
	public void setHq_nm(String hq_nm) {
		this.hq_nm = hq_nm;
	}
	public String getDept_cd() {
		return dept_cd;
	}
	public void setDept_cd(String dept_cd) {
		this.dept_cd = dept_cd;
	}
	public String getDept_nm() {
		return dept_nm;
	}
	public void setDept_nm(String dept_nm) {
		this.dept_nm = dept_nm;
	}
	public String getDept_full_nm() {
		return dept_full_nm;
	}
	public void setDept_full_nm(String dept_full_nm) {
		this.dept_full_nm = dept_full_nm;
	}
	public String getHoloff_cls() {
		return holoff_cls;
	}
	public void setHoloff_cls(String holoff_cls) {
		this.holoff_cls = holoff_cls;
	}
	public String getTel_offc() {
		return tel_offc;
	}
	public void setTel_offc(String tel_offc) {
		this.tel_offc = tel_offc;
	}
	public List<GAuth> getgAuth() {
		return gAuth;
	}
	public void setgAuth(List<GAuth> gAuth) {
		this.gAuth = gAuth;
	}
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	
}
