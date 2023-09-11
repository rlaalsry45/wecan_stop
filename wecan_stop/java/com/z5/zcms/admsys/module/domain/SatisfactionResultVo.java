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
	private String counselNo;
	private String counselclassificationname;
	private int score;
	
	private String change_askno;
	
	private int asknocnt1;
	private int asknocnt2;
	private int asknocnt3;
	private int asknocnt4;
	private int asknocnt5;
	
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
	public int getAsknocnt1() {
		return asknocnt1;
	}
	public void setAsknocnt1(int asknocnt1) {
		this.asknocnt1 = asknocnt1;
	}
	public int getAsknocnt2() {
		return asknocnt2;
	}
	public void setAsknocnt2(int asknocnt2) {
		this.asknocnt2 = asknocnt2;
	}
	public int getAsknocnt3() {
		return asknocnt3;
	}
	public void setAsknocnt3(int asknocnt3) {
		this.asknocnt3 = asknocnt3;
	}
	public int getAsknocnt4() {
		return asknocnt4;
	}
	public void setAsknocnt4(int asknocnt4) {
		this.asknocnt4 = asknocnt4;
	}
	public int getAsknocnt5() {
		return asknocnt5;
	}
	public void setAsknocnt5(int asknocnt5) {
		this.asknocnt5 = asknocnt5;
	}
	public String getCounselNo() {
		return counselNo;
	}
	public void setCounselNo(String counselNo) {
		this.counselNo = counselNo;
	}
	public String getCounselclassificationname() {
		return counselclassificationname;
	}
	public void setCounselclassificationname(String counselclassificationname) {
		this.counselclassificationname = counselclassificationname;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
}
