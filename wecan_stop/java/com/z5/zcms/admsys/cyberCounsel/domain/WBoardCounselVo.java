package com.z5.zcms.admsys.cyberCounsel.domain;

import java.util.ArrayList;
import java.util.List;

public class WBoardCounselVo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2401911797622660240L;

	private String boardNo; //순번
	private String boardUsername; //이름
	private String boardPasswd; //비밀번호
	private String boardTitle; //제목
	private String boardConts; //내용
	private String boardIp; //아이피
	private String boardHit; //조회수
	private String boardAnswer; //답변
	private String boardAnswerId; //답변ID
	private String userName; //상담원
	private String regDateAnswer; //답변등록일시
	private String delYn; //삭제여부
	private String regDate; //등록일시
	private String regId; //등록ID
	private String updDate; //답변수정일시
	private String updId; //답변수정ID
	
    private String regUser; //등록(수정)자
    private String excelName;
	
    private int n;
    private int m;
	String retStatus = "";
	String retMessage = "";
	String mode = "";    
	List<String> delList = new ArrayList<String>();
	String keyword;
	String cond1;
	String cond2;
	String cond3;
	String sdate;
	String edate;
	
	private String counselClassification; //상담구분
	private String counselGender; //성별
	private String counselNation; //국적
	private String counselRelation; //관계
	private String counselAge; //나이
	private String counselRegion; //지역
	private String counselType; //유형
	
	private String answerComplete; //답변완료
	private String answerWait; //답변대기
	private String add_file1; //답변 첨부파일명
	private String fileNames; //내담자 첨부파일명
	private String fileSaveNames; //내담자 첨부파일저장명
	private String satisfactionResult; //만족도조사참여여부
	
	
	public String getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(String boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardUsername() {
		return boardUsername;
	}
	public void setBoardUsername(String boardUsername) {
		this.boardUsername = boardUsername;
	}
	public String getBoardPasswd() {
		return boardPasswd;
	}
	public void setBoardPasswd(String boardPasswd) {
		this.boardPasswd = boardPasswd;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardConts() {
		return boardConts;
	}
	public void setBoardConts(String boardConts) {
		this.boardConts = boardConts;
	}
	public String getBoardIp() {
		return boardIp;
	}
	public void setBoardIp(String boardIp) {
		this.boardIp = boardIp;
	}
	public String getBoardHit() {
		return boardHit;
	}
	public void setBoardHit(String boardHit) {
		this.boardHit = boardHit;
	}
	public String getBoardAnswer() {
		return boardAnswer;
	}
	public void setBoardAnswer(String boardAnswer) {
		this.boardAnswer = boardAnswer;
	}
	public String getBoardAnswerId() {
		return boardAnswerId;
	}
	public void setBoardAnswerId(String boardAnswerId) {
		this.boardAnswerId = boardAnswerId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRegDateAnswer() {
		return regDateAnswer;
	}
	public void setRegDateAnswer(String regDateAnswer) {
		this.regDateAnswer = regDateAnswer;
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
	public String getCond3() {
		return cond3;
	}
	public void setCond3(String cond3) {
		this.cond3 = cond3;
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
	public String getCounselClassification() {
		return counselClassification;
	}
	public void setCounselClassification(String counselClassification) {
		this.counselClassification = counselClassification;
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
	public String getCounselType() {
		return counselType;
	}
	public void setCounselType(String counselType) {
		this.counselType = counselType;
	}
	public String getAnswerComplete() {
		return answerComplete;
	}
	public void setAnswerComplete(String answerComplete) {
		this.answerComplete = answerComplete;
	}
	public String getAnswerWait() {
		return answerWait;
	}
	public void setAnswerWait(String answerWait) {
		this.answerWait = answerWait;
	}
	public String getAdd_file1() {
		return add_file1;
	}
	public void setAdd_file1(String add_file1) {
		this.add_file1 = add_file1;
	}
	public String getFileNames() {
		return fileNames;
	}
	public void setFileNames(String fileNames) {
		this.fileNames = fileNames;
	}
	public String getSatisfactionResult() {
		return satisfactionResult;
	}
	public void setSatisfactionResult(String satisfactionResult) {
		this.satisfactionResult = satisfactionResult;
	}
	public String getExcelName() {
		return excelName;
	}
	public void setExcelName(String excelName) {
		this.excelName = excelName;
	}
	public String getFileSaveNames() {
		return fileSaveNames;
	}
	public void setFileSaveNames(String fileSaveNames) {
		this.fileSaveNames = fileSaveNames;
	}
	
}

