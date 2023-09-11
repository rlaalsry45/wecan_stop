package com.z5.zcms.admsys.orgculturedigmng.domain;

import java.io.Serializable;

public class ManagerListVo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 108033757950728118L;
	String manager_id = "";
	String manager_name = "";

	public String getManager_id() {
		return manager_id;
	}

	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}

	public String getManager_name() {
		return manager_name;
	}

	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}

}
