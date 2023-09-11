package com.z5.zcms.admsys.evnt.domain;

import com.z5.zcms.admsys.common.domain.CommonVo;

public class Evnt extends CommonVo{

	private static final long serialVersionUID = -3340179653724202393L;
	
	private String evnt_no; 
	private String evnt_start_date; 
	private String evnt_end_date;
	private String prwin_date; 
	private String archv_no; 
	private int not_yn; 
	private String reg_date; 
	private String evnt_opt_cd;
	private String evnt_title;
	private String evnt_sumup;
	private String caution;
	private String evnt_cnt;
	private int evnt_use_yn;
	private int prwin_commit;
	private int user_list_show_yn;
	private int only_member_yn;
	
	
	
	
	public int getOnly_member_yn() {
		return only_member_yn;
	}
	public void setOnly_member_yn(int only_member_yn) {
		this.only_member_yn = only_member_yn;
	}
	public int getUser_list_show_yn() {
		return user_list_show_yn;
	}
	public void setUser_list_show_yn(int user_list_show_yn) {
		this.user_list_show_yn = user_list_show_yn;
	}
	public int getPrwin_commit() {
		return prwin_commit;
	}
	public void setPrwin_commit(int prwin_commit) {
		this.prwin_commit = prwin_commit;
	}
	public int getNot_yn() {
		return not_yn;
	}
	public void setNot_yn(int not_yn) {
		this.not_yn = not_yn;
	}
	public int getEvnt_use_yn() {
		return evnt_use_yn;
	}
	public void setEvnt_use_yn(int evnt_use_yn) {
		this.evnt_use_yn = evnt_use_yn;
	}
	public String getEvnt_cnt() {
		return evnt_cnt;
	}
	public void setEvnt_cnt(String evnt_cnt) {
		this.evnt_cnt = evnt_cnt;
	}
	public String getCaution() {
		return caution;
	}
	public void setCaution(String caution) {
		this.caution = caution;
	}
	public String getEvnt_sumup() {
		return evnt_sumup;
	}
	public void setEvnt_sumup(String evnt_sumup) {
		this.evnt_sumup = evnt_sumup;
	}
	public String getEvnt_title() {
		return evnt_title;
	}
	public void setEvnt_title(String evnt_title) {
		this.evnt_title = evnt_title;
	}
	public String getEvnt_no() {
		return evnt_no;
	}
	public void setEvnt_no(String evnt_no) {
		this.evnt_no = evnt_no;
	}
	
	public String getEvnt_start_date() {
		return evnt_start_date;
	}
	public void setEvnt_start_date(String evnt_start_date) {
		this.evnt_start_date = evnt_start_date;
	}
	public String getEvnt_end_date() {
		return evnt_end_date;
	}
	public void setEvnt_end_date(String evnt_end_date) {
		this.evnt_end_date = evnt_end_date;
	}
	public String getPrwin_date() {
		return prwin_date;
	}
	public void setPrwin_date(String prwin_date) {
		this.prwin_date = prwin_date;
	}
	public String getArchv_no() {
		return archv_no;
	}
	public void setArchv_no(String archv_no) {
		this.archv_no = archv_no;
	}

	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	public String getEvnt_opt_cd() {
		return evnt_opt_cd;
	}
	public void setEvnt_opt_cd(String evnt_opt_cd) {
		this.evnt_opt_cd = evnt_opt_cd;
	} 
	
	
}
