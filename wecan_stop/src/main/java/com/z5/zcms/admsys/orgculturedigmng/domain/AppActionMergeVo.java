package com.z5.zcms.admsys.orgculturedigmng.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.z5.zcms.frontsys.front.domain.FrontApplicationVo;

public class AppActionMergeVo extends FrontApplicationVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3121061857173846434L;

	/// action///
	int actionNO = 0;// 번호actionNO
	String consulting_action_no = "";// 번호
	String atno_year = ""; // 접수년도
	String atno_type = ""; // 접수분류
	String manager = "";// 담당자
	String manager_name = "";// 담당자 이름
	String action_consulting_type = "";// 상담분류
	String registration_date = ""; // 일시-상담등록 버튼 누른시간(사용자 컴퓨티 기준)
	String registration_strtime = ""; //상담시작시간
	String registration_endtime = ""; //상담종료시간
	String registration_date_from = "";
	String registration_date_to = "";
	String action_received_type = "";// 경로: 전화, 메일, 문자, 기타
	String contact_tel_no = "";// 연락처
	String contact_email = "";// 이메일
	String client_name = "";// 의뢰인-이름
	String client_gender = "";// 의뢰인-성별
	String client_belong = "";// 의뢰인-소속
	String client_victim_rel_type = "";// 의뢰인-피해자와의관계_코드
	String client_victim_rel_type_etc = "";// 의뢰인-피해자와의관계_기타
	String org_accident_step = "";// 기관내진행단계
	String org_accident_step_etc = "";// 기관내진행단계-기타

	String action_type_monitoring = "";
	String action_type_info = "";
	String action_type_req_listening = "";
	String action_type_other_org_info = "";
	String action_type_other_org_min = "";
	String action_type_other_org_civil_criminal = "";
	String action_type_other_org_rights = "";
	String action_type_other_org_etc = "";
	String action_type_other_org_etc_txt = "";
	String action_type_servie_rel = "";
	String action_type_servie_rel_consulting = "";
	String action_type_servie_rel_law_min = "";
	String action_type_servie_rel_medic = "";
	String action_type_servie_rel_etc = "";
	String action_type_servie_rel_etc_txt = "";
	String action_type_etc = "";
	String action_type_etc_txt = "";
	
	String rel_manager = "";

	String action_contents = "";// 조치내용
	String after_plan = "";// 향후계획
	String action_etc = "";// 비고
	String consulting_history_no = "";// 상담일지 등록하기
	String action_consulting_date_from = "";// 일정 지정
	String action_consulting_date_to = "";// 일정 지정
	
	String action_register_date_from = "";// 등록일 지정
	String action_register_date_to = "";// 등록일 지정
	
	String counselNum = "";// 위원 지정
	String counselName = "";// 위원 이름
	int boardno = 0;// 첨부파일
	String press_group_no = "";// 언론모니터링 정보-그룹아이디
	String delete_reason = "";// 삭제사유
	String step_status_txt = "";
	String action_consulting_type_txt = "";
	String action_received_type_txt = "";
	String client_gender_txt = "";
	String client_victim_rel_type_txt = "";
	String org_accident_step_txt = "";
	String action_type_txt = "";
	String action_type_cont_txt = "";
	String org_type_txt = "";
	String org_type_gov_detail_txt = "";
	String accident_response_hist_txt = "";
	String harm_type_txt = "";
	String accident_step_txt = "";
	String first_org_type_txt = "";
	String dup_org_type_txt = "";
	String wish_consulting_date_txt = "";

	String userId = "";
	List<String> delList = new ArrayList<String>();
	List<String> updList = new ArrayList<String>();

	String retStatus = "";
	String retMessage = "";
	String mode = "";
	String edit_reason = "";

	List<String> fileList = new ArrayList<String>();
	List<String> pressList = new ArrayList<String>();
	List<String> managerList = new ArrayList<String>();
	String con_ac_type = "";

	String bbsType = "";// P:담당관, A:전체진단
	String loginUserId = "";

	List<CommInfoVo> cmmList = new ArrayList<CommInfoVo>();
	List<String> consultingNoList = new ArrayList<String>();

	String regAcNo = "";
	int totalCount = 0;
	String excelName = "";

	String action_type_cont = "";
	String rownum_ = "";

	String action_contents_etc = "";
	String action_no_type = "";

	String consulting_action_no_search = "";// 번호

	String fromDetailYN = "N";

	String joinYn = "N";

	String action_type_cont_etc_txt = "";
	
	Date registration_datetime = new Date();


	public AppActionMergeVo() {
		super();
		this.action_type_monitoring = "N";
		this.action_type_info = "N";
		this.action_type_req_listening = "N";
		this.action_type_other_org_info = "N";
		this.action_type_other_org_min = "N";
		this.action_type_other_org_civil_criminal = "N";
		this.action_type_other_org_rights = "N";
		this.action_type_other_org_etc = "N";
		this.action_type_servie_rel = "N";
		this.action_type_servie_rel_consulting = "N";
		this.action_type_servie_rel_law_min = "N";
		this.action_type_servie_rel_medic = "N";
		this.action_type_servie_rel_etc = "N";
		this.action_type_etc = "N";
		this.action_contents_etc = "N";
	}

	public int getActionNO() {
		return actionNO;
	}

	public void setActionNO(int actionNO) {
		this.actionNO = actionNO;
	}

	public String getConsulting_action_no() {
		return consulting_action_no;
	}

	public void setConsulting_action_no(String consulting_action_no) {
		this.consulting_action_no = consulting_action_no;
	}
	
	public String getAtno_year() {
		return atno_year;
	}

	public void setAtno_year(String atno_year) {
		this.atno_year = atno_year;
	}

	public String getAtno_type() {
		return atno_type;
	}

	public void setAtno_type(String atno_type) {
		this.atno_type = atno_type;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getManager_name() {
		return manager_name;
	}

	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}

	public String getAction_consulting_type() {
		return action_consulting_type;
	}

	public void setAction_consulting_type(String action_consulting_type) {
		this.action_consulting_type = action_consulting_type;
	}

	public String getAction_received_type() {
		return action_received_type;
	}

	public void setAction_received_type(String action_received_type) {
		this.action_received_type = action_received_type;
	}

	public String getContact_tel_no() {
		return contact_tel_no;
	}

	public void setContact_tel_no(String contact_tel_no) {
		this.contact_tel_no = contact_tel_no;
	}

	public String getContact_email() {
		return contact_email;
	}

	public void setContact_email(String contact_email) {
		this.contact_email = contact_email;
	}

	public String getClient_name() {
		return client_name;
	}

	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}

	public String getClient_gender() {
		return client_gender;
	}

	public void setClient_gender(String client_gender) {
		this.client_gender = client_gender;
	}

	public String getClient_belong() {
		return client_belong;
	}

	public void setClient_belong(String client_belong) {
		this.client_belong = client_belong;
	}

	public String getClient_victim_rel_type() {
		return client_victim_rel_type;
	}

	public void setClient_victim_rel_type(String client_victim_rel_type) {
		this.client_victim_rel_type = client_victim_rel_type;
	}

	public String getClient_victim_rel_type_etc() {
		return client_victim_rel_type_etc;
	}

	public void setClient_victim_rel_type_etc(String client_victim_rel_type_etc) {
		this.client_victim_rel_type_etc = client_victim_rel_type_etc;
	}

	public String getOrg_accident_step() {
		return org_accident_step;
	}

	public void setOrg_accident_step(String org_accident_step) {
		this.org_accident_step = org_accident_step;
	}

	public String getOrg_accident_step_etc() {
		return org_accident_step_etc;
	}

	public void setOrg_accident_step_etc(String org_accident_step_etc) {
		this.org_accident_step_etc = org_accident_step_etc;
	}

	public String getAction_type_monitoring() {
		return action_type_monitoring;
	}

	public void setAction_type_monitoring(String action_type_monitoring) {
		this.action_type_monitoring = action_type_monitoring;
	}

	public String getAction_type_info() {
		return action_type_info;
	}

	public void setAction_type_info(String action_type_info) {
		this.action_type_info = action_type_info;
	}

	public String getAction_type_req_listening() {
		return action_type_req_listening;
	}

	public void setAction_type_req_listening(String action_type_req_listening) {
		this.action_type_req_listening = action_type_req_listening;
	}

	public String getAction_type_other_org_info() {
		return action_type_other_org_info;
	}

	public void setAction_type_other_org_info(String action_type_other_org_info) {
		this.action_type_other_org_info = action_type_other_org_info;
	}

	public String getAction_type_other_org_min() {
		return action_type_other_org_min;
	}

	public void setAction_type_other_org_min(String action_type_other_org_min) {
		this.action_type_other_org_min = action_type_other_org_min;
	}

	public String getAction_type_other_org_civil_criminal() {
		return action_type_other_org_civil_criminal;
	}

	public void setAction_type_other_org_civil_criminal(String action_type_other_org_civil_criminal) {
		this.action_type_other_org_civil_criminal = action_type_other_org_civil_criminal;
	}

	public String getAction_type_other_org_rights() {
		return action_type_other_org_rights;
	}

	public void setAction_type_other_org_rights(String action_type_other_org_rights) {
		this.action_type_other_org_rights = action_type_other_org_rights;
	}

	public String getAction_type_other_org_etc() {
		return action_type_other_org_etc;
	}

	public void setAction_type_other_org_etc(String action_type_other_org_etc) {
		this.action_type_other_org_etc = action_type_other_org_etc;
	}

	public String getAction_type_other_org_etc_txt() {
		return action_type_other_org_etc_txt;
	}

	public void setAction_type_other_org_etc_txt(String action_type_other_org_etc_txt) {
		this.action_type_other_org_etc_txt = action_type_other_org_etc_txt;
	}

	public String getAction_type_servie_rel() {
		return action_type_servie_rel;
	}

	public void setAction_type_servie_rel(String action_type_servie_rel) {
		this.action_type_servie_rel = action_type_servie_rel;
	}

	public String getAction_type_servie_rel_consulting() {
		return action_type_servie_rel_consulting;
	}

	public void setAction_type_servie_rel_consulting(String action_type_servie_rel_consulting) {
		this.action_type_servie_rel_consulting = action_type_servie_rel_consulting;
	}

	public String getAction_type_servie_rel_law_min() {
		return action_type_servie_rel_law_min;
	}

	public void setAction_type_servie_rel_law_min(String action_type_servie_rel_law_min) {
		this.action_type_servie_rel_law_min = action_type_servie_rel_law_min;
	}

	public String getAction_type_servie_rel_medic() {
		return action_type_servie_rel_medic;
	}

	public void setAction_type_servie_rel_medic(String action_type_servie_rel_medic) {
		this.action_type_servie_rel_medic = action_type_servie_rel_medic;
	}

	public String getAction_type_servie_rel_etc() {
		return action_type_servie_rel_etc;
	}

	public void setAction_type_servie_rel_etc(String action_type_servie_rel_etc) {
		this.action_type_servie_rel_etc = action_type_servie_rel_etc;
	}

	public String getAction_type_servie_rel_etc_txt() {
		return action_type_servie_rel_etc_txt;
	}

	public void setAction_type_servie_rel_etc_txt(String action_type_servie_rel_etc_txt) {
		this.action_type_servie_rel_etc_txt = action_type_servie_rel_etc_txt;
	}

	public String getAction_type_etc() {
		return action_type_etc;
	}

	public void setAction_type_etc(String action_type_etc) {
		this.action_type_etc = action_type_etc;
	}

	public String getAction_type_etc_txt() {
		return action_type_etc_txt;
	}

	public void setAction_type_etc_txt(String action_type_etc_txt) {
		this.action_type_etc_txt = action_type_etc_txt;
	}

	public String getAction_contents() {
		return action_contents;
	}

	public void setAction_contents(String action_contents) {
		this.action_contents = action_contents;
	}

	public String getAfter_plan() {
		return after_plan;
	}

	public void setAfter_plan(String after_plan) {
		this.after_plan = after_plan;
	}

	public String getAction_etc() {
		return action_etc;
	}

	public void setAction_etc(String action_etc) {
		this.action_etc = action_etc;
	}

	public String getConsulting_history_no() {
		return consulting_history_no;
	}

	public void setConsulting_history_no(String consulting_history_no) {
		this.consulting_history_no = consulting_history_no;
	}

	public String getAction_consulting_date_from() {
		return action_consulting_date_from;
	}

	public void setAction_consulting_date_from(String action_consulting_date_from) {
		this.action_consulting_date_from = action_consulting_date_from;
	}

	public String getAction_consulting_date_to() {
		return action_consulting_date_to;
	}

	public void setAction_consulting_date_to(String action_consulting_date_to) {
		this.action_consulting_date_to = action_consulting_date_to;
	}

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

	public int getBoardno() {
		return boardno;
	}

	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}

	public String getPress_group_no() {
		return press_group_no;
	}

	public void setPress_group_no(String press_group_no) {
		this.press_group_no = press_group_no;
	}

	public String getDelete_reason() {
		return delete_reason;
	}

	public void setDelete_reason(String delete_reason) {
		this.delete_reason = delete_reason;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<String> getDelList() {
		return delList;
	}

	public void setDelList(List<String> delList) {
		this.delList = delList;
	}

	public List<String> getUpdList() {
		return updList;
	}

	public void setUpdList(List<String> updList) {
		this.updList = updList;
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

	public String getEdit_reason() {
		return edit_reason;
	}

	public void setEdit_reason(String edit_reason) {
		this.edit_reason = edit_reason;
	}

	public List<String> getFileList() {
		return fileList;
	}

	public void setFileList(List<String> fileList) {
		this.fileList = fileList;
	}

	public List<String> getPressList() {
		return pressList;
	}

	public void setPressList(List<String> pressList) {
		this.pressList = pressList;
	}

	public List<String> getManagerList() {
		return managerList;
	}

	public void setManagerList(List<String> managerList) {
		this.managerList = managerList;
	}

	public String getCon_ac_type() {
		return con_ac_type;
	}

	public void setCon_ac_type(String con_ac_type) {
		this.con_ac_type = con_ac_type;
	}

	public String getBbsType() {
		return bbsType;
	}

	public void setBbsType(String bbsType) {
		this.bbsType = bbsType;
	}

	public String getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

	public List<CommInfoVo> getCmmList() {
		return cmmList;
	}

	public void setCmmList(List<CommInfoVo> cmmList) {
		this.cmmList = cmmList;
	}

	public List<String> getConsultingNoList() {
		return consultingNoList;
	}

	public void setConsultingNoList(List<String> consultingNoList) {
		this.consultingNoList = consultingNoList;
	}

	public String getRegAcNo() {
		return regAcNo;
	}

	public void setRegAcNo(String regAcNo) {
		this.regAcNo = regAcNo;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public String getRegistration_date_from() {
		return registration_date_from;
	}

	public void setRegistration_date_from(String registration_date_from) {
		this.registration_date_from = registration_date_from;
	}

	public String getRegistration_date_to() {
		return registration_date_to;
	}

	public void setRegistration_date_to(String registration_date_to) {
		this.registration_date_to = registration_date_to;
	}

	public String getExcelName() {
		return excelName;
	}

	public void setExcelName(String excelName) {
		this.excelName = excelName;
	}

	public String getAction_type_cont() {
		return action_type_cont;
	}

	public void setAction_type_cont(String action_type_cont) {
		this.action_type_cont = action_type_cont;
	}

	public String getRownum_() {
		return rownum_;
	}

	public void setRownum_(String rownum_) {
		this.rownum_ = rownum_;
	}

	public String getAction_contents_etc() {
		return action_contents_etc;
	}

	public void setAction_contents_etc(String action_contents_etc) {
		this.action_contents_etc = action_contents_etc;
	}

	public String getAction_no_type() {
		return action_no_type;
	}

	public void setAction_no_type(String action_no_type) {
		this.action_no_type = action_no_type;
	}

	public String getConsulting_action_no_search() {
		return consulting_action_no_search;
	}

	public void setConsulting_action_no_search(String consulting_action_no_search) {
		this.consulting_action_no_search = consulting_action_no_search;
	}

	public String getFromDetailYN() {
		return fromDetailYN;
	}

	public void setFromDetailYN(String fromDetailYN) {
		this.fromDetailYN = fromDetailYN;
	}

	public String getJoinYn() {
		return joinYn;
	}

	public void setJoinYn(String joinYn) {
		this.joinYn = joinYn;
	}

	public String getAction_type_cont_etc_txt() {
		return action_type_cont_etc_txt;
	}

	public void setAction_type_cont_etc_txt(String action_type_cont_etc_txt) {
		this.action_type_cont_etc_txt = action_type_cont_etc_txt;
	}

	public Date getRegistration_datetime() {
		return registration_datetime;
	}

	public void setRegistration_datetime(Date registration_datetime) {
		this.registration_datetime = registration_datetime;
	}

	public String getAction_consulting_type_txt() {
		return action_consulting_type_txt;
	}

	public void setAction_consulting_type_txt(String action_consulting_type_txt) {
		this.action_consulting_type_txt = action_consulting_type_txt;
	}

	public String getAction_received_type_txt() {
		return action_received_type_txt;
	}

	public void setAction_received_type_txt(String action_received_type_txt) {
		this.action_received_type_txt = action_received_type_txt;
	}

	public String getStep_status_txt() {
		return step_status_txt;
	}

	public void setStep_status_txt(String step_status_txt) {
		this.step_status_txt = step_status_txt;
	}

	public String getClient_gender_txt() {
		return client_gender_txt;
	}

	public void setClient_gender_txt(String client_gender_txt) {
		this.client_gender_txt = client_gender_txt;
	}

	public String getClient_victim_rel_type_txt() {
		return client_victim_rel_type_txt;
	}

	public void setClient_victim_rel_type_txt(String client_victim_rel_type_txt) {
		this.client_victim_rel_type_txt = client_victim_rel_type_txt;
	}

	public String getOrg_accident_step_txt() {
		return org_accident_step_txt;
	}

	public void setOrg_accident_step_txt(String org_accident_step_txt) {
		this.org_accident_step_txt = org_accident_step_txt;
	}

	public String getAction_type_txt() {
		return action_type_txt;
	}

	public void setAction_type_txt(String action_type_txt) {
		this.action_type_txt = action_type_txt;
	}

	public String getAction_type_cont_txt() {
		return action_type_cont_txt;
	}

	public void setAction_type_cont_txt(String action_type_cont_txt) {
		this.action_type_cont_txt = action_type_cont_txt;
	}

	public String getOrg_type_txt() {
		return org_type_txt;
	}

	public void setOrg_type_txt(String org_type_txt) {
		this.org_type_txt = org_type_txt;
	}

	public String getOrg_type_gov_detail_txt() {
		return org_type_gov_detail_txt;
	}

	public void setOrg_type_gov_detail_txt(String org_type_gov_detail_txt) {
		this.org_type_gov_detail_txt = org_type_gov_detail_txt;
	}

	public String getAccident_response_hist_txt() {
		return accident_response_hist_txt;
	}

	public void setAccident_response_hist_txt(String accident_response_hist_txt) {
		this.accident_response_hist_txt = accident_response_hist_txt;
	}

	public String getHarm_type_txt() {
		return harm_type_txt;
	}

	public void setHarm_type_txt(String harm_type_txt) {
		this.harm_type_txt = harm_type_txt;
	}

	public String getAccident_step_txt() {
		return accident_step_txt;
	}

	public void setAccident_step_txt(String accident_step_txt) {
		this.accident_step_txt = accident_step_txt;
	}

	public String getFirst_org_type_txt() {
		return first_org_type_txt;
	}

	public void setFirst_org_type_txt(String first_org_type_txt) {
		this.first_org_type_txt = first_org_type_txt;
	}

	public String getDup_org_type_txt() {
		return dup_org_type_txt;
	}

	public void setDup_org_type_txt(String dup_org_type_txt) {
		this.dup_org_type_txt = dup_org_type_txt;
	}

	public String getWish_consulting_date_txt() {
		return wish_consulting_date_txt;
	}

	public void setWish_consulting_date_txt(String wish_consulting_date_txt) {
		this.wish_consulting_date_txt = wish_consulting_date_txt;
	}

	public String getRegistration_date() {
		return registration_date;
	}

	public void setRegistration_date(String registration_date) {
		this.registration_date = registration_date;
	}

	public String getRegistration_strtime() {
		return registration_strtime;
	}

	public void setRegistration_strtime(String registration_strtime) {
		this.registration_strtime = registration_strtime;
	}

	public String getRegistration_endtime() {
		return registration_endtime;
	}

	public void setRegistration_endtime(String registration_endtime) {
		this.registration_endtime = registration_endtime;
	}

	public String getRel_manager() {
		return rel_manager;
	}

	public void setRel_manager(String rel_manager) {
		this.rel_manager = rel_manager;
	}

	public String getAction_register_date_from() {
		return action_register_date_from;
	}

	public void setAction_register_date_from(String action_register_date_from) {
		this.action_register_date_from = action_register_date_from;
	}

	public String getAction_register_date_to() {
		return action_register_date_to;
	}

	public void setAction_register_date_to(String action_register_date_to) {
		this.action_register_date_to = action_register_date_to;
	}
}
