package com.z5.zcms.admsys.adminip.domain;

//import org.apache.poi.hssf.record.formula.functions.Logest;

import com.z5.zcms.admsys.common.domain.CommonVo;

public class AdminIP extends CommonVo{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String ip;
	private String name;
	private String memo;
	private String regdate;
	private String userid;
	private int adminip_permit;
	private int no;
	private int global_ip;

	
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getAdminip_permit() {
		return adminip_permit;
	}
	public void setAdminip_permit(int adminip_permit) {
		this.adminip_permit = adminip_permit;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getGlobal_ip() {
		return global_ip;
	}
	public void setGlobal_ip(int global_ip) {
		this.global_ip = global_ip;
	}

	
	
}
