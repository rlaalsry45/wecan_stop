package com.z5.zcms.admsys.evnt.domain;

import java.util.List;

import com.z5.zcms.frontsys.archv.domain.ArchvFile;

public class EvntPartcptHistVO extends EvntPartcptHist{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6373916447038758642L;
	private String contact1;
	private String contact2;
	private String contact3;
	private String useraddrno1;
	private String useraddrno2;
	private String useraddr;
	private String useraddr2;
	private String menu_catgry_name_list;
	private String evnt_title;
	private String not_date;
	private String not_date_eng;
	private List<ArchvFile> filelist;
	private String filename;
	private String filerealname;
	private String not_applicant_limit;
	
	
	
	public String getNot_applicant_limit() {
		return not_applicant_limit;
	}
	public void setNot_applicant_limit(String not_applicant_limit) {
		this.not_applicant_limit = not_applicant_limit;
	}
	public String getNot_date_eng() {
		return not_date_eng;
	}
	public void setNot_date_eng(String not_date_eng) {
		this.not_date_eng = not_date_eng;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFilerealname() {
		return filerealname;
	}
	public void setFilerealname(String filerealname) {
		this.filerealname = filerealname;
	}
	public List<ArchvFile> getFilelist() {
		return filelist;
	}
	public void setFilelist(List<ArchvFile> filelist) {
		this.filelist = filelist;
	}
	public String getEvnt_title() {
		return evnt_title;
	}
	public void setEvnt_title(String evnt_title) {
		this.evnt_title = evnt_title;
	}
	public String getNot_date() {
		return not_date;
	}
	public void setNot_date(String not_date) {
		this.not_date = not_date;
	}
	public String getMenu_catgry_name_list() {
		return menu_catgry_name_list;
	}
	public void setMenu_catgry_name_list(String menu_catgry_name_list) {
		this.menu_catgry_name_list = menu_catgry_name_list;
	}
	public String getUseraddrno1() {
		return useraddrno1;
	}
	public void setUseraddrno1(String useraddrno1) {
		this.useraddrno1 = useraddrno1;
	}
	public String getUseraddrno2() {
		return useraddrno2;
	}
	public void setUseraddrno2(String useraddrno2) {
		this.useraddrno2 = useraddrno2;
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
	public String getContact1() {
		return contact1;
	}
	public void setContact1(String contact1) {
		this.contact1 = contact1;
	}
	public String getContact2() {
		return contact2;
	}
	public void setContact2(String contact2) {
		this.contact2 = contact2;
	}
	public String getContact3() {
		return contact3;
	}
	public void setContact3(String contact3) {
		this.contact3 = contact3;
	}
	
	

}
