package com.z5.zcms.admsys.user.domain;

import java.util.List;

import com.z5.zcms.admsys.common.domain.CommonVo;

public class SearchUser extends CommonVo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4651901786747384820L;

	private String userno;
	private String userid;
	private String useridx;
	private String username;
	private String username2;
	private String work_grade;			//회원등급
	private String usersex;
	private String useroutrequest;
	private String dept_nm;
	private String dept_full_nm;
	private String userdatereg;
	private String userbirth;
	private String useraddrno;
	private String useremail;
	private String usermobile;
	private String usertel;
	private String useraddr;
	private String branch; 				//plus 지회
	private String usercname;
	private String postuserselect;
	private String postuseraddrno;
	private String postuseraddr;
	private String postuseraddr2;
	private String usercompanystatus;
	private String usercaddrno;
	private String usercaddr;
	private String tel_offc;
	private String userfax;
	private String nominator;
	private String lasteducation;		//최종학력
	private List<String> lasteducationArr;//학력 arr
	private String annualpause;
	private String semimemberconfirm;
	private String graduation0;
	private String university0;
	private String major0;
	private String degrees0;
	private String graduation1;
	private String university1;
	private String major1;
	private String degrees1;
	private String graduation2;
	private String university2;
	private String major2;
	private String degrees2;
	private String cond4 = "";
	private String cond5 = "";
	private String searchtype;
	private String keyword;
	private String usernostart;
	private String usernoend;
	private String sdatetype;
	private String sdateys;
	private String sdatems;
	private String sdateds;
	private String sdateye;
	private String sdateme;
	private String sdatede;
	private String st_sec1;//회원번호,이름,ID,우편번호 선택
	private String st_sec2;//오름차순 내림차순
	private String st_sec3;//회원번호,이름,ID,우편번호 선택
	private String st_sec4;//오름차순 내림차순
	private String st_sec5;//회원번호,이름,ID,우편번호 선택
	private String st_sec6;//오름차순 내림차순
	private String column;//검색결과 페이지에서 조건을 담고 있는 변수
	private String sc_sec1_val;//회원구분 리스트
	private String sd_sec1;//회원구분 or and
	private String sc_sec2_val;//지회구분 리스트
	private String sd_sec2;//지회구분 or and
	private String workplace; //직장종류
	private String sc_sec4_val;//직장구분 리스트
	private String sd_sec4;//지작구분 or and
	private String executive; //임원종류
	private String executivenm; //임원종류이름
	private List<String> executiveArr;//다중검색용 arr
	private String sc_sec5_val;//임원구분 리스트
	private String sd_sec5;//임원구분 or and
	private String committee; //위원회종류
	private String committeenm; //위원회종류이름
	private List<String> committeeArr; //위원회종류 검색용 arr
	private String sc_sec11_val;//위원회구분 리스트
	private String sd_sec11;//위원회구분 or and
	private String sc_sec12_val;//최종학력
	private String sd_sec12;//위원회구분 or and
	
	private String groupuser;
	private String paytype;
	private String postal;
	private String university;
	private List<String> universityArr;
	private String degrees; //학위 0졸업1수료2재학중
	
	private String duetype;
	private String duestart;
	private String dueend;
	private String duepaytype;
	private String dueyear;
	private String duepayquery;
	
	
	private String d2000;
	private String d2001;
	private String d2002;
	private String d2003;
	private String d2004;
	private String d2005;
	private String d2006;
	private String d2007;
	private String d2008;
	private String d2009;
	private String d2010;
	private String d2011;
	private String d2012;
	private String d2013;
	private String d2014;
	private String d2015;
	private String d2016;
	private String d2017;
	private String d2018;
	private String d2019;
	private String d2020;
	private String d2021;
	private String d2022;
	private String d2023;
	private String d2024;
	private String e2000;
	private String e2001;
	private String e2002;
	private String e2003;
	private String e2004;
	private String e2005;
	private String e2006;
	private String e2007;
	private String e2008;
	private String e2009;
	private String e2010;
	private String e2011;
	private String e2012;
	private String e2013;
	private String e2014;
	private String e2015;
	private String e2016;
	private String e2017;
	private String e2018;
	private String e2019;
	private String e2020;
	private String e2021;
	private String e2022;
	private String e2023;
	private String e2024;

	
	private List<String> dueYearArr;
	
	
	
	
	
	public String getUseridx() {
		return useridx;
	}
	public void setUseridx(String useridx) {
		this.useridx = useridx;
	}
	public String getD2000() {
		return d2000;
	}
	public void setD2000(String d2000) {
		this.d2000 = d2000;
	}
	public String getE2000() {
		return e2000;
	}
	public void setE2000(String e2000) {
		this.e2000 = e2000;
	}
	public String getDuepayquery() {
		return duepayquery;
	}
	public void setDuepayquery(String duepayquery) {
		this.duepayquery = duepayquery;
	}
	public String getDueyear() {
		return dueyear;
	}
	public void setDueyear(String dueyear) {
		this.dueyear = dueyear;
	}
	public List<String> getDueYearArr() {
		return dueYearArr;
	}
	public void setDueYearArr(List<String> dueYearArr) {
		this.dueYearArr = dueYearArr;
	}
	public String getDuetype() {
		return duetype;
	}
	public void setDuetype(String duetype) {
		this.duetype = duetype;
	}
	public String getDuestart() {
		return duestart;
	}
	public void setDuestart(String duestart) {
		this.duestart = duestart;
	}
	public String getDueend() {
		return dueend;
	}
	public void setDueend(String dueend) {
		this.dueend = dueend;
	}
	public String getDuepaytype() {
		return duepaytype;
	}
	public void setDuepaytype(String duepaytype) {
		this.duepaytype = duepaytype;
	}
	public String getD2001() {
		return d2001;
	}
	public void setD2001(String d2001) {
		this.d2001 = d2001;
	}
	public String getD2002() {
		return d2002;
	}
	public void setD2002(String d2002) {
		this.d2002 = d2002;
	}
	public String getD2003() {
		return d2003;
	}
	public void setD2003(String d2003) {
		this.d2003 = d2003;
	}
	public String getD2004() {
		return d2004;
	}
	public void setD2004(String d2004) {
		this.d2004 = d2004;
	}
	public String getD2005() {
		return d2005;
	}
	public void setD2005(String d2005) {
		this.d2005 = d2005;
	}
	public String getD2006() {
		return d2006;
	}
	public void setD2006(String d2006) {
		this.d2006 = d2006;
	}
	public String getD2007() {
		return d2007;
	}
	public void setD2007(String d2007) {
		this.d2007 = d2007;
	}
	public String getD2008() {
		return d2008;
	}
	public void setD2008(String d2008) {
		this.d2008 = d2008;
	}
	public String getD2009() {
		return d2009;
	}
	public void setD2009(String d2009) {
		this.d2009 = d2009;
	}
	public String getD2010() {
		return d2010;
	}
	public void setD2010(String d2010) {
		this.d2010 = d2010;
	}
	public String getD2011() {
		return d2011;
	}
	public void setD2011(String d2011) {
		this.d2011 = d2011;
	}
	public String getD2012() {
		return d2012;
	}
	public void setD2012(String d2012) {
		this.d2012 = d2012;
	}
	public String getD2013() {
		return d2013;
	}
	public void setD2013(String d2013) {
		this.d2013 = d2013;
	}
	public String getD2014() {
		return d2014;
	}
	public void setD2014(String d2014) {
		this.d2014 = d2014;
	}
	public String getD2015() {
		return d2015;
	}
	public void setD2015(String d2015) {
		this.d2015 = d2015;
	}
	public String getD2016() {
		return d2016;
	}
	public void setD2016(String d2016) {
		this.d2016 = d2016;
	}
	public String getD2017() {
		return d2017;
	}
	public void setD2017(String d2017) {
		this.d2017 = d2017;
	}
	public String getD2018() {
		return d2018;
	}
	public void setD2018(String d2018) {
		this.d2018 = d2018;
	}
	public String getD2019() {
		return d2019;
	}
	public void setD2019(String d2019) {
		this.d2019 = d2019;
	}
	public String getD2020() {
		return d2020;
	}
	public void setD2020(String d2020) {
		this.d2020 = d2020;
	}
	public String getD2021() {
		return d2021;
	}
	public void setD2021(String d2021) {
		this.d2021 = d2021;
	}
	public String getD2022() {
		return d2022;
	}
	public void setD2022(String d2022) {
		this.d2022 = d2022;
	}
	public String getD2023() {
		return d2023;
	}
	public void setD2023(String d2023) {
		this.d2023 = d2023;
	}
	public String getD2024() {
		return d2024;
	}
	public void setD2024(String d2024) {
		this.d2024 = d2024;
	}
	public String getE2001() {
		return e2001;
	}
	public void setE2001(String e2001) {
		this.e2001 = e2001;
	}
	public String getE2002() {
		return e2002;
	}
	public void setE2002(String e2002) {
		this.e2002 = e2002;
	}
	public String getE2003() {
		return e2003;
	}
	public void setE2003(String e2003) {
		this.e2003 = e2003;
	}
	public String getE2004() {
		return e2004;
	}
	public void setE2004(String e2004) {
		this.e2004 = e2004;
	}
	public String getE2005() {
		return e2005;
	}
	public void setE2005(String e2005) {
		this.e2005 = e2005;
	}
	public String getE2006() {
		return e2006;
	}
	public void setE2006(String e2006) {
		this.e2006 = e2006;
	}
	public String getE2007() {
		return e2007;
	}
	public void setE2007(String e2007) {
		this.e2007 = e2007;
	}
	public String getE2008() {
		return e2008;
	}
	public void setE2008(String e2008) {
		this.e2008 = e2008;
	}
	public String getE2009() {
		return e2009;
	}
	public void setE2009(String e2009) {
		this.e2009 = e2009;
	}
	public String getE2010() {
		return e2010;
	}
	public void setE2010(String e2010) {
		this.e2010 = e2010;
	}
	public String getE2011() {
		return e2011;
	}
	public void setE2011(String e2011) {
		this.e2011 = e2011;
	}
	public String getE2012() {
		return e2012;
	}
	public void setE2012(String e2012) {
		this.e2012 = e2012;
	}
	public String getE2013() {
		return e2013;
	}
	public void setE2013(String e2013) {
		this.e2013 = e2013;
	}
	public String getE2014() {
		return e2014;
	}
	public void setE2014(String e2014) {
		this.e2014 = e2014;
	}
	public String getE2015() {
		return e2015;
	}
	public void setE2015(String e2015) {
		this.e2015 = e2015;
	}
	public String getE2016() {
		return e2016;
	}
	public void setE2016(String e2016) {
		this.e2016 = e2016;
	}
	public String getE2017() {
		return e2017;
	}
	public void setE2017(String e2017) {
		this.e2017 = e2017;
	}
	public String getE2018() {
		return e2018;
	}
	public void setE2018(String e2018) {
		this.e2018 = e2018;
	}
	public String getE2019() {
		return e2019;
	}
	public void setE2019(String e2019) {
		this.e2019 = e2019;
	}
	public String getE2020() {
		return e2020;
	}
	public void setE2020(String e2020) {
		this.e2020 = e2020;
	}
	public String getE2021() {
		return e2021;
	}
	public void setE2021(String e2021) {
		this.e2021 = e2021;
	}
	public String getE2022() {
		return e2022;
	}
	public void setE2022(String e2022) {
		this.e2022 = e2022;
	}
	public String getE2023() {
		return e2023;
	}
	public void setE2023(String e2023) {
		this.e2023 = e2023;
	}
	public String getE2024() {
		return e2024;
	}
	public void setE2024(String e2024) {
		this.e2024 = e2024;
	}
	public String getPostuseraddrno() {
		return postuseraddrno;
	}
	public void setPostuseraddrno(String postuseraddrno) {
		this.postuseraddrno = postuseraddrno;
	}
	public String getPostuseraddr() {
		return postuseraddr;
	}
	public void setPostuseraddr(String postuseraddr) {
		this.postuseraddr = postuseraddr;
	}
	public String getPostuseraddr2() {
		return postuseraddr2;
	}
	public void setPostuseraddr2(String postuseraddr2) {
		this.postuseraddr2 = postuseraddr2;
	}
	public String getUserfax() {
		return userfax;
	}
	public void setUserfax(String userfax) {
		this.userfax = userfax;
	}
	public List<String> getLasteducationArr() {
		return lasteducationArr;
	}
	public void setLasteducationArr(List<String> lasteducationArr) {
		this.lasteducationArr = lasteducationArr;
	}
	public String getSc_sec12_val() {
		return sc_sec12_val;
	}
	public void setSc_sec12_val(String sc_sec12_val) {
		this.sc_sec12_val = sc_sec12_val;
	}
	public String getSd_sec12() {
		return sd_sec12;
	}
	public void setSd_sec12(String sd_sec12) {
		this.sd_sec12 = sd_sec12;
	}
	public String getDegrees0() {
		return degrees0;
	}
	public void setDegrees0(String degrees0) {
		this.degrees0 = degrees0;
	}
	public String getDegrees1() {
		return degrees1;
	}
	public void setDegrees1(String degrees1) {
		this.degrees1 = degrees1;
	}
	public String getDegrees2() {
		return degrees2;
	}
	public void setDegrees2(String degrees2) {
		this.degrees2 = degrees2;
	}
	public String getDegrees() {
		return degrees;
	}
	public void setDegrees(String degrees) {
		this.degrees = degrees;
	}
	public List<String> getUniversityArr() {
		return universityArr;
	}
	public void setUniversityArr(List<String> universityArr) {
		this.universityArr = universityArr;
	}
	public String getUniversity() {
		return university;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public String getExecutivenm() {
		return executivenm;
	}
	public void setExecutivenm(String executivenm) {
		this.executivenm = executivenm;
	}
	public String getCommitteenm() {
		return committeenm;
	}
	public void setCommitteenm(String committeenm) {
		this.committeenm = committeenm;
	}
	public List<String> getExecutiveArr() {
		return executiveArr;
	}
	public void setExecutiveArr(List<String> executiveArr) {
		this.executiveArr = executiveArr;
	}
	public List<String> getCommitteeArr() {
		return committeeArr;
	}
	public void setCommitteeArr(List<String> committeeArr) {
		this.committeeArr = committeeArr;
	}
	public String getCommittee() {
		return committee;
	}
	public void setCommittee(String committee) {
		this.committee = committee;
	}
	public String getSc_sec11_val() {
		return sc_sec11_val;
	}
	public void setSc_sec11_val(String sc_sec11_val) {
		this.sc_sec11_val = sc_sec11_val;
	}
	public String getSd_sec11() {
		return sd_sec11;
	}
	public void setSd_sec11(String sd_sec11) {
		this.sd_sec11 = sd_sec11;
	}
	public String getGroupuser() {
		return groupuser;
	}
	public void setGroupuser(String groupuser) {
		this.groupuser = groupuser;
	}
	public String getPaytype() {
		return paytype;
	}
	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}
	public String getPostal() {
		return postal;
	}
	public void setPostal(String postal) {
		this.postal = postal;
	}
	public String getExecutive() {
		return executive;
	}
	public void setExecutive(String executive) {
		this.executive = executive;
	}
	public String getSc_sec5_val() {
		return sc_sec5_val;
	}
	public void setSc_sec5_val(String sc_sec5_val) {
		this.sc_sec5_val = sc_sec5_val;
	}
	public String getSd_sec5() {
		return sd_sec5;
	}
	public void setSd_sec5(String sd_sec5) {
		this.sd_sec5 = sd_sec5;
	}
	public String getWorkplace() {
		return workplace;
	}
	public void setWorkplace(String workplace) {
		this.workplace = workplace;
	}
	public String getSc_sec4_val() {
		return sc_sec4_val;
	}
	public void setSc_sec4_val(String sc_sec4_val) {
		this.sc_sec4_val = sc_sec4_val;
	}
	public String getSd_sec4() {
		return sd_sec4;
	}
	public void setSd_sec4(String sd_sec4) {
		this.sd_sec4 = sd_sec4;
	}
	public String getSd_sec1() {
		return sd_sec1;
	}
	public void setSd_sec1(String sd_sec1) {
		this.sd_sec1 = sd_sec1;
	}
	public String getSd_sec2() {
		return sd_sec2;
	}
	public void setSd_sec2(String sd_sec2) {
		this.sd_sec2 = sd_sec2;
	}
	public String getSc_sec1_val() {
		return sc_sec1_val;
	}
	public void setSc_sec1_val(String sc_sec1_val) {
		this.sc_sec1_val = sc_sec1_val;
	}
	public String getSc_sec2_val() {
		return sc_sec2_val;
	}
	public void setSc_sec2_val(String sc_sec2_val) {
		this.sc_sec2_val = sc_sec2_val;
	}
	public String getTel_offc() {
		return tel_offc;
	}
	public void setTel_offc(String tel_offc) {
		this.tel_offc = tel_offc;
	}
	public String getColumn() {
		return column;
	}
	public void setColumn(String column) {
		this.column = column;
	}
	public String getSdatetype() {
		return sdatetype;
	}
	public void setSdatetype(String sdatetype) {
		this.sdatetype = sdatetype;
	}
	public String getSdateys() {
		return sdateys;
	}
	public void setSdateys(String sdateys) {
		this.sdateys = sdateys;
	}
	public String getSdatems() {
		return sdatems;
	}
	public void setSdatems(String sdatems) {
		this.sdatems = sdatems;
	}
	public String getSdateds() {
		return sdateds;
	}
	public void setSdateds(String sdateds) {
		this.sdateds = sdateds;
	}
	public String getSdateye() {
		return sdateye;
	}
	public void setSdateye(String sdateye) {
		this.sdateye = sdateye;
	}
	public String getSdateme() {
		return sdateme;
	}
	public void setSdateme(String sdateme) {
		this.sdateme = sdateme;
	}
	public String getSdatede() {
		return sdatede;
	}
	public void setSdatede(String sdatede) {
		this.sdatede = sdatede;
	}
	public String getSt_sec1() {
		return st_sec1;
	}
	public void setSt_sec1(String st_sec1) {
		this.st_sec1 = st_sec1;
	}
	public String getSt_sec2() {
		return st_sec2;
	}
	public void setSt_sec2(String st_sec2) {
		this.st_sec2 = st_sec2;
	}
	public String getSt_sec3() {
		return st_sec3;
	}
	public void setSt_sec3(String st_sec3) {
		this.st_sec3 = st_sec3;
	}
	public String getSt_sec4() {
		return st_sec4;
	}
	public void setSt_sec4(String st_sec4) {
		this.st_sec4 = st_sec4;
	}
	public String getSt_sec5() {
		return st_sec5;
	}
	public void setSt_sec5(String st_sec5) {
		this.st_sec5 = st_sec5;
	}
	public String getSt_sec6() {
		return st_sec6;
	}
	public void setSt_sec6(String st_sec6) {
		this.st_sec6 = st_sec6;
	}
	public String getUsernostart() {
		return usernostart;
	}
	public void setUsernostart(String usernostart) {
		this.usernostart = usernostart;
	}
	public String getUsernoend() {
		return usernoend;
	}
	public void setUsernoend(String usernoend) {
		this.usernoend = usernoend;
	}
	public String getSearchtype() {
		return searchtype;
	}
	public void setSearchtype(String searchtype) {
		this.searchtype = searchtype;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getCond4() {
		return cond4;
	}
	public void setCond4(String cond4) {
		this.cond4 = cond4;
	}
	public String getCond5() {
		return cond5;
	}
	public void setCond5(String cond5) {
		this.cond5 = cond5;
	}
	public String getUserno() {
		return userno;
	}
	public void setUserno(String userno) {
		this.userno = userno;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsername2() {
		return username2;
	}
	public void setUsername2(String username2) {
		this.username2 = username2;
	}
	public String getWork_grade() {
		return work_grade;
	}
	public void setWork_grade(String work_grade) {
		this.work_grade = work_grade;
	}
	public String getUsersex() {
		return usersex;
	}
	public void setUsersex(String usersex) {
		this.usersex = usersex;
	}
	public String getUseroutrequest() {
		return useroutrequest;
	}
	public void setUseroutrequest(String useroutrequest) {
		this.useroutrequest = useroutrequest;
	}
	public String getDept_nm() {
		return dept_nm;
	}
	public void setDept_nm(String dept_nm) {
		this.dept_nm = dept_nm;
	}
	public String getDept_full_nm() {
		return dept_full_nm;
	}
	public void setDept_full_nm(String dept_full_nm) {
		this.dept_full_nm = dept_full_nm;
	}
	public String getUserdatereg() {
		return userdatereg;
	}
	public void setUserdatereg(String userdatereg) {
		this.userdatereg = userdatereg;
	}
	public String getUserbirth() {
		return userbirth;
	}
	public void setUserbirth(String userbirth) {
		this.userbirth = userbirth;
	}
	public String getUseraddrno() {
		return useraddrno;
	}
	public void setUseraddrno(String useraddrno) {
		this.useraddrno = useraddrno;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	public String getUsermobile() {
		return usermobile;
	}
	public void setUsermobile(String usermobile) {
		this.usermobile = usermobile;
	}
	public String getUsertel() {
		return usertel;
	}
	public void setUsertel(String usertel) {
		this.usertel = usertel;
	}
	public String getUseraddr() {
		return useraddr;
	}
	public void setUseraddr(String useraddr) {
		this.useraddr = useraddr;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getUsercname() {
		return usercname;
	}
	public void setUsercname(String usercname) {
		this.usercname = usercname;
	}
	public String getPostuserselect() {
		return postuserselect;
	}
	public void setPostuserselect(String postuserselect) {
		this.postuserselect = postuserselect;
	}
	public String getUsercompanystatus() {
		return usercompanystatus;
	}
	public void setUsercompanystatus(String usercompanystatus) {
		this.usercompanystatus = usercompanystatus;
	}
	public String getUsercaddrno() {
		return usercaddrno;
	}
	public void setUsercaddrno(String usercaddrno) {
		this.usercaddrno = usercaddrno;
	}
	public String getUsercaddr() {
		return usercaddr;
	}
	public void setUsercaddr(String usercaddr) {
		this.usercaddr = usercaddr;
	}
	public String getNominator() {
		return nominator;
	}
	public void setNominator(String nominator) {
		this.nominator = nominator;
	}
	public String getLasteducation() {
		return lasteducation;
	}
	public void setLasteducation(String lasteducation) {
		this.lasteducation = lasteducation;
	}
	public String getAnnualpause() {
		return annualpause;
	}
	public void setAnnualpause(String annualpause) {
		this.annualpause = annualpause;
	}
	public String getSemimemberconfirm() {
		return semimemberconfirm;
	}
	public void setSemimemberconfirm(String semimemberconfirm) {
		this.semimemberconfirm = semimemberconfirm;
	}
	public String getGraduation0() {
		return graduation0;
	}
	public void setGraduation0(String graduation0) {
		this.graduation0 = graduation0;
	}
	public String getUniversity0() {
		return university0;
	}
	public void setUniversity0(String university0) {
		this.university0 = university0;
	}
	public String getMajor0() {
		return major0;
	}
	public void setMajor0(String major0) {
		this.major0 = major0;
	}
	public String getGraduation1() {
		return graduation1;
	}
	public void setGraduation1(String graduation1) {
		this.graduation1 = graduation1;
	}
	public String getUniversity1() {
		return university1;
	}
	public void setUniversity1(String university1) {
		this.university1 = university1;
	}
	public String getMajor1() {
		return major1;
	}
	public void setMajor1(String major1) {
		this.major1 = major1;
	}
	public String getGraduation2() {
		return graduation2;
	}
	public void setGraduation2(String graduation2) {
		this.graduation2 = graduation2;
	}
	public String getUniversity2() {
		return university2;
	}
	public void setUniversity2(String university2) {
		this.university2 = university2;
	}
	public String getMajor2() {
		return major2;
	}
	public void setMajor2(String major2) {
		this.major2 = major2;
	}
	
	
	
	
	
}
