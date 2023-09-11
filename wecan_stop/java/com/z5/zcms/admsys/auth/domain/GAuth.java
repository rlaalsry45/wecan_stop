package com.z5.zcms.admsys.auth.domain;

import java.util.Date;
import java.util.List;

import com.z5.zcms.admsys.common.domain.CommonVo;

public class GAuth extends CommonVo
{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	private int no;
	private String auth_no;
	private int groupno;
	
	private int urlno;
	private int menuno;
	private int siteno;
	private String emp_nm;
	private String groupnm;
	private String userid;
	private Date datereg;
	private List<Integer> arrFaqBestGroupNo;
	
	public List<Integer> getArrFaqBestGroupNo() {
		return arrFaqBestGroupNo;
	}
	public void setArrFaqBestGroupNo(List<Integer> arrFaqBestGroupNo) {
		this.arrFaqBestGroupNo = arrFaqBestGroupNo;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getUrlno() {
		return urlno;
	}
	public void setUrlno(int urlno) {
		this.urlno = urlno;
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
	public String getAuth_no() {
		return auth_no;
	}
	public void setAuth_no(String auth_no) {
		this.auth_no = auth_no;
	}
	public int getGroupno() {
		return groupno;
	}
	public void setGroupno(int groupno) {
		this.groupno = groupno;
	}
	public String getEmp_nm() {
		return emp_nm;
	}
	public void setEmp_nm(String emp_nm) {
		this.emp_nm = emp_nm;
	}
	public String getGroupnm() {
		return groupnm;
	}
	public void setGroupnm(String groupnm) {
		this.groupnm = groupnm;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Date getDatereg() {
		return datereg;
	}
	public void setDatereg(Date datereg) {
		this.datereg = datereg;
	}
}
