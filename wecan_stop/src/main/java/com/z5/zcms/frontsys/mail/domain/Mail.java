package com.z5.zcms.frontsys.mail.domain;

import java.io.Serializable;
import java.util.List;

import com.z5.zcms.admsys.common.domain.CommonVo;

@SuppressWarnings("serial")
public class Mail  extends CommonVo implements Serializable {
	private String idx;
	private String title;
	private String conts;
	private String reservedate;
	private String reservetime;
	private String reservemin;
	private String sendType;
	private String status;
	private String ref;
	private String regdate;
	private String sended;
	private String fromemail;
	private String isendless;
	private String usernos;
	private List<String> listUsernos;
	
	private String useremail;
	private String work_grade;
	
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getWork_grade() {
		return work_grade;
	}
	public void setWork_grade(String work_grade) {
		this.work_grade = work_grade;
	}
	public List<String> getListUsernos() {
		return listUsernos;
	}
	public void setListUsernos(List<String> listUsernos) {
		this.listUsernos = listUsernos;
	}
	public String getUsernos() {
		return usernos;
	}
	public void setUsernos(String usernos) {
		this.usernos = usernos;
	}
	public String getReservetime() {
		return reservetime;
	}
	public void setReservetime(String reservetime) {
		this.reservetime = reservetime;
	}
	public String getIsendless() {
		return isendless;
	}
	public void setIsendless(String isendless) {
		this.isendless = isendless;
	}
	public String getSended() {
		return sended;
	}
	public void setSended(String sended) {
		this.sended = sended;
	}
	public String getReservedate() {
		return reservedate;
	}
	public void setReservedate(String reservedate) {
		this.reservedate = reservedate;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public String getIdx() {
		return idx;
	}
	public void setIdx(String idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getConts() {
		return conts;
	}
	public void setConts(String conts) {
		this.conts = conts;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getReservemin() {
		return reservemin;
	}
	public void setReservemin(String reservemin) {
		this.reservemin = reservemin;
	}
	public String getSendType() {
		return sendType;
	}
	public void setSendType(String sendType) {
		this.sendType = sendType;
	}
	public String getFromemail() {
		return fromemail;
	}
	public void setFromemail(String fromemail) {
		this.fromemail = fromemail;
	}
	
		
}
