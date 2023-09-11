package com.z5.zcms.admsys.evnt.domain;

import com.z5.zcms.admsys.common.domain.CommonVo;

public class EvntPartcptHist extends CommonVo{

		
	/**
	 * 
	 */
	private static final long serialVersionUID = 671411456734457869L;
	private String partcpt_hist_no; 
	private String prwin_yn; 
	private String userid;
	private String contact; 
	private String useraddr; 
	private String useraddr2;
	private String subscpt_date; 
	private String useraddrno; 
	private String evnt_no;
	private String extra_conts;
	private String additional_conts;
	private String username;
	private String not_cfg_no;
	
	public String getNot_cfg_no() {
		return not_cfg_no;
	}
	public void setNot_cfg_no(String not_cfg_no) {
		this.not_cfg_no = not_cfg_no;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getExtra_conts() {
		return extra_conts;
	}
	public void setExtra_conts(String extra_conts) {
		this.extra_conts = extra_conts;
	}
	public String getAdditional_conts() {
		return additional_conts;
	}
	public void setAdditional_conts(String additional_conts) {
		this.additional_conts = additional_conts;
	}
	public String getPartcpt_hist_no() {
		return partcpt_hist_no;
	}
	public void setPartcpt_hist_no(String partcpt_hist_no) {
		this.partcpt_hist_no = partcpt_hist_no;
	}
	public String getPrwin_yn() {
		return prwin_yn;
	}
	public void setPrwin_yn(String prwin_yn) {
		this.prwin_yn = prwin_yn;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getUseraddr() {
		return useraddr;
	}
	public void setUseraddr(String useraddr) {
		this.useraddr = useraddr;
	}
	public String getUseraddr2() {
		return useraddr2;
	}
	public void setUseraddr2(String useraddr2) {
		this.useraddr2 = useraddr2;
	}
	public String getSubscpt_date() {
		return subscpt_date;
	}
	public void setSubscpt_date(String subscpt_date) {
		this.subscpt_date = subscpt_date;
	}
	public String getUseraddrno() {
		return useraddrno;
	}
	public void setUseraddrno(String useraddrno) {
		this.useraddrno = useraddrno;
	}
	public String getEvnt_no() {
		return evnt_no;
	}
	public void setEvnt_no(String evnt_no) {
		this.evnt_no = evnt_no;
	}
	
}

