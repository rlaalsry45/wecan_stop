package com.z5.zcms.admsys.cyberCounsel.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import net.sourceforge.jtds.jdbc.DateTime;

public class WFamilyViolenceVo implements Serializable {
    private static final long serialVersionUID = 1L;
    private String idx; //번호
    private String num_1; //1번문항
    private String num_2; //2번문항
    private String num_3; //3번문항
    private String num_4; //4번문항
    private String num_5; //5번문항
    private String num_6; //6번문항
    private String num_7; //7번문항
    private String num_8; //8번문항
    private String num_9; //9번문항
    private String num_10; //10번문항
    private String regUser; //등록(수정)자
    private String datetime; //등록시간    
    private int n;
    private int m;
	String retStatus = "";
	String retMessage = "";
	String mode = "";    
	String keyword;
	String cond1;
	String cond2;
	String sdate;
	String edate;
	
	double num_1_2_count;
	double num_1_1_count;
	double num_1_total_count;
	
	double num_2_2_count;
	double num_2_1_count;
	double num_2_total_count;
	
	double num_3_2_count;
	double num_3_1_count;
	double num_3_total_count;
	
	double num_4_2_count;
	double num_4_1_count;
	double num_4_total_count;
	
	double num_5_2_count;
	double num_5_1_count;
	double num_5_total_count;
	
	double num_6_2_count;
	double num_6_1_count;
	double num_6_total_count;
	
	double num_7_2_count;
	double num_7_1_count;
	double num_7_total_count;
	
	double num_8_2_count;
	double num_8_1_count;
	double num_8_total_count;
	
	double num_9_2_count;
	double num_9_1_count;
	double num_9_total_count;
	
	double num_10_2_count;
	double num_10_1_count;
	double num_10_total_count;
	
	double num_1_sum;	
	double num_1_count;	
	
	double num_2_sum;	
	double num_2_count;	
	
	double num_3_sum;	
	double num_3_count;	
	
	double num_4_sum;	
	double num_4_count;	
	
	double num_5_sum;	
	double num_5_count;	
	
	double num_6_sum;	
	double num_6_count;	
	
	double num_7_sum;	
	double num_7_count;	
	
	double num_8_sum;	
	double num_8_count;	
	
	double num_9_sum;	
	double num_9_count;	
	
	double num_10_sum;	
	double num_10_count;
	
	
	
	public String getIdx() {
		return idx;
	}
	public void setIdx(String idx) {
		this.idx = idx;
	}
	public String getNum_1() {
		return num_1;
	}
	public void setNum_1(String num_1) {
		this.num_1 = num_1;
	}
	public String getNum_2() {
		return num_2;
	}
	public void setNum_2(String num_2) {
		this.num_2 = num_2;
	}
	public String getNum_3() {
		return num_3;
	}
	public void setNum_3(String num_3) {
		this.num_3 = num_3;
	}
	public String getNum_4() {
		return num_4;
	}
	public void setNum_4(String num_4) {
		this.num_4 = num_4;
	}
	public String getNum_5() {
		return num_5;
	}
	public void setNum_5(String num_5) {
		this.num_5 = num_5;
	}
	public String getNum_6() {
		return num_6;
	}
	public void setNum_6(String num_6) {
		this.num_6 = num_6;
	}
	public String getNum_7() {
		return num_7;
	}
	public void setNum_7(String num_7) {
		this.num_7 = num_7;
	}
	public String getNum_8() {
		return num_8;
	}
	public void setNum_8(String num_8) {
		this.num_8 = num_8;
	}
	public String getNum_9() {
		return num_9;
	}
	public void setNum_9(String num_9) {
		this.num_9 = num_9;
	}
	public String getNum_10() {
		return num_10;
	}
	public void setNum_10(String num_10) {
		this.num_10 = num_10;
	}
	public String getRegUser() {
		return regUser;
	}
	public void setRegUser(String regUser) {
		this.regUser = regUser;
	}
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	public int getM() {
		return m;
	}
	public void setM(int m) {
		this.m = m;
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
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
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
	public double getNum_1_2_count() {
		return num_1_2_count;
	}
	public void setNum_1_2_count(double num_1_2_count) {
		this.num_1_2_count = num_1_2_count;
	}
	public double getNum_1_1_count() {
		return num_1_1_count;
	}
	public void setNum_1_1_count(double num_1_1_count) {
		this.num_1_1_count = num_1_1_count;
	}
	public double getNum_1_total_count() {
		return num_1_total_count;
	}
	public void setNum_1_total_count(double num_1_total_count) {
		this.num_1_total_count = num_1_total_count;
	}
	public double getNum_2_2_count() {
		return num_2_2_count;
	}
	public void setNum_2_2_count(double num_2_2_count) {
		this.num_2_2_count = num_2_2_count;
	}
	public double getNum_2_1_count() {
		return num_2_1_count;
	}
	public void setNum_2_1_count(double num_2_1_count) {
		this.num_2_1_count = num_2_1_count;
	}
	public double getNum_2_total_count() {
		return num_2_total_count;
	}
	public void setNum_2_total_count(double num_2_total_count) {
		this.num_2_total_count = num_2_total_count;
	}
	public double getNum_3_2_count() {
		return num_3_2_count;
	}
	public void setNum_3_2_count(double num_3_2_count) {
		this.num_3_2_count = num_3_2_count;
	}
	public double getNum_3_1_count() {
		return num_3_1_count;
	}
	public void setNum_3_1_count(double num_3_1_count) {
		this.num_3_1_count = num_3_1_count;
	}
	public double getNum_3_total_count() {
		return num_3_total_count;
	}
	public void setNum_3_total_count(double num_3_total_count) {
		this.num_3_total_count = num_3_total_count;
	}
	public double getNum_4_2_count() {
		return num_4_2_count;
	}
	public void setNum_4_2_count(double num_4_2_count) {
		this.num_4_2_count = num_4_2_count;
	}
	public double getNum_4_1_count() {
		return num_4_1_count;
	}
	public void setNum_4_1_count(double num_4_1_count) {
		this.num_4_1_count = num_4_1_count;
	}
	public double getNum_4_total_count() {
		return num_4_total_count;
	}
	public void setNum_4_total_count(double num_4_total_count) {
		this.num_4_total_count = num_4_total_count;
	}
	public double getNum_5_2_count() {
		return num_5_2_count;
	}
	public void setNum_5_2_count(double num_5_2_count) {
		this.num_5_2_count = num_5_2_count;
	}
	public double getNum_5_1_count() {
		return num_5_1_count;
	}
	public void setNum_5_1_count(double num_5_1_count) {
		this.num_5_1_count = num_5_1_count;
	}
	public double getNum_5_total_count() {
		return num_5_total_count;
	}
	public void setNum_5_total_count(double num_5_total_count) {
		this.num_5_total_count = num_5_total_count;
	}
	public double getNum_6_2_count() {
		return num_6_2_count;
	}
	public void setNum_6_2_count(double num_6_2_count) {
		this.num_6_2_count = num_6_2_count;
	}
	public double getNum_6_1_count() {
		return num_6_1_count;
	}
	public void setNum_6_1_count(double num_6_1_count) {
		this.num_6_1_count = num_6_1_count;
	}
	public double getNum_6_total_count() {
		return num_6_total_count;
	}
	public void setNum_6_total_count(double num_6_total_count) {
		this.num_6_total_count = num_6_total_count;
	}
	public double getNum_7_2_count() {
		return num_7_2_count;
	}
	public void setNum_7_2_count(double num_7_2_count) {
		this.num_7_2_count = num_7_2_count;
	}
	public double getNum_7_1_count() {
		return num_7_1_count;
	}
	public void setNum_7_1_count(double num_7_1_count) {
		this.num_7_1_count = num_7_1_count;
	}
	public double getNum_7_total_count() {
		return num_7_total_count;
	}
	public void setNum_7_total_count(double num_7_total_count) {
		this.num_7_total_count = num_7_total_count;
	}
	public double getNum_8_2_count() {
		return num_8_2_count;
	}
	public void setNum_8_2_count(double num_8_2_count) {
		this.num_8_2_count = num_8_2_count;
	}
	public double getNum_8_1_count() {
		return num_8_1_count;
	}
	public void setNum_8_1_count(double num_8_1_count) {
		this.num_8_1_count = num_8_1_count;
	}
	public double getNum_8_total_count() {
		return num_8_total_count;
	}
	public void setNum_8_total_count(double num_8_total_count) {
		this.num_8_total_count = num_8_total_count;
	}
	public double getNum_9_2_count() {
		return num_9_2_count;
	}
	public void setNum_9_2_count(double num_9_2_count) {
		this.num_9_2_count = num_9_2_count;
	}
	public double getNum_9_1_count() {
		return num_9_1_count;
	}
	public void setNum_9_1_count(double num_9_1_count) {
		this.num_9_1_count = num_9_1_count;
	}
	public double getNum_9_total_count() {
		return num_9_total_count;
	}
	public void setNum_9_total_count(double num_9_total_count) {
		this.num_9_total_count = num_9_total_count;
	}
	public double getNum_10_2_count() {
		return num_10_2_count;
	}
	public void setNum_10_2_count(double num_10_2_count) {
		this.num_10_2_count = num_10_2_count;
	}
	public double getNum_10_1_count() {
		return num_10_1_count;
	}
	public void setNum_10_1_count(double num_10_1_count) {
		this.num_10_1_count = num_10_1_count;
	}
	public double getNum_10_total_count() {
		return num_10_total_count;
	}
	public void setNum_10_total_count(double num_10_total_count) {
		this.num_10_total_count = num_10_total_count;
	}
	public double getNum_1_sum() {
		return num_1_sum;
	}
	public void setNum_1_sum(double num_1_sum) {
		this.num_1_sum = num_1_sum;
	}
	public double getNum_1_count() {
		return num_1_count;
	}
	public void setNum_1_count(double num_1_count) {
		this.num_1_count = num_1_count;
	}
	public double getNum_2_sum() {
		return num_2_sum;
	}
	public void setNum_2_sum(double num_2_sum) {
		this.num_2_sum = num_2_sum;
	}
	public double getNum_2_count() {
		return num_2_count;
	}
	public void setNum_2_count(double num_2_count) {
		this.num_2_count = num_2_count;
	}
	public double getNum_3_sum() {
		return num_3_sum;
	}
	public void setNum_3_sum(double num_3_sum) {
		this.num_3_sum = num_3_sum;
	}
	public double getNum_3_count() {
		return num_3_count;
	}
	public void setNum_3_count(double num_3_count) {
		this.num_3_count = num_3_count;
	}
	public double getNum_4_sum() {
		return num_4_sum;
	}
	public void setNum_4_sum(double num_4_sum) {
		this.num_4_sum = num_4_sum;
	}
	public double getNum_4_count() {
		return num_4_count;
	}
	public void setNum_4_count(double num_4_count) {
		this.num_4_count = num_4_count;
	}
	public double getNum_5_sum() {
		return num_5_sum;
	}
	public void setNum_5_sum(double num_5_sum) {
		this.num_5_sum = num_5_sum;
	}
	public double getNum_5_count() {
		return num_5_count;
	}
	public void setNum_5_count(double num_5_count) {
		this.num_5_count = num_5_count;
	}
	public double getNum_6_sum() {
		return num_6_sum;
	}
	public void setNum_6_sum(double num_6_sum) {
		this.num_6_sum = num_6_sum;
	}
	public double getNum_6_count() {
		return num_6_count;
	}
	public void setNum_6_count(double num_6_count) {
		this.num_6_count = num_6_count;
	}
	public double getNum_7_sum() {
		return num_7_sum;
	}
	public void setNum_7_sum(double num_7_sum) {
		this.num_7_sum = num_7_sum;
	}
	public double getNum_7_count() {
		return num_7_count;
	}
	public void setNum_7_count(double num_7_count) {
		this.num_7_count = num_7_count;
	}
	public double getNum_8_sum() {
		return num_8_sum;
	}
	public void setNum_8_sum(double num_8_sum) {
		this.num_8_sum = num_8_sum;
	}
	public double getNum_8_count() {
		return num_8_count;
	}
	public void setNum_8_count(double num_8_count) {
		this.num_8_count = num_8_count;
	}
	public double getNum_9_sum() {
		return num_9_sum;
	}
	public void setNum_9_sum(double num_9_sum) {
		this.num_9_sum = num_9_sum;
	}
	public double getNum_9_count() {
		return num_9_count;
	}
	public void setNum_9_count(double num_9_count) {
		this.num_9_count = num_9_count;
	}
	public double getNum_10_sum() {
		return num_10_sum;
	}
	public void setNum_10_sum(double num_10_sum) {
		this.num_10_sum = num_10_sum;
	}
	public double getNum_10_count() {
		return num_10_count;
	}
	public void setNum_10_count(double num_10_count) {
		this.num_10_count = num_10_count;
	}	
	
	
	
}