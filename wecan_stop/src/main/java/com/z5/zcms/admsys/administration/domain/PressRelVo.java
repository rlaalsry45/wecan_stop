package com.z5.zcms.admsys.administration.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.z5.zcms.admsys.common.domain.CommonVo;

public class PressRelVo extends CommonVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1492955029110129373L;
	int NO = 0;
	String con_ac_no = "";
	String con_ac_type = "";
	String article_title = "";
	String consulting_action_no = "";
	String consulting_application_no = "";
	String create_user = "";
	String create_date = "";
	String update_user = "";
	String update_date = "";
	String delete_user = "";
	String delete_date = "";
	String delete_yn = "";

	List<String> pressNoList = new ArrayList<String>();
	int press_no = 0;

	public int getNO() {
		return NO;
	}

	public void setNO(int nO) {
		NO = nO;
	}

	public String getCon_ac_no() {
		return con_ac_no;
	}

	public void setCon_ac_no(String con_ac_no) {
		this.con_ac_no = con_ac_no;
	}

	public String getCon_ac_type() {
		return con_ac_type;
	}

	public void setCon_ac_type(String con_ac_type) {
		this.con_ac_type = con_ac_type;
	}

	public String getConsulting_action_no() {
		return consulting_action_no;
	}

	public void setConsulting_action_no(String consulting_action_no) {
		this.consulting_action_no = consulting_action_no;
	}

	public String getConsulting_application_no() {
		return consulting_application_no;
	}

	public void setConsulting_application_no(String consulting_application_no) {
		this.consulting_application_no = consulting_application_no;
	}

	public int getPress_no() {
		return press_no;
	}

	public void setPress_no(int press_no) {
		this.press_no = press_no;
	}

	public List<String> getPressNoList() {
		return pressNoList;
	}

	public void setPressNoList(List<String> pressNoList) {
		this.pressNoList = pressNoList;
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

	public String getArticle_title() {
		return article_title;
	}

	public void setArticle_title(String article_title) {
		this.article_title = article_title;
	}

}
