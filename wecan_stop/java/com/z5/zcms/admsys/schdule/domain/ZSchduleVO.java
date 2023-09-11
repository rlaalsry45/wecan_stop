package com.z5.zcms.admsys.schdule.domain;

import com.z5.zcms.admsys.common.domain.CommonVo;

/**
 * @Class Name : ZmainVO.java
 * @Description : Zmain VO class
 * @Modification Information
 *
 * @author 김문석
 * @since 2013
 * @version 1.0
 * @see
 *  
 *  Copyright (C)  All right reserved.
 */
public class ZSchduleVO extends CommonVo{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8373736410579860490L;
	private String searchCondition;
	private String searchMode; 
	private String calendar_no;
	private String schdulUrl;
	private String schdulUrlTarget;
	
	
	
	public String getSchdulUrlTarget() {
		return schdulUrlTarget;
	}

	public void setSchdulUrlTarget(String schdulUrlTarget) {
		this.schdulUrlTarget = schdulUrlTarget;
	}

	public String getSchdulUrl() {
		return schdulUrl;
	}

	public void setSchdulUrl(String schdulUrl) {
		this.schdulUrl = schdulUrl;
	}

	private String last_updusr_id; 
	public String getLast_updusr_id() {
		return last_updusr_id;
	}

	public void setLast_updusr_id(String last_updusr_id) {
		this.last_updusr_id = last_updusr_id;
	}

	public String getCalendar_no() {
		return calendar_no;
	}

	public void setCalendar_no(String calendar_no) {
		this.calendar_no = calendar_no;
	}

	public String getUniqId() {
		return uniqId;
	}

	public void setUniqId(String uniqId) {
		this.uniqId = uniqId;
	}

	private String uniqId; 
	public String getSearchMode() {
		return searchMode;
	}

	public void setSearchMode(String searchMode) {
		this.searchMode = searchMode;
	}

	public String getSiteDivision() {
		return siteDivision;
	}

	public void setSiteDivision(String siteDivision) {
		this.siteDivision = siteDivision;
	}

	private String siteDivision;
	  


	public String getSearchCondition() {
		return searchCondition;
	}

	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	private String searchMonth; 
	private String searchDay;
	private String searchKeyword;

	

	public String getSearchMonth() {
		return searchMonth;
	}

	public void setSearchMonth(String searchMonth) {
		this.searchMonth = searchMonth;
	}

	public String getSearchDay() {
		return searchDay;
	}

	public void setSearchDay(String searchDay) {
		this.searchDay = searchDay;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	/** 일정ID */
	private String schdulId;
	
	/** 일정구분(회의/교육/세미나/강의 기타) */
	
	private String schdulSe;
	
	/** 일정부서ID */
	private String schdulDeptId;
	
	/** 일정종류(부서일정/개인일정) */
	private String schdulKindCode;
	
	/** 일정시작일자 */
	private String schdulBgnde;
	
	/** 일정종료일자 */
	private String schdulEndde;
	
	/** 일정명 */
	private String schdulNm;
	
	/** 일정내용 */
	private String schdulCn;
	
	/** 일정장소 */
	private String schdulPlace;
	
	/** 일정중요도코드 */
	private String schdulIpcrCode;
	
	/** 일정담담자ID */
	private String schdulChargerId;
	
	/** 첨부파일ID */
	private String atchFileId;
	
	/** 반복구분(반복, 연속, 요일반복) */
	private String reptitSeCode;
	
	/** 최초등록시점 */
	private String frstRegisterPnttm = "";
	
	/** 최초등록자ID */
	private String frstRegisterId = "";
	
	/** 최종수정시점 */
	private String lastUpdusrPnttm = "";
	
	/** 최종수정ID */
	private String lastUpdusrId = "";
	
	/** 일정시작일자(시간) */
	private String schdulBgndeHH = "";
	
	/** 일정시작일자(분) */
	private String schdulBgndeMM = "";
	
	/** 일정종료일자(시간) */
	private String schdulEnddeHH = "";
	
	/** 일정종료일자(분) */
	private String schdulEnddeMM = "";
	
	/** 일정시작일자(Year/Month/Day) */
	private String schdulBgndeYYYMMDD = "";
	
	/** 일정종료일자(Year/Month/Day) */
	private String schdulEnddeYYYMMDD = "";
	
	/** 담당부서 */
	private String schdulDeptName = "";
	
	/** 담당자명 */
	private String schdulChargerName = "";
	
	/** 센터구분 */
	private String sitedivision = "";
	
	/** 노출형태, 중앙,전체, 지역만 */
	private String exposuretype;
	
	private Integer interlockboardno;
	private Integer interlockbbsno;
	private Integer interlockboardsiteno;
	private String interlockboardskin;
	private Integer interlockboardmenuno;

	private String ctitle; //캘린더제목

	public String getExposuretype() {
		return exposuretype;
	}

	public void setExposuretype(String exposuretype) {
		this.exposuretype = exposuretype;
	}

	public String getSitedivision() {
		return sitedivision;
	}

	public void setSitedivision(String sitedivision) {
		this.sitedivision = sitedivision;
	}
	
	public String getCtitle() {
		return ctitle;
	}

	public void setCtitle(String ctitle) {
		this.ctitle = ctitle;
	}

	/**
	 * schdulId attribute 를 리턴한다.
	 * @return the String
	 */
	public String getSchdulId() {
		return schdulId;
	}

	/**
	 * schdulId attribute 값을 설정한다.
	 * @return schdulId String
	 */
	public void setSchdulId(String schdulId) {
		this.schdulId = schdulId;
	}

	/**
	 * schdulSe attribute 를 리턴한다.
	 * @return the String
	 */
	public String getSchdulSe() {
		return schdulSe;
	}

	/**
	 * schdulSe attribute 값을 설정한다.
	 * @return schdulSe String
	 */
	public void setSchdulSe(String schdulSe) {
		this.schdulSe = schdulSe;
	}

	/**
	 * schdulDeptId attribute 를 리턴한다.
	 * @return the String
	 */
	public String getSchdulDeptId() {
		return schdulDeptId;
	}

	/**
	 * schdulDeptId attribute 값을 설정한다.
	 * @return schdulDeptId String
	 */
	public void setSchdulDeptId(String schdulDeptId) {
		this.schdulDeptId = schdulDeptId;
	}

	/**
	 * schdulKindCode attribute 를 리턴한다.
	 * @return the String
	 */
	public String getSchdulKindCode() {
		return schdulKindCode;
	}

	/**
	 * schdulKindCode attribute 값을 설정한다.
	 * @return schdulKindCode String
	 */
	public void setSchdulKindCode(String schdulKindCode) {
		this.schdulKindCode = schdulKindCode;
	}

	/**
	 * schdulBgnde attribute 를 리턴한다.
	 * @return the String
	 */
	public String getSchdulBgnde() {
		return schdulBgnde;
	}

	/**
	 * schdulBgnde attribute 값을 설정한다.
	 * @return schdulBgnde String
	 */
	public void setSchdulBgnde(String schdulBgnde) {
		this.schdulBgnde = schdulBgnde;
	}

	/**
	 * schdulEndde attribute 를 리턴한다.
	 * @return the String
	 */
	public String getSchdulEndde() {
		return schdulEndde;
	}

	/**
	 * schdulEndde attribute 값을 설정한다.
	 * @return schdulEndde String
	 */
	public void setSchdulEndde(String schdulEndde) {
		this.schdulEndde = schdulEndde;
	}

	/**
	 * schdulNm attribute 를 리턴한다.
	 * @return the String
	 */
	public String getSchdulNm() {
		return schdulNm;
	}

	/**
	 * schdulNm attribute 값을 설정한다.
	 * @return schdulNm String
	 */
	public void setSchdulNm(String schdulNm) {
		this.schdulNm = schdulNm;
	}

	/**
	 * schdulCn attribute 를 리턴한다.
	 * @return the String
	 */
	public String getSchdulCn() {
		return schdulCn;
	}

	/**
	 * schdulCn attribute 값을 설정한다.
	 * @return schdulCn String
	 */
	public void setSchdulCn(String schdulCn) {
		this.schdulCn = schdulCn;
	}

	/**
	 * schdulPlace attribute 를 리턴한다.
	 * @return the String
	 */
	public String getSchdulPlace() {
		return schdulPlace;
	}

	/**
	 * schdulPlace attribute 값을 설정한다.
	 * @return schdulPlace String
	 */
	public void setSchdulPlace(String schdulPlace) {
		this.schdulPlace = schdulPlace;
	}

	/**
	 * schdulIpcrCode attribute 를 리턴한다.
	 * @return the String
	 */
	public String getSchdulIpcrCode() {
		return schdulIpcrCode;
	}

	/**
	 * schdulIpcrCode attribute 값을 설정한다.
	 * @return schdulIpcrCode String
	 */
	public void setSchdulIpcrCode(String schdulIpcrCode) {
		this.schdulIpcrCode = schdulIpcrCode;
	}

	/**
	 * schdulChargerId attribute 를 리턴한다.
	 * @return the String
	 */
	public String getSchdulChargerId() {
		return schdulChargerId;
	}

	/**
	 * schdulChargerId attribute 값을 설정한다.
	 * @return schdulChargerId String
	 */
	public void setSchdulChargerId(String schdulChargerId) {
		this.schdulChargerId = schdulChargerId;
	}

	/**
	 * atchFileId attribute 를 리턴한다.
	 * @return the String
	 */
	public String getAtchFileId() {
		return atchFileId;
	}

	/**
	 * atchFileId attribute 값을 설정한다.
	 * @return atchFileId String
	 */
	public void setAtchFileId(String atchFileId) {
		this.atchFileId = atchFileId;
	}

	/**
	 * reptitSeCode attribute 를 리턴한다.
	 * @return the String
	 */
	public String getReptitSeCode() {
		return reptitSeCode;
	}

	/**
	 * reptitSeCode attribute 값을 설정한다.
	 * @return reptitSeCode String
	 */
	public void setReptitSeCode(String reptitSeCode) {
		this.reptitSeCode = reptitSeCode;
	}

	/**
	 * frstRegisterPnttm attribute 를 리턴한다.
	 * @return the String
	 */
	public String getFrstRegisterPnttm() {
		return frstRegisterPnttm;
	}

	/**
	 * frstRegisterPnttm attribute 값을 설정한다.
	 * @return frstRegisterPnttm String
	 */
	public void setFrstRegisterPnttm(String frstRegisterPnttm) {
		this.frstRegisterPnttm = frstRegisterPnttm;
	}

	/**
	 * frstRegisterId attribute 를 리턴한다.
	 * @return the String
	 */
	public String getFrstRegisterId() {
		return frstRegisterId;
	}

	/**
	 * frstRegisterId attribute 값을 설정한다.
	 * @return frstRegisterId String
	 */
	public void setFrstRegisterId(String frstRegisterId) {
		this.frstRegisterId = frstRegisterId;
	}

	/**
	 * lastUpdusrPnttm attribute 를 리턴한다.
	 * @return the String
	 */
	public String getLastUpdusrPnttm() {
		return lastUpdusrPnttm;
	}

	/**
	 * lastUpdusrPnttm attribute 값을 설정한다.
	 * @return lastUpdusrPnttm String
	 */
	public void setLastUpdusrPnttm(String lastUpdusrPnttm) {
		this.lastUpdusrPnttm = lastUpdusrPnttm;
	}

	/**
	 * lastUpdusrId attribute 를 리턴한다.
	 * @return the String
	 */
	public String getLastUpdusrId() {
		return lastUpdusrId;
	}

	/**
	 * lastUpdusrId attribute 값을 설정한다.
	 * @return lastUpdusrId String
	 */
	public void setLastUpdusrId(String lastUpdusrId) {
		this.lastUpdusrId = lastUpdusrId;
	}

	/**
	 * schdulBgndeHH attribute 를 리턴한다.
	 * @return the String
	 */
	public String getSchdulBgndeHH() {
		return schdulBgndeHH;
	}

	/**
	 * schdulBgndeHH attribute 값을 설정한다.
	 * @return schdulBgndeHH String
	 */
	public void setSchdulBgndeHH(String schdulBgndeHH) {
		this.schdulBgndeHH = schdulBgndeHH;
	}

	/**
	 * schdulBgndeMM attribute 를 리턴한다.
	 * @return the String
	 */
	public String getSchdulBgndeMM() {
		return schdulBgndeMM;
	}

	/**
	 * schdulBgndeMM attribute 값을 설정한다.
	 * @return schdulBgndeMM String
	 */
	public void setSchdulBgndeMM(String schdulBgndeMM) {
		this.schdulBgndeMM = schdulBgndeMM;
	}

	/**
	 * schdulEnddeHH attribute 를 리턴한다.
	 * @return the String
	 */
	public String getSchdulEnddeHH() {
		return schdulEnddeHH;
	}

	/**
	 * schdulEnddeHH attribute 값을 설정한다.
	 * @return schdulEnddeHH String
	 */
	public void setSchdulEnddeHH(String schdulEnddeHH) {
		this.schdulEnddeHH = schdulEnddeHH;
	}

	/**
	 * schdulEnddeMM attribute 를 리턴한다.
	 * @return the String
	 */
	public String getSchdulEnddeMM() {
		return schdulEnddeMM;
	}

	/**
	 * schdulEnddeMM attribute 값을 설정한다.
	 * @return schdulEnddeMM String
	 */
	public void setSchdulEnddeMM(String schdulEnddeMM) {
		this.schdulEnddeMM = schdulEnddeMM;
	}

	/**
	 * schdulBgndeYYYMMDD attribute 를 리턴한다.
	 * @return the String
	 */
	public String getSchdulBgndeYYYMMDD() {
		return schdulBgndeYYYMMDD;
	}

	/**
	 * schdulBgndeYYYMMDD attribute 값을 설정한다.
	 * @return schdulBgndeYYYMMDD String
	 */
	public void setSchdulBgndeYYYMMDD(String schdulBgndeYYYMMDD) {
		this.schdulBgndeYYYMMDD = schdulBgndeYYYMMDD;
	}

	/**
	 * schdulEnddeYYYMMDD attribute 를 리턴한다.
	 * @return the String
	 */
	public String getSchdulEnddeYYYMMDD() {
		return schdulEnddeYYYMMDD;
	}

	/**
	 * schdulEnddeYYYMMDD attribute 값을 설정한다.
	 * @return schdulEnddeYYYMMDD String
	 */
	public void setSchdulEnddeYYYMMDD(String schdulEnddeYYYMMDD) {
		this.schdulEnddeYYYMMDD = schdulEnddeYYYMMDD;
	}

	/**
	 * schdulDeptName attribute 를 리턴한다.
	 * @return the String
	 */
	public String getSchdulDeptName() {
		return schdulDeptName;
	}

	/**
	 * schdulDeptName attribute 값을 설정한다.
	 * @return schdulDeptName String
	 */
	public void setSchdulDeptName(String schdulDeptName) {
		this.schdulDeptName = schdulDeptName;
	}

	/**
	 * schdulChargerName attribute 를 리턴한다.
	 * @return the String
	 */
	public String getSchdulChargerName() {
		return schdulChargerName;
	}

	/**
	 * schdulChargerName attribute 값을 설정한다.
	 * @return schdulChargerName String
	 */
	public void setSchdulChargerName(String schdulChargerName) {
		this.schdulChargerName = schdulChargerName;
	}
	
	
	public Integer getInterlockboardno() {
		return interlockboardno;
	}

	public void setInterlockboardno(Integer interlockboardno) {
		this.interlockboardno = interlockboardno;
	}

	public Integer getInterlockbbsno() {
		return interlockbbsno;
	}

	public void setInterlockbbsno(Integer interlockbbsno) {
		this.interlockbbsno = interlockbbsno;
	}

	public Integer getInterlockboardsiteno() {
		return interlockboardsiteno;
	}

	public void setInterlockboardsiteno(Integer interlockboardsiteno) {
		this.interlockboardsiteno = interlockboardsiteno;
	}

	public String getInterlockboardskin() {
		return interlockboardskin;
	}

	public void setInterlockboardskin(String interlockboardskin) {
		this.interlockboardskin = interlockboardskin;
	}

	public Integer getInterlockboardmenuno() {
		return interlockboardmenuno;
	}

	public void setInterlockboardmenuno(Integer interlockboardmenuno) {
		this.interlockboardmenuno = interlockboardmenuno;
	}

	/**
	 * calendermanage tbl 추가
	 */
	private String calendar_name;
	private String calendar_lang;
	private String frst_reg_dt;
	private String frst_reg_user;
	private String last_mod_dt;
	private String last_mod_user;
	private String menuno;
	private String siteno;
	private String use_yn;
	private String schdulcnt;

	public String getCalendar_name() {
		return calendar_name;
	}

	public void setCalendar_name(String calendar_name) {
		this.calendar_name = calendar_name;
	}

	public String getCalendar_lang() {
		return calendar_lang;
	}

	public void setCalendar_lang(String calendar_lang) {
		this.calendar_lang = calendar_lang;
	}

	public String getFrst_reg_dt() {
		return frst_reg_dt;
	}

	public void setFrst_reg_dt(String frst_reg_dt) {
		this.frst_reg_dt = frst_reg_dt;
	}

	public String getFrst_reg_user() {
		return frst_reg_user;
	}

	public void setFrst_reg_user(String frst_reg_user) {
		this.frst_reg_user = frst_reg_user;
	}

	public String getLast_mod_dt() {
		return last_mod_dt;
	}

	public void setLast_mod_dt(String last_mod_dt) {
		this.last_mod_dt = last_mod_dt;
	}

	public String getLast_mod_user() {
		return last_mod_user;
	}

	public void setLast_mod_user(String last_mod_user) {
		this.last_mod_user = last_mod_user;
	}

	public String getMenuno() {
		return menuno;
	}

	public void setMenuno(String menuno) {
		this.menuno = menuno;
	}

	public String getSiteno() {
		return siteno;
	}

	public void setSiteno(String siteno) {
		this.siteno = siteno;
	}

	public String getUse_yn() {
		return use_yn;
	}

	public void setUse_yn(String use_yn) {
		this.use_yn = use_yn;
	}

	public String getSchdulcnt() {
		return schdulcnt;
	}

	public void setSchdulcnt(String schdulcnt) {
		this.schdulcnt = schdulcnt;
	}
}