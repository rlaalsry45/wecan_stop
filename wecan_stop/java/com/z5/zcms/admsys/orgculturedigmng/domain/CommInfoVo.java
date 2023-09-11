package com.z5.zcms.admsys.orgculturedigmng.domain;

import java.io.Serializable;

public class CommInfoVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6595704279553618866L;
	int NO = 0;
	String consulting_action_no = "";
	int counselNum = 0;
	String counselName = "";
	String ac_com_date_from = "";
	String ac_com_date_to = "";
	String create_user = "";
	String create_date = "";
	String update_user = "";
	String update_date = "";
	String delete_user = "";
	String delete_date = "";
	String delete_yn = "";

	public int getNO() {
		return NO;
	}

	public void setNO(int nO) {
		NO = nO;
	}

	public String getConsulting_action_no() {
		return consulting_action_no;
	}

	public void setConsulting_action_no(String consulting_action_no) {
		this.consulting_action_no = consulting_action_no;
	}

	public int getCounselNum() {
		return counselNum;
	}

	public void setCounselNum(int counselNum) {
		this.counselNum = counselNum;
	}

	public String getAc_com_date_from() {
		return ac_com_date_from;
	}

	public void setAc_com_date_from(String ac_com_date_from) {
		this.ac_com_date_from = ac_com_date_from;
	}

	public String getAc_com_date_to() {
		return ac_com_date_to;
	}

	public void setAc_com_date_to(String ac_com_date_to) {
		this.ac_com_date_to = ac_com_date_to;
	}

	public String getCreate_user() {
		return create_user;
	}

	public void setCreate_user(String create_user) {
		this.create_user = create_user;
	}

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}

	public String getUpdate_user() {
		return update_user;
	}

	public void setUpdate_user(String update_user) {
		this.update_user = update_user;
	}

	public String getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}

	public String getDelete_user() {
		return delete_user;
	}

	public void setDelete_user(String delete_user) {
		this.delete_user = delete_user;
	}

	public String getDelete_date() {
		return delete_date;
	}

	public void setDelete_date(String delete_date) {
		this.delete_date = delete_date;
	}

	public String getDelete_yn() {
		return delete_yn;
	}

	public void setDelete_yn(String delete_yn) {
		this.delete_yn = delete_yn;
	}

	public String getCounselName() {
		return counselName;
	}

	public void setCounselName(String counselName) {
		this.counselName = counselName;
	}

}
