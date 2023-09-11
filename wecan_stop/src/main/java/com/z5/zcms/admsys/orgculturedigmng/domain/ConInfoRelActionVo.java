package com.z5.zcms.admsys.orgculturedigmng.domain;

import java.io.Serializable;

public class ConInfoRelActionVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8197845363506419726L;
	int NO = 0;
	String action_no = "";
	String consulting_no = "";
	String consulting_history_no = "";
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

	public String getAction_no() {
		return action_no;
	}

	public void setAction_no(String action_no) {
		this.action_no = action_no;
	}

	public String getConsulting_no() {
		return consulting_no;
	}

	public void setConsulting_no(String consulting_no) {
		this.consulting_no = consulting_no;
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

	public String getConsulting_history_no() {
		return consulting_history_no;
	}

	public void setConsulting_history_no(String consulting_history_no) {
		this.consulting_history_no = consulting_history_no;
	}

}
