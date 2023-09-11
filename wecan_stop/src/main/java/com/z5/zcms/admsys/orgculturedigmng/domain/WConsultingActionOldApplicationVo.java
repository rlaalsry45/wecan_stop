package com.z5.zcms.admsys.orgculturedigmng.domain;

import com.z5.zcms.admsys.common.domain.CommonVo;

public class WConsultingActionOldApplicationVo extends CommonVo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8738051679360090977L;

	private int NO; 
	private String consulting_action_no; 
	private String org_name; 
	private String selection_status; 
	private String unselected_standby; 
	private String application_date; 
	private String application_cancel; 
	private String consulting_schedule; 
	private String visit_schedule; 
	private String visit_complete; 
	private String manager; 
	private String manager_2; 
	private String contact_point; 
	private String upper_org_name; 
	private String consultant_1; 
	private String consultant_2; 
	private String consultant_3; 
	private String consulting_status; 
	private String time_of_dispatch; 
	private String consulting_type; 
	private String org_type_gov_detail; 
	private String org_type_gov_detail_national; 
	private String org_type_gov_detail_local; 
	private String org_type_gov_detail_public; 
	private String org_type_gov_detail_school; 
	private String org_type_gov_detail_university; 
	private String org_type_gov_detail_priv; 
	private String org_type_gov_detail_etc; 
	private String org_type_gov_detail_school_gubun; 
	private String org_type_gov_detail_public_gubun; 
	private String application_org_member; 
	private String accident_status; 
	private String accident; 
	private String accident_not; 
	private String accident_informal_processing; 
	private String accident_not_listed; 
	private String accident_date; 
	private String receipt_date; 
	private String harm_type_verbals; 
	private String harm_type_body; 
	private String harm_type_visual; 
	private String harm_type_second; 
	private String harm_type_etc; 
	private String harm_type_not_listed; 
	private String accident_step_1; 
	private String accident_step_2; 
	private String accident_step_3; 
	private String accident_step_4; 
	private String application_etc_txt; 
	private String application_reason;
	
	
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
	public String getOrg_name() {
		return org_name;
	}
	public void setOrg_name(String org_name) {
		this.org_name = org_name;
	}
	public String getSelection_status() {
		return selection_status;
	}
	public void setSelection_status(String selection_status) {
		this.selection_status = selection_status;
	}
	public String getUnselected_standby() {
		return unselected_standby;
	}
	public void setUnselected_standby(String unselected_standby) {
		this.unselected_standby = unselected_standby;
	}
	public String getApplication_date() {
		return application_date;
	}
	public void setApplication_date(String application_date) {
		this.application_date = application_date;
	}
	public String getApplication_cancel() {
		return application_cancel;
	}
	public void setApplication_cancel(String application_cancel) {
		this.application_cancel = application_cancel;
	}
	public String getConsulting_schedule() {
		return consulting_schedule;
	}
	public void setConsulting_schedule(String consulting_schedule) {
		this.consulting_schedule = consulting_schedule;
	}
	public String getVisit_schedule() {
		return visit_schedule;
	}
	public void setVisit_schedule(String visit_schedule) {
		this.visit_schedule = visit_schedule;
	}
	public String getVisit_complete() {
		return visit_complete;
	}
	public void setVisit_complete(String visit_complete) {
		this.visit_complete = visit_complete;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getManager_2() {
		return manager_2;
	}
	public void setManager_2(String manager_2) {
		this.manager_2 = manager_2;
	}
	public String getContact_point() {
		return contact_point;
	}
	public void setContact_point(String contact_point) {
		this.contact_point = contact_point;
	}
	public String getUpper_org_name() {
		return upper_org_name;
	}
	public void setUpper_org_name(String upper_org_name) {
		this.upper_org_name = upper_org_name;
	}
	public String getConsultant_1() {
		return consultant_1;
	}
	public void setConsultant_1(String consultant_1) {
		this.consultant_1 = consultant_1;
	}
	public String getConsultant_2() {
		return consultant_2;
	}
	public void setConsultant_2(String consultant_2) {
		this.consultant_2 = consultant_2;
	}
	public String getConsultant_3() {
		return consultant_3;
	}
	public void setConsultant_3(String consultant_3) {
		this.consultant_3 = consultant_3;
	}
	public String getConsulting_status() {
		return consulting_status;
	}
	public void setConsulting_status(String consulting_status) {
		this.consulting_status = consulting_status;
	}
	public String getTime_of_dispatch() {
		return time_of_dispatch;
	}
	public void setTime_of_dispatch(String time_of_dispatch) {
		this.time_of_dispatch = time_of_dispatch;
	}
	public String getConsulting_type() {
		return consulting_type;
	}
	public void setConsulting_type(String consulting_type) {
		this.consulting_type = consulting_type;
	}
	public String getOrg_type_gov_detail() {
		return org_type_gov_detail;
	}
	public void setOrg_type_gov_detail(String org_type_gov_detail) {
		this.org_type_gov_detail = org_type_gov_detail;
	}
	public String getOrg_type_gov_detail_national() {
		return org_type_gov_detail_national;
	}
	public void setOrg_type_gov_detail_national(String org_type_gov_detail_national) {
		this.org_type_gov_detail_national = org_type_gov_detail_national;
	}
	public String getOrg_type_gov_detail_local() {
		return org_type_gov_detail_local;
	}
	public void setOrg_type_gov_detail_local(String org_type_gov_detail_local) {
		this.org_type_gov_detail_local = org_type_gov_detail_local;
	}
	public String getOrg_type_gov_detail_public() {
		return org_type_gov_detail_public;
	}
	public void setOrg_type_gov_detail_public(String org_type_gov_detail_public) {
		this.org_type_gov_detail_public = org_type_gov_detail_public;
	}
	public String getOrg_type_gov_detail_school() {
		return org_type_gov_detail_school;
	}
	public void setOrg_type_gov_detail_school(String org_type_gov_detail_school) {
		this.org_type_gov_detail_school = org_type_gov_detail_school;
	}
	public String getOrg_type_gov_detail_university() {
		return org_type_gov_detail_university;
	}
	public void setOrg_type_gov_detail_university(String org_type_gov_detail_university) {
		this.org_type_gov_detail_university = org_type_gov_detail_university;
	}
	public String getOrg_type_gov_detail_priv() {
		return org_type_gov_detail_priv;
	}
	public void setOrg_type_gov_detail_priv(String org_type_gov_detail_priv) {
		this.org_type_gov_detail_priv = org_type_gov_detail_priv;
	}
	public String getOrg_type_gov_detail_etc() {
		return org_type_gov_detail_etc;
	}
	public void setOrg_type_gov_detail_etc(String org_type_gov_detail_etc) {
		this.org_type_gov_detail_etc = org_type_gov_detail_etc;
	}
	public String getOrg_type_gov_detail_school_gubun() {
		return org_type_gov_detail_school_gubun;
	}
	public void setOrg_type_gov_detail_school_gubun(String org_type_gov_detail_school_gubun) {
		this.org_type_gov_detail_school_gubun = org_type_gov_detail_school_gubun;
	}
	public String getOrg_type_gov_detail_public_gubun() {
		return org_type_gov_detail_public_gubun;
	}
	public void setOrg_type_gov_detail_public_gubun(String org_type_gov_detail_public_gubun) {
		this.org_type_gov_detail_public_gubun = org_type_gov_detail_public_gubun;
	}
	public String getApplication_org_member() {
		return application_org_member;
	}
	public void setApplication_org_member(String application_org_member) {
		this.application_org_member = application_org_member;
	}
	public String getAccident_status() {
		return accident_status;
	}
	public void setAccident_status(String accident_status) {
		this.accident_status = accident_status;
	}
	public String getAccident() {
		return accident;
	}
	public void setAccident(String accident) {
		this.accident = accident;
	}
	public String getAccident_not() {
		return accident_not;
	}
	public void setAccident_not(String accident_not) {
		this.accident_not = accident_not;
	}
	public String getAccident_informal_processing() {
		return accident_informal_processing;
	}
	public void setAccident_informal_processing(String accident_informal_processing) {
		this.accident_informal_processing = accident_informal_processing;
	}
	public String getAccident_not_listed() {
		return accident_not_listed;
	}
	public void setAccident_not_listed(String accident_not_listed) {
		this.accident_not_listed = accident_not_listed;
	}
	public String getAccident_date() {
		return accident_date;
	}
	public void setAccident_date(String accident_date) {
		this.accident_date = accident_date;
	}
	public String getReceipt_date() {
		return receipt_date;
	}
	public void setReceipt_date(String receipt_date) {
		this.receipt_date = receipt_date;
	}
	public String getHarm_type_verbals() {
		return harm_type_verbals;
	}
	public void setHarm_type_verbals(String harm_type_verbals) {
		this.harm_type_verbals = harm_type_verbals;
	}
	public String getHarm_type_body() {
		return harm_type_body;
	}
	public void setHarm_type_body(String harm_type_body) {
		this.harm_type_body = harm_type_body;
	}
	public String getHarm_type_visual() {
		return harm_type_visual;
	}
	public void setHarm_type_visual(String harm_type_visual) {
		this.harm_type_visual = harm_type_visual;
	}
	public String getHarm_type_second() {
		return harm_type_second;
	}
	public void setHarm_type_second(String harm_type_second) {
		this.harm_type_second = harm_type_second;
	}
	public String getHarm_type_etc() {
		return harm_type_etc;
	}
	public void setHarm_type_etc(String harm_type_etc) {
		this.harm_type_etc = harm_type_etc;
	}
	public String getHarm_type_not_listed() {
		return harm_type_not_listed;
	}
	public void setHarm_type_not_listed(String harm_type_not_listed) {
		this.harm_type_not_listed = harm_type_not_listed;
	}
	public String getAccident_step_1() {
		return accident_step_1;
	}
	public void setAccident_step_1(String accident_step_1) {
		this.accident_step_1 = accident_step_1;
	}
	public String getAccident_step_2() {
		return accident_step_2;
	}
	public void setAccident_step_2(String accident_step_2) {
		this.accident_step_2 = accident_step_2;
	}
	public String getAccident_step_3() {
		return accident_step_3;
	}
	public void setAccident_step_3(String accident_step_3) {
		this.accident_step_3 = accident_step_3;
	}
	public String getAccident_step_4() {
		return accident_step_4;
	}
	public void setAccident_step_4(String accident_step_4) {
		this.accident_step_4 = accident_step_4;
	}
	public String getApplication_etc_txt() {
		return application_etc_txt;
	}
	public void setApplication_etc_txt(String application_etc_txt) {
		this.application_etc_txt = application_etc_txt;
	}
	public String getApplication_reason() {
		return application_reason;
	}
	public void setApplication_reason(String application_reason) {
		this.application_reason = application_reason;
	}

}