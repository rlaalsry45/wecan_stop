package com.z5.zcms.admsys.orgculturedigmng.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.z5.zcms.admsys.common.domain.CommonVo;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WOrgCultureDigMngVo extends CommonVo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8738051679360090974L;

	int NO = 0;// 번호
	String consulting_action_no = "";// 번호
	String manager = "";// 담당자
	String manager_name = "";// 담당자 이름
	String action_consulting_type = "";// 상담분류
	String registration_date = "";// 일시-상담등록 버튼 누른시간(사용자 컴퓨티 기준)
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

	String action_contents = "";// 조치내용
	String after_plan = "";// 향후계획
	String action_etc = "";// 비고
	String consulting_history_no = "";// 상담일지 등록하기
	String action_consulting_date_from = "";// 일정 지정
	String action_consulting_date_to = "";// 일정 지정
	String counselNum = "";// 위원 지정
	String counselName = "";// 위원 이름
	int boardno = 0;// 첨부파일
	String press_group_no = "";// 언론모니터링 정보-그룹아이디
	String delete_reason = "";// 삭제사유
	String create_user = "";// 생성자
	String create_date = "";// 생성일
	String update_user = "";// 수정자
	String update_date = "";// 수정일
	String delete_user = "";// 삭제자
	String delete_date = "";// 삭제일
	String delete_yn = "";// 삭제여부

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

	public WOrgCultureDigMngVo() {
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
	}

	public int getNO() {
		return NO;
	}

	public void setNO(int nO) {
		NO = nO;
	}

	public String getConsulting_action_no() {
		return consulting_action_no;
	}

	public void setConsulting_action_no(String consulting_action_no) {
		this.consulting_action_no = consulting_action_no;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getAction_consulting_type() {
		return action_consulting_type;
	}

	public void setAction_consulting_type(String action_consulting_type) {
		this.action_consulting_type = action_consulting_type;
	}

	public String getRegistration_date() {
		return registration_date;
	}

	public void setRegistration_date(String registration_date) {
		this.registration_date = registration_date;
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

	public String getAction_type_other_org_etc_txt() {
		return action_type_other_org_etc_txt;
	}

	public void setAction_type_other_org_etc_txt(String action_type_other_org_etc_txt) {
		this.action_type_other_org_etc_txt = action_type_other_org_etc_txt;
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

	public String getAction_type_servie_rel_etc_txt() {
		return action_type_servie_rel_etc_txt;
	}

	public void setAction_type_servie_rel_etc_txt(String action_type_servie_rel_etc_txt) {
		this.action_type_servie_rel_etc_txt = action_type_servie_rel_etc_txt;
	}

	public String getAction_type_etc_txt() {
		return action_type_etc_txt;
	}

	public void setAction_type_etc_txt(String action_type_etc_txt) {
		this.action_type_etc_txt = action_type_etc_txt;
	}

	public String getAction_type_other_org_etc() {
		return action_type_other_org_etc;
	}

	public void setAction_type_other_org_etc(String action_type_other_org_etc) {
		this.action_type_other_org_etc = action_type_other_org_etc;
	}

	public String getAction_type_servie_rel() {
		return action_type_servie_rel;
	}

	public void setAction_type_servie_rel(String action_type_servie_rel) {
		this.action_type_servie_rel = action_type_servie_rel;
	}

	public String getAction_type_servie_rel_etc() {
		return action_type_servie_rel_etc;
	}

	public void setAction_type_servie_rel_etc(String action_type_servie_rel_etc) {
		this.action_type_servie_rel_etc = action_type_servie_rel_etc;
	}

	public String getAction_type_etc() {
		return action_type_etc;
	}

	public void setAction_type_etc(String action_type_etc) {
		this.action_type_etc = action_type_etc;
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

	public String getCounselNum() {
		return counselNum;
	}

	public void setCounselNum(String counselNum) {
		this.counselNum = counselNum;
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

	public String getCreate_user() {
		return create_user;
	}

	public void setCreate_user(String create_user) {
		this.create_user = create_user;
	}

	public String getCreate_date() {
		return create_date;
	}

	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}

	public String getUpdate_user() {
		return update_user;
	}

	public void setUpdate_user(String update_user) {
		this.update_user = update_user;
	}

	public String getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}

	public String getDelete_user() {
		return delete_user;
	}

	public void setDelete_user(String delete_user) {
		this.delete_user = delete_user;
	}

	public String getDelete_date() {
		return delete_date;
	}

	public void setDelete_date(String delete_date) {
		this.delete_date = delete_date;
	}

	public String getDelete_yn() {
		return delete_yn;
	}

	public void setDelete_yn(String delete_yn) {
		this.delete_yn = delete_yn;
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

	public String getCounselName() {
		return counselName;
	}

	public void setCounselName(String counselName) {
		this.counselName = counselName;
	}

	public String getManager_name() {
		return manager_name;
	}

	public void setManager_name(String manager_name) {
		this.manager_name = manager_name;
	}

	public List<String> getManagerList() {
		return managerList;
	}

	public void setManagerList(List<String> managerList) {
		this.managerList = managerList;
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

	public String getCon_ac_type() {
		return con_ac_type;
	}

	public void setCon_ac_type(String con_ac_type) {
		this.con_ac_type = con_ac_type;
	}

}