package com.z5.zcms.admsys.module.domain;

import com.z5.zcms.admsys.common.domain.CommonVo;

public class SatisfactionResultVo extends CommonVo{

	private static final long serialVersionUID = -2904533167366016011L;

	private int no;
	private String counselclassification;
	private int counselclassificationnum;
	private int satisfactionno;
	private int askno;
	private String answer;
	private String regdate;
	
	private String change_askno;
	
	
	public String getChange_askno() {
		return change_askno;
	}
	public void setChange_askno(String change_askno) {
		this.change_askno = change_askno;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getCounselclassification() {
		return counselclassification;
	}
	public void setCounselclassification(String counselclassification) {
		this.counselclassification = counselclassification;
	}
	public int getCounselclassificationnum() {
		return counselclassificationnum;
	}
	public void setCounselclassificationnum(int counselclassificationnum) {
		this.counselclassificationnum = counselclassificationnum;
	}
	public int getSatisfactionno() {
		return satisfactionno;
	}
	public void setSatisfactionno(int satisfactionno) {
		this.satisfactionno = satisfactionno;
	}
	public int getAskno() {
		return askno;
	}
	public void setAskno(int askno) {
		this.askno = askno;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
}
