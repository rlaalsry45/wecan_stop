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
	private String counselActionResult; //조치결과
	private String chat; //상담구분(채팅)
	private String board; //상담구분(게시판)
	private String completionDate; //완료일
	
    private String regUser; //등록(수정)자
    private String boardRegUser; //게시판상담 답변등록자
    private String boardUpdUser; //게시판상담 답변수정자
    private String chatAnswer; //채팅상담 답변자
    private String delDate; //삭제일시
    private String delId; //삭제ID
    private String chatCreatedAt; //채팅상담시작
    private String chatClosedAt; //채팅상담종료
    private String boardCreatedAt; //게시판상담시작
    private String boardClosedAt; //게시판상담종료
    private String kakaoStrTime; //카카오상담시작
    private String kakaoEndTime; //카카오상담종료
    private String counselorName; //상담원명
    private String chatTelnum; //전화번호
    private String updYn; //수정여부
    private String counselorId; //상담원id
    private String counselClassificationNm; //상담구분명
    
    private String representVictimYn; //대표피해자여부
    private String victimNation; //피해자내국인
    private String victimNm; //피해자명
    private String victimGender; //피해자성별
    private String victimBirth; //피해자생년월일
    private String victimAgeGrasp; //피해자나이파악
    private String victimPhone; //피해자전화번호
    private String victimCellphone; //피해자휴대전화번호
    private String victimMarriedState; //피해자결혼상태
    private String victimDisability; //피해자장애
    private String victimAcquireCitizenship; //피해자국적취득
    private String victimCitizenship; //피해자국적
    private String victimStayQualification; //피해자체류자격
    private String victimZipCode; //피해자우편번호
    private String victimAddr; //피해자주소
    private String victimDetailAddr; //피해자상세주소
    private String attackerNm; //가해자명
    private String attackerGender; //가해자성별
    private String attackerBirth; //가해자생년월일
    private String attackerAgeGrasp; //가해자나이파악
    private String attackerPhone; //가해자전화번호
    private String attackerCellphone; //가해자휴대전화번호
    private String attackerMarriedState; //가해자결혼상태
    private String attackerDisability; //가해자장애
    private String attackerNation; //가해자내국인
    private String attackerCitizenship; //가해자국적
    private String attackerType; //가해자유형
    private String attackerDetailType; //가해자상세유형
    private String attackerLiveTogetherYn; //가해자동거여부
    private String attackerZipCode; //가해자우편번호
    private String attackerAddr; //가해자주소
    private String attackerDetailAddr; //가해자상세주소
    
    private int n;
    private int m;
	private String retStatus = "";
	private String retMessage = "";
	private String mode = "";    
	private List<String> delList = new ArrayList<String>();
	private String keyword;
	private String cond1;
	private String cond2;
	private String cond3;
	private String cond4;
	private String sdate;
	private String edate;
	
	private String TYP001;
	private String TYP002;
	private String TYP003;
	private String TYP004;
	private String TYP005;
	private String TYP006;
	private String TYP007;
	private String TYP008;
	private String TYP009;
	private String TYP010;
	private String TYP011;
	private String TYP012;
	
	private String chatMessage;
	private String fileNames;
	private String answerFileNames;
	
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
	public String getChat() {
		return chat;
	}
	public void setChat(String chat) {
		this.chat = chat;
	}
	public String getBoard() {
		return board;
	}
	public void setBoard(String board) {
		this.board = board;
	}
	public String getRegUser() {
		return regUser;
	}
	public void setRegUser(String regUser) {
		this.regUser = regUser;
	}
	public String getBoardRegUser() {
		return boardRegUser;
	}
	public void setBoardRegUser(String boardRegUser) {
		this.boardRegUser = boardRegUser;
	}
	public String getBoardUpdUser() {
		return boardUpdUser;
	}
	public void setBoardUpdUser(String boardUpdUser) {
		this.boardUpdUser = boardUpdUser;
	}
	public String getChatAnswer() {
		return chatAnswer;
	}
	public void setChatAnswer(String chatAnswer) {
		this.chatAnswer = chatAnswer;
	}
	public String getDelDate() {
		return delDate;
	}
	public void setDelDate(String delDate) {
		this.delDate = delDate;
	}
	public String getDelId() {
		return delId;
	}
	public void setDelId(String delId) {
		this.delId = delId;
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
	public String getTYP001() {
		return TYP001;
	}
	public void setTYP001(String tYP001) {
		TYP001 = tYP001;
	}
	public String getTYP002() {
		return TYP002;
	}
	public void setTYP002(String tYP002) {
		TYP002 = tYP002;
	}
	public String getTYP003() {
		return TYP003;
	}
	public void setTYP003(String tYP003) {
		TYP003 = tYP003;
	}
	public String getTYP004() {
		return TYP004;
	}
	public void setTYP004(String tYP004) {
		TYP004 = tYP004;
	}
	public String getTYP005() {
		return TYP005;
	}
	public void setTYP005(String tYP005) {
		TYP005 = tYP005;
	}
	public String getTYP006() {
		return TYP006;
	}
	public void setTYP006(String tYP006) {
		TYP006 = tYP006;
	}
	public String getTYP007() {
		return TYP007;
	}
	public void setTYP007(String tYP007) {
		TYP007 = tYP007;
	}
	public String getTYP008() {
		return TYP008;
	}
	public void setTYP008(String tYP008) {
		TYP008 = tYP008;
	}
	public String getTYP009() {
		return TYP009;
	}
	public void setTYP009(String tYP009) {
		TYP009 = tYP009;
	}
	public String getTYP010() {
		return TYP010;
	}
	public void setTYP010(String tYP010) {
		TYP010 = tYP010;
	}
	public String getTYP011() {
		return TYP011;
	}
	public void setTYP011(String tYP011) {
		TYP011 = tYP011;
	}
	public String getTYP012() {
		return TYP012;
	}
	public void setTYP012(String tYP012) {
		TYP012 = tYP012;
	}
	public String getChatMessage() {
		return chatMessage;
	}
	public void setChatMessage(String chatMessage) {
		this.chatMessage = chatMessage;
	}
	public String getFileNames() {
		return fileNames;
	}
	public void setFileNames(String fileNames) {
		this.fileNames = fileNames;
	}
	public String getRepresentVictimYn() {
		return representVictimYn;
	}
	public void setRepresentVictimYn(String representVictimYn) {
		this.representVictimYn = representVictimYn;
	}
	public String getVictimNation() {
		return victimNation;
	}
	public void setVictimNation(String victimNation) {
		this.victimNation = victimNation;
	}
	public String getVictimNm() {
		return victimNm;
	}
	public void setVictimNm(String victimNm) {
		this.victimNm = victimNm;
	}
	public String getVictimGender() {
		return victimGender;
	}
	public void setVictimGender(String victimGender) {
		this.victimGender = victimGender;
	}
	public String getVictimBirth() {
		return victimBirth;
	}
	public void setVictimBirth(String victimBirth) {
		this.victimBirth = victimBirth;
	}
	public String getVictimAgeGrasp() {
		return victimAgeGrasp;
	}
	public void setVictimAgeGrasp(String victimAgeGrasp) {
		this.victimAgeGrasp = victimAgeGrasp;
	}
	public String getVictimPhone() {
		return victimPhone;
	}
	public void setVictimPhone(String victimPhone) {
		this.victimPhone = victimPhone;
	}
	public String getVictimCellphone() {
		return victimCellphone;
	}
	public void setVictimCellphone(String victimCellphone) {
		this.victimCellphone = victimCellphone;
	}
	public String getVictimMarriedState() {
		return victimMarriedState;
	}
	public void setVictimMarriedState(String victimMarriedState) {
		this.victimMarriedState = victimMarriedState;
	}
	public String getVictimDisability() {
		return victimDisability;
	}
	public void setVictimDisability(String victimDisability) {
		this.victimDisability = victimDisability;
	}
	public String getVictimAcquireCitizenship() {
		return victimAcquireCitizenship;
	}
	public void setVictimAcquireCitizenship(String victimAcquireCitizenship) {
		this.victimAcquireCitizenship = victimAcquireCitizenship;
	}
	public String getVictimCitizenship() {
		return victimCitizenship;
	}
	public void setVictimCitizenship(String victimCitizenship) {
		this.victimCitizenship = victimCitizenship;
	}
	public String getVictimStayQualification() {
		return victimStayQualification;
	}
	public void setVictimStayQualification(String victimStayQualification) {
		this.victimStayQualification = victimStayQualification;
	}
	public String getVictimZipCode() {
		return victimZipCode;
	}
	public void setVictimZipCode(String victimZipCode) {
		this.victimZipCode = victimZipCode;
	}
	public String getVictimAddr() {
		return victimAddr;
	}
	public void setVictimAddr(String victimAddr) {
		this.victimAddr = victimAddr;
	}
	public String getVictimDetailAddr() {
		return victimDetailAddr;
	}
	public void setVictimDetailAddr(String victimDetailAddr) {
		this.victimDetailAddr = victimDetailAddr;
	}
	public String getAttackerNm() {
		return attackerNm;
	}
	public void setAttackerNm(String attackerNm) {
		this.attackerNm = attackerNm;
	}
	public String getAttackerGender() {
		return attackerGender;
	}
	public void setAttackerGender(String attackerGender) {
		this.attackerGender = attackerGender;
	}
	public String getAttackerBirth() {
		return attackerBirth;
	}
	public void setAttackerBirth(String attackerBirth) {
		this.attackerBirth = attackerBirth;
	}
	public String getAttackerAgeGrasp() {
		return attackerAgeGrasp;
	}
	public void setAttackerAgeGrasp(String attackerAgeGrasp) {
		this.attackerAgeGrasp = attackerAgeGrasp;
	}
	public String getAttackerPhone() {
		return attackerPhone;
	}
	public void setAttackerPhone(String attackerPhone) {
		this.attackerPhone = attackerPhone;
	}
	public String getAttackerCellphone() {
		return attackerCellphone;
	}
	public void setAttackerCellphone(String attackerCellphone) {
		this.attackerCellphone = attackerCellphone;
	}
	public String getAttackerMarriedState() {
		return attackerMarriedState;
	}
	public void setAttackerMarriedState(String attackerMarriedState) {
		this.attackerMarriedState = attackerMarriedState;
	}
	public String getAttackerDisability() {
		return attackerDisability;
	}
	public void setAttackerDisability(String attackerDisability) {
		this.attackerDisability = attackerDisability;
	}
	public String getAttackerNation() {
		return attackerNation;
	}
	public void setAttackerNation(String attackerNation) {
		this.attackerNation = attackerNation;
	}
	public String getAttackerCitizenship() {
		return attackerCitizenship;
	}
	public void setAttackerCitizenship(String attackerCitizenship) {
		this.attackerCitizenship = attackerCitizenship;
	}
	public String getAttackerType() {
		return attackerType;
	}
	public void setAttackerType(String attackerType) {
		this.attackerType = attackerType;
	}
	public String getAttackerDetailType() {
		return attackerDetailType;
	}
	public void setAttackerDetailType(String attackerDetailType) {
		this.attackerDetailType = attackerDetailType;
	}
	public String getAttackerLiveTogetherYn() {
		return attackerLiveTogetherYn;
	}
	public void setAttackerLiveTogetherYn(String attackerLiveTogetherYn) {
		this.attackerLiveTogetherYn = attackerLiveTogetherYn;
	}
	public String getAttackerZipCode() {
		return attackerZipCode;
	}
	public void setAttackerZipCode(String attackerZipCode) {
		this.attackerZipCode = attackerZipCode;
	}
	public String getAttackerAddr() {
		return attackerAddr;
	}
	public void setAttackerAddr(String attackerAddr) {
		this.attackerAddr = attackerAddr;
	}
	public String getAttackerDetailAddr() {
		return attackerDetailAddr;
	}
	public void setAttackerDetailAddr(String attackerDetailAddr) {
		this.attackerDetailAddr = attackerDetailAddr;
	}
	public String getCounselActionResult() {
		return counselActionResult;
	}
	public void setCounselActionResult(String counselActionResult) {
		this.counselActionResult = counselActionResult;
	}
	public String getAnswerFileNames() {
		return answerFileNames;
	}
	public void setAnswerFileNames(String answerFileNames) {
		this.answerFileNames = answerFileNames;
	}
	public String getChatCreatedAt() {
		return chatCreatedAt;
	}
	public void setChatCreatedAt(String chatCreatedAt) {
		this.chatCreatedAt = chatCreatedAt;
	}
	public String getChatClosedAt() {
		return chatClosedAt;
	}
	public void setChatClosedAt(String chatClosedAt) {
		this.chatClosedAt = chatClosedAt;
	}
	public String getBoardCreatedAt() {
		return boardCreatedAt;
	}
	public void setBoardCreatedAt(String boardCreatedAt) {
		this.boardCreatedAt = boardCreatedAt;
	}
	public String getBoardClosedAt() {
		return boardClosedAt;
	}
	public void setBoardClosedAt(String boardClosedAt) {
		this.boardClosedAt = boardClosedAt;
	}
	public String getKakaoStrTime() {
		return kakaoStrTime;
	}
	public void setKakaoStrTime(String kakaoStrTime) {
		this.kakaoStrTime = kakaoStrTime;
	}
	public String getKakaoEndTime() {
		return kakaoEndTime;
	}
	public void setKakaoEndTime(String kakaoEndTime) {
		this.kakaoEndTime = kakaoEndTime;
	}
	public String getCounselorName() {
		return counselorName;
	}
	public void setCounselorName(String counselorName) {
		this.counselorName = counselorName;
	}
	public String getChatTelnum() {
		return chatTelnum;
	}
	public void setChatTelnum(String chatTelnum) {
		this.chatTelnum = chatTelnum;
	}
	public String getUpdYn() {
		return updYn;
	}
	public void setUpdYn(String updYn) {
		this.updYn = updYn;
	}
	public String getCounselorId() {
		return counselorId;
	}
	public void setCounselorId(String counselorId) {
		this.counselorId = counselorId;
	}
	public String getCounselClassificationNm() {
		return counselClassificationNm;
	}
	public void setCounselClassificationNm(String counselClassificationNm) {
		this.counselClassificationNm = counselClassificationNm;
	}
	public String getCompletionDate() {
		return completionDate;
	}
	public void setCompletionDate(String completionDate) {
		this.completionDate = completionDate;
	}
	
}

