package com.z5.zcms.frontsys.front.domain;

import java.io.Serializable;

public class FrontApplicationVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1410416010539561129L;
	int NO = 0;
	String consulting_application_no = "";
	String atno_type = "";
	String atno_year = "";

	String org_type = "";
	String org_type_gov_detail = "";
	String org_name = "";
	String org_code = "";
	String upper_org_name = "";
	String upper_org_code = "";
	Integer org_member_count = 0;

	String belong_job_title = "";
	String org_client_name = "";
	String org_client_tel_no = "";
	String org_client_email = "";

	String accident_response_hist = "";
	String accident_date = "";
	String receipt_date = "";

	String harm_type_verbals = "";
	String harm_type_body = "";
	String harm_type_visual = "";
	String harm_type_second = "";
	String harm_type_etc = "";
	String harm_etc_txt = "";

	String accident_step = "";

	String application_etc_txt = "";

	String first_org_type_all = "";
	String first_org_type_inorg = "";
	String first_org_type_protect = "";
	String first_org_type_etc = "";
	String first_org_type_etc_txt = "";

	String dup_org_type_check = "";
	String dup_org_type_protect = "";
	String dup_org_type_all = "";
	String dup_org_type_inorg = "";
	String dup_org_type_etc = "";
	String dup_org_type_etc_txt = "";

	String wish_consulting_date_1 = "";
	String wish_consulting_date_2 = "";
	String wish_consulting_date_3 = "";
	String wish_consulting_date_4 = "";
	String wish_consulting_date_5 = "";
	String wish_consulting_date_1_yn = "";
	String wish_consulting_date_2_yn = "";
	String wish_consulting_date_3_yn = "";
	String wish_consulting_date_4_yn = "";
	String wish_consulting_date_5_yn = "";

	String reference_etc = "";
	String create_user = "";
	String create_date = "";
	String update_user = "";
	String update_date = "";
	String delete_user = "";
	String delete_date = "";
	String delete_yn = "";

	Integer step_status = 0;
	String step_status_name = "";
	String step_status_txt = "";

	private int m;
	private int n;

	private String cond1 = "";
	private String cond2 = "";
	private String keyword = "";
	private String sdate = "";
	private String edate = "";

	private String excelName = "";
	private String retStatus = "";
	private String acc_exists_yn = "";

	private String ORGANIZATION_ID = "";

	public FrontApplicationVo() {
		super();
		this.harm_type_verbals = "N";
		this.harm_type_body = "N";
		this.harm_type_visual = "N";
		this.harm_type_second = "N";
		this.harm_type_etc = "N";
		this.first_org_type_all = "N";
		this.first_org_type_inorg = "N";
		this.first_org_type_protect = "N";
		this.first_org_type_etc = "N";
		this.dup_org_type_check = "N";
		this.dup_org_type_protect = "N";
		this.dup_org_type_all = "N";
		this.dup_org_type_inorg = "N";
		this.dup_org_type_etc = "N";
		this.wish_consulting_date_1_yn = "N";
		this.wish_consulting_date_2_yn = "N";
		this.wish_consulting_date_3_yn = "N";
		this.wish_consulting_date_4_yn = "N";
		this.wish_consulting_date_5_yn = "N";
	}

	public int getNO() {
		return NO;
	}

	public void setNO(int nO) {
		NO = nO;
	}

	public String getConsulting_application_no() {
		return consulting_application_no;
	}

	public void setConsulting_application_no(String consulting_application_no) {
		this.consulting_application_no = consulting_application_no;
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

	public String getOrg_type() {
		return org_type;
	}

	public void setOrg_type(String org_type) {
		this.org_type = org_type;
	}

	public String getOrg_type_gov_detail() {
		return org_type_gov_detail;
	}

	public void setOrg_type_gov_detail(String org_type_gov_detail) {
		this.org_type_gov_detail = org_type_gov_detail;
	}

	public String getOrg_name() {
		return org_name;
	}

	public void setOrg_name(String org_name) {
		this.org_name = org_name;
	}

	public String getUpper_org_name() {
		return upper_org_name;
	}

	public void setUpper_org_name(String upper_org_name) {
		this.upper_org_name = upper_org_name;
	}

	public Integer getOrg_member_count() {
		return org_member_count;
	}

	public void setOrg_member_count(Integer org_member_count) {
		this.org_member_count = org_member_count;
	}

	public String getBelong_job_title() {
		return belong_job_title;
	}

	public void setBelong_job_title(String belong_job_title) {
		this.belong_job_title = belong_job_title;
	}

	public String getOrg_client_name() {
		return org_client_name;
	}

	public void setOrg_client_name(String org_client_name) {
		this.org_client_name = org_client_name;
	}

	public String getOrg_client_tel_no() {
		return org_client_tel_no;
	}

	public void setOrg_client_tel_no(String org_client_tel_no) {
		this.org_client_tel_no = org_client_tel_no;
	}

	public String getOrg_client_email() {
		return org_client_email;
	}

	public void setOrg_client_email(String org_client_email) {
		this.org_client_email = org_client_email;
	}

	public String getAccident_response_hist() {
		return accident_response_hist;
	}

	public void setAccident_response_hist(String accident_response_hist) {
		this.accident_response_hist = accident_response_hist;
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

	public String getHarm_etc_txt() {
		return harm_etc_txt;
	}

	public void setHarm_etc_txt(String harm_etc_txt) {
		this.harm_etc_txt = harm_etc_txt;
	}

	public String getAccident_step() {
		return accident_step;
	}

	public void setAccident_step(String accident_step) {
		this.accident_step = accident_step;
	}

	public String getApplication_etc_txt() {
		return application_etc_txt;
	}

	public void setApplication_etc_txt(String application_etc_txt) {
		this.application_etc_txt = application_etc_txt;
	}

	public String getFirst_org_type_all() {
		return first_org_type_all;
	}

	public void setFirst_org_type_all(String first_org_type_all) {
		this.first_org_type_all = first_org_type_all;
	}

	public String getFirst_org_type_inorg() {
		return first_org_type_inorg;
	}

	public void setFirst_org_type_inorg(String first_org_type_inorg) {
		this.first_org_type_inorg = first_org_type_inorg;
	}

	public String getFirst_org_type_protect() {
		return first_org_type_protect;
	}

	public void setFirst_org_type_protect(String first_org_type_protect) {
		this.first_org_type_protect = first_org_type_protect;
	}

	public String getFirst_org_type_etc() {
		return first_org_type_etc;
	}

	public void setFirst_org_type_etc(String first_org_type_etc) {
		this.first_org_type_etc = first_org_type_etc;
	}

	public String getFirst_org_type_etc_txt() {
		return first_org_type_etc_txt;
	}

	public void setFirst_org_type_etc_txt(String first_org_type_etc_txt) {
		this.first_org_type_etc_txt = first_org_type_etc_txt;
	}

	public String getDup_org_type_check() {
		return dup_org_type_check;
	}

	public void setDup_org_type_check(String dup_org_type_check) {
		this.dup_org_type_check = dup_org_type_check;
	}

	public String getDup_org_type_protect() {
		return dup_org_type_protect;
	}

	public void setDup_org_type_protect(String dup_org_type_protect) {
		this.dup_org_type_protect = dup_org_type_protect;
	}

	public String getDup_org_type_all() {
		return dup_org_type_all;
	}

	public void setDup_org_type_all(String dup_org_type_all) {
		this.dup_org_type_all = dup_org_type_all;
	}

	public String getDup_org_type_inorg() {
		return dup_org_type_inorg;
	}

	public void setDup_org_type_inorg(String dup_org_type_inorg) {
		this.dup_org_type_inorg = dup_org_type_inorg;
	}

	public String getDup_org_type_etc() {
		return dup_org_type_etc;
	}

	public void setDup_org_type_etc(String dup_org_type_etc) {
		this.dup_org_type_etc = dup_org_type_etc;
	}

	public String getDup_org_type_etc_txt() {
		return dup_org_type_etc_txt;
	}

	public void setDup_org_type_etc_txt(String dup_org_type_etc_txt) {
		this.dup_org_type_etc_txt = dup_org_type_etc_txt;
	}

	public String getWish_consulting_date_1() {
		return wish_consulting_date_1;
	}

	public void setWish_consulting_date_1(String wish_consulting_date_1) {
		this.wish_consulting_date_1 = wish_consulting_date_1;
	}

	public String getWish_consulting_date_2() {
		return wish_consulting_date_2;
	}

	public void setWish_consulting_date_2(String wish_consulting_date_2) {
		this.wish_consulting_date_2 = wish_consulting_date_2;
	}

	public String getWish_consulting_date_3() {
		return wish_consulting_date_3;
	}

	public void setWish_consulting_date_3(String wish_consulting_date_3) {
		this.wish_consulting_date_3 = wish_consulting_date_3;
	}

	public String getWish_consulting_date_4() {
		return wish_consulting_date_4;
	}

	public void setWish_consulting_date_4(String wish_consulting_date_4) {
		this.wish_consulting_date_4 = wish_consulting_date_4;
	}

	public String getWish_consulting_date_5() {
		return wish_consulting_date_5;
	}

	public void setWish_consulting_date_5(String wish_consulting_date_5) {
		this.wish_consulting_date_5 = wish_consulting_date_5;
	}

	public String getWish_consulting_date_1_yn() {
		return wish_consulting_date_1_yn;
	}

	public void setWish_consulting_date_1_yn(String wish_consulting_date_1_yn) {
		this.wish_consulting_date_1_yn = wish_consulting_date_1_yn;
	}

	public String getWish_consulting_date_2_yn() {
		return wish_consulting_date_2_yn;
	}

	public void setWish_consulting_date_2_yn(String wish_consulting_date_2_yn) {
		this.wish_consulting_date_2_yn = wish_consulting_date_2_yn;
	}

	public String getWish_consulting_date_3_yn() {
		return wish_consulting_date_3_yn;
	}

	public void setWish_consulting_date_3_yn(String wish_consulting_date_3_yn) {
		this.wish_consulting_date_3_yn = wish_consulting_date_3_yn;
	}

	public String getWish_consulting_date_4_yn() {
		return wish_consulting_date_4_yn;
	}

	public void setWish_consulting_date_4_yn(String wish_consulting_date_4_yn) {
		this.wish_consulting_date_4_yn = wish_consulting_date_4_yn;
	}

	public String getWish_consulting_date_5_yn() {
		return wish_consulting_date_5_yn;
	}

	public void setWish_consulting_date_5_yn(String wish_consulting_date_5_yn) {
		this.wish_consulting_date_5_yn = wish_consulting_date_5_yn;
	}

	public String getReference_etc() {
		return reference_etc;
	}

	public void setReference_etc(String reference_etc) {
		this.reference_etc = reference_etc;
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

	public Integer getStep_status() {
		return step_status;
	}

	public void setStep_status(Integer step_status) {
		this.step_status = step_status;
	}

	public String getOrg_code() {
		return org_code;
	}

	public void setOrg_code(String org_code) {
		this.org_code = org_code;
	}

	public String getUpper_org_code() {
		return upper_org_code;
	}

	public void setUpper_org_code(String upper_org_code) {
		this.upper_org_code = upper_org_code;
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
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

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
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

	public String getStep_status_name() {
		return step_status_name;
	}

	public void setStep_status_name(String step_status_name) {
		this.step_status_name = step_status_name;
	}

	public String getExcelName() {
		return excelName;
	}

	public void setExcelName(String excelName) {
		this.excelName = excelName;
	}

	public String getRetStatus() {
		return retStatus;
	}

	public void setRetStatus(String retStatus) {
		this.retStatus = retStatus;
	}

	public String getAcc_exists_yn() {
		return acc_exists_yn;
	}

	public void setAcc_exists_yn(String acc_exists_yn) {
		this.acc_exists_yn = acc_exists_yn;
	}

	public String getORGANIZATION_ID() {
		return ORGANIZATION_ID;
	}

	public void setORGANIZATION_ID(String oRGANIZATION_ID) {
		ORGANIZATION_ID = oRGANIZATION_ID;
	}

	public String getStep_status_txt() {
		return step_status_txt;
	}

	public void setStep_status_txt(String step_status_txt) {
		this.step_status_txt = step_status_txt;
	}

}
