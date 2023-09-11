package com.z5.zcms.frontsys.front.domain;

import java.io.Serializable;

public class GovUserInfoVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8299789914003294574L;
	int ORGANIZATION_NO = 0;
	String ORGANIZATION_ID = "";
	String ORGANIZATION_NAME = "";
	String ORGANIZATION_CHARGENAME = "";
	String ORGANIZATION_EMAIL = "";
	String ORGANIZATION_TELNUM = "";
	String USE_YN = "";
	String DEL_YN = "";
	String REG_DATE = "";
	String REG_ID = "";
	String UPD_DATE = "";
	String UPD_ID = "";

	public int getORGANIZATION_NO() {
		return ORGANIZATION_NO;
	}

	public void setORGANIZATION_NO(int oRGANIZATION_NO) {
		ORGANIZATION_NO = oRGANIZATION_NO;
	}

	public String getORGANIZATION_ID() {
		return ORGANIZATION_ID;
	}

	public void setORGANIZATION_ID(String oRGANIZATION_ID) {
		ORGANIZATION_ID = oRGANIZATION_ID;
	}

	public String getORGANIZATION_NAME() {
		return ORGANIZATION_NAME;
	}

	public void setORGANIZATION_NAME(String oRGANIZATION_NAME) {
		ORGANIZATION_NAME = oRGANIZATION_NAME;
	}

	public String getORGANIZATION_CHARGENAME() {
		return ORGANIZATION_CHARGENAME;
	}

	public void setORGANIZATION_CHARGENAME(String oRGANIZATION_CHARGENAME) {
		ORGANIZATION_CHARGENAME = oRGANIZATION_CHARGENAME;
	}

	public String getORGANIZATION_EMAIL() {
		return ORGANIZATION_EMAIL;
	}

	public void setORGANIZATION_EMAIL(String oRGANIZATION_EMAIL) {
		ORGANIZATION_EMAIL = oRGANIZATION_EMAIL;
	}

	public String getORGANIZATION_TELNUM() {
		return ORGANIZATION_TELNUM;
	}

	public void setORGANIZATION_TELNUM(String oRGANIZATION_TELNUM) {
		ORGANIZATION_TELNUM = oRGANIZATION_TELNUM;
	}

	public String getUSE_YN() {
		return USE_YN;
	}

	public void setUSE_YN(String uSE_YN) {
		USE_YN = uSE_YN;
	}

	public String getDEL_YN() {
		return DEL_YN;
	}

	public void setDEL_YN(String dEL_YN) {
		DEL_YN = dEL_YN;
	}

	public String getREG_DATE() {
		return REG_DATE;
	}

	public void setREG_DATE(String rEG_DATE) {
		REG_DATE = rEG_DATE;
	}

	public String getREG_ID() {
		return REG_ID;
	}

	public void setREG_ID(String rEG_ID) {
		REG_ID = rEG_ID;
	}

	public String getUPD_DATE() {
		return UPD_DATE;
	}

	public void setUPD_DATE(String uPD_DATE) {
		UPD_DATE = uPD_DATE;
	}

	public String getUPD_ID() {
		return UPD_ID;
	}

	public void setUPD_ID(String uPD_ID) {
		UPD_ID = uPD_ID;
	}

}
