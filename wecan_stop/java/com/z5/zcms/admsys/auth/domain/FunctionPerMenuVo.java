package com.z5.zcms.admsys.auth.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FunctionPerMenuVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3275356223789101361L;
	int NO = 0;
	int URLNO = 0;
	String FUNCTION_NAME = "";
	String FUNCTION_TYPE = "";
	String create_user = "";
	String create_date = "";
	String update_user = "";
	String update_date = "";
	String delete_user = "";
	String delete_date = "";
	String delete_yn = "";

	List<String> delList = new ArrayList<String>();

	public int getNO() {
		return NO;
	}

	public void setNO(int nO) {
		NO = nO;
	}

	public int getURLNO() {
		return URLNO;
	}

	public void setURLNO(int uRLNO) {
		URLNO = uRLNO;
	}

	public String getFUNCTION_NAME() {
		return FUNCTION_NAME;
	}

	public void setFUNCTION_NAME(String fUNCTION_NAME) {
		FUNCTION_NAME = fUNCTION_NAME;
	}

	public String getFUNCTION_TYPE() {
		return FUNCTION_TYPE;
	}

	public void setFUNCTION_TYPE(String fUNCTION_TYPE) {
		FUNCTION_TYPE = fUNCTION_TYPE;
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

	public List<String> getDelList() {
		return delList;
	}

	public void setDelList(List<String> delList) {
		this.delList = delList;
	}

}