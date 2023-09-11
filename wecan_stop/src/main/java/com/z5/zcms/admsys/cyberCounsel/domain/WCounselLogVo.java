package com.z5.zcms.admsys.cyberCounsel.domain;

import java.util.ArrayList;
import java.util.List;

public class WCounselLogVo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2401911797622660240L;

	private String counselNo; //순번
	private String counselClassification; //상담구분
	private int counselClassificationnum; //상담구분번호
	private String counselGender; //성별
	private String counselNation; //국적
	private String counselRelation; //관계
	private String counselAge; //나이
	private String counselRegion; //지역
	private String counselRegionParent; //지역분류
	private String counselType; //유형
	private String counselContent; //상담내용
	private String delYn; //삭제여부
	private String regDate; //등록일
	private String regId; //등록ID
	private String updDate; //수정일
	private String updId; //수정ID
	private String acrcNum; //권익위 상담관리번호
	private String counselClientName; //의뢰인명
	private String counselTelNum; //의뢰인 휴대전화
	private String counselReceiptChannel; //접수채널
	private String counselCountinue; //지속상담구분
	private String counselActionContent; //조치내용
	private String counselActionContentDetail; //조치내용상세
	
    private String regUser; //등록(수정)자
	
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
	
	
	public String getCounselNo() {
		return counselNo;
	}
	public void setCounselNo(String counselNo) {
		this.counselNo = counselNo;
	}
	public String getCounselClassification() {
		return counselClassification;
	}
	public void setCounselClassification(String counselClassification) {
		this.counselClassification = counselClassification;
	}
	public int getCounselClassificationnum() {
		return counselClassificationnum;
	}
	public void setCounselClassificationnum(int counselClassificationnum) {
		this.counselClassificationnum = counselClassificationnum;
	}
	public String getCounselGender() {
		return counselGender;
	}
	public void setCounselGender(String counselGender) {
		this.counselGender = counselGender;
	}
	public String getCounselNation() {
		return counselNation;
	}
	public void setCounselNation(String counselNation) {
		this.counselNation = counselNation;
	}
	public String getCounselRelation() {
		return counselRelation;
	}
	public void setCounselRelation(String counselRelation) {
		this.counselRelation = counselRelation;
	}
	public String getCounselAge() {
		return counselAge;
	}
	public void setCounselAge(String counselAge) {
		this.counselAge = counselAge;
	}
	public String getCounselRegion() {
		return counselRegion;
	}
	public void setCounselRegion(String counselRegion) {
		this.counselRegion = counselRegion;
	}
	public String getCounselRegionParent() {
		return counselRegionParent;
	}
	public void setCounselRegionParent(String counselRegionParent) {
		this.counselRegionParent = counselRegionParent;
	}
	public String getCounselType() {
		return counselType;
	}
	public void setCounselType(String counselType) {
		this.counselType = counselType;
	}
	public String getCounselContent() {
		return counselContent;
	}
	public void setCounselContent(String counselContent) {
		this.counselContent = counselContent;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
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
	public String getAcrcNum() {
		return acrcNum;
	}
	public void setAcrcNum(String acrcNum) {
		this.acrcNum = acrcNum;
	}
	public String getCounselClientName() {
		return counselClientName;
	}
	public void setCounselClientName(String counselClientName) {
		this.counselClientName = counselClientName;
	}
	public String getCounselTelNum() {
		return counselTelNum;
	}
	public void setCounselTelNum(String counselTelNum) {
		this.counselTelNum = counselTelNum;
	}
	public String getCounselReceiptChannel() {
		return counselReceiptChannel;
	}
	public void setCounselReceiptChannel(String counselReceiptChannel) {
		this.counselReceiptChannel = counselReceiptChannel;
	}
	public String getCounselCountinue() {
		return counselCountinue;
	}
	public void setCounselCountinue(String counselCountinue) {
		this.counselCountinue = counselCountinue;
	}
	public String getCounselActionContent() {
		return counselActionContent;
	}
	public void setCounselActionContent(String counselActionContent) {
		this.counselActionContent = counselActionContent;
	}
	public String getCounselActionContentDetail() {
		return counselActionContentDetail;
	}
	public void setCounselActionContentDetail(String counselActionContentDetail) {
		this.counselActionContentDetail = counselActionContentDetail;
	}
	public String getRegUser() {
		return regUser;
	}
	public void setRegUser(String regUser) {
		this.regUser = regUser;
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
	
}

