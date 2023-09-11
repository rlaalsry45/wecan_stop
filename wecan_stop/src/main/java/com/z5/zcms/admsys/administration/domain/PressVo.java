package com.z5.zcms.admsys.administration.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.z5.zcms.admsys.common.domain.CommonVo;

public class PressVo extends CommonVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1060482233898469239L;

	int NO = 0;// 번호
	String article_title = "";
	String rel_event_name = "";
	String rel_event_no = "";
	String rel_event_url = "";
	String create_user = "";
	String create_date = "";
	String update_user = "";
	String update_date = "";
	String delete_user = "";
	String delete_date = "";
	String delete_yn = "";
	String retStatus = "";
	String retMessage = "";
	String mode = "";
	int rownum_ = 0;
	String protocol_type = "";
	String create_userName = "";

	List<String> delList = new ArrayList<String>();
	List<String> actionNoList = new ArrayList<String>();
	List<String> consultingNoList = new ArrayList<String>();
	List<String> pressNoList = new ArrayList<String>();
	List<String> fileList = new ArrayList<String>();
	String con_ac_type = "";

	List<PressRelVo> acRelList = new ArrayList<PressRelVo>();
	List<PressRelVo> conRelList = new ArrayList<PressRelVo>();
	List<String> conAcPressNoList = new ArrayList<String>();
	// 추후 파일 목록 필요

	public int getNO() {
		return NO;
	}

	public void setNO(int nO) {
		NO = nO;
	}

	public String getArticle_title() {
		return article_title;
	}

	public void setArticle_title(String article_title) {
		this.article_title = article_title;
	}

	public String getRel_event_name() {
		return rel_event_name;
	}

	public void setRel_event_name(String rel_event_name) {
		this.rel_event_name = rel_event_name;
	}

	public String getRel_event_no() {
		return rel_event_no;
	}

	public void setRel_event_no(String rel_event_no) {
		this.rel_event_no = rel_event_no;
	}

	public String getRel_event_url() {
		return rel_event_url;
	}

	public void setRel_event_url(String rel_event_url) {
		this.rel_event_url = rel_event_url;
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

	public int getRownum_() {
		return rownum_;
	}

	public void setRownum_(int rownum_) {
		this.rownum_ = rownum_;
	}

	public List<String> getActionNoList() {
		return actionNoList;
	}

	public void setActionNoList(List<String> actionNoList) {
		this.actionNoList = actionNoList;
	}

	public List<String> getDelList() {
		return delList;
	}

	public void setDelList(List<String> delList) {
		this.delList = delList;
	}

	public List<String> getFileList() {
		return fileList;
	}

	public void setFileList(List<String> fileList) {
		this.fileList = fileList;
	}

	public String getCon_ac_type() {
		return con_ac_type;
	}

	public void setCon_ac_type(String con_ac_type) {
		this.con_ac_type = con_ac_type;
	}

	public List<PressRelVo> getAcRelList() {
		return acRelList;
	}

	public void setAcRelList(List<PressRelVo> acRelList) {
		this.acRelList = acRelList;
	}

	public List<PressRelVo> getConRelList() {
		return conRelList;
	}

	public void setConRelList(List<PressRelVo> conRelList) {
		this.conRelList = conRelList;
	}

	public List<String> getConAcPressNoList() {
		return conAcPressNoList;
	}

	public void setConAcPressNoList(List<String> conAcPressNoList) {
		this.conAcPressNoList = conAcPressNoList;
	}

	public List<String> getConsultingNoList() {
		return consultingNoList;
	}

	public void setConsultingNoList(List<String> consultingNoList) {
		this.consultingNoList = consultingNoList;
	}

	public List<String> getPressNoList() {
		return pressNoList;
	}

	public void setPressNoList(List<String> pressNoList) {
		this.pressNoList = pressNoList;
	}

	public String getProtocol_type() {
		return protocol_type;
	}

	public void setProtocol_type(String protocol_type) {
		this.protocol_type = protocol_type;
	}

	public String getCreate_userName() {
		return create_userName;
	}

	public void setCreate_userName(String create_userName) {
		this.create_userName = create_userName;
	}

}
