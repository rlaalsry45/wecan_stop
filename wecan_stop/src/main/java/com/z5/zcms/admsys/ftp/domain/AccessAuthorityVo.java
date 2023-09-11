package com.z5.zcms.admsys.ftp.domain;

import java.util.ArrayList;
import java.util.List;

public class AccessAuthorityVo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2401911797622660246L;

	private int NO; //순번
	private String userId; //사용자ID
	private String userName; //사용자명
	private String identification_info; //대상자 식별정보
	private String permission_info; //접근 권한 정보
	private String permission_type; //유형
	private String permission_typeName; //유형명
	private String reason; //신청사유
	private String approval_user; //승인자
	private String approval_date; //승인일시
	private String URLINFO; //url정보
	private int URLNO; //url번호
	private String URLTITLE; //url제목
	private String FUNCTION_TYPE; //기능유형
	private String permissions01; //권한1
	private String permissions02; //권한2
	private String permissions03; //권한3
	private String permissions04; //권한4
	private String permissions05; //권한5
	private String regName; //등록명
	private String create_user; //생성자
    
    private int n;
    private int m;
	private String retStatus = "";
	private String retMessage = "";
	private String mode = "";
	private String keyword;
	private String cond1;
	private String cond2;
	private String sdate;
	private String edate;
	
	
	
	public int getNO() {
		return NO;
	}
	public void setNO(int nO) {
		NO = nO;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getIdentification_info() {
		return identification_info;
	}
	public void setIdentification_info(String identification_info) {
		this.identification_info = identification_info;
	}
	public String getPermission_info() {
		return permission_info;
	}
	public void setPermission_info(String permission_info) {
		this.permission_info = permission_info;
	}
	public String getPermission_type() {
		return permission_type;
	}
	public void setPermission_type(String permission_type) {
		this.permission_type = permission_type;
	}
	public String getPermission_typeName() {
		return permission_typeName;
	}
	public void setPermission_typeName(String permission_typeName) {
		this.permission_typeName = permission_typeName;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getApproval_user() {
		return approval_user;
	}
	public void setApproval_user(String approval_user) {
		this.approval_user = approval_user;
	}
	public String getApproval_date() {
		return approval_date;
	}
	public void setApproval_date(String approval_date) {
		this.approval_date = approval_date;
	}
	public String getURLINFO() {
		return URLINFO;
	}
	public void setURLINFO(String uRLINFO) {
		URLINFO = uRLINFO;
	}
	public int getURLNO() {
		return URLNO;
	}
	public void setURLNO(int uRLNO) {
		URLNO = uRLNO;
	}
	public String getURLTITLE() {
		return URLTITLE;
	}
	public void setURLTITLE(String uRLTITLE) {
		URLTITLE = uRLTITLE;
	}
	public String getFUNCTION_TYPE() {
		return FUNCTION_TYPE;
	}
	public void setFUNCTION_TYPE(String fUNCTION_TYPE) {
		FUNCTION_TYPE = fUNCTION_TYPE;
	}
	public String getPermissions01() {
		return permissions01;
	}
	public void setPermissions01(String permissions01) {
		this.permissions01 = permissions01;
	}
	public String getPermissions02() {
		return permissions02;
	}
	public void setPermissions02(String permissions02) {
		this.permissions02 = permissions02;
	}
	public String getPermissions03() {
		return permissions03;
	}
	public void setPermissions03(String permissions03) {
		this.permissions03 = permissions03;
	}
	public String getPermissions04() {
		return permissions04;
	}
	public void setPermissions04(String permissions04) {
		this.permissions04 = permissions04;
	}
	public String getPermissions05() {
		return permissions05;
	}
	public void setPermissions05(String permissions05) {
		this.permissions05 = permissions05;
	}
	public String getRegName() {
		return regName;
	}
	public void setRegName(String regName) {
		this.regName = regName;
	}
	public String getCreate_user() {
		return create_user;
	}
	public void setCreate_user(String create_user) {
		this.create_user = create_user;
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
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
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
	
}