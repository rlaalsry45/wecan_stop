package com.z5.zcms.admsys.statisticsmng.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ZStatisticsMngVo implements Serializable {
	
	private static final long serialVersionUID = -3121061857173846435L;
		
	private String counselCnt;
	private String counselCnt01;
	private String counselCnt02;
	private String counselCnt03;
	private String counselCnt04;
	private String counselCnt05;
	private String counselCnt06;
	private String counselCnt07;
	private String counselCnt08;
	private String counselCnt09;
	private String counselCnt10;
	private String counselCnt11;
	private String counselCnt12;
	private String counselCnt13;
	private String counselCnt14;
	private String counselCnt15;
	
	private String consultingCnt01;
	private String consultingCnt02;
	private String consultingCnt03;
	private String consultingCnt04;
	private String consultingCnt05;
	private String consultingCnt06;
	private String consultingCnt07;
	private String consultingCnt08;
	private String consultingCnt09;
	private String consultingCnt10;
	private String consultingCnt11;
	private String consultingCnt12;
	private String consultingCnt13;
	private String consultingCnt14;
	private String consultingCnt15;
	private String consultingCnt16;
	
	private String satisfaction1;
	private String satisfactionCnt01_1;
	private String satisfactionCnt01_2;
	private String satisfactionCnt01_3;
	private String satisfactionCnt01_4;
	private String satisfactionCnt01_5;
	private String satisfactionCnt01_6;
	private String satisfactionCnt02_1;
	private String satisfactionCnt02_2;
	private String satisfactionCnt02_3;
	private String satisfactionCnt02_4;
	private String satisfactionCnt02_5;
	private String satisfactionCnt03_1;
	private String satisfactionCnt03_2;
	private String satisfactionCnt03_3;
	private String satisfactionCnt03_4;
	private String satisfactionCnt03_5;
	private String satisfactionCnt04_1;
	private String satisfactionCnt04_2;
	private String satisfactionCnt04_3;
	private String satisfactionCnt04_4;
	private String satisfactionCnt04_5;
	private String satisfactionCnt05_1;
	private String satisfactionCnt05_2;
	private String satisfactionCnt05_3;
	private String satisfactionCnt05_4;
	private String satisfactionCnt05_5;
	private String satisfactionCnt06_1;
	private String satisfactionCnt06_2;
	private String satisfactionCnt06_3;
	private String satisfactionCnt06_4;
	private String satisfactionCnt06_5;
	private String satisfactionCnt07_1;
	private String satisfactionCnt07_2;
	private String satisfactionCnt07_3;
	private String satisfactionCnt07_4;
	private String satisfactionCnt07_5;
	private String satisfactionCnt08_1;
	private String satisfactionCnt08_2;
	private String satisfactionCnt08_3;
	private String satisfactionCnt08_4;
	private String satisfactionCnt08_5;
	
	private String surveyType;
	private String surveyCnt00A_1;
	private String surveyCnt00A_2;	
	private String surveyCnt00B_1;
	private String surveyCnt00B_2;
	private String surveyCnt01_1A_1;
	private String surveyCnt01_1A_2;
	private String surveyCnt01_1A_3;
	private String surveyCnt01_1A_4;
	private String surveyCnt01_1B_1;
	private String surveyCnt01_1B_2;
	private String surveyCnt01_1B_3;
	private String surveyCnt01_1B_4;
	private String surveyCnt01_2A_1;
	private String surveyCnt01_2A_2;
	private String surveyCnt01_2A_3;
	private String surveyCnt01_2A_4;
	private String surveyCnt01_2B_1;
	private String surveyCnt01_2B_2;
	private String surveyCnt01_2B_3;
	private String surveyCnt01_2B_4;
	private String surveyCnt01_3A_1;
	private String surveyCnt01_3A_2;
	private String surveyCnt01_3A_3;
	private String surveyCnt01_3A_4;
	private String surveyCnt01_3B_1;
	private String surveyCnt01_3B_2;
	private String surveyCnt01_3B_3;
	private String surveyCnt01_3B_4;
	private String surveyCnt01_4A_1;
	private String surveyCnt01_4A_2;
	private String surveyCnt01_4A_3;
	private String surveyCnt01_4A_4;
	private String surveyCnt01_4B_1;
	private String surveyCnt01_4B_2;
	private String surveyCnt01_4B_3;
	private String surveyCnt01_4B_4;
	private String surveyCnt02_1A_1;
	private String surveyCnt02_1A_2;
	private String surveyCnt02_1A_3;
	private String surveyCnt02_1A_4;
	private String surveyCnt02_1B_1;
	private String surveyCnt02_1B_2;
	private String surveyCnt02_1B_3;
	private String surveyCnt02_1B_4;
	private String surveyCnt02_2A_1;
	private String surveyCnt02_2A_2;
	private String surveyCnt02_2A_3;
	private String surveyCnt02_2A_4;
	private String surveyCnt02_2B_1;
	private String surveyCnt02_2B_2;
	private String surveyCnt02_2B_3;
	private String surveyCnt02_2B_4;
	private String surveyCnt02_3A_1;
	private String surveyCnt02_3A_2;
	private String surveyCnt02_3A_3;
	private String surveyCnt02_3A_4;
	private String surveyCnt02_3B_1;
	private String surveyCnt02_3B_2;
	private String surveyCnt02_3B_3;
	private String surveyCnt02_3B_4;
	private String surveyCnt02_4A_1;
	private String surveyCnt02_4A_2;
	private String surveyCnt02_4A_3;
	private String surveyCnt02_4A_4;
	private String surveyCnt02_4B_1;
	private String surveyCnt02_4B_2;
	private String surveyCnt02_4B_3;
	private String surveyCnt02_4B_4;	
	private String surveyCnt03_1A_1;
	private String surveyCnt03_1A_2;
	private String surveyCnt03_1A_3;
	private String surveyCnt03_1A_4;
	private String surveyCnt03_1B_1;
	private String surveyCnt03_1B_2;
	private String surveyCnt03_1B_3;
	private String surveyCnt03_1B_4;
	private String surveyCnt03_2A_1;
	private String surveyCnt03_2A_2;
	private String surveyCnt03_2A_3;
	private String surveyCnt03_2A_4;
	private String surveyCnt03_2B_1;
	private String surveyCnt03_2B_2;
	private String surveyCnt03_2B_3;
	private String surveyCnt03_2B_4;
	private String surveyCnt03_3A_1;
	private String surveyCnt03_3A_2;
	private String surveyCnt03_3A_3;
	private String surveyCnt03_3A_4;
	private String surveyCnt03_3B_1;
	private String surveyCnt03_3B_2;
	private String surveyCnt03_3B_3;
	private String surveyCnt03_3B_4;
	private String surveyCnt03_4A_1;
	private String surveyCnt03_4A_2;
	private String surveyCnt03_4A_3;
	private String surveyCnt03_4A_4;
	private String surveyCnt03_4B_1;
	private String surveyCnt03_4B_2;
	private String surveyCnt03_4B_3;
	private String surveyCnt03_4B_4;
	private String surveyCnt03_5A_1;
	private String surveyCnt03_5A_2;
	private String surveyCnt03_5A_3;
	private String surveyCnt03_5A_4;
	private String surveyCnt03_5B_1;
	private String surveyCnt03_5B_2;
	private String surveyCnt03_5B_3;
	private String surveyCnt03_5B_4;
	private String surveyCnt04_1A_1;
	private String surveyCnt04_1A_2;
	private String surveyCnt04_1A_3;
	private String surveyCnt04_1A_4;
	private String surveyCnt04_1B_1;
	private String surveyCnt04_1B_2;
	private String surveyCnt04_1B_3;
	private String surveyCnt04_1B_4;
	private String surveyCnt04_2A_1;
	private String surveyCnt04_2A_2;
	private String surveyCnt04_2A_3;
	private String surveyCnt04_2A_4;
	private String surveyCnt04_2B_1;
	private String surveyCnt04_2B_2;
	private String surveyCnt04_2B_3;
	private String surveyCnt04_2B_4;
	private String surveyCnt04_3A_1;
	private String surveyCnt04_3A_2;
	private String surveyCnt04_3A_3;
	private String surveyCnt04_3A_4;
	private String surveyCnt04_3B_1;
	private String surveyCnt04_3B_2;
	private String surveyCnt04_3B_3;
	private String surveyCnt04_3B_4;
	private String surveyCnt04_4A_1;
	private String surveyCnt04_4A_2;
	private String surveyCnt04_4A_3;
	private String surveyCnt04_4A_4;
	private String surveyCnt04_4B_1;
	private String surveyCnt04_4B_2;
	private String surveyCnt04_4B_3;
	private String surveyCnt04_4B_4;	
	private String surveyCnt05_1A_1;
	private String surveyCnt05_1A_2;
	private String surveyCnt05_1A_3;
	private String surveyCnt05_1A_4;
	private String surveyCnt05_1B_1;
	private String surveyCnt05_1B_2;
	private String surveyCnt05_1B_3;
	private String surveyCnt05_1B_4;
	private String surveyCnt05_2A_1;
	private String surveyCnt05_2A_2;
	private String surveyCnt05_2A_3;
	private String surveyCnt05_2A_4;
	private String surveyCnt05_2B_1;
	private String surveyCnt05_2B_2;
	private String surveyCnt05_2B_3;
	private String surveyCnt05_2B_4;
	private String surveyCnt05_3A_1;
	private String surveyCnt05_3A_2;
	private String surveyCnt05_3A_3;
	private String surveyCnt05_3A_4;
	private String surveyCnt05_3B_1;
	private String surveyCnt05_3B_2;
	private String surveyCnt05_3B_3;
	private String surveyCnt05_3B_4;
	private String surveyCnt05_4A_1;
	private String surveyCnt05_4A_2;
	private String surveyCnt05_4A_3;
	private String surveyCnt05_4A_4;
	private String surveyCnt05_4B_1;
	private String surveyCnt05_4B_2;
	private String surveyCnt05_4B_3;
	private String surveyCnt05_4B_4;
	private String surveyCnt05_5A_1;
	private String surveyCnt05_5A_2;
	private String surveyCnt05_5A_3;
	private String surveyCnt05_5A_4;
	private String surveyCnt05_5B_1;
	private String surveyCnt05_5B_2;
	private String surveyCnt05_5B_3;
	private String surveyCnt05_5B_4;	
	private String surveyCnt06_1A_1;
	private String surveyCnt06_1A_2;
	private String surveyCnt06_1A_3;
	private String surveyCnt06_1A_4;
	private String surveyCnt06_1B_1;
	private String surveyCnt06_1B_2;
	private String surveyCnt06_1B_3;
	private String surveyCnt06_1B_4;
	private String surveyCnt06_2A_1;
	private String surveyCnt06_2A_2;
	private String surveyCnt06_2A_3;
	private String surveyCnt06_2A_4;
	private String surveyCnt06_2B_1;
	private String surveyCnt06_2B_2;
	private String surveyCnt06_2B_3;
	private String surveyCnt06_2B_4;
	private String surveyCnt06_3A_1;
	private String surveyCnt06_3A_2;
	private String surveyCnt06_3A_3;
	private String surveyCnt06_3A_4;
	private String surveyCnt06_3B_1;
	private String surveyCnt06_3B_2;
	private String surveyCnt06_3B_3;
	private String surveyCnt06_3B_4;
	private String surveyCnt06_4A_1;
	private String surveyCnt06_4A_2;
	private String surveyCnt06_4A_3;
	private String surveyCnt06_4A_4;
	private String surveyCnt06_4B_1;
	private String surveyCnt06_4B_2;
	private String surveyCnt06_4B_3;
	private String surveyCnt06_4B_4;
	private String surveyCnt06_5A_1;
	private String surveyCnt06_5A_2;
	private String surveyCnt06_5A_3;
	private String surveyCnt06_5A_4;
	private String surveyCnt06_5B_1;
	private String surveyCnt06_5B_2;
	private String surveyCnt06_5B_3;
	private String surveyCnt06_5B_4;
	private String surveyCnt07_1A;
	private String surveyCnt07_2A;
	private String surveyCnt07_3A;
	private String surveyCnt07_4A;
	private String surveyCnt07_5A;
	private String surveyCnt07_6A;
	private String surveyCnt07_7A;
	private String surveyCnt07_8A;
	private String surveyCnt07_1B;
	private String surveyCnt07_2B;
	private String surveyCnt07_3B;
	private String surveyCnt07_4B;
	private String surveyCnt07_5B;
	private String surveyCnt07_6B;
	private String surveyCnt07_7B;
	private String surveyCnt07_8B;
	private String surveyCnt07_1_1A_1;
	private String surveyCnt07_1_1A_2;
	private String surveyCnt07_1_1A_3;
	private String surveyCnt07_1_1A_4;
	private String surveyCnt07_1_1A_5;
	private String surveyCnt07_1_1A_6;
	private String surveyCnt07_1_1B_1;
	private String surveyCnt07_1_1B_2;
	private String surveyCnt07_1_1B_3;
	private String surveyCnt07_1_1B_4;
	private String surveyCnt07_1_1B_5;
	private String surveyCnt07_1_1B_6;
	private String surveyCnt07_2_1A_1;
	private String surveyCnt07_2_1A_2;
	private String surveyCnt07_2_1A_3;
	private String surveyCnt07_2_1A_4;
	private String surveyCnt07_2_1A_5;
	private String surveyCnt07_2_1A_6;
	private String surveyCnt07_2_1A_7;
	private String surveyCnt07_2_1B_1;
	private String surveyCnt07_2_1B_2;
	private String surveyCnt07_2_1B_3;
	private String surveyCnt07_2_1B_4;
	private String surveyCnt07_2_1B_5;
	private String surveyCnt07_2_1B_6;
	private String surveyCnt07_2_1B_7;
	private String surveyCnt08A_1;
	private String surveyCnt08A_2;
	private String surveyCnt08A_3;
	private String surveyCnt08A_4;
	private String surveyCnt08A_5;
	private String surveyCnt08B_1;
	private String surveyCnt08B_2;
	private String surveyCnt08B_3;
	private String surveyCnt08B_4;
	private String surveyCnt08B_5;
	private String surveyCnt09A_1;
	private String surveyCnt09A_2;
	private String surveyCnt09A_3;
	private String surveyCnt09A_4;
	private String surveyCnt09A_5;
	private String surveyCnt09A_6;
	private String surveyCnt09B_1;
	private String surveyCnt09B_2;
	private String surveyCnt09B_3;
	private String surveyCnt09B_4;
	private String surveyCnt09B_5;
	private String surveyCnt09B_6;
	private String surveyCnt10_1A;
	private String surveyCnt10_2A;
	private String surveyCnt10_3A;
	private String surveyCnt10_4A;
	private String surveyCnt10_5A;
	private String surveyCnt10_6A;
	private String surveyCnt10_7A;
	private String surveyCnt10_8A;
	private String surveyCnt10_1B;
	private String surveyCnt10_2B;
	private String surveyCnt10_3B;
	private String surveyCnt10_4B;
	private String surveyCnt10_5B;
	private String surveyCnt10_6B;
	private String surveyCnt10_7B;
	private String surveyCnt10_8B;
	private String surveyCnt11_1A;
	private String surveyCnt11_2A;
	private String surveyCnt11_3A;
	private String surveyCnt11_4A;
	private String surveyCnt11_5A;
	private String surveyCnt11_6A;
	private String surveyCnt11_1B;
	private String surveyCnt11_2B;
	private String surveyCnt11_3B;
	private String surveyCnt11_4B;
	private String surveyCnt11_5B;
	private String surveyCnt11_6B;
	private String surveyCnt12_1A;
	private String surveyCnt12_2A;
	private String surveyCnt12_3A;
	private String surveyCnt12_4A;
	private String surveyCnt12_5A;
	private String surveyCnt12_1B;
	private String surveyCnt12_2B;
	private String surveyCnt12_3B;
	private String surveyCnt12_4B;
	private String surveyCnt12_5B;
	private String surveyCnt14A_1;
	private String surveyCnt14A_2;
	private String surveyCnt14B_1;
	private String surveyCnt14B_2;
	private String surveyCnt15A_1;
	private String surveyCnt15A_2;
	private String surveyCnt15A_3;
	private String surveyCnt15A_4;
	private String surveyCnt15B_1;
	private String surveyCnt15B_2;
	private String surveyCnt15B_3;
	private String surveyCnt15B_4;
	private String surveyCnt16A_1;
	private String surveyCnt16A_2;
	private String surveyCnt16A_3;
	private String surveyCnt16A_4;
	private String surveyCnt16A_5;
	
	
	private String askno1opinion;
	private String askno2opinion;
	private String askno3opinion;
	private String askno4opinion;
	private String askno5opinion;
	private String askno6opinion;
	private String askno7opinion;
	private String askno7_1_1opinion;
	private String askno7_2_1opinion;
	private String askno8opinion;
	private String askno9;
	private String askno10opinion;
	private String askno11opinion;
	private String askno12opinion;
	private String askno13opinion;
	
	private String sdate;
	private String edate;
	private String org1;
	private String org2;
	private String orgType1;
	private String orgType2;
	private String type1;
	private String type2;
	private String type3;
	private String type4;
	private String orgId;
	private String consulting_application_no;
	
	private String prequeryCnt01_1;
	private String prequeryCnt01_2;
	private String prequeryCnt01_3;
	private String prequeryCnt01_4;
	private String prequeryCnt01_5;
	private String prequeryCnt01_6;
	private String prequeryCnt02_1;
	private String prequeryCnt02_2;
	private String prequeryCnt02_3;
	private String prequeryCnt02_4;
	private String prequeryCnt02_5;
	private String prequeryCnt02_6;
	private String prequeryCnt02_7;
	private String prequeryCnt02_8;
	private String prequeryCnt03_1;
	private String prequeryCnt03_2;
	private String prequeryCnt05_1;
	private String prequeryCnt05_2;
	private String prequeryCnt05_3;
	private String prequeryCnt05_4;
	private String prequeryCnt05_5;
	private String prequeryCnt05_6;
	private String prequeryCnt05_7;
	private String prequeryCnt05_8;
	private String prequeryCnt06_1_1;
	private String prequeryCnt06_1_2;
	private String prequeryCnt06_1_3_1;
	private String prequeryCnt06_1_3_2;
	private String prequeryCnt06_1_4;
	private String prequeryCnt06_1_5;
	private String prequeryCnt06_1_6;
	private String prequeryCnt06_1_7;
	private String prequeryCnt06_1_8;
	private String prequeryCnt06_2_1;
	private String prequeryCnt06_2_2;
	private String prequeryCnt06_2_3;
	private String prequeryCnt06_2_4;
	private String prequeryCnt06_2_5;
	private String prequeryCnt06_2_6;
	private String prequeryCnt06_2_7;
	private String prequeryCnt06_2_1_1;
	private String prequeryCnt06_2_1_2;
	private String prequeryCnt06_2_1_3;
	private String prequeryCnt06_2_1_4;
	private String prequeryCnt06_2_1_5;
	private String prequeryCnt06_2_1_6;
	private String prequeryCnt06_3_1_1;
	private String prequeryCnt06_3_1_2;
	private String prequeryCnt06_3_2;
	private String prequeryCnt06_3_3;
	private String prequeryCnt06_3_4;
	private String prequeryCnt07_1;
	private String prequeryCnt07_2;
	private String prequeryCnt07_3;
	private String prequeryCnt07_4;
	private String prequeryCnt08_1;
	private String prequeryCnt08_2;
	private String prequeryCnt08_3;
	private String prequeryCnt12_1;
	private String prequeryCnt12_2;
	private String prequeryCnt12_3;
	private String prequeryCnt12_4;
	private String prequeryCnt12_5;
	
	private String prequery1;
	private String prequery2_8opinion;
	private String prequery4_1;
	private String prequery4_2;
	private String prequery5_8opinion;
	private String prequery6_1_7opinion;
	private String prequery6_2_6opinion;
	private String prequery6_2_1_6opinion;
	private String prequery6_3_3opinion;
	private String prequery7_4opinion;
	private String prequery9_1;
	private String prequery9_2;
	private String prequery10_1;
	private String prequery10_2;
	private String prequery10_3;
	private String prequery10_4;
	private String prequery11;
	private String prequery13_1;
	private String prequery13_2;
	private String prequery13_3;
	private String prequery13_4;
	private String prequery13_5;
	private String prequery13_6;
	private String prequery13_7;
	
	List<String> orgList = new ArrayList<String>();
	List<String> typeList = new ArrayList<String>();
	
	private String regDate;
	private String range;
	private String days;
	private String months;
	private String counselCnt1;
	private String counselCnt2;
	private String counselCnt3;
	private String counselCnt4;
	private String counselCnt5;
	private String counselCnt6;
	private String counselCnt7;
	private String counselCnt8;
	
	private List<String> consultingTypeCbx;
	private List<String> receivedTypeCbx;
	private List<String> consultingReqTypeCbx;
	private List<String> contactMethodTypeCbx;
	private List<String> clientGenderCbx;
	private List<String> clientVictimRelTypeCbx; 
	private List<String> victimGenderTypeCbx;
	private List<String> offenderGenderTypeCbx;
	private List<String> offenderVictimRelTypeCbx;
	private List<String> harmFirstTypeCbx;
	private List<String> harmSecTypeCbx;
	private List<String> responseTypeIntroOrgCbx;
	private List<String> responseTypeServiceRelCbx;
	
	private List<String> actionTypeCbx;
	private List<String> stepStatusCbx;
	private List<String> actionConsultingTypeCbx;
	private List<String> actionReceivedTypeCbx;
	private List<String> orgAccidentStepCbx;
	private List<String> actionTypeOtherOrgCbx;
	private List<String> actionTypeServiceRelCbx;
	private List<String> actionTypeContCbx;
	
	private String actionCnt;
	private String actionCnt01;
	private String actionCnt02;
	private String actionCnt03;
	private String actionCnt04;
	private String actionCnt05;
	private String actionCnt06;
	private String actionCnt07;
	private String actionCnt08;
	private String actionCnt09;
	private String actionCnt10;
	private String actionCnt11;
	private String actionCnt12;
	
	public String getCounselCnt() {
		return counselCnt;
	}
	public void setCounselCnt(String counselCnt) {
		this.counselCnt = counselCnt;
	}
	public String getCounselCnt01() {
		return counselCnt01;
	}
	public void setCounselCnt01(String counselCnt01) {
		this.counselCnt01 = counselCnt01;
	}
	public String getCounselCnt02() {
		return counselCnt02;
	}
	public void setCounselCnt02(String counselCnt02) {
		this.counselCnt02 = counselCnt02;
	}
	public String getCounselCnt03() {
		return counselCnt03;
	}
	public void setCounselCnt03(String counselCnt03) {
		this.counselCnt03 = counselCnt03;
	}
	public String getCounselCnt04() {
		return counselCnt04;
	}
	public void setCounselCnt04(String counselCnt04) {
		this.counselCnt04 = counselCnt04;
	}
	public String getCounselCnt05() {
		return counselCnt05;
	}
	public void setCounselCnt05(String counselCnt05) {
		this.counselCnt05 = counselCnt05;
	}
	public String getCounselCnt06() {
		return counselCnt06;
	}
	public void setCounselCnt06(String counselCnt06) {
		this.counselCnt06 = counselCnt06;
	}
	public String getCounselCnt07() {
		return counselCnt07;
	}
	public void setCounselCnt07(String counselCnt07) {
		this.counselCnt07 = counselCnt07;
	}
	public String getCounselCnt08() {
		return counselCnt08;
	}
	public void setCounselCnt08(String counselCnt08) {
		this.counselCnt08 = counselCnt08;
	}
	public String getCounselCnt09() {
		return counselCnt09;
	}
	public void setCounselCnt09(String counselCnt09) {
		this.counselCnt09 = counselCnt09;
	}
	public String getCounselCnt10() {
		return counselCnt10;
	}
	public void setCounselCnt10(String counselCnt10) {
		this.counselCnt10 = counselCnt10;
	}
	public String getCounselCnt11() {
		return counselCnt11;
	}
	public void setCounselCnt11(String counselCnt11) {
		this.counselCnt11 = counselCnt11;
	}
	public String getCounselCnt12() {
		return counselCnt12;
	}
	public void setCounselCnt12(String counselCnt12) {
		this.counselCnt12 = counselCnt12;
	}
	public String getCounselCnt13() {
		return counselCnt13;
	}
	public void setCounselCnt13(String counselCnt13) {
		this.counselCnt13 = counselCnt13;
	}
	public String getCounselCnt14() {
		return counselCnt14;
	}
	public void setCounselCnt14(String counselCnt14) {
		this.counselCnt14 = counselCnt14;
	}
	public String getCounselCnt15() {
		return counselCnt15;
	}
	public void setCounselCnt15(String counselCnt15) {
		this.counselCnt15 = counselCnt15;
	}
	public String getConsultingCnt01() {
		return consultingCnt01;
	}
	public void setConsultingCnt01(String consultingCnt01) {
		this.consultingCnt01 = consultingCnt01;
	}
	public String getConsultingCnt02() {
		return consultingCnt02;
	}
	public void setConsultingCnt02(String consultingCnt02) {
		this.consultingCnt02 = consultingCnt02;
	}
	public String getConsultingCnt03() {
		return consultingCnt03;
	}
	public void setConsultingCnt03(String consultingCnt03) {
		this.consultingCnt03 = consultingCnt03;
	}
	public String getConsultingCnt04() {
		return consultingCnt04;
	}
	public void setConsultingCnt04(String consultingCnt04) {
		this.consultingCnt04 = consultingCnt04;
	}
	public String getConsultingCnt05() {
		return consultingCnt05;
	}
	public void setConsultingCnt05(String consultingCnt05) {
		this.consultingCnt05 = consultingCnt05;
	}
	public String getConsultingCnt06() {
		return consultingCnt06;
	}
	public void setConsultingCnt06(String consultingCnt06) {
		this.consultingCnt06 = consultingCnt06;
	}
	public String getConsultingCnt07() {
		return consultingCnt07;
	}
	public void setConsultingCnt07(String consultingCnt07) {
		this.consultingCnt07 = consultingCnt07;
	}
	public String getConsultingCnt08() {
		return consultingCnt08;
	}
	public void setConsultingCnt08(String consultingCnt08) {
		this.consultingCnt08 = consultingCnt08;
	}
	public String getConsultingCnt09() {
		return consultingCnt09;
	}
	public void setConsultingCnt09(String consultingCnt09) {
		this.consultingCnt09 = consultingCnt09;
	}
	public String getConsultingCnt10() {
		return consultingCnt10;
	}
	public void setConsultingCnt10(String consultingCnt10) {
		this.consultingCnt10 = consultingCnt10;
	}
	public String getConsultingCnt11() {
		return consultingCnt11;
	}
	public void setConsultingCnt11(String consultingCnt11) {
		this.consultingCnt11 = consultingCnt11;
	}
	public String getConsultingCnt12() {
		return consultingCnt12;
	}
	public void setConsultingCnt12(String consultingCnt12) {
		this.consultingCnt12 = consultingCnt12;
	}
	public String getConsultingCnt13() {
		return consultingCnt13;
	}
	public void setConsultingCnt13(String consultingCnt13) {
		this.consultingCnt13 = consultingCnt13;
	}
	public String getConsultingCnt14() {
		return consultingCnt14;
	}
	public void setConsultingCnt14(String consultingCnt14) {
		this.consultingCnt14 = consultingCnt14;
	}
	public String getConsultingCnt15() {
		return consultingCnt15;
	}
	public void setConsultingCnt15(String consultingCnt15) {
		this.consultingCnt15 = consultingCnt15;
	}
	public String getConsultingCnt16() {
		return consultingCnt16;
	}
	public void setConsultingCnt16(String consultingCnt16) {
		this.consultingCnt16 = consultingCnt16;
	}
	public String getAskno1opinion() {
		return askno1opinion;
	}
	public void setAskno1opinion(String askno1opinion) {
		this.askno1opinion = askno1opinion;
	}
	public String getAskno2opinion() {
		return askno2opinion;
	}
	public void setAskno2opinion(String askno2opinion) {
		this.askno2opinion = askno2opinion;
	}
	public String getAskno3opinion() {
		return askno3opinion;
	}
	public void setAskno3opinion(String askno3opinion) {
		this.askno3opinion = askno3opinion;
	}
	public String getAskno4opinion() {
		return askno4opinion;
	}
	public void setAskno4opinion(String askno4opinion) {
		this.askno4opinion = askno4opinion;
	}
	public String getAskno5opinion() {
		return askno5opinion;
	}
	public void setAskno5opinion(String askno5opinion) {
		this.askno5opinion = askno5opinion;
	}
	public String getAskno6opinion() {
		return askno6opinion;
	}
	public void setAskno6opinion(String askno6opinion) {
		this.askno6opinion = askno6opinion;
	}
	public String getAskno7opinion() {
		return askno7opinion;
	}
	public void setAskno7opinion(String askno7opinion) {
		this.askno7opinion = askno7opinion;
	}
	public String getAskno8opinion() {
		return askno8opinion;
	}
	public void setAskno8opinion(String askno8opinion) {
		this.askno8opinion = askno8opinion;
	}
	public String getAskno9() {
		return askno9;
	}
	public void setAskno9(String askno9) {
		this.askno9 = askno9;
	}
	public String getAskno7_1_1opinion() {
		return askno7_1_1opinion;
	}
	public void setAskno7_1_1opinion(String askno7_1_1opinion) {
		this.askno7_1_1opinion = askno7_1_1opinion;
	}
	public String getAskno7_2_1opinion() {
		return askno7_2_1opinion;
	}
	public void setAskno7_2_1opinion(String askno7_2_1opinion) {
		this.askno7_2_1opinion = askno7_2_1opinion;
	}
	public String getAskno10opinion() {
		return askno10opinion;
	}
	public void setAskno10opinion(String askno10opinion) {
		this.askno10opinion = askno10opinion;
	}
	public String getAskno11opinion() {
		return askno11opinion;
	}
	public void setAskno11opinion(String askno11opinion) {
		this.askno11opinion = askno11opinion;
	}
	public String getAskno12opinion() {
		return askno12opinion;
	}
	public void setAskno12opinion(String askno12opinion) {
		this.askno12opinion = askno12opinion;
	}
	public String getAskno13opinion() {
		return askno13opinion;
	}
	public void setAskno13opinion(String askno13opinion) {
		this.askno13opinion = askno13opinion;
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
	public String getOrg1() {
		return org1;
	}
	public void setOrg1(String org1) {
		this.org1 = org1;
	}
	public String getOrg2() {
		return org2;
	}
	public void setOrg2(String org2) {
		this.org2 = org2;
	}
	public String getOrgType1() {
		return orgType1;
	}
	public void setOrgType1(String orgType1) {
		this.orgType1 = orgType1;
	}
	public String getOrgType2() {
		return orgType2;
	}
	public void setOrgType2(String orgType2) {
		this.orgType2 = orgType2;
	}
	public String getPrequery2_8opinion() {
		return prequery2_8opinion;
	}
	public void setPrequery2_8opinion(String prequery2_8opinion) {
		this.prequery2_8opinion = prequery2_8opinion;
	}
	public String getPrequery4_1() {
		return prequery4_1;
	}
	public void setPrequery4_1(String prequery4_1) {
		this.prequery4_1 = prequery4_1;
	}
	public String getPrequery4_2() {
		return prequery4_2;
	}
	public void setPrequery4_2(String prequery4_2) {
		this.prequery4_2 = prequery4_2;
	}
	public String getPrequery5_8opinion() {
		return prequery5_8opinion;
	}
	public void setPrequery5_8opinion(String prequery5_8opinion) {
		this.prequery5_8opinion = prequery5_8opinion;
	}
	public String getPrequery6_1_7opinion() {
		return prequery6_1_7opinion;
	}
	public void setPrequery6_1_7opinion(String prequery6_1_7opinion) {
		this.prequery6_1_7opinion = prequery6_1_7opinion;
	}
	public String getPrequery6_2_6opinion() {
		return prequery6_2_6opinion;
	}
	public void setPrequery6_2_6opinion(String prequery6_2_6opinion) {
		this.prequery6_2_6opinion = prequery6_2_6opinion;
	}
	public String getPrequery6_2_1_6opinion() {
		return prequery6_2_1_6opinion;
	}
	public void setPrequery6_2_1_6opinion(String prequery6_2_1_6opinion) {
		this.prequery6_2_1_6opinion = prequery6_2_1_6opinion;
	}
	public String getPrequery6_3_3opinion() {
		return prequery6_3_3opinion;
	}
	public void setPrequery6_3_3opinion(String prequery6_3_3opinion) {
		this.prequery6_3_3opinion = prequery6_3_3opinion;
	}
	public String getPrequery7_4opinion() {
		return prequery7_4opinion;
	}
	public void setPrequery7_4opinion(String prequery7_4opinion) {
		this.prequery7_4opinion = prequery7_4opinion;
	}
	public String getPrequery9_1() {
		return prequery9_1;
	}
	public void setPrequery9_1(String prequery9_1) {
		this.prequery9_1 = prequery9_1;
	}
	public String getPrequery9_2() {
		return prequery9_2;
	}
	public void setPrequery9_2(String prequery9_2) {
		this.prequery9_2 = prequery9_2;
	}
	public String getPrequery10_1() {
		return prequery10_1;
	}
	public void setPrequery10_1(String prequery10_1) {
		this.prequery10_1 = prequery10_1;
	}
	public String getPrequery10_2() {
		return prequery10_2;
	}
	public void setPrequery10_2(String prequery10_2) {
		this.prequery10_2 = prequery10_2;
	}
	public String getPrequery10_3() {
		return prequery10_3;
	}
	public void setPrequery10_3(String prequery10_3) {
		this.prequery10_3 = prequery10_3;
	}
	public String getPrequery10_4() {
		return prequery10_4;
	}
	public void setPrequery10_4(String prequery10_4) {
		this.prequery10_4 = prequery10_4;
	}
	public String getPrequery11() {
		return prequery11;
	}
	public void setPrequery11(String prequery11) {
		this.prequery11 = prequery11;
	}
	public String getPrequery13_1() {
		return prequery13_1;
	}
	public void setPrequery13_1(String prequery13_1) {
		this.prequery13_1 = prequery13_1;
	}
	public String getPrequery13_2() {
		return prequery13_2;
	}
	public void setPrequery13_2(String prequery13_2) {
		this.prequery13_2 = prequery13_2;
	}
	public String getPrequery13_3() {
		return prequery13_3;
	}
	public void setPrequery13_3(String prequery13_3) {
		this.prequery13_3 = prequery13_3;
	}
	public String getPrequery13_4() {
		return prequery13_4;
	}
	public void setPrequery13_4(String prequery13_4) {
		this.prequery13_4 = prequery13_4;
	}
	public String getPrequery13_5() {
		return prequery13_5;
	}
	public void setPrequery13_5(String prequery13_5) {
		this.prequery13_5 = prequery13_5;
	}
	public String getPrequery13_6() {
		return prequery13_6;
	}
	public void setPrequery13_6(String prequery13_6) {
		this.prequery13_6 = prequery13_6;
	}
	public String getPrequery13_7() {
		return prequery13_7;
	}
	public void setPrequery13_7(String prequery13_7) {
		this.prequery13_7 = prequery13_7;
	}
	public List<String> getTypeList() {
		return typeList;
	}
	public void setTypeList(List<String> typeList) {
		this.typeList = typeList;
	}
	public String getType1() {
		return type1;
	}
	public void setType1(String type1) {
		this.type1 = type1;
	}
	public String getType2() {
		return type2;
	}
	public void setType2(String type2) {
		this.type2 = type2;
	}
	public String getType3() {
		return type3;
	}
	public void setType3(String type3) {
		this.type3 = type3;
	}
	public String getType4() {
		return type4;
	}
	public void setType4(String type4) {
		this.type4 = type4;
	}
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}
	public String getConsulting_application_no() {
		return consulting_application_no;
	}
	public void setConsulting_application_no(String consulting_application_no) {
		this.consulting_application_no = consulting_application_no;
	}
	public String getSatisfactionCnt01_1() {
		return satisfactionCnt01_1;
	}
	public void setSatisfactionCnt01_1(String satisfactionCnt01_1) {
		this.satisfactionCnt01_1 = satisfactionCnt01_1;
	}
	public String getSatisfactionCnt01_2() {
		return satisfactionCnt01_2;
	}
	public void setSatisfactionCnt01_2(String satisfactionCnt01_2) {
		this.satisfactionCnt01_2 = satisfactionCnt01_2;
	}
	public String getSatisfactionCnt01_3() {
		return satisfactionCnt01_3;
	}
	public void setSatisfactionCnt01_3(String satisfactionCnt01_3) {
		this.satisfactionCnt01_3 = satisfactionCnt01_3;
	}
	public String getSatisfactionCnt01_4() {
		return satisfactionCnt01_4;
	}
	public void setSatisfactionCnt01_4(String satisfactionCnt01_4) {
		this.satisfactionCnt01_4 = satisfactionCnt01_4;
	}
	public String getSatisfactionCnt01_5() {
		return satisfactionCnt01_5;
	}
	public void setSatisfactionCnt01_5(String satisfactionCnt01_5) {
		this.satisfactionCnt01_5 = satisfactionCnt01_5;
	}
	public String getSatisfactionCnt01_6() {
		return satisfactionCnt01_6;
	}
	public void setSatisfactionCnt01_6(String satisfactionCnt01_6) {
		this.satisfactionCnt01_6 = satisfactionCnt01_6;
	}
	public String getSatisfactionCnt02_1() {
		return satisfactionCnt02_1;
	}
	public void setSatisfactionCnt02_1(String satisfactionCnt02_1) {
		this.satisfactionCnt02_1 = satisfactionCnt02_1;
	}
	public String getSatisfactionCnt02_2() {
		return satisfactionCnt02_2;
	}
	public void setSatisfactionCnt02_2(String satisfactionCnt02_2) {
		this.satisfactionCnt02_2 = satisfactionCnt02_2;
	}
	public String getSatisfactionCnt02_3() {
		return satisfactionCnt02_3;
	}
	public void setSatisfactionCnt02_3(String satisfactionCnt02_3) {
		this.satisfactionCnt02_3 = satisfactionCnt02_3;
	}
	public String getSatisfactionCnt02_4() {
		return satisfactionCnt02_4;
	}
	public void setSatisfactionCnt02_4(String satisfactionCnt02_4) {
		this.satisfactionCnt02_4 = satisfactionCnt02_4;
	}
	public String getSatisfactionCnt02_5() {
		return satisfactionCnt02_5;
	}
	public void setSatisfactionCnt02_5(String satisfactionCnt02_5) {
		this.satisfactionCnt02_5 = satisfactionCnt02_5;
	}
	public String getSatisfactionCnt03_1() {
		return satisfactionCnt03_1;
	}
	public void setSatisfactionCnt03_1(String satisfactionCnt03_1) {
		this.satisfactionCnt03_1 = satisfactionCnt03_1;
	}
	public String getSatisfactionCnt03_2() {
		return satisfactionCnt03_2;
	}
	public void setSatisfactionCnt03_2(String satisfactionCnt03_2) {
		this.satisfactionCnt03_2 = satisfactionCnt03_2;
	}
	public String getSatisfactionCnt03_3() {
		return satisfactionCnt03_3;
	}
	public void setSatisfactionCnt03_3(String satisfactionCnt03_3) {
		this.satisfactionCnt03_3 = satisfactionCnt03_3;
	}
	public String getSatisfactionCnt03_4() {
		return satisfactionCnt03_4;
	}
	public void setSatisfactionCnt03_4(String satisfactionCnt03_4) {
		this.satisfactionCnt03_4 = satisfactionCnt03_4;
	}
	public String getSatisfactionCnt03_5() {
		return satisfactionCnt03_5;
	}
	public void setSatisfactionCnt03_5(String satisfactionCnt03_5) {
		this.satisfactionCnt03_5 = satisfactionCnt03_5;
	}
	public String getSatisfactionCnt04_1() {
		return satisfactionCnt04_1;
	}
	public void setSatisfactionCnt04_1(String satisfactionCnt04_1) {
		this.satisfactionCnt04_1 = satisfactionCnt04_1;
	}
	public String getSatisfactionCnt04_2() {
		return satisfactionCnt04_2;
	}
	public void setSatisfactionCnt04_2(String satisfactionCnt04_2) {
		this.satisfactionCnt04_2 = satisfactionCnt04_2;
	}
	public String getSatisfactionCnt04_3() {
		return satisfactionCnt04_3;
	}
	public void setSatisfactionCnt04_3(String satisfactionCnt04_3) {
		this.satisfactionCnt04_3 = satisfactionCnt04_3;
	}
	public String getSatisfactionCnt04_4() {
		return satisfactionCnt04_4;
	}
	public void setSatisfactionCnt04_4(String satisfactionCnt04_4) {
		this.satisfactionCnt04_4 = satisfactionCnt04_4;
	}
	public String getSatisfactionCnt04_5() {
		return satisfactionCnt04_5;
	}
	public void setSatisfactionCnt04_5(String satisfactionCnt04_5) {
		this.satisfactionCnt04_5 = satisfactionCnt04_5;
	}
	public String getSatisfactionCnt05_1() {
		return satisfactionCnt05_1;
	}
	public void setSatisfactionCnt05_1(String satisfactionCnt05_1) {
		this.satisfactionCnt05_1 = satisfactionCnt05_1;
	}
	public String getSatisfactionCnt05_2() {
		return satisfactionCnt05_2;
	}
	public void setSatisfactionCnt05_2(String satisfactionCnt05_2) {
		this.satisfactionCnt05_2 = satisfactionCnt05_2;
	}
	public String getSatisfactionCnt05_3() {
		return satisfactionCnt05_3;
	}
	public void setSatisfactionCnt05_3(String satisfactionCnt05_3) {
		this.satisfactionCnt05_3 = satisfactionCnt05_3;
	}
	public String getSatisfactionCnt05_4() {
		return satisfactionCnt05_4;
	}
	public void setSatisfactionCnt05_4(String satisfactionCnt05_4) {
		this.satisfactionCnt05_4 = satisfactionCnt05_4;
	}
	public String getSatisfactionCnt05_5() {
		return satisfactionCnt05_5;
	}
	public void setSatisfactionCnt05_5(String satisfactionCnt05_5) {
		this.satisfactionCnt05_5 = satisfactionCnt05_5;
	}
	public String getSatisfactionCnt06_1() {
		return satisfactionCnt06_1;
	}
	public void setSatisfactionCnt06_1(String satisfactionCnt06_1) {
		this.satisfactionCnt06_1 = satisfactionCnt06_1;
	}
	public String getSatisfactionCnt06_2() {
		return satisfactionCnt06_2;
	}
	public void setSatisfactionCnt06_2(String satisfactionCnt06_2) {
		this.satisfactionCnt06_2 = satisfactionCnt06_2;
	}
	public String getSatisfactionCnt06_3() {
		return satisfactionCnt06_3;
	}
	public void setSatisfactionCnt06_3(String satisfactionCnt06_3) {
		this.satisfactionCnt06_3 = satisfactionCnt06_3;
	}
	public String getSatisfactionCnt06_4() {
		return satisfactionCnt06_4;
	}
	public void setSatisfactionCnt06_4(String satisfactionCnt06_4) {
		this.satisfactionCnt06_4 = satisfactionCnt06_4;
	}
	public String getSatisfactionCnt06_5() {
		return satisfactionCnt06_5;
	}
	public void setSatisfactionCnt06_5(String satisfactionCnt06_5) {
		this.satisfactionCnt06_5 = satisfactionCnt06_5;
	}
	public String getSatisfactionCnt07_1() {
		return satisfactionCnt07_1;
	}
	public void setSatisfactionCnt07_1(String satisfactionCnt07_1) {
		this.satisfactionCnt07_1 = satisfactionCnt07_1;
	}
	public String getSatisfactionCnt07_2() {
		return satisfactionCnt07_2;
	}
	public void setSatisfactionCnt07_2(String satisfactionCnt07_2) {
		this.satisfactionCnt07_2 = satisfactionCnt07_2;
	}
	public String getSatisfactionCnt07_3() {
		return satisfactionCnt07_3;
	}
	public void setSatisfactionCnt07_3(String satisfactionCnt07_3) {
		this.satisfactionCnt07_3 = satisfactionCnt07_3;
	}
	public String getSatisfactionCnt07_4() {
		return satisfactionCnt07_4;
	}
	public void setSatisfactionCnt07_4(String satisfactionCnt07_4) {
		this.satisfactionCnt07_4 = satisfactionCnt07_4;
	}
	public String getSatisfactionCnt07_5() {
		return satisfactionCnt07_5;
	}
	public void setSatisfactionCnt07_5(String satisfactionCnt07_5) {
		this.satisfactionCnt07_5 = satisfactionCnt07_5;
	}
	public String getSatisfactionCnt08_1() {
		return satisfactionCnt08_1;
	}
	public void setSatisfactionCnt08_1(String satisfactionCnt08_1) {
		this.satisfactionCnt08_1 = satisfactionCnt08_1;
	}
	public String getSatisfactionCnt08_2() {
		return satisfactionCnt08_2;
	}
	public void setSatisfactionCnt08_2(String satisfactionCnt08_2) {
		this.satisfactionCnt08_2 = satisfactionCnt08_2;
	}
	public String getSatisfactionCnt08_3() {
		return satisfactionCnt08_3;
	}
	public void setSatisfactionCnt08_3(String satisfactionCnt08_3) {
		this.satisfactionCnt08_3 = satisfactionCnt08_3;
	}
	public String getSatisfactionCnt08_4() {
		return satisfactionCnt08_4;
	}
	public void setSatisfactionCnt08_4(String satisfactionCnt08_4) {
		this.satisfactionCnt08_4 = satisfactionCnt08_4;
	}
	public String getSatisfactionCnt08_5() {
		return satisfactionCnt08_5;
	}
	public void setSatisfactionCnt08_5(String satisfactionCnt08_5) {
		this.satisfactionCnt08_5 = satisfactionCnt08_5;
	}
	public List<String> getOrgList() {
		return orgList;
	}
	public void setOrgList(List<String> orgList) {
		this.orgList = orgList;
	}
	public String getPrequeryCnt01_1() {
		return prequeryCnt01_1;
	}
	public void setPrequeryCnt01_1(String prequeryCnt01_1) {
		this.prequeryCnt01_1 = prequeryCnt01_1;
	}
	public String getPrequeryCnt01_2() {
		return prequeryCnt01_2;
	}
	public void setPrequeryCnt01_2(String prequeryCnt01_2) {
		this.prequeryCnt01_2 = prequeryCnt01_2;
	}
	public String getPrequeryCnt01_3() {
		return prequeryCnt01_3;
	}
	public void setPrequeryCnt01_3(String prequeryCnt01_3) {
		this.prequeryCnt01_3 = prequeryCnt01_3;
	}
	public String getPrequeryCnt01_4() {
		return prequeryCnt01_4;
	}
	public void setPrequeryCnt01_4(String prequeryCnt01_4) {
		this.prequeryCnt01_4 = prequeryCnt01_4;
	}
	public String getPrequeryCnt01_5() {
		return prequeryCnt01_5;
	}
	public void setPrequeryCnt01_5(String prequeryCnt01_5) {
		this.prequeryCnt01_5 = prequeryCnt01_5;
	}
	public String getPrequeryCnt01_6() {
		return prequeryCnt01_6;
	}
	public void setPrequeryCnt01_6(String prequeryCnt01_6) {
		this.prequeryCnt01_6 = prequeryCnt01_6;
	}
	public String getPrequeryCnt02_1() {
		return prequeryCnt02_1;
	}
	public void setPrequeryCnt02_1(String prequeryCnt02_1) {
		this.prequeryCnt02_1 = prequeryCnt02_1;
	}
	public String getPrequeryCnt02_2() {
		return prequeryCnt02_2;
	}
	public void setPrequeryCnt02_2(String prequeryCnt02_2) {
		this.prequeryCnt02_2 = prequeryCnt02_2;
	}
	public String getPrequeryCnt02_3() {
		return prequeryCnt02_3;
	}
	public void setPrequeryCnt02_3(String prequeryCnt02_3) {
		this.prequeryCnt02_3 = prequeryCnt02_3;
	}
	public String getPrequeryCnt02_4() {
		return prequeryCnt02_4;
	}
	public void setPrequeryCnt02_4(String prequeryCnt02_4) {
		this.prequeryCnt02_4 = prequeryCnt02_4;
	}
	public String getPrequeryCnt02_5() {
		return prequeryCnt02_5;
	}
	public void setPrequeryCnt02_5(String prequeryCnt02_5) {
		this.prequeryCnt02_5 = prequeryCnt02_5;
	}
	public String getPrequeryCnt02_6() {
		return prequeryCnt02_6;
	}
	public void setPrequeryCnt02_6(String prequeryCnt02_6) {
		this.prequeryCnt02_6 = prequeryCnt02_6;
	}
	public String getPrequeryCnt02_7() {
		return prequeryCnt02_7;
	}
	public void setPrequeryCnt02_7(String prequeryCnt02_7) {
		this.prequeryCnt02_7 = prequeryCnt02_7;
	}
	public String getPrequeryCnt02_8() {
		return prequeryCnt02_8;
	}
	public void setPrequeryCnt02_8(String prequeryCnt02_8) {
		this.prequeryCnt02_8 = prequeryCnt02_8;
	}
	public String getPrequeryCnt03_1() {
		return prequeryCnt03_1;
	}
	public void setPrequeryCnt03_1(String prequeryCnt03_1) {
		this.prequeryCnt03_1 = prequeryCnt03_1;
	}
	public String getPrequeryCnt03_2() {
		return prequeryCnt03_2;
	}
	public void setPrequeryCnt03_2(String prequeryCnt03_2) {
		this.prequeryCnt03_2 = prequeryCnt03_2;
	}
	public String getPrequeryCnt05_1() {
		return prequeryCnt05_1;
	}
	public void setPrequeryCnt05_1(String prequeryCnt05_1) {
		this.prequeryCnt05_1 = prequeryCnt05_1;
	}
	public String getPrequeryCnt05_2() {
		return prequeryCnt05_2;
	}
	public void setPrequeryCnt05_2(String prequeryCnt05_2) {
		this.prequeryCnt05_2 = prequeryCnt05_2;
	}
	public String getPrequeryCnt05_3() {
		return prequeryCnt05_3;
	}
	public void setPrequeryCnt05_3(String prequeryCnt05_3) {
		this.prequeryCnt05_3 = prequeryCnt05_3;
	}
	public String getPrequeryCnt05_4() {
		return prequeryCnt05_4;
	}
	public void setPrequeryCnt05_4(String prequeryCnt05_4) {
		this.prequeryCnt05_4 = prequeryCnt05_4;
	}
	public String getPrequeryCnt05_5() {
		return prequeryCnt05_5;
	}
	public void setPrequeryCnt05_5(String prequeryCnt05_5) {
		this.prequeryCnt05_5 = prequeryCnt05_5;
	}
	public String getPrequeryCnt05_6() {
		return prequeryCnt05_6;
	}
	public void setPrequeryCnt05_6(String prequeryCnt05_6) {
		this.prequeryCnt05_6 = prequeryCnt05_6;
	}
	public String getPrequeryCnt05_7() {
		return prequeryCnt05_7;
	}
	public void setPrequeryCnt05_7(String prequeryCnt05_7) {
		this.prequeryCnt05_7 = prequeryCnt05_7;
	}
	public String getPrequeryCnt05_8() {
		return prequeryCnt05_8;
	}
	public void setPrequeryCnt05_8(String prequeryCnt05_8) {
		this.prequeryCnt05_8 = prequeryCnt05_8;
	}
	public String getPrequeryCnt06_1_1() {
		return prequeryCnt06_1_1;
	}
	public void setPrequeryCnt06_1_1(String prequeryCnt06_1_1) {
		this.prequeryCnt06_1_1 = prequeryCnt06_1_1;
	}
	public String getPrequeryCnt06_1_2() {
		return prequeryCnt06_1_2;
	}
	public void setPrequeryCnt06_1_2(String prequeryCnt06_1_2) {
		this.prequeryCnt06_1_2 = prequeryCnt06_1_2;
	}
	public String getPrequeryCnt06_1_3_1() {
		return prequeryCnt06_1_3_1;
	}
	public void setPrequeryCnt06_1_3_1(String prequeryCnt06_1_3_1) {
		this.prequeryCnt06_1_3_1 = prequeryCnt06_1_3_1;
	}
	public String getPrequeryCnt06_1_3_2() {
		return prequeryCnt06_1_3_2;
	}
	public void setPrequeryCnt06_1_3_2(String prequeryCnt06_1_3_2) {
		this.prequeryCnt06_1_3_2 = prequeryCnt06_1_3_2;
	}
	public String getPrequeryCnt06_1_4() {
		return prequeryCnt06_1_4;
	}
	public void setPrequeryCnt06_1_4(String prequeryCnt06_1_4) {
		this.prequeryCnt06_1_4 = prequeryCnt06_1_4;
	}
	public String getPrequeryCnt06_1_5() {
		return prequeryCnt06_1_5;
	}
	public void setPrequeryCnt06_1_5(String prequeryCnt06_1_5) {
		this.prequeryCnt06_1_5 = prequeryCnt06_1_5;
	}
	public String getPrequeryCnt06_1_6() {
		return prequeryCnt06_1_6;
	}
	public void setPrequeryCnt06_1_6(String prequeryCnt06_1_6) {
		this.prequeryCnt06_1_6 = prequeryCnt06_1_6;
	}
	public String getPrequeryCnt06_1_7() {
		return prequeryCnt06_1_7;
	}
	public void setPrequeryCnt06_1_7(String prequeryCnt06_1_7) {
		this.prequeryCnt06_1_7 = prequeryCnt06_1_7;
	}
	public String getPrequeryCnt06_1_8() {
		return prequeryCnt06_1_8;
	}
	public void setPrequeryCnt06_1_8(String prequeryCnt06_1_8) {
		this.prequeryCnt06_1_8 = prequeryCnt06_1_8;
	}
	public String getPrequeryCnt06_2_1() {
		return prequeryCnt06_2_1;
	}
	public void setPrequeryCnt06_2_1(String prequeryCnt06_2_1) {
		this.prequeryCnt06_2_1 = prequeryCnt06_2_1;
	}
	public String getPrequeryCnt06_2_2() {
		return prequeryCnt06_2_2;
	}
	public void setPrequeryCnt06_2_2(String prequeryCnt06_2_2) {
		this.prequeryCnt06_2_2 = prequeryCnt06_2_2;
	}
	public String getPrequeryCnt06_2_3() {
		return prequeryCnt06_2_3;
	}
	public void setPrequeryCnt06_2_3(String prequeryCnt06_2_3) {
		this.prequeryCnt06_2_3 = prequeryCnt06_2_3;
	}
	public String getPrequeryCnt06_2_4() {
		return prequeryCnt06_2_4;
	}
	public void setPrequeryCnt06_2_4(String prequeryCnt06_2_4) {
		this.prequeryCnt06_2_4 = prequeryCnt06_2_4;
	}
	public String getPrequeryCnt06_2_5() {
		return prequeryCnt06_2_5;
	}
	public void setPrequeryCnt06_2_5(String prequeryCnt06_2_5) {
		this.prequeryCnt06_2_5 = prequeryCnt06_2_5;
	}
	public String getPrequeryCnt06_2_6() {
		return prequeryCnt06_2_6;
	}
	public void setPrequeryCnt06_2_6(String prequeryCnt06_2_6) {
		this.prequeryCnt06_2_6 = prequeryCnt06_2_6;
	}
	public String getPrequeryCnt06_2_7() {
		return prequeryCnt06_2_7;
	}
	public void setPrequeryCnt06_2_7(String prequeryCnt06_2_7) {
		this.prequeryCnt06_2_7 = prequeryCnt06_2_7;
	}
	public String getPrequeryCnt06_2_1_1() {
		return prequeryCnt06_2_1_1;
	}
	public void setPrequeryCnt06_2_1_1(String prequeryCnt06_2_1_1) {
		this.prequeryCnt06_2_1_1 = prequeryCnt06_2_1_1;
	}
	public String getPrequeryCnt06_2_1_2() {
		return prequeryCnt06_2_1_2;
	}
	public void setPrequeryCnt06_2_1_2(String prequeryCnt06_2_1_2) {
		this.prequeryCnt06_2_1_2 = prequeryCnt06_2_1_2;
	}
	public String getPrequeryCnt06_2_1_3() {
		return prequeryCnt06_2_1_3;
	}
	public void setPrequeryCnt06_2_1_3(String prequeryCnt06_2_1_3) {
		this.prequeryCnt06_2_1_3 = prequeryCnt06_2_1_3;
	}
	public String getPrequeryCnt06_2_1_4() {
		return prequeryCnt06_2_1_4;
	}
	public void setPrequeryCnt06_2_1_4(String prequeryCnt06_2_1_4) {
		this.prequeryCnt06_2_1_4 = prequeryCnt06_2_1_4;
	}
	public String getPrequeryCnt06_2_1_5() {
		return prequeryCnt06_2_1_5;
	}
	public void setPrequeryCnt06_2_1_5(String prequeryCnt06_2_1_5) {
		this.prequeryCnt06_2_1_5 = prequeryCnt06_2_1_5;
	}
	public String getPrequeryCnt06_2_1_6() {
		return prequeryCnt06_2_1_6;
	}
	public void setPrequeryCnt06_2_1_6(String prequeryCnt06_2_1_6) {
		this.prequeryCnt06_2_1_6 = prequeryCnt06_2_1_6;
	}
	public String getPrequeryCnt06_3_1_1() {
		return prequeryCnt06_3_1_1;
	}
	public void setPrequeryCnt06_3_1_1(String prequeryCnt06_3_1_1) {
		this.prequeryCnt06_3_1_1 = prequeryCnt06_3_1_1;
	}
	public String getPrequeryCnt06_3_1_2() {
		return prequeryCnt06_3_1_2;
	}
	public void setPrequeryCnt06_3_1_2(String prequeryCnt06_3_1_2) {
		this.prequeryCnt06_3_1_2 = prequeryCnt06_3_1_2;
	}
	public String getPrequeryCnt06_3_2() {
		return prequeryCnt06_3_2;
	}
	public void setPrequeryCnt06_3_2(String prequeryCnt06_3_2) {
		this.prequeryCnt06_3_2 = prequeryCnt06_3_2;
	}
	public String getPrequeryCnt06_3_3() {
		return prequeryCnt06_3_3;
	}
	public void setPrequeryCnt06_3_3(String prequeryCnt06_3_3) {
		this.prequeryCnt06_3_3 = prequeryCnt06_3_3;
	}
	public String getPrequeryCnt06_3_4() {
		return prequeryCnt06_3_4;
	}
	public void setPrequeryCnt06_3_4(String prequeryCnt06_3_4) {
		this.prequeryCnt06_3_4 = prequeryCnt06_3_4;
	}
	public String getPrequeryCnt07_1() {
		return prequeryCnt07_1;
	}
	public void setPrequeryCnt07_1(String prequeryCnt07_1) {
		this.prequeryCnt07_1 = prequeryCnt07_1;
	}
	public String getPrequeryCnt07_2() {
		return prequeryCnt07_2;
	}
	public void setPrequeryCnt07_2(String prequeryCnt07_2) {
		this.prequeryCnt07_2 = prequeryCnt07_2;
	}
	public String getPrequeryCnt07_3() {
		return prequeryCnt07_3;
	}
	public void setPrequeryCnt07_3(String prequeryCnt07_3) {
		this.prequeryCnt07_3 = prequeryCnt07_3;
	}
	public String getPrequeryCnt07_4() {
		return prequeryCnt07_4;
	}
	public void setPrequeryCnt07_4(String prequeryCnt07_4) {
		this.prequeryCnt07_4 = prequeryCnt07_4;
	}
	public String getPrequeryCnt08_1() {
		return prequeryCnt08_1;
	}
	public void setPrequeryCnt08_1(String prequeryCnt08_1) {
		this.prequeryCnt08_1 = prequeryCnt08_1;
	}
	public String getPrequeryCnt08_2() {
		return prequeryCnt08_2;
	}
	public void setPrequeryCnt08_2(String prequeryCnt08_2) {
		this.prequeryCnt08_2 = prequeryCnt08_2;
	}
	public String getPrequeryCnt08_3() {
		return prequeryCnt08_3;
	}
	public void setPrequeryCnt08_3(String prequeryCnt08_3) {
		this.prequeryCnt08_3 = prequeryCnt08_3;
	}
	public String getPrequeryCnt12_1() {
		return prequeryCnt12_1;
	}
	public void setPrequeryCnt12_1(String prequeryCnt12_1) {
		this.prequeryCnt12_1 = prequeryCnt12_1;
	}
	public String getPrequeryCnt12_2() {
		return prequeryCnt12_2;
	}
	public void setPrequeryCnt12_2(String prequeryCnt12_2) {
		this.prequeryCnt12_2 = prequeryCnt12_2;
	}
	public String getPrequeryCnt12_3() {
		return prequeryCnt12_3;
	}
	public void setPrequeryCnt12_3(String prequeryCnt12_3) {
		this.prequeryCnt12_3 = prequeryCnt12_3;
	}
	public String getPrequeryCnt12_4() {
		return prequeryCnt12_4;
	}
	public void setPrequeryCnt12_4(String prequeryCnt12_4) {
		this.prequeryCnt12_4 = prequeryCnt12_4;
	}
	public String getPrequeryCnt12_5() {
		return prequeryCnt12_5;
	}
	public void setPrequeryCnt12_5(String prequeryCnt12_5) {
		this.prequeryCnt12_5 = prequeryCnt12_5;
	}
	public String getSurveyCnt00A_1() {
		return surveyCnt00A_1;
	}
	public void setSurveyCnt00A_1(String surveyCnt00A_1) {
		this.surveyCnt00A_1 = surveyCnt00A_1;
	}
	public String getSurveyCnt00A_2() {
		return surveyCnt00A_2;
	}
	public void setSurveyCnt00A_2(String surveyCnt00A_2) {
		this.surveyCnt00A_2 = surveyCnt00A_2;
	}
	public String getSurveyCnt00B_1() {
		return surveyCnt00B_1;
	}
	public void setSurveyCnt00B_1(String surveyCnt00B_1) {
		this.surveyCnt00B_1 = surveyCnt00B_1;
	}
	public String getSurveyCnt00B_2() {
		return surveyCnt00B_2;
	}
	public void setSurveyCnt00B_2(String surveyCnt00B_2) {
		this.surveyCnt00B_2 = surveyCnt00B_2;
	}
	public String getSurveyCnt01_1A_1() {
		return surveyCnt01_1A_1;
	}
	public void setSurveyCnt01_1A_1(String surveyCnt01_1A_1) {
		this.surveyCnt01_1A_1 = surveyCnt01_1A_1;
	}
	public String getSurveyCnt01_1A_2() {
		return surveyCnt01_1A_2;
	}
	public void setSurveyCnt01_1A_2(String surveyCnt01_1A_2) {
		this.surveyCnt01_1A_2 = surveyCnt01_1A_2;
	}
	public String getSurveyCnt01_1A_3() {
		return surveyCnt01_1A_3;
	}
	public void setSurveyCnt01_1A_3(String surveyCnt01_1A_3) {
		this.surveyCnt01_1A_3 = surveyCnt01_1A_3;
	}
	public String getSurveyCnt01_1A_4() {
		return surveyCnt01_1A_4;
	}
	public void setSurveyCnt01_1A_4(String surveyCnt01_1A_4) {
		this.surveyCnt01_1A_4 = surveyCnt01_1A_4;
	}
	public String getSurveyCnt01_1B_1() {
		return surveyCnt01_1B_1;
	}
	public void setSurveyCnt01_1B_1(String surveyCnt01_1B_1) {
		this.surveyCnt01_1B_1 = surveyCnt01_1B_1;
	}
	public String getSurveyCnt01_1B_2() {
		return surveyCnt01_1B_2;
	}
	public void setSurveyCnt01_1B_2(String surveyCnt01_1B_2) {
		this.surveyCnt01_1B_2 = surveyCnt01_1B_2;
	}
	public String getSurveyCnt01_1B_3() {
		return surveyCnt01_1B_3;
	}
	public void setSurveyCnt01_1B_3(String surveyCnt01_1B_3) {
		this.surveyCnt01_1B_3 = surveyCnt01_1B_3;
	}
	public String getSurveyCnt01_1B_4() {
		return surveyCnt01_1B_4;
	}
	public void setSurveyCnt01_1B_4(String surveyCnt01_1B_4) {
		this.surveyCnt01_1B_4 = surveyCnt01_1B_4;
	}
	public String getSurveyCnt01_2A_1() {
		return surveyCnt01_2A_1;
	}
	public void setSurveyCnt01_2A_1(String surveyCnt01_2A_1) {
		this.surveyCnt01_2A_1 = surveyCnt01_2A_1;
	}
	public String getSurveyCnt01_2A_2() {
		return surveyCnt01_2A_2;
	}
	public void setSurveyCnt01_2A_2(String surveyCnt01_2A_2) {
		this.surveyCnt01_2A_2 = surveyCnt01_2A_2;
	}
	public String getSurveyCnt01_2A_3() {
		return surveyCnt01_2A_3;
	}
	public void setSurveyCnt01_2A_3(String surveyCnt01_2A_3) {
		this.surveyCnt01_2A_3 = surveyCnt01_2A_3;
	}
	public String getSurveyCnt01_2A_4() {
		return surveyCnt01_2A_4;
	}
	public void setSurveyCnt01_2A_4(String surveyCnt01_2A_4) {
		this.surveyCnt01_2A_4 = surveyCnt01_2A_4;
	}
	public String getSurveyCnt01_2B_1() {
		return surveyCnt01_2B_1;
	}
	public void setSurveyCnt01_2B_1(String surveyCnt01_2B_1) {
		this.surveyCnt01_2B_1 = surveyCnt01_2B_1;
	}
	public String getSurveyCnt01_2B_2() {
		return surveyCnt01_2B_2;
	}
	public void setSurveyCnt01_2B_2(String surveyCnt01_2B_2) {
		this.surveyCnt01_2B_2 = surveyCnt01_2B_2;
	}
	public String getSurveyCnt01_2B_3() {
		return surveyCnt01_2B_3;
	}
	public void setSurveyCnt01_2B_3(String surveyCnt01_2B_3) {
		this.surveyCnt01_2B_3 = surveyCnt01_2B_3;
	}
	public String getSurveyCnt01_2B_4() {
		return surveyCnt01_2B_4;
	}
	public void setSurveyCnt01_2B_4(String surveyCnt01_2B_4) {
		this.surveyCnt01_2B_4 = surveyCnt01_2B_4;
	}
	public String getSurveyCnt01_3A_1() {
		return surveyCnt01_3A_1;
	}
	public void setSurveyCnt01_3A_1(String surveyCnt01_3A_1) {
		this.surveyCnt01_3A_1 = surveyCnt01_3A_1;
	}
	public String getSurveyCnt01_3A_2() {
		return surveyCnt01_3A_2;
	}
	public void setSurveyCnt01_3A_2(String surveyCnt01_3A_2) {
		this.surveyCnt01_3A_2 = surveyCnt01_3A_2;
	}
	public String getSurveyCnt01_3A_3() {
		return surveyCnt01_3A_3;
	}
	public void setSurveyCnt01_3A_3(String surveyCnt01_3A_3) {
		this.surveyCnt01_3A_3 = surveyCnt01_3A_3;
	}
	public String getSurveyCnt01_3A_4() {
		return surveyCnt01_3A_4;
	}
	public void setSurveyCnt01_3A_4(String surveyCnt01_3A_4) {
		this.surveyCnt01_3A_4 = surveyCnt01_3A_4;
	}
	public String getSurveyCnt01_3B_1() {
		return surveyCnt01_3B_1;
	}
	public void setSurveyCnt01_3B_1(String surveyCnt01_3B_1) {
		this.surveyCnt01_3B_1 = surveyCnt01_3B_1;
	}
	public String getSurveyCnt01_3B_2() {
		return surveyCnt01_3B_2;
	}
	public void setSurveyCnt01_3B_2(String surveyCnt01_3B_2) {
		this.surveyCnt01_3B_2 = surveyCnt01_3B_2;
	}
	public String getSurveyCnt01_3B_3() {
		return surveyCnt01_3B_3;
	}
	public void setSurveyCnt01_3B_3(String surveyCnt01_3B_3) {
		this.surveyCnt01_3B_3 = surveyCnt01_3B_3;
	}
	public String getSurveyCnt01_3B_4() {
		return surveyCnt01_3B_4;
	}
	public void setSurveyCnt01_3B_4(String surveyCnt01_3B_4) {
		this.surveyCnt01_3B_4 = surveyCnt01_3B_4;
	}
	public String getSurveyCnt01_4A_1() {
		return surveyCnt01_4A_1;
	}
	public void setSurveyCnt01_4A_1(String surveyCnt01_4A_1) {
		this.surveyCnt01_4A_1 = surveyCnt01_4A_1;
	}
	public String getSurveyCnt01_4A_2() {
		return surveyCnt01_4A_2;
	}
	public void setSurveyCnt01_4A_2(String surveyCnt01_4A_2) {
		this.surveyCnt01_4A_2 = surveyCnt01_4A_2;
	}
	public String getSurveyCnt01_4A_3() {
		return surveyCnt01_4A_3;
	}
	public void setSurveyCnt01_4A_3(String surveyCnt01_4A_3) {
		this.surveyCnt01_4A_3 = surveyCnt01_4A_3;
	}
	public String getSurveyCnt01_4A_4() {
		return surveyCnt01_4A_4;
	}
	public void setSurveyCnt01_4A_4(String surveyCnt01_4A_4) {
		this.surveyCnt01_4A_4 = surveyCnt01_4A_4;
	}
	public String getSurveyCnt01_4B_1() {
		return surveyCnt01_4B_1;
	}
	public void setSurveyCnt01_4B_1(String surveyCnt01_4B_1) {
		this.surveyCnt01_4B_1 = surveyCnt01_4B_1;
	}
	public String getSurveyCnt01_4B_2() {
		return surveyCnt01_4B_2;
	}
	public void setSurveyCnt01_4B_2(String surveyCnt01_4B_2) {
		this.surveyCnt01_4B_2 = surveyCnt01_4B_2;
	}
	public String getSurveyCnt01_4B_3() {
		return surveyCnt01_4B_3;
	}
	public void setSurveyCnt01_4B_3(String surveyCnt01_4B_3) {
		this.surveyCnt01_4B_3 = surveyCnt01_4B_3;
	}
	public String getSurveyCnt01_4B_4() {
		return surveyCnt01_4B_4;
	}
	public void setSurveyCnt01_4B_4(String surveyCnt01_4B_4) {
		this.surveyCnt01_4B_4 = surveyCnt01_4B_4;
	}
	public String getSurveyCnt02_1A_1() {
		return surveyCnt02_1A_1;
	}
	public void setSurveyCnt02_1A_1(String surveyCnt02_1A_1) {
		this.surveyCnt02_1A_1 = surveyCnt02_1A_1;
	}
	public String getSurveyCnt02_1A_2() {
		return surveyCnt02_1A_2;
	}
	public void setSurveyCnt02_1A_2(String surveyCnt02_1A_2) {
		this.surveyCnt02_1A_2 = surveyCnt02_1A_2;
	}
	public String getSurveyCnt02_1A_3() {
		return surveyCnt02_1A_3;
	}
	public void setSurveyCnt02_1A_3(String surveyCnt02_1A_3) {
		this.surveyCnt02_1A_3 = surveyCnt02_1A_3;
	}
	public String getSurveyCnt02_1A_4() {
		return surveyCnt02_1A_4;
	}
	public void setSurveyCnt02_1A_4(String surveyCnt02_1A_4) {
		this.surveyCnt02_1A_4 = surveyCnt02_1A_4;
	}
	public String getSurveyCnt02_1B_1() {
		return surveyCnt02_1B_1;
	}
	public void setSurveyCnt02_1B_1(String surveyCnt02_1B_1) {
		this.surveyCnt02_1B_1 = surveyCnt02_1B_1;
	}
	public String getSurveyCnt02_1B_2() {
		return surveyCnt02_1B_2;
	}
	public void setSurveyCnt02_1B_2(String surveyCnt02_1B_2) {
		this.surveyCnt02_1B_2 = surveyCnt02_1B_2;
	}
	public String getSurveyCnt02_1B_3() {
		return surveyCnt02_1B_3;
	}
	public void setSurveyCnt02_1B_3(String surveyCnt02_1B_3) {
		this.surveyCnt02_1B_3 = surveyCnt02_1B_3;
	}
	public String getSurveyCnt02_1B_4() {
		return surveyCnt02_1B_4;
	}
	public void setSurveyCnt02_1B_4(String surveyCnt02_1B_4) {
		this.surveyCnt02_1B_4 = surveyCnt02_1B_4;
	}
	public String getSurveyCnt02_2A_1() {
		return surveyCnt02_2A_1;
	}
	public void setSurveyCnt02_2A_1(String surveyCnt02_2A_1) {
		this.surveyCnt02_2A_1 = surveyCnt02_2A_1;
	}
	public String getSurveyCnt02_2A_2() {
		return surveyCnt02_2A_2;
	}
	public void setSurveyCnt02_2A_2(String surveyCnt02_2A_2) {
		this.surveyCnt02_2A_2 = surveyCnt02_2A_2;
	}
	public String getSurveyCnt02_2A_3() {
		return surveyCnt02_2A_3;
	}
	public void setSurveyCnt02_2A_3(String surveyCnt02_2A_3) {
		this.surveyCnt02_2A_3 = surveyCnt02_2A_3;
	}
	public String getSurveyCnt02_2A_4() {
		return surveyCnt02_2A_4;
	}
	public void setSurveyCnt02_2A_4(String surveyCnt02_2A_4) {
		this.surveyCnt02_2A_4 = surveyCnt02_2A_4;
	}
	public String getSurveyCnt02_2B_1() {
		return surveyCnt02_2B_1;
	}
	public void setSurveyCnt02_2B_1(String surveyCnt02_2B_1) {
		this.surveyCnt02_2B_1 = surveyCnt02_2B_1;
	}
	public String getSurveyCnt02_2B_2() {
		return surveyCnt02_2B_2;
	}
	public void setSurveyCnt02_2B_2(String surveyCnt02_2B_2) {
		this.surveyCnt02_2B_2 = surveyCnt02_2B_2;
	}
	public String getSurveyCnt02_2B_3() {
		return surveyCnt02_2B_3;
	}
	public void setSurveyCnt02_2B_3(String surveyCnt02_2B_3) {
		this.surveyCnt02_2B_3 = surveyCnt02_2B_3;
	}
	public String getSurveyCnt02_2B_4() {
		return surveyCnt02_2B_4;
	}
	public void setSurveyCnt02_2B_4(String surveyCnt02_2B_4) {
		this.surveyCnt02_2B_4 = surveyCnt02_2B_4;
	}
	public String getSurveyCnt02_3A_1() {
		return surveyCnt02_3A_1;
	}
	public void setSurveyCnt02_3A_1(String surveyCnt02_3A_1) {
		this.surveyCnt02_3A_1 = surveyCnt02_3A_1;
	}
	public String getSurveyCnt02_3A_2() {
		return surveyCnt02_3A_2;
	}
	public void setSurveyCnt02_3A_2(String surveyCnt02_3A_2) {
		this.surveyCnt02_3A_2 = surveyCnt02_3A_2;
	}
	public String getSurveyCnt02_3A_3() {
		return surveyCnt02_3A_3;
	}
	public void setSurveyCnt02_3A_3(String surveyCnt02_3A_3) {
		this.surveyCnt02_3A_3 = surveyCnt02_3A_3;
	}
	public String getSurveyCnt02_3A_4() {
		return surveyCnt02_3A_4;
	}
	public void setSurveyCnt02_3A_4(String surveyCnt02_3A_4) {
		this.surveyCnt02_3A_4 = surveyCnt02_3A_4;
	}
	public String getSurveyCnt02_3B_1() {
		return surveyCnt02_3B_1;
	}
	public void setSurveyCnt02_3B_1(String surveyCnt02_3B_1) {
		this.surveyCnt02_3B_1 = surveyCnt02_3B_1;
	}
	public String getSurveyCnt02_3B_2() {
		return surveyCnt02_3B_2;
	}
	public void setSurveyCnt02_3B_2(String surveyCnt02_3B_2) {
		this.surveyCnt02_3B_2 = surveyCnt02_3B_2;
	}
	public String getSurveyCnt02_3B_3() {
		return surveyCnt02_3B_3;
	}
	public void setSurveyCnt02_3B_3(String surveyCnt02_3B_3) {
		this.surveyCnt02_3B_3 = surveyCnt02_3B_3;
	}
	public String getSurveyCnt02_3B_4() {
		return surveyCnt02_3B_4;
	}
	public void setSurveyCnt02_3B_4(String surveyCnt02_3B_4) {
		this.surveyCnt02_3B_4 = surveyCnt02_3B_4;
	}
	public String getSurveyCnt02_4A_1() {
		return surveyCnt02_4A_1;
	}
	public void setSurveyCnt02_4A_1(String surveyCnt02_4A_1) {
		this.surveyCnt02_4A_1 = surveyCnt02_4A_1;
	}
	public String getSurveyCnt02_4A_2() {
		return surveyCnt02_4A_2;
	}
	public void setSurveyCnt02_4A_2(String surveyCnt02_4A_2) {
		this.surveyCnt02_4A_2 = surveyCnt02_4A_2;
	}
	public String getSurveyCnt02_4A_3() {
		return surveyCnt02_4A_3;
	}
	public void setSurveyCnt02_4A_3(String surveyCnt02_4A_3) {
		this.surveyCnt02_4A_3 = surveyCnt02_4A_3;
	}
	public String getSurveyCnt02_4A_4() {
		return surveyCnt02_4A_4;
	}
	public void setSurveyCnt02_4A_4(String surveyCnt02_4A_4) {
		this.surveyCnt02_4A_4 = surveyCnt02_4A_4;
	}
	public String getSurveyCnt02_4B_1() {
		return surveyCnt02_4B_1;
	}
	public void setSurveyCnt02_4B_1(String surveyCnt02_4B_1) {
		this.surveyCnt02_4B_1 = surveyCnt02_4B_1;
	}
	public String getSurveyCnt02_4B_2() {
		return surveyCnt02_4B_2;
	}
	public void setSurveyCnt02_4B_2(String surveyCnt02_4B_2) {
		this.surveyCnt02_4B_2 = surveyCnt02_4B_2;
	}
	public String getSurveyCnt02_4B_3() {
		return surveyCnt02_4B_3;
	}
	public void setSurveyCnt02_4B_3(String surveyCnt02_4B_3) {
		this.surveyCnt02_4B_3 = surveyCnt02_4B_3;
	}
	public String getSurveyCnt02_4B_4() {
		return surveyCnt02_4B_4;
	}
	public void setSurveyCnt02_4B_4(String surveyCnt02_4B_4) {
		this.surveyCnt02_4B_4 = surveyCnt02_4B_4;
	}
	public String getSurveyCnt03_1A_1() {
		return surveyCnt03_1A_1;
	}
	public void setSurveyCnt03_1A_1(String surveyCnt03_1A_1) {
		this.surveyCnt03_1A_1 = surveyCnt03_1A_1;
	}
	public String getSurveyCnt03_1A_2() {
		return surveyCnt03_1A_2;
	}
	public void setSurveyCnt03_1A_2(String surveyCnt03_1A_2) {
		this.surveyCnt03_1A_2 = surveyCnt03_1A_2;
	}
	public String getSurveyCnt03_1A_3() {
		return surveyCnt03_1A_3;
	}
	public void setSurveyCnt03_1A_3(String surveyCnt03_1A_3) {
		this.surveyCnt03_1A_3 = surveyCnt03_1A_3;
	}
	public String getSurveyCnt03_1A_4() {
		return surveyCnt03_1A_4;
	}
	public void setSurveyCnt03_1A_4(String surveyCnt03_1A_4) {
		this.surveyCnt03_1A_4 = surveyCnt03_1A_4;
	}
	public String getSurveyCnt03_1B_1() {
		return surveyCnt03_1B_1;
	}
	public void setSurveyCnt03_1B_1(String surveyCnt03_1B_1) {
		this.surveyCnt03_1B_1 = surveyCnt03_1B_1;
	}
	public String getSurveyCnt03_1B_2() {
		return surveyCnt03_1B_2;
	}
	public void setSurveyCnt03_1B_2(String surveyCnt03_1B_2) {
		this.surveyCnt03_1B_2 = surveyCnt03_1B_2;
	}
	public String getSurveyCnt03_1B_3() {
		return surveyCnt03_1B_3;
	}
	public void setSurveyCnt03_1B_3(String surveyCnt03_1B_3) {
		this.surveyCnt03_1B_3 = surveyCnt03_1B_3;
	}
	public String getSurveyCnt03_1B_4() {
		return surveyCnt03_1B_4;
	}
	public void setSurveyCnt03_1B_4(String surveyCnt03_1B_4) {
		this.surveyCnt03_1B_4 = surveyCnt03_1B_4;
	}
	public String getSurveyCnt03_2A_1() {
		return surveyCnt03_2A_1;
	}
	public void setSurveyCnt03_2A_1(String surveyCnt03_2A_1) {
		this.surveyCnt03_2A_1 = surveyCnt03_2A_1;
	}
	public String getSurveyCnt03_2A_2() {
		return surveyCnt03_2A_2;
	}
	public void setSurveyCnt03_2A_2(String surveyCnt03_2A_2) {
		this.surveyCnt03_2A_2 = surveyCnt03_2A_2;
	}
	public String getSurveyCnt03_2A_3() {
		return surveyCnt03_2A_3;
	}
	public void setSurveyCnt03_2A_3(String surveyCnt03_2A_3) {
		this.surveyCnt03_2A_3 = surveyCnt03_2A_3;
	}
	public String getSurveyCnt03_2A_4() {
		return surveyCnt03_2A_4;
	}
	public void setSurveyCnt03_2A_4(String surveyCnt03_2A_4) {
		this.surveyCnt03_2A_4 = surveyCnt03_2A_4;
	}
	public String getSurveyCnt03_2B_1() {
		return surveyCnt03_2B_1;
	}
	public void setSurveyCnt03_2B_1(String surveyCnt03_2B_1) {
		this.surveyCnt03_2B_1 = surveyCnt03_2B_1;
	}
	public String getSurveyCnt03_2B_2() {
		return surveyCnt03_2B_2;
	}
	public void setSurveyCnt03_2B_2(String surveyCnt03_2B_2) {
		this.surveyCnt03_2B_2 = surveyCnt03_2B_2;
	}
	public String getSurveyCnt03_2B_3() {
		return surveyCnt03_2B_3;
	}
	public void setSurveyCnt03_2B_3(String surveyCnt03_2B_3) {
		this.surveyCnt03_2B_3 = surveyCnt03_2B_3;
	}
	public String getSurveyCnt03_2B_4() {
		return surveyCnt03_2B_4;
	}
	public void setSurveyCnt03_2B_4(String surveyCnt03_2B_4) {
		this.surveyCnt03_2B_4 = surveyCnt03_2B_4;
	}
	public String getSurveyCnt03_3A_1() {
		return surveyCnt03_3A_1;
	}
	public void setSurveyCnt03_3A_1(String surveyCnt03_3A_1) {
		this.surveyCnt03_3A_1 = surveyCnt03_3A_1;
	}
	public String getSurveyCnt03_3A_2() {
		return surveyCnt03_3A_2;
	}
	public void setSurveyCnt03_3A_2(String surveyCnt03_3A_2) {
		this.surveyCnt03_3A_2 = surveyCnt03_3A_2;
	}
	public String getSurveyCnt03_3A_3() {
		return surveyCnt03_3A_3;
	}
	public void setSurveyCnt03_3A_3(String surveyCnt03_3A_3) {
		this.surveyCnt03_3A_3 = surveyCnt03_3A_3;
	}
	public String getSurveyCnt03_3A_4() {
		return surveyCnt03_3A_4;
	}
	public void setSurveyCnt03_3A_4(String surveyCnt03_3A_4) {
		this.surveyCnt03_3A_4 = surveyCnt03_3A_4;
	}
	public String getSurveyCnt03_3B_1() {
		return surveyCnt03_3B_1;
	}
	public void setSurveyCnt03_3B_1(String surveyCnt03_3B_1) {
		this.surveyCnt03_3B_1 = surveyCnt03_3B_1;
	}
	public String getSurveyCnt03_3B_2() {
		return surveyCnt03_3B_2;
	}
	public void setSurveyCnt03_3B_2(String surveyCnt03_3B_2) {
		this.surveyCnt03_3B_2 = surveyCnt03_3B_2;
	}
	public String getSurveyCnt03_3B_3() {
		return surveyCnt03_3B_3;
	}
	public void setSurveyCnt03_3B_3(String surveyCnt03_3B_3) {
		this.surveyCnt03_3B_3 = surveyCnt03_3B_3;
	}
	public String getSurveyCnt03_3B_4() {
		return surveyCnt03_3B_4;
	}
	public void setSurveyCnt03_3B_4(String surveyCnt03_3B_4) {
		this.surveyCnt03_3B_4 = surveyCnt03_3B_4;
	}
	public String getSurveyCnt03_4A_1() {
		return surveyCnt03_4A_1;
	}
	public void setSurveyCnt03_4A_1(String surveyCnt03_4A_1) {
		this.surveyCnt03_4A_1 = surveyCnt03_4A_1;
	}
	public String getSurveyCnt03_4A_2() {
		return surveyCnt03_4A_2;
	}
	public void setSurveyCnt03_4A_2(String surveyCnt03_4A_2) {
		this.surveyCnt03_4A_2 = surveyCnt03_4A_2;
	}
	public String getSurveyCnt03_4A_3() {
		return surveyCnt03_4A_3;
	}
	public void setSurveyCnt03_4A_3(String surveyCnt03_4A_3) {
		this.surveyCnt03_4A_3 = surveyCnt03_4A_3;
	}
	public String getSurveyCnt03_4A_4() {
		return surveyCnt03_4A_4;
	}
	public void setSurveyCnt03_4A_4(String surveyCnt03_4A_4) {
		this.surveyCnt03_4A_4 = surveyCnt03_4A_4;
	}
	public String getSurveyCnt03_4B_1() {
		return surveyCnt03_4B_1;
	}
	public void setSurveyCnt03_4B_1(String surveyCnt03_4B_1) {
		this.surveyCnt03_4B_1 = surveyCnt03_4B_1;
	}
	public String getSurveyCnt03_4B_2() {
		return surveyCnt03_4B_2;
	}
	public void setSurveyCnt03_4B_2(String surveyCnt03_4B_2) {
		this.surveyCnt03_4B_2 = surveyCnt03_4B_2;
	}
	public String getSurveyCnt03_4B_3() {
		return surveyCnt03_4B_3;
	}
	public void setSurveyCnt03_4B_3(String surveyCnt03_4B_3) {
		this.surveyCnt03_4B_3 = surveyCnt03_4B_3;
	}
	public String getSurveyCnt03_4B_4() {
		return surveyCnt03_4B_4;
	}
	public void setSurveyCnt03_4B_4(String surveyCnt03_4B_4) {
		this.surveyCnt03_4B_4 = surveyCnt03_4B_4;
	}
	public String getSurveyCnt03_5A_1() {
		return surveyCnt03_5A_1;
	}
	public void setSurveyCnt03_5A_1(String surveyCnt03_5A_1) {
		this.surveyCnt03_5A_1 = surveyCnt03_5A_1;
	}
	public String getSurveyCnt03_5A_2() {
		return surveyCnt03_5A_2;
	}
	public void setSurveyCnt03_5A_2(String surveyCnt03_5A_2) {
		this.surveyCnt03_5A_2 = surveyCnt03_5A_2;
	}
	public String getSurveyCnt03_5A_3() {
		return surveyCnt03_5A_3;
	}
	public void setSurveyCnt03_5A_3(String surveyCnt03_5A_3) {
		this.surveyCnt03_5A_3 = surveyCnt03_5A_3;
	}
	public String getSurveyCnt03_5A_4() {
		return surveyCnt03_5A_4;
	}
	public void setSurveyCnt03_5A_4(String surveyCnt03_5A_4) {
		this.surveyCnt03_5A_4 = surveyCnt03_5A_4;
	}
	public String getSurveyCnt03_5B_1() {
		return surveyCnt03_5B_1;
	}
	public void setSurveyCnt03_5B_1(String surveyCnt03_5B_1) {
		this.surveyCnt03_5B_1 = surveyCnt03_5B_1;
	}
	public String getSurveyCnt03_5B_2() {
		return surveyCnt03_5B_2;
	}
	public void setSurveyCnt03_5B_2(String surveyCnt03_5B_2) {
		this.surveyCnt03_5B_2 = surveyCnt03_5B_2;
	}
	public String getSurveyCnt03_5B_3() {
		return surveyCnt03_5B_3;
	}
	public void setSurveyCnt03_5B_3(String surveyCnt03_5B_3) {
		this.surveyCnt03_5B_3 = surveyCnt03_5B_3;
	}
	public String getSurveyCnt03_5B_4() {
		return surveyCnt03_5B_4;
	}
	public void setSurveyCnt03_5B_4(String surveyCnt03_5B_4) {
		this.surveyCnt03_5B_4 = surveyCnt03_5B_4;
	}
	public String getSurveyCnt04_1A_1() {
		return surveyCnt04_1A_1;
	}
	public void setSurveyCnt04_1A_1(String surveyCnt04_1A_1) {
		this.surveyCnt04_1A_1 = surveyCnt04_1A_1;
	}
	public String getSurveyCnt04_1A_2() {
		return surveyCnt04_1A_2;
	}
	public void setSurveyCnt04_1A_2(String surveyCnt04_1A_2) {
		this.surveyCnt04_1A_2 = surveyCnt04_1A_2;
	}
	public String getSurveyCnt04_1A_3() {
		return surveyCnt04_1A_3;
	}
	public void setSurveyCnt04_1A_3(String surveyCnt04_1A_3) {
		this.surveyCnt04_1A_3 = surveyCnt04_1A_3;
	}
	public String getSurveyCnt04_1A_4() {
		return surveyCnt04_1A_4;
	}
	public void setSurveyCnt04_1A_4(String surveyCnt04_1A_4) {
		this.surveyCnt04_1A_4 = surveyCnt04_1A_4;
	}
	public String getSurveyCnt04_1B_1() {
		return surveyCnt04_1B_1;
	}
	public void setSurveyCnt04_1B_1(String surveyCnt04_1B_1) {
		this.surveyCnt04_1B_1 = surveyCnt04_1B_1;
	}
	public String getSurveyCnt04_1B_2() {
		return surveyCnt04_1B_2;
	}
	public void setSurveyCnt04_1B_2(String surveyCnt04_1B_2) {
		this.surveyCnt04_1B_2 = surveyCnt04_1B_2;
	}
	public String getSurveyCnt04_1B_3() {
		return surveyCnt04_1B_3;
	}
	public void setSurveyCnt04_1B_3(String surveyCnt04_1B_3) {
		this.surveyCnt04_1B_3 = surveyCnt04_1B_3;
	}
	public String getSurveyCnt04_1B_4() {
		return surveyCnt04_1B_4;
	}
	public void setSurveyCnt04_1B_4(String surveyCnt04_1B_4) {
		this.surveyCnt04_1B_4 = surveyCnt04_1B_4;
	}
	public String getSurveyCnt04_2A_1() {
		return surveyCnt04_2A_1;
	}
	public void setSurveyCnt04_2A_1(String surveyCnt04_2A_1) {
		this.surveyCnt04_2A_1 = surveyCnt04_2A_1;
	}
	public String getSurveyCnt04_2A_2() {
		return surveyCnt04_2A_2;
	}
	public void setSurveyCnt04_2A_2(String surveyCnt04_2A_2) {
		this.surveyCnt04_2A_2 = surveyCnt04_2A_2;
	}
	public String getSurveyCnt04_2A_3() {
		return surveyCnt04_2A_3;
	}
	public void setSurveyCnt04_2A_3(String surveyCnt04_2A_3) {
		this.surveyCnt04_2A_3 = surveyCnt04_2A_3;
	}
	public String getSurveyCnt04_2A_4() {
		return surveyCnt04_2A_4;
	}
	public void setSurveyCnt04_2A_4(String surveyCnt04_2A_4) {
		this.surveyCnt04_2A_4 = surveyCnt04_2A_4;
	}
	public String getSurveyCnt04_2B_1() {
		return surveyCnt04_2B_1;
	}
	public void setSurveyCnt04_2B_1(String surveyCnt04_2B_1) {
		this.surveyCnt04_2B_1 = surveyCnt04_2B_1;
	}
	public String getSurveyCnt04_2B_2() {
		return surveyCnt04_2B_2;
	}
	public void setSurveyCnt04_2B_2(String surveyCnt04_2B_2) {
		this.surveyCnt04_2B_2 = surveyCnt04_2B_2;
	}
	public String getSurveyCnt04_2B_3() {
		return surveyCnt04_2B_3;
	}
	public void setSurveyCnt04_2B_3(String surveyCnt04_2B_3) {
		this.surveyCnt04_2B_3 = surveyCnt04_2B_3;
	}
	public String getSurveyCnt04_2B_4() {
		return surveyCnt04_2B_4;
	}
	public void setSurveyCnt04_2B_4(String surveyCnt04_2B_4) {
		this.surveyCnt04_2B_4 = surveyCnt04_2B_4;
	}
	public String getSurveyCnt04_3A_1() {
		return surveyCnt04_3A_1;
	}
	public void setSurveyCnt04_3A_1(String surveyCnt04_3A_1) {
		this.surveyCnt04_3A_1 = surveyCnt04_3A_1;
	}
	public String getSurveyCnt04_3A_2() {
		return surveyCnt04_3A_2;
	}
	public void setSurveyCnt04_3A_2(String surveyCnt04_3A_2) {
		this.surveyCnt04_3A_2 = surveyCnt04_3A_2;
	}
	public String getSurveyCnt04_3A_3() {
		return surveyCnt04_3A_3;
	}
	public void setSurveyCnt04_3A_3(String surveyCnt04_3A_3) {
		this.surveyCnt04_3A_3 = surveyCnt04_3A_3;
	}
	public String getSurveyCnt04_3A_4() {
		return surveyCnt04_3A_4;
	}
	public void setSurveyCnt04_3A_4(String surveyCnt04_3A_4) {
		this.surveyCnt04_3A_4 = surveyCnt04_3A_4;
	}
	public String getSurveyCnt04_3B_1() {
		return surveyCnt04_3B_1;
	}
	public void setSurveyCnt04_3B_1(String surveyCnt04_3B_1) {
		this.surveyCnt04_3B_1 = surveyCnt04_3B_1;
	}
	public String getSurveyCnt04_3B_2() {
		return surveyCnt04_3B_2;
	}
	public void setSurveyCnt04_3B_2(String surveyCnt04_3B_2) {
		this.surveyCnt04_3B_2 = surveyCnt04_3B_2;
	}
	public String getSurveyCnt04_3B_3() {
		return surveyCnt04_3B_3;
	}
	public void setSurveyCnt04_3B_3(String surveyCnt04_3B_3) {
		this.surveyCnt04_3B_3 = surveyCnt04_3B_3;
	}
	public String getSurveyCnt04_3B_4() {
		return surveyCnt04_3B_4;
	}
	public void setSurveyCnt04_3B_4(String surveyCnt04_3B_4) {
		this.surveyCnt04_3B_4 = surveyCnt04_3B_4;
	}
	public String getSurveyCnt04_4A_1() {
		return surveyCnt04_4A_1;
	}
	public void setSurveyCnt04_4A_1(String surveyCnt04_4A_1) {
		this.surveyCnt04_4A_1 = surveyCnt04_4A_1;
	}
	public String getSurveyCnt04_4A_2() {
		return surveyCnt04_4A_2;
	}
	public void setSurveyCnt04_4A_2(String surveyCnt04_4A_2) {
		this.surveyCnt04_4A_2 = surveyCnt04_4A_2;
	}
	public String getSurveyCnt04_4A_3() {
		return surveyCnt04_4A_3;
	}
	public void setSurveyCnt04_4A_3(String surveyCnt04_4A_3) {
		this.surveyCnt04_4A_3 = surveyCnt04_4A_3;
	}
	public String getSurveyCnt04_4A_4() {
		return surveyCnt04_4A_4;
	}
	public void setSurveyCnt04_4A_4(String surveyCnt04_4A_4) {
		this.surveyCnt04_4A_4 = surveyCnt04_4A_4;
	}
	public String getSurveyCnt04_4B_1() {
		return surveyCnt04_4B_1;
	}
	public void setSurveyCnt04_4B_1(String surveyCnt04_4B_1) {
		this.surveyCnt04_4B_1 = surveyCnt04_4B_1;
	}
	public String getSurveyCnt04_4B_2() {
		return surveyCnt04_4B_2;
	}
	public void setSurveyCnt04_4B_2(String surveyCnt04_4B_2) {
		this.surveyCnt04_4B_2 = surveyCnt04_4B_2;
	}
	public String getSurveyCnt04_4B_3() {
		return surveyCnt04_4B_3;
	}
	public void setSurveyCnt04_4B_3(String surveyCnt04_4B_3) {
		this.surveyCnt04_4B_3 = surveyCnt04_4B_3;
	}
	public String getSurveyCnt04_4B_4() {
		return surveyCnt04_4B_4;
	}
	public void setSurveyCnt04_4B_4(String surveyCnt04_4B_4) {
		this.surveyCnt04_4B_4 = surveyCnt04_4B_4;
	}
	public String getSurveyCnt05_1A_1() {
		return surveyCnt05_1A_1;
	}
	public void setSurveyCnt05_1A_1(String surveyCnt05_1A_1) {
		this.surveyCnt05_1A_1 = surveyCnt05_1A_1;
	}
	public String getSurveyCnt05_1A_2() {
		return surveyCnt05_1A_2;
	}
	public void setSurveyCnt05_1A_2(String surveyCnt05_1A_2) {
		this.surveyCnt05_1A_2 = surveyCnt05_1A_2;
	}
	public String getSurveyCnt05_1A_3() {
		return surveyCnt05_1A_3;
	}
	public void setSurveyCnt05_1A_3(String surveyCnt05_1A_3) {
		this.surveyCnt05_1A_3 = surveyCnt05_1A_3;
	}
	public String getSurveyCnt05_1A_4() {
		return surveyCnt05_1A_4;
	}
	public void setSurveyCnt05_1A_4(String surveyCnt05_1A_4) {
		this.surveyCnt05_1A_4 = surveyCnt05_1A_4;
	}
	public String getSurveyCnt05_1B_1() {
		return surveyCnt05_1B_1;
	}
	public void setSurveyCnt05_1B_1(String surveyCnt05_1B_1) {
		this.surveyCnt05_1B_1 = surveyCnt05_1B_1;
	}
	public String getSurveyCnt05_1B_2() {
		return surveyCnt05_1B_2;
	}
	public void setSurveyCnt05_1B_2(String surveyCnt05_1B_2) {
		this.surveyCnt05_1B_2 = surveyCnt05_1B_2;
	}
	public String getSurveyCnt05_1B_3() {
		return surveyCnt05_1B_3;
	}
	public void setSurveyCnt05_1B_3(String surveyCnt05_1B_3) {
		this.surveyCnt05_1B_3 = surveyCnt05_1B_3;
	}
	public String getSurveyCnt05_1B_4() {
		return surveyCnt05_1B_4;
	}
	public void setSurveyCnt05_1B_4(String surveyCnt05_1B_4) {
		this.surveyCnt05_1B_4 = surveyCnt05_1B_4;
	}
	public String getSurveyCnt05_2A_1() {
		return surveyCnt05_2A_1;
	}
	public void setSurveyCnt05_2A_1(String surveyCnt05_2A_1) {
		this.surveyCnt05_2A_1 = surveyCnt05_2A_1;
	}
	public String getSurveyCnt05_2A_2() {
		return surveyCnt05_2A_2;
	}
	public void setSurveyCnt05_2A_2(String surveyCnt05_2A_2) {
		this.surveyCnt05_2A_2 = surveyCnt05_2A_2;
	}
	public String getSurveyCnt05_2A_3() {
		return surveyCnt05_2A_3;
	}
	public void setSurveyCnt05_2A_3(String surveyCnt05_2A_3) {
		this.surveyCnt05_2A_3 = surveyCnt05_2A_3;
	}
	public String getSurveyCnt05_2A_4() {
		return surveyCnt05_2A_4;
	}
	public void setSurveyCnt05_2A_4(String surveyCnt05_2A_4) {
		this.surveyCnt05_2A_4 = surveyCnt05_2A_4;
	}
	public String getSurveyCnt05_2B_1() {
		return surveyCnt05_2B_1;
	}
	public void setSurveyCnt05_2B_1(String surveyCnt05_2B_1) {
		this.surveyCnt05_2B_1 = surveyCnt05_2B_1;
	}
	public String getSurveyCnt05_2B_2() {
		return surveyCnt05_2B_2;
	}
	public void setSurveyCnt05_2B_2(String surveyCnt05_2B_2) {
		this.surveyCnt05_2B_2 = surveyCnt05_2B_2;
	}
	public String getSurveyCnt05_2B_3() {
		return surveyCnt05_2B_3;
	}
	public void setSurveyCnt05_2B_3(String surveyCnt05_2B_3) {
		this.surveyCnt05_2B_3 = surveyCnt05_2B_3;
	}
	public String getSurveyCnt05_2B_4() {
		return surveyCnt05_2B_4;
	}
	public void setSurveyCnt05_2B_4(String surveyCnt05_2B_4) {
		this.surveyCnt05_2B_4 = surveyCnt05_2B_4;
	}
	public String getSurveyCnt05_3A_1() {
		return surveyCnt05_3A_1;
	}
	public void setSurveyCnt05_3A_1(String surveyCnt05_3A_1) {
		this.surveyCnt05_3A_1 = surveyCnt05_3A_1;
	}
	public String getSurveyCnt05_3A_2() {
		return surveyCnt05_3A_2;
	}
	public void setSurveyCnt05_3A_2(String surveyCnt05_3A_2) {
		this.surveyCnt05_3A_2 = surveyCnt05_3A_2;
	}
	public String getSurveyCnt05_3A_3() {
		return surveyCnt05_3A_3;
	}
	public void setSurveyCnt05_3A_3(String surveyCnt05_3A_3) {
		this.surveyCnt05_3A_3 = surveyCnt05_3A_3;
	}
	public String getSurveyCnt05_3A_4() {
		return surveyCnt05_3A_4;
	}
	public void setSurveyCnt05_3A_4(String surveyCnt05_3A_4) {
		this.surveyCnt05_3A_4 = surveyCnt05_3A_4;
	}
	public String getSurveyCnt05_3B_1() {
		return surveyCnt05_3B_1;
	}
	public void setSurveyCnt05_3B_1(String surveyCnt05_3B_1) {
		this.surveyCnt05_3B_1 = surveyCnt05_3B_1;
	}
	public String getSurveyCnt05_3B_2() {
		return surveyCnt05_3B_2;
	}
	public void setSurveyCnt05_3B_2(String surveyCnt05_3B_2) {
		this.surveyCnt05_3B_2 = surveyCnt05_3B_2;
	}
	public String getSurveyCnt05_3B_3() {
		return surveyCnt05_3B_3;
	}
	public void setSurveyCnt05_3B_3(String surveyCnt05_3B_3) {
		this.surveyCnt05_3B_3 = surveyCnt05_3B_3;
	}
	public String getSurveyCnt05_3B_4() {
		return surveyCnt05_3B_4;
	}
	public void setSurveyCnt05_3B_4(String surveyCnt05_3B_4) {
		this.surveyCnt05_3B_4 = surveyCnt05_3B_4;
	}
	public String getSurveyCnt05_4A_1() {
		return surveyCnt05_4A_1;
	}
	public void setSurveyCnt05_4A_1(String surveyCnt05_4A_1) {
		this.surveyCnt05_4A_1 = surveyCnt05_4A_1;
	}
	public String getSurveyCnt05_4A_2() {
		return surveyCnt05_4A_2;
	}
	public void setSurveyCnt05_4A_2(String surveyCnt05_4A_2) {
		this.surveyCnt05_4A_2 = surveyCnt05_4A_2;
	}
	public String getSurveyCnt05_4A_3() {
		return surveyCnt05_4A_3;
	}
	public void setSurveyCnt05_4A_3(String surveyCnt05_4A_3) {
		this.surveyCnt05_4A_3 = surveyCnt05_4A_3;
	}
	public String getSurveyCnt05_4A_4() {
		return surveyCnt05_4A_4;
	}
	public void setSurveyCnt05_4A_4(String surveyCnt05_4A_4) {
		this.surveyCnt05_4A_4 = surveyCnt05_4A_4;
	}
	public String getSurveyCnt05_4B_1() {
		return surveyCnt05_4B_1;
	}
	public void setSurveyCnt05_4B_1(String surveyCnt05_4B_1) {
		this.surveyCnt05_4B_1 = surveyCnt05_4B_1;
	}
	public String getSurveyCnt05_4B_2() {
		return surveyCnt05_4B_2;
	}
	public void setSurveyCnt05_4B_2(String surveyCnt05_4B_2) {
		this.surveyCnt05_4B_2 = surveyCnt05_4B_2;
	}
	public String getSurveyCnt05_4B_3() {
		return surveyCnt05_4B_3;
	}
	public void setSurveyCnt05_4B_3(String surveyCnt05_4B_3) {
		this.surveyCnt05_4B_3 = surveyCnt05_4B_3;
	}
	public String getSurveyCnt05_4B_4() {
		return surveyCnt05_4B_4;
	}
	public void setSurveyCnt05_4B_4(String surveyCnt05_4B_4) {
		this.surveyCnt05_4B_4 = surveyCnt05_4B_4;
	}
	public String getSurveyCnt05_5A_1() {
		return surveyCnt05_5A_1;
	}
	public void setSurveyCnt05_5A_1(String surveyCnt05_5A_1) {
		this.surveyCnt05_5A_1 = surveyCnt05_5A_1;
	}
	public String getSurveyCnt05_5A_2() {
		return surveyCnt05_5A_2;
	}
	public void setSurveyCnt05_5A_2(String surveyCnt05_5A_2) {
		this.surveyCnt05_5A_2 = surveyCnt05_5A_2;
	}
	public String getSurveyCnt05_5A_3() {
		return surveyCnt05_5A_3;
	}
	public void setSurveyCnt05_5A_3(String surveyCnt05_5A_3) {
		this.surveyCnt05_5A_3 = surveyCnt05_5A_3;
	}
	public String getSurveyCnt05_5A_4() {
		return surveyCnt05_5A_4;
	}
	public void setSurveyCnt05_5A_4(String surveyCnt05_5A_4) {
		this.surveyCnt05_5A_4 = surveyCnt05_5A_4;
	}
	public String getSurveyCnt05_5B_1() {
		return surveyCnt05_5B_1;
	}
	public void setSurveyCnt05_5B_1(String surveyCnt05_5B_1) {
		this.surveyCnt05_5B_1 = surveyCnt05_5B_1;
	}
	public String getSurveyCnt05_5B_2() {
		return surveyCnt05_5B_2;
	}
	public void setSurveyCnt05_5B_2(String surveyCnt05_5B_2) {
		this.surveyCnt05_5B_2 = surveyCnt05_5B_2;
	}
	public String getSurveyCnt05_5B_3() {
		return surveyCnt05_5B_3;
	}
	public void setSurveyCnt05_5B_3(String surveyCnt05_5B_3) {
		this.surveyCnt05_5B_3 = surveyCnt05_5B_3;
	}
	public String getSurveyCnt05_5B_4() {
		return surveyCnt05_5B_4;
	}
	public void setSurveyCnt05_5B_4(String surveyCnt05_5B_4) {
		this.surveyCnt05_5B_4 = surveyCnt05_5B_4;
	}
	public String getSurveyCnt06_1A_1() {
		return surveyCnt06_1A_1;
	}
	public void setSurveyCnt06_1A_1(String surveyCnt06_1A_1) {
		this.surveyCnt06_1A_1 = surveyCnt06_1A_1;
	}
	public String getSurveyCnt06_1A_2() {
		return surveyCnt06_1A_2;
	}
	public void setSurveyCnt06_1A_2(String surveyCnt06_1A_2) {
		this.surveyCnt06_1A_2 = surveyCnt06_1A_2;
	}
	public String getSurveyCnt06_1A_3() {
		return surveyCnt06_1A_3;
	}
	public void setSurveyCnt06_1A_3(String surveyCnt06_1A_3) {
		this.surveyCnt06_1A_3 = surveyCnt06_1A_3;
	}
	public String getSurveyCnt06_1A_4() {
		return surveyCnt06_1A_4;
	}
	public void setSurveyCnt06_1A_4(String surveyCnt06_1A_4) {
		this.surveyCnt06_1A_4 = surveyCnt06_1A_4;
	}
	public String getSurveyCnt06_1B_1() {
		return surveyCnt06_1B_1;
	}
	public void setSurveyCnt06_1B_1(String surveyCnt06_1B_1) {
		this.surveyCnt06_1B_1 = surveyCnt06_1B_1;
	}
	public String getSurveyCnt06_1B_2() {
		return surveyCnt06_1B_2;
	}
	public void setSurveyCnt06_1B_2(String surveyCnt06_1B_2) {
		this.surveyCnt06_1B_2 = surveyCnt06_1B_2;
	}
	public String getSurveyCnt06_1B_3() {
		return surveyCnt06_1B_3;
	}
	public void setSurveyCnt06_1B_3(String surveyCnt06_1B_3) {
		this.surveyCnt06_1B_3 = surveyCnt06_1B_3;
	}
	public String getSurveyCnt06_1B_4() {
		return surveyCnt06_1B_4;
	}
	public void setSurveyCnt06_1B_4(String surveyCnt06_1B_4) {
		this.surveyCnt06_1B_4 = surveyCnt06_1B_4;
	}
	public String getSurveyCnt06_2A_1() {
		return surveyCnt06_2A_1;
	}
	public void setSurveyCnt06_2A_1(String surveyCnt06_2A_1) {
		this.surveyCnt06_2A_1 = surveyCnt06_2A_1;
	}
	public String getSurveyCnt06_2A_2() {
		return surveyCnt06_2A_2;
	}
	public void setSurveyCnt06_2A_2(String surveyCnt06_2A_2) {
		this.surveyCnt06_2A_2 = surveyCnt06_2A_2;
	}
	public String getSurveyCnt06_2A_3() {
		return surveyCnt06_2A_3;
	}
	public void setSurveyCnt06_2A_3(String surveyCnt06_2A_3) {
		this.surveyCnt06_2A_3 = surveyCnt06_2A_3;
	}
	public String getSurveyCnt06_2A_4() {
		return surveyCnt06_2A_4;
	}
	public void setSurveyCnt06_2A_4(String surveyCnt06_2A_4) {
		this.surveyCnt06_2A_4 = surveyCnt06_2A_4;
	}
	public String getSurveyCnt06_2B_1() {
		return surveyCnt06_2B_1;
	}
	public void setSurveyCnt06_2B_1(String surveyCnt06_2B_1) {
		this.surveyCnt06_2B_1 = surveyCnt06_2B_1;
	}
	public String getSurveyCnt06_2B_2() {
		return surveyCnt06_2B_2;
	}
	public void setSurveyCnt06_2B_2(String surveyCnt06_2B_2) {
		this.surveyCnt06_2B_2 = surveyCnt06_2B_2;
	}
	public String getSurveyCnt06_2B_3() {
		return surveyCnt06_2B_3;
	}
	public void setSurveyCnt06_2B_3(String surveyCnt06_2B_3) {
		this.surveyCnt06_2B_3 = surveyCnt06_2B_3;
	}
	public String getSurveyCnt06_2B_4() {
		return surveyCnt06_2B_4;
	}
	public void setSurveyCnt06_2B_4(String surveyCnt06_2B_4) {
		this.surveyCnt06_2B_4 = surveyCnt06_2B_4;
	}
	public String getSurveyCnt06_3A_1() {
		return surveyCnt06_3A_1;
	}
	public void setSurveyCnt06_3A_1(String surveyCnt06_3A_1) {
		this.surveyCnt06_3A_1 = surveyCnt06_3A_1;
	}
	public String getSurveyCnt06_3A_2() {
		return surveyCnt06_3A_2;
	}
	public void setSurveyCnt06_3A_2(String surveyCnt06_3A_2) {
		this.surveyCnt06_3A_2 = surveyCnt06_3A_2;
	}
	public String getSurveyCnt06_3A_3() {
		return surveyCnt06_3A_3;
	}
	public void setSurveyCnt06_3A_3(String surveyCnt06_3A_3) {
		this.surveyCnt06_3A_3 = surveyCnt06_3A_3;
	}
	public String getSurveyCnt06_3A_4() {
		return surveyCnt06_3A_4;
	}
	public void setSurveyCnt06_3A_4(String surveyCnt06_3A_4) {
		this.surveyCnt06_3A_4 = surveyCnt06_3A_4;
	}
	public String getSurveyCnt06_3B_1() {
		return surveyCnt06_3B_1;
	}
	public void setSurveyCnt06_3B_1(String surveyCnt06_3B_1) {
		this.surveyCnt06_3B_1 = surveyCnt06_3B_1;
	}
	public String getSurveyCnt06_3B_2() {
		return surveyCnt06_3B_2;
	}
	public void setSurveyCnt06_3B_2(String surveyCnt06_3B_2) {
		this.surveyCnt06_3B_2 = surveyCnt06_3B_2;
	}
	public String getSurveyCnt06_3B_3() {
		return surveyCnt06_3B_3;
	}
	public void setSurveyCnt06_3B_3(String surveyCnt06_3B_3) {
		this.surveyCnt06_3B_3 = surveyCnt06_3B_3;
	}
	public String getSurveyCnt06_3B_4() {
		return surveyCnt06_3B_4;
	}
	public void setSurveyCnt06_3B_4(String surveyCnt06_3B_4) {
		this.surveyCnt06_3B_4 = surveyCnt06_3B_4;
	}
	public String getSurveyCnt06_4A_1() {
		return surveyCnt06_4A_1;
	}
	public void setSurveyCnt06_4A_1(String surveyCnt06_4A_1) {
		this.surveyCnt06_4A_1 = surveyCnt06_4A_1;
	}
	public String getSurveyCnt06_4A_2() {
		return surveyCnt06_4A_2;
	}
	public void setSurveyCnt06_4A_2(String surveyCnt06_4A_2) {
		this.surveyCnt06_4A_2 = surveyCnt06_4A_2;
	}
	public String getSurveyCnt06_4A_3() {
		return surveyCnt06_4A_3;
	}
	public void setSurveyCnt06_4A_3(String surveyCnt06_4A_3) {
		this.surveyCnt06_4A_3 = surveyCnt06_4A_3;
	}
	public String getSurveyCnt06_4A_4() {
		return surveyCnt06_4A_4;
	}
	public void setSurveyCnt06_4A_4(String surveyCnt06_4A_4) {
		this.surveyCnt06_4A_4 = surveyCnt06_4A_4;
	}
	public String getSurveyCnt06_4B_1() {
		return surveyCnt06_4B_1;
	}
	public void setSurveyCnt06_4B_1(String surveyCnt06_4B_1) {
		this.surveyCnt06_4B_1 = surveyCnt06_4B_1;
	}
	public String getSurveyCnt06_4B_2() {
		return surveyCnt06_4B_2;
	}
	public void setSurveyCnt06_4B_2(String surveyCnt06_4B_2) {
		this.surveyCnt06_4B_2 = surveyCnt06_4B_2;
	}
	public String getSurveyCnt06_4B_3() {
		return surveyCnt06_4B_3;
	}
	public void setSurveyCnt06_4B_3(String surveyCnt06_4B_3) {
		this.surveyCnt06_4B_3 = surveyCnt06_4B_3;
	}
	public String getSurveyCnt06_4B_4() {
		return surveyCnt06_4B_4;
	}
	public void setSurveyCnt06_4B_4(String surveyCnt06_4B_4) {
		this.surveyCnt06_4B_4 = surveyCnt06_4B_4;
	}
	public String getSurveyCnt06_5A_1() {
		return surveyCnt06_5A_1;
	}
	public void setSurveyCnt06_5A_1(String surveyCnt06_5A_1) {
		this.surveyCnt06_5A_1 = surveyCnt06_5A_1;
	}
	public String getSurveyCnt06_5A_2() {
		return surveyCnt06_5A_2;
	}
	public void setSurveyCnt06_5A_2(String surveyCnt06_5A_2) {
		this.surveyCnt06_5A_2 = surveyCnt06_5A_2;
	}
	public String getSurveyCnt06_5A_3() {
		return surveyCnt06_5A_3;
	}
	public void setSurveyCnt06_5A_3(String surveyCnt06_5A_3) {
		this.surveyCnt06_5A_3 = surveyCnt06_5A_3;
	}
	public String getSurveyCnt06_5A_4() {
		return surveyCnt06_5A_4;
	}
	public void setSurveyCnt06_5A_4(String surveyCnt06_5A_4) {
		this.surveyCnt06_5A_4 = surveyCnt06_5A_4;
	}
	public String getSurveyCnt06_5B_1() {
		return surveyCnt06_5B_1;
	}
	public void setSurveyCnt06_5B_1(String surveyCnt06_5B_1) {
		this.surveyCnt06_5B_1 = surveyCnt06_5B_1;
	}
	public String getSurveyCnt06_5B_2() {
		return surveyCnt06_5B_2;
	}
	public void setSurveyCnt06_5B_2(String surveyCnt06_5B_2) {
		this.surveyCnt06_5B_2 = surveyCnt06_5B_2;
	}
	public String getSurveyCnt06_5B_3() {
		return surveyCnt06_5B_3;
	}
	public void setSurveyCnt06_5B_3(String surveyCnt06_5B_3) {
		this.surveyCnt06_5B_3 = surveyCnt06_5B_3;
	}
	public String getSurveyCnt06_5B_4() {
		return surveyCnt06_5B_4;
	}
	public void setSurveyCnt06_5B_4(String surveyCnt06_5B_4) {
		this.surveyCnt06_5B_4 = surveyCnt06_5B_4;
	}
	public String getSurveyCnt07_1A() {
		return surveyCnt07_1A;
	}
	public void setSurveyCnt07_1A(String surveyCnt07_1A) {
		this.surveyCnt07_1A = surveyCnt07_1A;
	}
	public String getSurveyCnt07_2A() {
		return surveyCnt07_2A;
	}
	public void setSurveyCnt07_2A(String surveyCnt07_2A) {
		this.surveyCnt07_2A = surveyCnt07_2A;
	}
	public String getSurveyCnt07_3A() {
		return surveyCnt07_3A;
	}
	public void setSurveyCnt07_3A(String surveyCnt07_3A) {
		this.surveyCnt07_3A = surveyCnt07_3A;
	}
	public String getSurveyCnt07_4A() {
		return surveyCnt07_4A;
	}
	public void setSurveyCnt07_4A(String surveyCnt07_4A) {
		this.surveyCnt07_4A = surveyCnt07_4A;
	}
	public String getSurveyCnt07_5A() {
		return surveyCnt07_5A;
	}
	public void setSurveyCnt07_5A(String surveyCnt07_5A) {
		this.surveyCnt07_5A = surveyCnt07_5A;
	}
	public String getSurveyCnt07_6A() {
		return surveyCnt07_6A;
	}
	public void setSurveyCnt07_6A(String surveyCnt07_6A) {
		this.surveyCnt07_6A = surveyCnt07_6A;
	}
	public String getSurveyCnt07_7A() {
		return surveyCnt07_7A;
	}
	public void setSurveyCnt07_7A(String surveyCnt07_7A) {
		this.surveyCnt07_7A = surveyCnt07_7A;
	}
	public String getSurveyCnt07_8A() {
		return surveyCnt07_8A;
	}
	public void setSurveyCnt07_8A(String surveyCnt07_8A) {
		this.surveyCnt07_8A = surveyCnt07_8A;
	}
	public String getSurveyCnt07_1B() {
		return surveyCnt07_1B;
	}
	public void setSurveyCnt07_1B(String surveyCnt07_1B) {
		this.surveyCnt07_1B = surveyCnt07_1B;
	}
	public String getSurveyCnt07_2B() {
		return surveyCnt07_2B;
	}
	public void setSurveyCnt07_2B(String surveyCnt07_2B) {
		this.surveyCnt07_2B = surveyCnt07_2B;
	}
	public String getSurveyCnt07_3B() {
		return surveyCnt07_3B;
	}
	public void setSurveyCnt07_3B(String surveyCnt07_3B) {
		this.surveyCnt07_3B = surveyCnt07_3B;
	}
	public String getSurveyCnt07_4B() {
		return surveyCnt07_4B;
	}
	public void setSurveyCnt07_4B(String surveyCnt07_4B) {
		this.surveyCnt07_4B = surveyCnt07_4B;
	}
	public String getSurveyCnt07_5B() {
		return surveyCnt07_5B;
	}
	public void setSurveyCnt07_5B(String surveyCnt07_5B) {
		this.surveyCnt07_5B = surveyCnt07_5B;
	}
	public String getSurveyCnt07_6B() {
		return surveyCnt07_6B;
	}
	public void setSurveyCnt07_6B(String surveyCnt07_6B) {
		this.surveyCnt07_6B = surveyCnt07_6B;
	}
	public String getSurveyCnt07_7B() {
		return surveyCnt07_7B;
	}
	public void setSurveyCnt07_7B(String surveyCnt07_7B) {
		this.surveyCnt07_7B = surveyCnt07_7B;
	}
	public String getSurveyCnt07_8B() {
		return surveyCnt07_8B;
	}
	public void setSurveyCnt07_8B(String surveyCnt07_8B) {
		this.surveyCnt07_8B = surveyCnt07_8B;
	}
	public String getSurveyCnt07_1_1A_1() {
		return surveyCnt07_1_1A_1;
	}
	public void setSurveyCnt07_1_1A_1(String surveyCnt07_1_1A_1) {
		this.surveyCnt07_1_1A_1 = surveyCnt07_1_1A_1;
	}
	public String getSurveyCnt07_1_1A_2() {
		return surveyCnt07_1_1A_2;
	}
	public void setSurveyCnt07_1_1A_2(String surveyCnt07_1_1A_2) {
		this.surveyCnt07_1_1A_2 = surveyCnt07_1_1A_2;
	}
	public String getSurveyCnt07_1_1A_3() {
		return surveyCnt07_1_1A_3;
	}
	public void setSurveyCnt07_1_1A_3(String surveyCnt07_1_1A_3) {
		this.surveyCnt07_1_1A_3 = surveyCnt07_1_1A_3;
	}
	public String getSurveyCnt07_1_1A_4() {
		return surveyCnt07_1_1A_4;
	}
	public void setSurveyCnt07_1_1A_4(String surveyCnt07_1_1A_4) {
		this.surveyCnt07_1_1A_4 = surveyCnt07_1_1A_4;
	}
	public String getSurveyCnt07_1_1A_5() {
		return surveyCnt07_1_1A_5;
	}
	public void setSurveyCnt07_1_1A_5(String surveyCnt07_1_1A_5) {
		this.surveyCnt07_1_1A_5 = surveyCnt07_1_1A_5;
	}
	public String getSurveyCnt07_1_1A_6() {
		return surveyCnt07_1_1A_6;
	}
	public void setSurveyCnt07_1_1A_6(String surveyCnt07_1_1A_6) {
		this.surveyCnt07_1_1A_6 = surveyCnt07_1_1A_6;
	}
	public String getSurveyCnt07_1_1B_1() {
		return surveyCnt07_1_1B_1;
	}
	public void setSurveyCnt07_1_1B_1(String surveyCnt07_1_1B_1) {
		this.surveyCnt07_1_1B_1 = surveyCnt07_1_1B_1;
	}
	public String getSurveyCnt07_1_1B_2() {
		return surveyCnt07_1_1B_2;
	}
	public void setSurveyCnt07_1_1B_2(String surveyCnt07_1_1B_2) {
		this.surveyCnt07_1_1B_2 = surveyCnt07_1_1B_2;
	}
	public String getSurveyCnt07_1_1B_3() {
		return surveyCnt07_1_1B_3;
	}
	public void setSurveyCnt07_1_1B_3(String surveyCnt07_1_1B_3) {
		this.surveyCnt07_1_1B_3 = surveyCnt07_1_1B_3;
	}
	public String getSurveyCnt07_1_1B_4() {
		return surveyCnt07_1_1B_4;
	}
	public void setSurveyCnt07_1_1B_4(String surveyCnt07_1_1B_4) {
		this.surveyCnt07_1_1B_4 = surveyCnt07_1_1B_4;
	}
	public String getSurveyCnt07_1_1B_5() {
		return surveyCnt07_1_1B_5;
	}
	public void setSurveyCnt07_1_1B_5(String surveyCnt07_1_1B_5) {
		this.surveyCnt07_1_1B_5 = surveyCnt07_1_1B_5;
	}
	public String getSurveyCnt07_1_1B_6() {
		return surveyCnt07_1_1B_6;
	}
	public void setSurveyCnt07_1_1B_6(String surveyCnt07_1_1B_6) {
		this.surveyCnt07_1_1B_6 = surveyCnt07_1_1B_6;
	}
	public String getSurveyCnt07_2_1A_1() {
		return surveyCnt07_2_1A_1;
	}
	public void setSurveyCnt07_2_1A_1(String surveyCnt07_2_1A_1) {
		this.surveyCnt07_2_1A_1 = surveyCnt07_2_1A_1;
	}
	public String getSurveyCnt07_2_1A_2() {
		return surveyCnt07_2_1A_2;
	}
	public void setSurveyCnt07_2_1A_2(String surveyCnt07_2_1A_2) {
		this.surveyCnt07_2_1A_2 = surveyCnt07_2_1A_2;
	}
	public String getSurveyCnt07_2_1A_3() {
		return surveyCnt07_2_1A_3;
	}
	public void setSurveyCnt07_2_1A_3(String surveyCnt07_2_1A_3) {
		this.surveyCnt07_2_1A_3 = surveyCnt07_2_1A_3;
	}
	public String getSurveyCnt07_2_1A_4() {
		return surveyCnt07_2_1A_4;
	}
	public void setSurveyCnt07_2_1A_4(String surveyCnt07_2_1A_4) {
		this.surveyCnt07_2_1A_4 = surveyCnt07_2_1A_4;
	}
	public String getSurveyCnt07_2_1A_5() {
		return surveyCnt07_2_1A_5;
	}
	public void setSurveyCnt07_2_1A_5(String surveyCnt07_2_1A_5) {
		this.surveyCnt07_2_1A_5 = surveyCnt07_2_1A_5;
	}
	public String getSurveyCnt07_2_1A_6() {
		return surveyCnt07_2_1A_6;
	}
	public void setSurveyCnt07_2_1A_6(String surveyCnt07_2_1A_6) {
		this.surveyCnt07_2_1A_6 = surveyCnt07_2_1A_6;
	}
	public String getSurveyCnt07_2_1A_7() {
		return surveyCnt07_2_1A_7;
	}
	public void setSurveyCnt07_2_1A_7(String surveyCnt07_2_1A_7) {
		this.surveyCnt07_2_1A_7 = surveyCnt07_2_1A_7;
	}
	public String getSurveyCnt07_2_1B_1() {
		return surveyCnt07_2_1B_1;
	}
	public void setSurveyCnt07_2_1B_1(String surveyCnt07_2_1B_1) {
		this.surveyCnt07_2_1B_1 = surveyCnt07_2_1B_1;
	}
	public String getSurveyCnt07_2_1B_2() {
		return surveyCnt07_2_1B_2;
	}
	public void setSurveyCnt07_2_1B_2(String surveyCnt07_2_1B_2) {
		this.surveyCnt07_2_1B_2 = surveyCnt07_2_1B_2;
	}
	public String getSurveyCnt07_2_1B_3() {
		return surveyCnt07_2_1B_3;
	}
	public void setSurveyCnt07_2_1B_3(String surveyCnt07_2_1B_3) {
		this.surveyCnt07_2_1B_3 = surveyCnt07_2_1B_3;
	}
	public String getSurveyCnt07_2_1B_4() {
		return surveyCnt07_2_1B_4;
	}
	public void setSurveyCnt07_2_1B_4(String surveyCnt07_2_1B_4) {
		this.surveyCnt07_2_1B_4 = surveyCnt07_2_1B_4;
	}
	public String getSurveyCnt07_2_1B_5() {
		return surveyCnt07_2_1B_5;
	}
	public void setSurveyCnt07_2_1B_5(String surveyCnt07_2_1B_5) {
		this.surveyCnt07_2_1B_5 = surveyCnt07_2_1B_5;
	}
	public String getSurveyCnt07_2_1B_6() {
		return surveyCnt07_2_1B_6;
	}
	public void setSurveyCnt07_2_1B_6(String surveyCnt07_2_1B_6) {
		this.surveyCnt07_2_1B_6 = surveyCnt07_2_1B_6;
	}
	public String getSurveyCnt07_2_1B_7() {
		return surveyCnt07_2_1B_7;
	}
	public void setSurveyCnt07_2_1B_7(String surveyCnt07_2_1B_7) {
		this.surveyCnt07_2_1B_7 = surveyCnt07_2_1B_7;
	}
	public String getSurveyCnt08A_1() {
		return surveyCnt08A_1;
	}
	public void setSurveyCnt08A_1(String surveyCnt08A_1) {
		this.surveyCnt08A_1 = surveyCnt08A_1;
	}
	public String getSurveyCnt08A_2() {
		return surveyCnt08A_2;
	}
	public void setSurveyCnt08A_2(String surveyCnt08A_2) {
		this.surveyCnt08A_2 = surveyCnt08A_2;
	}
	public String getSurveyCnt08A_3() {
		return surveyCnt08A_3;
	}
	public void setSurveyCnt08A_3(String surveyCnt08A_3) {
		this.surveyCnt08A_3 = surveyCnt08A_3;
	}
	public String getSurveyCnt08A_4() {
		return surveyCnt08A_4;
	}
	public void setSurveyCnt08A_4(String surveyCnt08A_4) {
		this.surveyCnt08A_4 = surveyCnt08A_4;
	}
	public String getSurveyCnt08A_5() {
		return surveyCnt08A_5;
	}
	public void setSurveyCnt08A_5(String surveyCnt08A_5) {
		this.surveyCnt08A_5 = surveyCnt08A_5;
	}
	public String getSurveyCnt08B_1() {
		return surveyCnt08B_1;
	}
	public void setSurveyCnt08B_1(String surveyCnt08B_1) {
		this.surveyCnt08B_1 = surveyCnt08B_1;
	}
	public String getSurveyCnt08B_2() {
		return surveyCnt08B_2;
	}
	public void setSurveyCnt08B_2(String surveyCnt08B_2) {
		this.surveyCnt08B_2 = surveyCnt08B_2;
	}
	public String getSurveyCnt08B_3() {
		return surveyCnt08B_3;
	}
	public void setSurveyCnt08B_3(String surveyCnt08B_3) {
		this.surveyCnt08B_3 = surveyCnt08B_3;
	}
	public String getSurveyCnt08B_4() {
		return surveyCnt08B_4;
	}
	public void setSurveyCnt08B_4(String surveyCnt08B_4) {
		this.surveyCnt08B_4 = surveyCnt08B_4;
	}
	public String getSurveyCnt08B_5() {
		return surveyCnt08B_5;
	}
	public void setSurveyCnt08B_5(String surveyCnt08B_5) {
		this.surveyCnt08B_5 = surveyCnt08B_5;
	}
	public String getSurveyCnt09A_1() {
		return surveyCnt09A_1;
	}
	public void setSurveyCnt09A_1(String surveyCnt09A_1) {
		this.surveyCnt09A_1 = surveyCnt09A_1;
	}
	public String getSurveyCnt09A_2() {
		return surveyCnt09A_2;
	}
	public void setSurveyCnt09A_2(String surveyCnt09A_2) {
		this.surveyCnt09A_2 = surveyCnt09A_2;
	}
	public String getSurveyCnt09A_3() {
		return surveyCnt09A_3;
	}
	public void setSurveyCnt09A_3(String surveyCnt09A_3) {
		this.surveyCnt09A_3 = surveyCnt09A_3;
	}
	public String getSurveyCnt09A_4() {
		return surveyCnt09A_4;
	}
	public void setSurveyCnt09A_4(String surveyCnt09A_4) {
		this.surveyCnt09A_4 = surveyCnt09A_4;
	}
	public String getSurveyCnt09A_5() {
		return surveyCnt09A_5;
	}
	public void setSurveyCnt09A_5(String surveyCnt09A_5) {
		this.surveyCnt09A_5 = surveyCnt09A_5;
	}
	public String getSurveyCnt09A_6() {
		return surveyCnt09A_6;
	}
	public void setSurveyCnt09A_6(String surveyCnt09A_6) {
		this.surveyCnt09A_6 = surveyCnt09A_6;
	}
	public String getSurveyCnt09B_1() {
		return surveyCnt09B_1;
	}
	public void setSurveyCnt09B_1(String surveyCnt09B_1) {
		this.surveyCnt09B_1 = surveyCnt09B_1;
	}
	public String getSurveyCnt09B_2() {
		return surveyCnt09B_2;
	}
	public void setSurveyCnt09B_2(String surveyCnt09B_2) {
		this.surveyCnt09B_2 = surveyCnt09B_2;
	}
	public String getSurveyCnt09B_3() {
		return surveyCnt09B_3;
	}
	public void setSurveyCnt09B_3(String surveyCnt09B_3) {
		this.surveyCnt09B_3 = surveyCnt09B_3;
	}
	public String getSurveyCnt09B_4() {
		return surveyCnt09B_4;
	}
	public void setSurveyCnt09B_4(String surveyCnt09B_4) {
		this.surveyCnt09B_4 = surveyCnt09B_4;
	}
	public String getSurveyCnt09B_5() {
		return surveyCnt09B_5;
	}
	public void setSurveyCnt09B_5(String surveyCnt09B_5) {
		this.surveyCnt09B_5 = surveyCnt09B_5;
	}
	public String getSurveyCnt09B_6() {
		return surveyCnt09B_6;
	}
	public void setSurveyCnt09B_6(String surveyCnt09B_6) {
		this.surveyCnt09B_6 = surveyCnt09B_6;
	}
	public String getSurveyCnt10_1A() {
		return surveyCnt10_1A;
	}
	public void setSurveyCnt10_1A(String surveyCnt10_1A) {
		this.surveyCnt10_1A = surveyCnt10_1A;
	}
	public String getSurveyCnt10_2A() {
		return surveyCnt10_2A;
	}
	public void setSurveyCnt10_2A(String surveyCnt10_2A) {
		this.surveyCnt10_2A = surveyCnt10_2A;
	}
	public String getSurveyCnt10_3A() {
		return surveyCnt10_3A;
	}
	public void setSurveyCnt10_3A(String surveyCnt10_3A) {
		this.surveyCnt10_3A = surveyCnt10_3A;
	}
	public String getSurveyCnt10_4A() {
		return surveyCnt10_4A;
	}
	public void setSurveyCnt10_4A(String surveyCnt10_4A) {
		this.surveyCnt10_4A = surveyCnt10_4A;
	}
	public String getSurveyCnt10_5A() {
		return surveyCnt10_5A;
	}
	public void setSurveyCnt10_5A(String surveyCnt10_5A) {
		this.surveyCnt10_5A = surveyCnt10_5A;
	}
	public String getSurveyCnt10_6A() {
		return surveyCnt10_6A;
	}
	public void setSurveyCnt10_6A(String surveyCnt10_6A) {
		this.surveyCnt10_6A = surveyCnt10_6A;
	}
	public String getSurveyCnt10_7A() {
		return surveyCnt10_7A;
	}
	public void setSurveyCnt10_7A(String surveyCnt10_7A) {
		this.surveyCnt10_7A = surveyCnt10_7A;
	}
	public String getSurveyCnt10_8A() {
		return surveyCnt10_8A;
	}
	public void setSurveyCnt10_8A(String surveyCnt10_8A) {
		this.surveyCnt10_8A = surveyCnt10_8A;
	}
	public String getSurveyCnt10_1B() {
		return surveyCnt10_1B;
	}
	public void setSurveyCnt10_1B(String surveyCnt10_1B) {
		this.surveyCnt10_1B = surveyCnt10_1B;
	}
	public String getSurveyCnt10_2B() {
		return surveyCnt10_2B;
	}
	public void setSurveyCnt10_2B(String surveyCnt10_2B) {
		this.surveyCnt10_2B = surveyCnt10_2B;
	}
	public String getSurveyCnt10_3B() {
		return surveyCnt10_3B;
	}
	public void setSurveyCnt10_3B(String surveyCnt10_3B) {
		this.surveyCnt10_3B = surveyCnt10_3B;
	}
	public String getSurveyCnt10_4B() {
		return surveyCnt10_4B;
	}
	public void setSurveyCnt10_4B(String surveyCnt10_4B) {
		this.surveyCnt10_4B = surveyCnt10_4B;
	}
	public String getSurveyCnt10_5B() {
		return surveyCnt10_5B;
	}
	public void setSurveyCnt10_5B(String surveyCnt10_5B) {
		this.surveyCnt10_5B = surveyCnt10_5B;
	}
	public String getSurveyCnt10_6B() {
		return surveyCnt10_6B;
	}
	public void setSurveyCnt10_6B(String surveyCnt10_6B) {
		this.surveyCnt10_6B = surveyCnt10_6B;
	}
	public String getSurveyCnt10_7B() {
		return surveyCnt10_7B;
	}
	public void setSurveyCnt10_7B(String surveyCnt10_7B) {
		this.surveyCnt10_7B = surveyCnt10_7B;
	}
	public String getSurveyCnt10_8B() {
		return surveyCnt10_8B;
	}
	public void setSurveyCnt10_8B(String surveyCnt10_8B) {
		this.surveyCnt10_8B = surveyCnt10_8B;
	}
	public String getSurveyCnt11_1A() {
		return surveyCnt11_1A;
	}
	public void setSurveyCnt11_1A(String surveyCnt11_1A) {
		this.surveyCnt11_1A = surveyCnt11_1A;
	}
	public String getSurveyCnt11_2A() {
		return surveyCnt11_2A;
	}
	public void setSurveyCnt11_2A(String surveyCnt11_2A) {
		this.surveyCnt11_2A = surveyCnt11_2A;
	}
	public String getSurveyCnt11_3A() {
		return surveyCnt11_3A;
	}
	public void setSurveyCnt11_3A(String surveyCnt11_3A) {
		this.surveyCnt11_3A = surveyCnt11_3A;
	}
	public String getSurveyCnt11_4A() {
		return surveyCnt11_4A;
	}
	public void setSurveyCnt11_4A(String surveyCnt11_4A) {
		this.surveyCnt11_4A = surveyCnt11_4A;
	}
	public String getSurveyCnt11_5A() {
		return surveyCnt11_5A;
	}
	public void setSurveyCnt11_5A(String surveyCnt11_5A) {
		this.surveyCnt11_5A = surveyCnt11_5A;
	}
	public String getSurveyCnt11_6A() {
		return surveyCnt11_6A;
	}
	public void setSurveyCnt11_6A(String surveyCnt11_6A) {
		this.surveyCnt11_6A = surveyCnt11_6A;
	}
	public String getSurveyCnt11_1B() {
		return surveyCnt11_1B;
	}
	public void setSurveyCnt11_1B(String surveyCnt11_1B) {
		this.surveyCnt11_1B = surveyCnt11_1B;
	}
	public String getSurveyCnt11_2B() {
		return surveyCnt11_2B;
	}
	public void setSurveyCnt11_2B(String surveyCnt11_2B) {
		this.surveyCnt11_2B = surveyCnt11_2B;
	}
	public String getSurveyCnt11_3B() {
		return surveyCnt11_3B;
	}
	public void setSurveyCnt11_3B(String surveyCnt11_3B) {
		this.surveyCnt11_3B = surveyCnt11_3B;
	}
	public String getSurveyCnt11_4B() {
		return surveyCnt11_4B;
	}
	public void setSurveyCnt11_4B(String surveyCnt11_4B) {
		this.surveyCnt11_4B = surveyCnt11_4B;
	}
	public String getSurveyCnt11_5B() {
		return surveyCnt11_5B;
	}
	public void setSurveyCnt11_5B(String surveyCnt11_5B) {
		this.surveyCnt11_5B = surveyCnt11_5B;
	}
	public String getSurveyCnt11_6B() {
		return surveyCnt11_6B;
	}
	public void setSurveyCnt11_6B(String surveyCnt11_6B) {
		this.surveyCnt11_6B = surveyCnt11_6B;
	}
	public String getSurveyCnt12_1A() {
		return surveyCnt12_1A;
	}
	public void setSurveyCnt12_1A(String surveyCnt12_1A) {
		this.surveyCnt12_1A = surveyCnt12_1A;
	}
	public String getSurveyCnt12_2A() {
		return surveyCnt12_2A;
	}
	public void setSurveyCnt12_2A(String surveyCnt12_2A) {
		this.surveyCnt12_2A = surveyCnt12_2A;
	}
	public String getSurveyCnt12_3A() {
		return surveyCnt12_3A;
	}
	public void setSurveyCnt12_3A(String surveyCnt12_3A) {
		this.surveyCnt12_3A = surveyCnt12_3A;
	}
	public String getSurveyCnt12_4A() {
		return surveyCnt12_4A;
	}
	public void setSurveyCnt12_4A(String surveyCnt12_4A) {
		this.surveyCnt12_4A = surveyCnt12_4A;
	}
	public String getSurveyCnt12_5A() {
		return surveyCnt12_5A;
	}
	public void setSurveyCnt12_5A(String surveyCnt12_5A) {
		this.surveyCnt12_5A = surveyCnt12_5A;
	}
	public String getSurveyCnt12_1B() {
		return surveyCnt12_1B;
	}
	public void setSurveyCnt12_1B(String surveyCnt12_1B) {
		this.surveyCnt12_1B = surveyCnt12_1B;
	}
	public String getSurveyCnt12_2B() {
		return surveyCnt12_2B;
	}
	public void setSurveyCnt12_2B(String surveyCnt12_2B) {
		this.surveyCnt12_2B = surveyCnt12_2B;
	}
	public String getSurveyCnt12_3B() {
		return surveyCnt12_3B;
	}
	public void setSurveyCnt12_3B(String surveyCnt12_3B) {
		this.surveyCnt12_3B = surveyCnt12_3B;
	}
	public String getSurveyCnt12_4B() {
		return surveyCnt12_4B;
	}
	public void setSurveyCnt12_4B(String surveyCnt12_4B) {
		this.surveyCnt12_4B = surveyCnt12_4B;
	}
	public String getSurveyCnt12_5B() {
		return surveyCnt12_5B;
	}
	public void setSurveyCnt12_5B(String surveyCnt12_5B) {
		this.surveyCnt12_5B = surveyCnt12_5B;
	}
	public String getSurveyCnt14A_1() {
		return surveyCnt14A_1;
	}
	public void setSurveyCnt14A_1(String surveyCnt14A_1) {
		this.surveyCnt14A_1 = surveyCnt14A_1;
	}
	public String getSurveyCnt14A_2() {
		return surveyCnt14A_2;
	}
	public void setSurveyCnt14A_2(String surveyCnt14A_2) {
		this.surveyCnt14A_2 = surveyCnt14A_2;
	}
	public String getSurveyCnt14B_1() {
		return surveyCnt14B_1;
	}
	public void setSurveyCnt14B_1(String surveyCnt14B_1) {
		this.surveyCnt14B_1 = surveyCnt14B_1;
	}
	public String getSurveyCnt14B_2() {
		return surveyCnt14B_2;
	}
	public void setSurveyCnt14B_2(String surveyCnt14B_2) {
		this.surveyCnt14B_2 = surveyCnt14B_2;
	}
	public String getSurveyCnt15A_1() {
		return surveyCnt15A_1;
	}
	public void setSurveyCnt15A_1(String surveyCnt15A_1) {
		this.surveyCnt15A_1 = surveyCnt15A_1;
	}
	public String getSurveyCnt15A_2() {
		return surveyCnt15A_2;
	}
	public void setSurveyCnt15A_2(String surveyCnt15A_2) {
		this.surveyCnt15A_2 = surveyCnt15A_2;
	}
	public String getSurveyCnt15A_3() {
		return surveyCnt15A_3;
	}
	public void setSurveyCnt15A_3(String surveyCnt15A_3) {
		this.surveyCnt15A_3 = surveyCnt15A_3;
	}
	public String getSurveyCnt15A_4() {
		return surveyCnt15A_4;
	}
	public void setSurveyCnt15A_4(String surveyCnt15A_4) {
		this.surveyCnt15A_4 = surveyCnt15A_4;
	}
	public String getSurveyCnt15B_1() {
		return surveyCnt15B_1;
	}
	public void setSurveyCnt15B_1(String surveyCnt15B_1) {
		this.surveyCnt15B_1 = surveyCnt15B_1;
	}
	public String getSurveyCnt15B_2() {
		return surveyCnt15B_2;
	}
	public void setSurveyCnt15B_2(String surveyCnt15B_2) {
		this.surveyCnt15B_2 = surveyCnt15B_2;
	}
	public String getSurveyCnt15B_3() {
		return surveyCnt15B_3;
	}
	public void setSurveyCnt15B_3(String surveyCnt15B_3) {
		this.surveyCnt15B_3 = surveyCnt15B_3;
	}
	public String getSurveyCnt15B_4() {
		return surveyCnt15B_4;
	}
	public void setSurveyCnt15B_4(String surveyCnt15B_4) {
		this.surveyCnt15B_4 = surveyCnt15B_4;
	}
	public String getSurveyCnt16A_1() {
		return surveyCnt16A_1;
	}
	public void setSurveyCnt16A_1(String surveyCnt16A_1) {
		this.surveyCnt16A_1 = surveyCnt16A_1;
	}
	public String getSurveyCnt16A_2() {
		return surveyCnt16A_2;
	}
	public void setSurveyCnt16A_2(String surveyCnt16A_2) {
		this.surveyCnt16A_2 = surveyCnt16A_2;
	}
	public String getSurveyCnt16A_3() {
		return surveyCnt16A_3;
	}
	public void setSurveyCnt16A_3(String surveyCnt16A_3) {
		this.surveyCnt16A_3 = surveyCnt16A_3;
	}
	public String getSurveyCnt16A_4() {
		return surveyCnt16A_4;
	}
	public void setSurveyCnt16A_4(String surveyCnt16A_4) {
		this.surveyCnt16A_4 = surveyCnt16A_4;
	}
	public String getSurveyCnt16A_5() {
		return surveyCnt16A_5;
	}
	public void setSurveyCnt16A_5(String surveyCnt16A_5) {
		this.surveyCnt16A_5 = surveyCnt16A_5;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getRange() {
		return range;
	}
	public void setRange(String range) {
		this.range = range;
	}
	public String getDays() {
		return days;
	}
	public void setDays(String days) {
		this.days = days;
	}
	public String getMonths() {
		return months;
	}
	public void setMonths(String months) {
		this.months = months;
	}
	public List<String> getConsultingTypeCbx() {
		return consultingTypeCbx;
	}
	public void setConsultingTypeCbx(List<String> consultingTypeCbx) {
		this.consultingTypeCbx = consultingTypeCbx;
	}
	public List<String> getReceivedTypeCbx() {
		return receivedTypeCbx;
	}
	public void setReceivedTypeCbx(List<String> receivedTypeCbx) {
		this.receivedTypeCbx = receivedTypeCbx;
	}
	public List<String> getConsultingReqTypeCbx() {
		return consultingReqTypeCbx;
	}
	public void setConsultingReqTypeCbx(List<String> consultingReqTypeCbx) {
		this.consultingReqTypeCbx = consultingReqTypeCbx;
	}
	public List<String> getContactMethodTypeCbx() {
		return contactMethodTypeCbx;
	}
	public void setContactMethodTypeCbx(List<String> contactMethodTypeCbx) {
		this.contactMethodTypeCbx = contactMethodTypeCbx;
	}
	public List<String> getClientGenderCbx() {
		return clientGenderCbx;
	}
	public void setClientGenderCbx(List<String> clientGenderCbx) {
		this.clientGenderCbx = clientGenderCbx;
	}
	public List<String> getClientVictimRelTypeCbx() {
		return clientVictimRelTypeCbx;
	}
	public void setClientVictimRelTypeCbx(List<String> clientVictimRelTypeCbx) {
		this.clientVictimRelTypeCbx = clientVictimRelTypeCbx;
	}
	public List<String> getVictimGenderTypeCbx() {
		return victimGenderTypeCbx;
	}
	public void setVictimGenderTypeCbx(List<String> victimGenderTypeCbx) {
		this.victimGenderTypeCbx = victimGenderTypeCbx;
	}
	public List<String> getOffenderGenderTypeCbx() {
		return offenderGenderTypeCbx;
	}
	public void setOffenderGenderTypeCbx(List<String> offenderGenderTypeCbx) {
		this.offenderGenderTypeCbx = offenderGenderTypeCbx;
	}
	public List<String> getOffenderVictimRelTypeCbx() {
		return offenderVictimRelTypeCbx;
	}
	public void setOffenderVictimRelTypeCbx(List<String> offenderVictimRelTypeCbx) {
		this.offenderVictimRelTypeCbx = offenderVictimRelTypeCbx;
	}
	public List<String> getHarmFirstTypeCbx() {
		return harmFirstTypeCbx;
	}
	public void setHarmFirstTypeCbx(List<String> harmFirstTypeCbx) {
		this.harmFirstTypeCbx = harmFirstTypeCbx;
	}
	public List<String> getHarmSecTypeCbx() {
		return harmSecTypeCbx;
	}
	public void setHarmSecTypeCbx(List<String> harmSecTypeCbx) {
		this.harmSecTypeCbx = harmSecTypeCbx;
	}
	public List<String> getResponseTypeIntroOrgCbx() {
		return responseTypeIntroOrgCbx;
	}
	public void setResponseTypeIntroOrgCbx(List<String> responseTypeIntroOrgCbx) {
		this.responseTypeIntroOrgCbx = responseTypeIntroOrgCbx;
	}
	public List<String> getResponseTypeServiceRelCbx() {
		return responseTypeServiceRelCbx;
	}
	public void setResponseTypeServiceRelCbx(List<String> responseTypeServiceRelCbx) {
		this.responseTypeServiceRelCbx = responseTypeServiceRelCbx;
	}
	public List<String> getActionTypeCbx() {
		return actionTypeCbx;
	}
	public void setActionTypeCbx(List<String> actionTypeCbx) {
		this.actionTypeCbx = actionTypeCbx;
	}
	public List<String> getStepStatusCbx() {
		return stepStatusCbx;
	}
	public void setStepStatusCbx(List<String> stepStatusCbx) {
		this.stepStatusCbx = stepStatusCbx;
	}
	public List<String> getActionConsultingTypeCbx() {
		return actionConsultingTypeCbx;
	}
	public void setActionConsultingTypeCbx(List<String> actionConsultingTypeCbx) {
		this.actionConsultingTypeCbx = actionConsultingTypeCbx;
	}
	public List<String> getActionReceivedTypeCbx() {
		return actionReceivedTypeCbx;
	}
	public void setActionReceivedTypeCbx(List<String> actionReceivedTypeCbx) {
		this.actionReceivedTypeCbx = actionReceivedTypeCbx;
	}
	public List<String> getOrgAccidentStepCbx() {
		return orgAccidentStepCbx;
	}
	public void setOrgAccidentStepCbx(List<String> orgAccidentStepCbx) {
		this.orgAccidentStepCbx = orgAccidentStepCbx;
	}
	public List<String> getActionTypeOtherOrgCbx() {
		return actionTypeOtherOrgCbx;
	}
	public void setActionTypeOtherOrgCbx(List<String> actionTypeOtherOrgCbx) {
		this.actionTypeOtherOrgCbx = actionTypeOtherOrgCbx;
	}
	public List<String> getActionTypeServiceRelCbx() {
		return actionTypeServiceRelCbx;
	}
	public void setActionTypeServiceRelCbx(List<String> actionTypeServiceRelCbx) {
		this.actionTypeServiceRelCbx = actionTypeServiceRelCbx;
	}
	public List<String> getActionTypeContCbx() {
		return actionTypeContCbx;
	}
	public void setActionTypeContCbx(List<String> actionTypeContCbx) {
		this.actionTypeContCbx = actionTypeContCbx;
	}
	public String getCounselCnt1() {
		return counselCnt1;
	}
	public void setCounselCnt1(String counselCnt1) {
		this.counselCnt1 = counselCnt1;
	}
	public String getCounselCnt2() {
		return counselCnt2;
	}
	public void setCounselCnt2(String counselCnt2) {
		this.counselCnt2 = counselCnt2;
	}
	public String getCounselCnt3() {
		return counselCnt3;
	}
	public void setCounselCnt3(String counselCnt3) {
		this.counselCnt3 = counselCnt3;
	}
	public String getCounselCnt4() {
		return counselCnt4;
	}
	public void setCounselCnt4(String counselCnt4) {
		this.counselCnt4 = counselCnt4;
	}
	public String getCounselCnt5() {
		return counselCnt5;
	}
	public void setCounselCnt5(String counselCnt5) {
		this.counselCnt5 = counselCnt5;
	}
	public String getCounselCnt6() {
		return counselCnt6;
	}
	public void setCounselCnt6(String counselCnt6) {
		this.counselCnt6 = counselCnt6;
	}
	public String getCounselCnt7() {
		return counselCnt7;
	}
	public void setCounselCnt7(String counselCnt7) {
		this.counselCnt7 = counselCnt7;
	}
	public String getCounselCnt8() {
		return counselCnt8;
	}
	public void setCounselCnt8(String counselCnt8) {
		this.counselCnt8 = counselCnt8;
	}
	public String getActionCnt() {
		return actionCnt;
	}
	public void setActionCnt(String actionCnt) {
		this.actionCnt = actionCnt;
	}
	public String getActionCnt01() {
		return actionCnt01;
	}
	public void setActionCnt01(String actionCnt01) {
		this.actionCnt01 = actionCnt01;
	}
	public String getActionCnt02() {
		return actionCnt02;
	}
	public void setActionCnt02(String actionCnt02) {
		this.actionCnt02 = actionCnt02;
	}
	public String getActionCnt03() {
		return actionCnt03;
	}
	public void setActionCnt03(String actionCnt03) {
		this.actionCnt03 = actionCnt03;
	}
	public String getActionCnt04() {
		return actionCnt04;
	}
	public void setActionCnt04(String actionCnt04) {
		this.actionCnt04 = actionCnt04;
	}
	public String getActionCnt05() {
		return actionCnt05;
	}
	public void setActionCnt05(String actionCnt05) {
		this.actionCnt05 = actionCnt05;
	}
	public String getActionCnt06() {
		return actionCnt06;
	}
	public void setActionCnt06(String actionCnt06) {
		this.actionCnt06 = actionCnt06;
	}
	public String getActionCnt07() {
		return actionCnt07;
	}
	public void setActionCnt07(String actionCnt07) {
		this.actionCnt07 = actionCnt07;
	}
	public String getActionCnt08() {
		return actionCnt08;
	}
	public void setActionCnt08(String actionCnt08) {
		this.actionCnt08 = actionCnt08;
	}
	public String getActionCnt09() {
		return actionCnt09;
	}
	public void setActionCnt09(String actionCnt09) {
		this.actionCnt09 = actionCnt09;
	}
	public String getActionCnt10() {
		return actionCnt10;
	}
	public void setActionCnt10(String actionCnt10) {
		this.actionCnt10 = actionCnt10;
	}
	public String getActionCnt11() {
		return actionCnt11;
	}
	public void setActionCnt11(String actionCnt11) {
		this.actionCnt11 = actionCnt11;
	}
	public String getActionCnt12() {
		return actionCnt12;
	}
	public void setActionCnt12(String actionCnt12) {
		this.actionCnt12 = actionCnt12;
	}
	public String getPrequery1() {
		return prequery1;
	}
	public void setPrequery1(String prequery1) {
		this.prequery1 = prequery1;
	}
	public String getSatisfaction1() {
		return satisfaction1;
	}
	public void setSatisfaction1(String satisfaction1) {
		this.satisfaction1 = satisfaction1;
	}
	public String getSurveyType() {
		return surveyType;
	}
	public void setSurveyType(String surveyType) {
		this.surveyType = surveyType;
	}
	
}