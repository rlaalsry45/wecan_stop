package com.z5.zcms.admsys.consultingmng.domain;

import java.util.ArrayList;
import java.util.List;

import com.z5.zcms.admsys.common.domain.CommonVo;

public class WConsultingOldMngVo extends CommonVo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2136813525890473407L;

	String counsel_month = ""; 
	String counsel_date= ""; 
	String counsel_starttime= ""; 
	String counsel_endtime= ""; 
	int NO= 0; 
	String manager= ""; 
	String received_type_tel= ""; 
	String received_type_mail= ""; 
	String received_type_visit= ""; 
	String received_type_move= ""; 
	String consulting_type= ""; 
	String consulting_type_public= ""; 
	String consulting_type_civil= ""; 
	String consulting_type_personal= ""; 
	String consulting_type_etc= ""; 
	String tel_type= ""; 
	String contact_tel_no= ""; 
	String consulting_req_type= ""; 
	String consulting_req_type_relaccident= ""; 
	String consulting_req_type_simple= ""; 
	String consulting_req_type_etc= ""; 
	String client_name= ""; 
	String client_gender_female= ""; 
	String client_gender_male= ""; 
	String client_gender_unknown= ""; 
	String client_belong= ""; 
	String client_victim_rel_type_me= ""; 
	String client_victim_rel_type_agent= ""; 
	String client_victim_rel_type_relmanager= ""; 
	String client_victim_rel_type_doer= ""; 
	String client_victim_rel_type_etc= ""; 
	String client_victim_rel_type_etc_txt= ""; 
	String victim_name= ""; 
	String victim_gender_type_female= ""; 
	String victim_gender_type_male= ""; 
	String victim_gender_type_unknown= ""; 
	String victim_gender_type_none= ""; 
	String victim_belong= ""; 
	String offender_name= ""; 
	String offender_gender_type_female= ""; 
	String offender_gender_type_male= ""; 
	String offender_gender_type_unknown= ""; 
	String offender_gender_type_none= ""; 
	String offender_belong= ""; 
	String offender_victim_rel_type_boss= ""; 
	String offender_victim_rel_type_senior= ""; 
	String offender_victim_rel_type_partner= ""; 
	String offender_victim_rel_type_otherrel= ""; 
	String offender_victim_rel_type_etc= ""; 
	String offender_victim_rel_type_etc_txt= ""; 
	String offender_victim_rel_type_unknown= ""; 
	String harm_first_type_rape= ""; 
	String harm_first_type_harass= ""; 
	String harm_first_type_verbal= ""; 
	String harm_first_type_visual= ""; 
	String harm_first_type_etc= ""; 
	String harm_sec_type= ""; 
	String harm_sec_type_security= ""; 
	String harm_sec_type_seprate= ""; 
	String harm_sec_type_intention= ""; 
	String harm_sec_type_identity= ""; 
	String harm_sec_etc= ""; 
	String harm_sec_etc_txt= ""; 
	String harm_etc= ""; 
	String harm_etc_txt= ""; 
	String harm_first_type_sexism= ""; 
	String harm_first_type_unknown= ""; 
	String harm_first_type_none= ""; 
	String response_type_info= ""; 
	String response_type_advice= ""; 
	String response_type_intro_org= ""; 
	String response_type_intro_org_women= ""; 
	String response_type_intro_org_labor= ""; 
	String response_type_intro_org_police= ""; 
	String response_type_intro_org_education= ""; 
	String response_type_intro_org_human= ""; 
	String response_type_intro_org_etc= ""; 
	String response_type_intro_org_etc_txt= ""; 
	String response_type_service_rel_1= ""; 
	String response_type_service_rel_2= ""; 
	String response_type_service_rel_3= ""; 
	String response_type_service_rel_4= ""; 
	String response_type_service_rel_5= ""; 
	String response_type_etc= ""; 
	String response_type_etc_txt= ""; 
	String consulting_contents= ""; 
	String consulting_contents_etc= ""; 
	String contact_method_type_internet= ""; 
	String contact_method_type_support= ""; 
	String contact_method_type_gov= ""; 
	String contact_method_type_etc= ""; 
	String contact_method_type_etc_txt= ""; 
	String contact_method_type_unknown= ""; 
	String continue_consulting= ""; 
	String add_call_time_1= ""; 
	String add_call_time_2= ""; 
	String time= "";
	
	
	public String getCounsel_month() {
		return counsel_month;
	}
	public void setCounsel_month(String counsel_month) {
		this.counsel_month = counsel_month;
	}
	public String getCounsel_date() {
		return counsel_date;
	}
	public void setCounsel_date(String counsel_date) {
		this.counsel_date = counsel_date;
	}
	public String getCounsel_starttime() {
		return counsel_starttime;
	}
	public void setCounsel_starttime(String counsel_starttime) {
		this.counsel_starttime = counsel_starttime;
	}
	public String getCounsel_endtime() {
		return counsel_endtime;
	}
	public void setCounsel_endtime(String counsel_endtime) {
		this.counsel_endtime = counsel_endtime;
	}
	public int getNO() {
		return NO;
	}
	public void setNO(int nO) {
		NO = nO;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getReceived_type_tel() {
		return received_type_tel;
	}
	public void setReceived_type_tel(String received_type_tel) {
		this.received_type_tel = received_type_tel;
	}
	public String getReceived_type_mail() {
		return received_type_mail;
	}
	public void setReceived_type_mail(String received_type_mail) {
		this.received_type_mail = received_type_mail;
	}
	public String getReceived_type_visit() {
		return received_type_visit;
	}
	public void setReceived_type_visit(String received_type_visit) {
		this.received_type_visit = received_type_visit;
	}
	public String getReceived_type_move() {
		return received_type_move;
	}
	public void setReceived_type_move(String received_type_move) {
		this.received_type_move = received_type_move;
	}
	public String getConsulting_type() {
		return consulting_type;
	}
	public void setConsulting_type(String consulting_type) {
		this.consulting_type = consulting_type;
	}
	public String getConsulting_type_public() {
		return consulting_type_public;
	}
	public void setConsulting_type_public(String consulting_type_public) {
		this.consulting_type_public = consulting_type_public;
	}
	public String getConsulting_type_civil() {
		return consulting_type_civil;
	}
	public void setConsulting_type_civil(String consulting_type_civil) {
		this.consulting_type_civil = consulting_type_civil;
	}
	public String getConsulting_type_personal() {
		return consulting_type_personal;
	}
	public void setConsulting_type_personal(String consulting_type_personal) {
		this.consulting_type_personal = consulting_type_personal;
	}
	public String getConsulting_type_etc() {
		return consulting_type_etc;
	}
	public void setConsulting_type_etc(String consulting_type_etc) {
		this.consulting_type_etc = consulting_type_etc;
	}
	public String getTel_type() {
		return tel_type;
	}
	public void setTel_type(String tel_type) {
		this.tel_type = tel_type;
	}
	public String getContact_tel_no() {
		return contact_tel_no;
	}
	public void setContact_tel_no(String contact_tel_no) {
		this.contact_tel_no = contact_tel_no;
	}
	public String getConsulting_req_type() {
		return consulting_req_type;
	}
	public void setConsulting_req_type(String consulting_req_type) {
		this.consulting_req_type = consulting_req_type;
	}
	public String getConsulting_req_type_relaccident() {
		return consulting_req_type_relaccident;
	}
	public void setConsulting_req_type_relaccident(String consulting_req_type_relaccident) {
		this.consulting_req_type_relaccident = consulting_req_type_relaccident;
	}
	public String getConsulting_req_type_simple() {
		return consulting_req_type_simple;
	}
	public void setConsulting_req_type_simple(String consulting_req_type_simple) {
		this.consulting_req_type_simple = consulting_req_type_simple;
	}
	public String getConsulting_req_type_etc() {
		return consulting_req_type_etc;
	}
	public void setConsulting_req_type_etc(String consulting_req_type_etc) {
		this.consulting_req_type_etc = consulting_req_type_etc;
	}
	public String getClient_name() {
		return client_name;
	}
	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}
	public String getClient_gender_female() {
		return client_gender_female;
	}
	public void setClient_gender_female(String client_gender_female) {
		this.client_gender_female = client_gender_female;
	}
	public String getClient_gender_male() {
		return client_gender_male;
	}
	public void setClient_gender_male(String client_gender_male) {
		this.client_gender_male = client_gender_male;
	}
	public String getClient_gender_unknown() {
		return client_gender_unknown;
	}
	public void setClient_gender_unknown(String client_gender_unknown) {
		this.client_gender_unknown = client_gender_unknown;
	}
	public String getClient_belong() {
		return client_belong;
	}
	public void setClient_belong(String client_belong) {
		this.client_belong = client_belong;
	}
	public String getClient_victim_rel_type_me() {
		return client_victim_rel_type_me;
	}
	public void setClient_victim_rel_type_me(String client_victim_rel_type_me) {
		this.client_victim_rel_type_me = client_victim_rel_type_me;
	}
	public String getClient_victim_rel_type_agent() {
		return client_victim_rel_type_agent;
	}
	public void setClient_victim_rel_type_agent(String client_victim_rel_type_agent) {
		this.client_victim_rel_type_agent = client_victim_rel_type_agent;
	}
	public String getClient_victim_rel_type_relmanager() {
		return client_victim_rel_type_relmanager;
	}
	public void setClient_victim_rel_type_relmanager(String client_victim_rel_type_relmanager) {
		this.client_victim_rel_type_relmanager = client_victim_rel_type_relmanager;
	}
	public String getClient_victim_rel_type_doer() {
		return client_victim_rel_type_doer;
	}
	public void setClient_victim_rel_type_doer(String client_victim_rel_type_doer) {
		this.client_victim_rel_type_doer = client_victim_rel_type_doer;
	}
	public String getClient_victim_rel_type_etc() {
		return client_victim_rel_type_etc;
	}
	public void setClient_victim_rel_type_etc(String client_victim_rel_type_etc) {
		this.client_victim_rel_type_etc = client_victim_rel_type_etc;
	}
	public String getClient_victim_rel_type_etc_txt() {
		return client_victim_rel_type_etc_txt;
	}
	public void setClient_victim_rel_type_etc_txt(String client_victim_rel_type_etc_txt) {
		this.client_victim_rel_type_etc_txt = client_victim_rel_type_etc_txt;
	}
	public String getVictim_name() {
		return victim_name;
	}
	public void setVictim_name(String victim_name) {
		this.victim_name = victim_name;
	}
	public String getVictim_gender_type_female() {
		return victim_gender_type_female;
	}
	public void setVictim_gender_type_female(String victim_gender_type_female) {
		this.victim_gender_type_female = victim_gender_type_female;
	}
	public String getVictim_gender_type_male() {
		return victim_gender_type_male;
	}
	public void setVictim_gender_type_male(String victim_gender_type_male) {
		this.victim_gender_type_male = victim_gender_type_male;
	}
	public String getVictim_gender_type_unknown() {
		return victim_gender_type_unknown;
	}
	public void setVictim_gender_type_unknown(String victim_gender_type_unknown) {
		this.victim_gender_type_unknown = victim_gender_type_unknown;
	}
	public String getVictim_gender_type_none() {
		return victim_gender_type_none;
	}
	public void setVictim_gender_type_none(String victim_gender_type_none) {
		this.victim_gender_type_none = victim_gender_type_none;
	}
	public String getVictim_belong() {
		return victim_belong;
	}
	public void setVictim_belong(String victim_belong) {
		this.victim_belong = victim_belong;
	}
	public String getOffender_name() {
		return offender_name;
	}
	public void setOffender_name(String offender_name) {
		this.offender_name = offender_name;
	}
	public String getOffender_gender_type_female() {
		return offender_gender_type_female;
	}
	public void setOffender_gender_type_female(String offender_gender_type_female) {
		this.offender_gender_type_female = offender_gender_type_female;
	}
	public String getOffender_gender_type_male() {
		return offender_gender_type_male;
	}
	public void setOffender_gender_type_male(String offender_gender_type_male) {
		this.offender_gender_type_male = offender_gender_type_male;
	}
	public String getOffender_gender_type_unknown() {
		return offender_gender_type_unknown;
	}
	public void setOffender_gender_type_unknown(String offender_gender_type_unknown) {
		this.offender_gender_type_unknown = offender_gender_type_unknown;
	}
	public String getOffender_gender_type_none() {
		return offender_gender_type_none;
	}
	public void setOffender_gender_type_none(String offender_gender_type_none) {
		this.offender_gender_type_none = offender_gender_type_none;
	}
	public String getOffender_belong() {
		return offender_belong;
	}
	public void setOffender_belong(String offender_belong) {
		this.offender_belong = offender_belong;
	}
	public String getOffender_victim_rel_type_boss() {
		return offender_victim_rel_type_boss;
	}
	public void setOffender_victim_rel_type_boss(String offender_victim_rel_type_boss) {
		this.offender_victim_rel_type_boss = offender_victim_rel_type_boss;
	}
	public String getOffender_victim_rel_type_senior() {
		return offender_victim_rel_type_senior;
	}
	public void setOffender_victim_rel_type_senior(String offender_victim_rel_type_senior) {
		this.offender_victim_rel_type_senior = offender_victim_rel_type_senior;
	}
	public String getOffender_victim_rel_type_partner() {
		return offender_victim_rel_type_partner;
	}
	public void setOffender_victim_rel_type_partner(String offender_victim_rel_type_partner) {
		this.offender_victim_rel_type_partner = offender_victim_rel_type_partner;
	}
	public String getOffender_victim_rel_type_otherrel() {
		return offender_victim_rel_type_otherrel;
	}
	public void setOffender_victim_rel_type_otherrel(String offender_victim_rel_type_otherrel) {
		this.offender_victim_rel_type_otherrel = offender_victim_rel_type_otherrel;
	}
	public String getOffender_victim_rel_type_etc() {
		return offender_victim_rel_type_etc;
	}
	public void setOffender_victim_rel_type_etc(String offender_victim_rel_type_etc) {
		this.offender_victim_rel_type_etc = offender_victim_rel_type_etc;
	}
	public String getOffender_victim_rel_type_etc_txt() {
		return offender_victim_rel_type_etc_txt;
	}
	public void setOffender_victim_rel_type_etc_txt(String offender_victim_rel_type_etc_txt) {
		this.offender_victim_rel_type_etc_txt = offender_victim_rel_type_etc_txt;
	}
	public String getOffender_victim_rel_type_unknown() {
		return offender_victim_rel_type_unknown;
	}
	public void setOffender_victim_rel_type_unknown(String offender_victim_rel_type_unknown) {
		this.offender_victim_rel_type_unknown = offender_victim_rel_type_unknown;
	}
	public String getHarm_first_type_rape() {
		return harm_first_type_rape;
	}
	public void setHarm_first_type_rape(String harm_first_type_rape) {
		this.harm_first_type_rape = harm_first_type_rape;
	}
	public String getHarm_first_type_harass() {
		return harm_first_type_harass;
	}
	public void setHarm_first_type_harass(String harm_first_type_harass) {
		this.harm_first_type_harass = harm_first_type_harass;
	}
	public String getHarm_first_type_verbal() {
		return harm_first_type_verbal;
	}
	public void setHarm_first_type_verbal(String harm_first_type_verbal) {
		this.harm_first_type_verbal = harm_first_type_verbal;
	}
	public String getHarm_first_type_visual() {
		return harm_first_type_visual;
	}
	public void setHarm_first_type_visual(String harm_first_type_visual) {
		this.harm_first_type_visual = harm_first_type_visual;
	}
	public String getHarm_first_type_etc() {
		return harm_first_type_etc;
	}
	public void setHarm_first_type_etc(String harm_first_type_etc) {
		this.harm_first_type_etc = harm_first_type_etc;
	}
	public String getHarm_sec_type() {
		return harm_sec_type;
	}
	public void setHarm_sec_type(String harm_sec_type) {
		this.harm_sec_type = harm_sec_type;
	}
	public String getHarm_sec_type_security() {
		return harm_sec_type_security;
	}
	public void setHarm_sec_type_security(String harm_sec_type_security) {
		this.harm_sec_type_security = harm_sec_type_security;
	}
	public String getHarm_sec_type_seprate() {
		return harm_sec_type_seprate;
	}
	public void setHarm_sec_type_seprate(String harm_sec_type_seprate) {
		this.harm_sec_type_seprate = harm_sec_type_seprate;
	}
	public String getHarm_sec_type_intention() {
		return harm_sec_type_intention;
	}
	public void setHarm_sec_type_intention(String harm_sec_type_intention) {
		this.harm_sec_type_intention = harm_sec_type_intention;
	}
	public String getHarm_sec_type_identity() {
		return harm_sec_type_identity;
	}
	public void setHarm_sec_type_identity(String harm_sec_type_identity) {
		this.harm_sec_type_identity = harm_sec_type_identity;
	}
	public String getHarm_sec_etc() {
		return harm_sec_etc;
	}
	public void setHarm_sec_etc(String harm_sec_etc) {
		this.harm_sec_etc = harm_sec_etc;
	}
	public String getHarm_sec_etc_txt() {
		return harm_sec_etc_txt;
	}
	public void setHarm_sec_etc_txt(String harm_sec_etc_txt) {
		this.harm_sec_etc_txt = harm_sec_etc_txt;
	}
	public String getHarm_etc() {
		return harm_etc;
	}
	public void setHarm_etc(String harm_etc) {
		this.harm_etc = harm_etc;
	}
	public String getHarm_etc_txt() {
		return harm_etc_txt;
	}
	public void setHarm_etc_txt(String harm_etc_txt) {
		this.harm_etc_txt = harm_etc_txt;
	}
	public String getHarm_first_type_sexism() {
		return harm_first_type_sexism;
	}
	public void setHarm_first_type_sexism(String harm_first_type_sexism) {
		this.harm_first_type_sexism = harm_first_type_sexism;
	}
	public String getHarm_first_type_unknown() {
		return harm_first_type_unknown;
	}
	public void setHarm_first_type_unknown(String harm_first_type_unknown) {
		this.harm_first_type_unknown = harm_first_type_unknown;
	}
	public String getHarm_first_type_none() {
		return harm_first_type_none;
	}
	public void setHarm_first_type_none(String harm_first_type_none) {
		this.harm_first_type_none = harm_first_type_none;
	}
	public String getResponse_type_info() {
		return response_type_info;
	}
	public void setResponse_type_info(String response_type_info) {
		this.response_type_info = response_type_info;
	}
	public String getResponse_type_advice() {
		return response_type_advice;
	}
	public void setResponse_type_advice(String response_type_advice) {
		this.response_type_advice = response_type_advice;
	}
	public String getResponse_type_intro_org() {
		return response_type_intro_org;
	}
	public void setResponse_type_intro_org(String response_type_intro_org) {
		this.response_type_intro_org = response_type_intro_org;
	}
	public String getResponse_type_intro_org_women() {
		return response_type_intro_org_women;
	}
	public void setResponse_type_intro_org_women(String response_type_intro_org_women) {
		this.response_type_intro_org_women = response_type_intro_org_women;
	}
	public String getResponse_type_intro_org_labor() {
		return response_type_intro_org_labor;
	}
	public void setResponse_type_intro_org_labor(String response_type_intro_org_labor) {
		this.response_type_intro_org_labor = response_type_intro_org_labor;
	}
	public String getResponse_type_intro_org_police() {
		return response_type_intro_org_police;
	}
	public void setResponse_type_intro_org_police(String response_type_intro_org_police) {
		this.response_type_intro_org_police = response_type_intro_org_police;
	}
	public String getResponse_type_intro_org_education() {
		return response_type_intro_org_education;
	}
	public void setResponse_type_intro_org_education(String response_type_intro_org_education) {
		this.response_type_intro_org_education = response_type_intro_org_education;
	}
	public String getResponse_type_intro_org_human() {
		return response_type_intro_org_human;
	}
	public void setResponse_type_intro_org_human(String response_type_intro_org_human) {
		this.response_type_intro_org_human = response_type_intro_org_human;
	}
	public String getResponse_type_intro_org_etc() {
		return response_type_intro_org_etc;
	}
	public void setResponse_type_intro_org_etc(String response_type_intro_org_etc) {
		this.response_type_intro_org_etc = response_type_intro_org_etc;
	}
	public String getResponse_type_intro_org_etc_txt() {
		return response_type_intro_org_etc_txt;
	}
	public void setResponse_type_intro_org_etc_txt(String response_type_intro_org_etc_txt) {
		this.response_type_intro_org_etc_txt = response_type_intro_org_etc_txt;
	}
	public String getResponse_type_service_rel_1() {
		return response_type_service_rel_1;
	}
	public void setResponse_type_service_rel_1(String response_type_service_rel_1) {
		this.response_type_service_rel_1 = response_type_service_rel_1;
	}
	public String getResponse_type_service_rel_2() {
		return response_type_service_rel_2;
	}
	public void setResponse_type_service_rel_2(String response_type_service_rel_2) {
		this.response_type_service_rel_2 = response_type_service_rel_2;
	}
	public String getResponse_type_service_rel_3() {
		return response_type_service_rel_3;
	}
	public void setResponse_type_service_rel_3(String response_type_service_rel_3) {
		this.response_type_service_rel_3 = response_type_service_rel_3;
	}
	public String getResponse_type_service_rel_4() {
		return response_type_service_rel_4;
	}
	public void setResponse_type_service_rel_4(String response_type_service_rel_4) {
		this.response_type_service_rel_4 = response_type_service_rel_4;
	}
	public String getResponse_type_service_rel_5() {
		return response_type_service_rel_5;
	}
	public void setResponse_type_service_rel_5(String response_type_service_rel_5) {
		this.response_type_service_rel_5 = response_type_service_rel_5;
	}
	public String getResponse_type_etc() {
		return response_type_etc;
	}
	public void setResponse_type_etc(String response_type_etc) {
		this.response_type_etc = response_type_etc;
	}
	public String getResponse_type_etc_txt() {
		return response_type_etc_txt;
	}
	public void setResponse_type_etc_txt(String response_type_etc_txt) {
		this.response_type_etc_txt = response_type_etc_txt;
	}
	public String getConsulting_contents() {
		return consulting_contents;
	}
	public void setConsulting_contents(String consulting_contents) {
		this.consulting_contents = consulting_contents;
	}
	public String getConsulting_contents_etc() {
		return consulting_contents_etc;
	}
	public void setConsulting_contents_etc(String consulting_contents_etc) {
		this.consulting_contents_etc = consulting_contents_etc;
	}
	public String getContact_method_type_internet() {
		return contact_method_type_internet;
	}
	public void setContact_method_type_internet(String contact_method_type_internet) {
		this.contact_method_type_internet = contact_method_type_internet;
	}
	public String getContact_method_type_support() {
		return contact_method_type_support;
	}
	public void setContact_method_type_support(String contact_method_type_support) {
		this.contact_method_type_support = contact_method_type_support;
	}
	public String getContact_method_type_gov() {
		return contact_method_type_gov;
	}
	public void setContact_method_type_gov(String contact_method_type_gov) {
		this.contact_method_type_gov = contact_method_type_gov;
	}
	public String getContact_method_type_etc() {
		return contact_method_type_etc;
	}
	public void setContact_method_type_etc(String contact_method_type_etc) {
		this.contact_method_type_etc = contact_method_type_etc;
	}
	public String getContact_method_type_etc_txt() {
		return contact_method_type_etc_txt;
	}
	public void setContact_method_type_etc_txt(String contact_method_type_etc_txt) {
		this.contact_method_type_etc_txt = contact_method_type_etc_txt;
	}
	public String getContact_method_type_unknown() {
		return contact_method_type_unknown;
	}
	public void setContact_method_type_unknown(String contact_method_type_unknown) {
		this.contact_method_type_unknown = contact_method_type_unknown;
	}
	public String getContinue_consulting() {
		return continue_consulting;
	}
	public void setContinue_consulting(String continue_consulting) {
		this.continue_consulting = continue_consulting;
	}
	public String getAdd_call_time_1() {
		return add_call_time_1;
	}
	public void setAdd_call_time_1(String add_call_time_1) {
		this.add_call_time_1 = add_call_time_1;
	}
	public String getAdd_call_time_2() {
		return add_call_time_2;
	}
	public void setAdd_call_time_2(String add_call_time_2) {
		this.add_call_time_2 = add_call_time_2;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

}