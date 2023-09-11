package com.z5.zcms.frontsys.mail.domain;

import java.io.Serializable;

import com.z5.zcms.admsys.common.domain.CommonVo;

public class MailParticipant  extends CommonVo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2110235707650094288L;
	private String seq;
	private String idx;
	private String userno;
	private String userid;
	private String username;
	private String useremail;
	private String work_grade;
	private String sended;
	private String newsletter1;
	
	
	
	public String getNewsletter1() {
		return newsletter1;
	}
	public void setNewsletter1(String newsletter1) {
		this.newsletter1 = newsletter1;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getWork_grade() {
		return work_grade;
	}
	public void setWork_grade(String work_grade) {
		this.work_grade = work_grade;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getIdx() {
		return idx;
	}
	public void setIdx(String idx) {
		this.idx = idx;
	}
	public String getUserno() {
		return userno;
	}
	public void setUserno(String userno) {
		this.userno = userno;
	}
	public String getSended() {
		return sended;
	}
	public void setSended(String sended) {
		this.sended = sended;
	}
	
	
}
