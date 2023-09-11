package com.z5.zcms.admsys.common.domain;

import java.io.Serializable;

public class EditHistoryVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8196255099920930343L;

	int NO = 0;
	String consulting_action_no = "";
	String edit_history_no = "";
	String edit_contents = "";
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

	public String getEdit_history_no() {
		return edit_history_no;
	}

	public void setEdit_history_no(String edit_history_no) {
		this.edit_history_no = edit_history_no;
	}

	public String getEdit_contents() {
		return edit_contents;
	}

	public void setEdit_contents(String edit_contents) {
		this.edit_contents = edit_contents;
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

}
