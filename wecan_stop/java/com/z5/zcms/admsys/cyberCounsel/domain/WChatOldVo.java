package com.z5.zcms.admsys.cyberCounsel.domain;

public class WChatOldVo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2401911797622660242L;

	private int no; //순번
	private String counselId; //상담원ID
	private String message; //대화내용
	private String regDt; //등록일시
	private String gender; //성별
	private String relation; //관계
	private String age; //나이
	private String region; //지역
	private String startDt; //상담시작시간
	private String endDt; //상담종료시간
	private int totalTime; //총상담시간
    
    private int n;
    private int m;
	private String retStatus = "";
	private String retMessage = "";
	private String mode = "";
	private String keyword;
	private String cond1;
	private String cond2;
	private String cond3;
	private String cond4;
	private String cond5;
	private String cond6;
	private String cond7;
	private String sdate;
	private String edate;
	private String stime;
	private String etime;
	private String csdate;
	private String cedate;
	
	
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getCounselId() {
		return counselId;
	}
	public void setCounselId(String counselId) {
		this.counselId = counselId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getRegDt() {
		return regDt;
	}
	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
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
	public String getEndDt() {
		return endDt;
	}
	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}
	public int getTotalTime() {
		return totalTime;
	}
	public void setTotalTime(int totalTime) {
		this.totalTime = totalTime;
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
	public String getCond3() {
		return cond3;
	}
	public void setCond3(String cond3) {
		this.cond3 = cond3;
	}
	public String getCond4() {
		return cond4;
	}
	public void setCond4(String cond4) {
		this.cond4 = cond4;
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
	public String getCond5() {
		return cond5;
	}
	public void setCond5(String cond5) {
		this.cond5 = cond5;
	}
	public String getCond6() {
		return cond6;
	}
	public void setCond6(String cond6) {
		this.cond6 = cond6;
	}
	public String getCond7() {
		return cond7;
	}
	public void setCond7(String cond7) {
		this.cond7 = cond7;
	}
	public String getStime() {
		return stime;
	}
	public void setStime(String stime) {
		this.stime = stime;
	}
	public String getEtime() {
		return etime;
	}
	public void setEtime(String etime) {
		this.etime = etime;
	}
	public String getCsdate() {
		return csdate;
	}
	public void setCsdate(String csdate) {
		this.csdate = csdate;
	}
	public String getCedate() {
		return cedate;
	}
	public void setCedate(String cedate) {
		this.cedate = cedate;
	}
	
}

