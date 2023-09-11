package com.z5.zcms.admsys.orgculturedigmng.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WCounselorVo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String counselNum; // 번호
	private String counselName; // 위원 성명
	private String org; // 소속기관
	private String region; // 활동지역
	private String startDt; // 최초활동일
	private String actYn; // 활동여부
	private String phoneNum; // 연락처
	private String regUser; // 등록(수정)자
	private String regDt; // 최초활동일
	private int n;
	private int m;
	String retStatus = "";
	String retMessage = "";
	String mode = "";
	List<String> delList = new ArrayList<String>();
	String keyword;
	String cond1;
	String cond2;
	String sdate;
	String edate;

	String consulting_action_no = "";
	String client_belong = "";
	String ac_com_date_from = "";
	String ac_com_date_to = "";
	int rownum_ = 0;
	int groupCnt = 0;
	int seq = 0;

	String excelName = "";

	public String getCounselNum() {
		return counselNum;
	}

	public void setCounselNum(String counselNum) {
		this.counselNum = counselNum;
	}

	public String getCounselName() {
		return counselName;
	}

	public void setCounselName(String counselName) {
		this.counselName = counselName;
	}

	public String getOrg() {
		return org;
	}

	public void setOrg(String org) {
		this.org = org;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getStartDt() {
		return startDt;
	}

	public void setStartDt(String startDt) {
		this.startDt = startDt;
	}

	public String getActYn() {
		return actYn;
	}

	public void setActYn(String actYn) {
		this.actYn = actYn;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getRegUser() {
		return regUser;
	}

	public void setRegUser(String regUser) {
		this.regUser = regUser;
	}

	public String getRegDt() {
		return regDt;
	}

	public void setRegDt(String regDt) {
		this.regDt = regDt;
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

	public List<String> getDelList() {
		return delList;
	}

	public void setDelList(List<String> delList) {
		this.delList = delList;
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

	public String getConsulting_action_no() {
		return consulting_action_no;
	}

	public void setConsulting_action_no(String consulting_action_no) {
		this.consulting_action_no = consulting_action_no;
	}

	public String getClient_belong() {
		return client_belong;
	}

	public void setClient_belong(String client_belong) {
		this.client_belong = client_belong;
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

	public int getRownum_() {
		return rownum_;
	}

	public void setRownum_(int rownum_) {
		this.rownum_ = rownum_;
	}

	public int getGroupCnt() {
		return groupCnt;
	}

	public void setGroupCnt(int groupCnt) {
		this.groupCnt = groupCnt;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getExcelName() {
		return excelName;
	}

	public void setExcelName(String excelName) {
		this.excelName = excelName;
	}

}