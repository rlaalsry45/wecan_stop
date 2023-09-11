package com.z5.zcms.admsys.orgculturedigmng.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WOrganizationVo implements Serializable {
    
	private static final long serialVersionUID = -8738051679360090975L;
   
	private String organizationNo;
    private String organizationId;
    private String organizationName;
    private String organizationChargename;
    private String organizationEmail;
    private String organizationTelnum;
    private String useYn;
    private String regDate;
    private String regId;
    private String updDate;
    private String updId;
    private String cond1;
    private String cond2;
    private String keyword;
    private String sdate;
    private String edate;
    private String filepath;
    private String sheetName;
    private int n;
    private int m;
	String retStatus = "";
	String retMessage = "";
	String mode = "";
	List<String> updList = new ArrayList<String>();
	
	

	
	public String getOrganizationNo() {
		return organizationNo;
	}
	public void setOrganizationNo(String organizationNo) {
		this.organizationNo = organizationNo;
	}
	public String getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}
	public String getOrganizationChargename() {
		return organizationChargename;
	}
	public void setOrganizationChargename(String organizationChargename) {
		this.organizationChargename = organizationChargename;
	}
	public String getOrganizationEmail() {
		return organizationEmail;
	}
	public void setOrganizationEmail(String organizationEmail) {
		this.organizationEmail = organizationEmail;
	}
	public String getOrganizationTelnum() {
		return organizationTelnum;
	}
	public void setOrganizationTelnum(String organizationTelnum) {
		this.organizationTelnum = organizationTelnum;
	}
	public String getUseYn() {
		return useYn;
	}
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getRegId() {
		return regId;
	}
	public void setRegId(String regId) {
		this.regId = regId;
	}
	public String getUpdDate() {
		return updDate;
	}
	public void setUpdDate(String updDate) {
		this.updDate = updDate;
	}
	public String getUpdId() {
		return updId;
	}
	public void setUpdId(String updId) {
		this.updId = updId;
	}
	public String getCond1() {
		return cond1;
	}
	public void setCond1(String cond1) {
		this.cond1 = cond1;
	}
	public String getCond2() {
		return cond2;
	}
	public void setCond2(String cond2) {
		this.cond2 = cond2;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public String getEdate() {
		return edate;
	}
	public void setEdate(String edate) {
		this.edate = edate;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public String getSheetName() {
		return sheetName;
	}
	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public int getM() {
		return m;
	}
	public void setM(int m) {
		this.m = m;
	}
	public String getRetStatus() {
		return retStatus;
	}
	public void setRetStatus(String retStatus) {
		this.retStatus = retStatus;
	}
	public String getRetMessage() {
		return retMessage;
	}
	public void setRetMessage(String retMessage) {
		this.retMessage = retMessage;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public List<String> getUpdList() {
		return updList;
	}
	public void setUpdList(List<String> updList) {
		this.updList = updList;
	}

}