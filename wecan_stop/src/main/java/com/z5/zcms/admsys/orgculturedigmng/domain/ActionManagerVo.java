package com.z5.zcms.admsys.orgculturedigmng.domain;

import java.io.Serializable;

public class ActionManagerVo implements Serializable {

	private static final long serialVersionUID = 6191229266381848122L;
	int NO = 0;
	String consulting_action_no = "";
	String manager = "";
	String create_user = "";// 생성자
	String create_date = "";// 생성일
	String update_user = "";// 수정자
	String update_date = "";// 수정일
	String delete_user = "";// 삭제자
	String delete_date = "";// 삭제일
	String delete_yn = "";// 삭제여부

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

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
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
