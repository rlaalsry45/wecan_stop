package com.z5.zcms.admsys.user.domain;

import java.io.Serializable;

public class ZDesignVo implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4658153289227675576L;
	
	private String dpkid;
	private String homepage;
	private String sphereetcname;
	private String schoolname;
	private String sdeptname;
	private String sgradename;
	private String introclob;
	private String uselanguage;
	private String isopenlanguage;
	private String scrapnum;
	private String pickupnum;
	private String isopeneducate;
	private String isopentaketrain;
	private String isopenjoinorg;
	private String isopenworkplace;
	private String isopenprize;
	private String isopenlecture;
	private String isopenproject;
	private String isopenpublish;
	private String isopentreatise;
	private String isopendisplay;
	private String isaction;
	private String fkupkid;
	private String isopenjudge;
	private String isopenhomepage;
	private String isopenschoolname;
	private String isopendeptname;
	private String isopengradename;
	
	//기타코드
	private String menupkid;
	private String menumaster;
	private String menucode;
	private String menuname;
	private String ordernum;
	private String writerlevel;
	private String writerid;
	private String modifylevel;
	private String modifyid;
	private String modifydate;
	private String etcexplain;
	
	//분야 tbldesignspmat
	private String matpkid;
	private String spherecode;
	
	//학력 tbldesigngrad
	private String itempkid;
	private String isposinout;
	private String graduatedate;
	private String graduatename;
	private String majorname;
	private String degreegubun;
	private String isuse;
	private String regdate;
	private String fkdpkid;
	
	//연수 - tbldesigntrain
	private String startdate;
	private String enddate;
	private String taketrainname;
	private String taketrainorg;
	
	//가입단체 - tbldesigngrade  의 joinorgname 에 숫자로 들어가 있으며, tbletccode 의 menupkid 와 매핑되어 있음.
	private String joinorgname;
	
	//직장경력 - tbldesignwork
	private String workplacename;
	
	//교육경력 - tbldesignlect
	private String lectureorg;
	private String lecturename;
	
	//연구실적/프로젝트 경력 - tbldesignproj
	private String projectname;
	private String projectorg;
	
	//저서 - tbldesignpubs
	private String publishdate;
	private String writingsname;
	private String compublish;
	
	//논문 - tbldesigntreat
	private String expressdate;
	private String treatisename;
	private String treatisegubun;
	private String expressorg;
	
	//전시경력 - tbldesigndisp
	private String displaydate;
	private String displayname;
	private String displayplace;
	
	//심사경력 - tbldesignjudge
	private String judgedate;
	private String judgegubun;
	private String judgename;
	
	//상훈 - tbldesignpriz
	private String prizedate;
	private String prizename;
	private String prizeorg;
	
	
	
	public String getMenupkid() {
		return menupkid;
	}
	public void setMenupkid(String menupkid) {
		this.menupkid = menupkid;
	}
	public String getMenumaster() {
		return menumaster;
	}
	public void setMenumaster(String menumaster) {
		this.menumaster = menumaster;
	}
	public String getMenucode() {
		return menucode;
	}
	public void setMenucode(String menucode) {
		this.menucode = menucode;
	}
	public String getMenuname() {
		return menuname;
	}
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
	public String getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}
	public String getWriterlevel() {
		return writerlevel;
	}
	public void setWriterlevel(String writerlevel) {
		this.writerlevel = writerlevel;
	}
	public String getWriterid() {
		return writerid;
	}
	public void setWriterid(String writerid) {
		this.writerid = writerid;
	}
	public String getModifylevel() {
		return modifylevel;
	}
	public void setModifylevel(String modifylevel) {
		this.modifylevel = modifylevel;
	}
	public String getModifyid() {
		return modifyid;
	}
	public void setModifyid(String modifyid) {
		this.modifyid = modifyid;
	}
	public String getModifydate() {
		return modifydate;
	}
	public void setModifydate(String modifydate) {
		this.modifydate = modifydate;
	}
	public String getEtcexplain() {
		return etcexplain;
	}
	public void setEtcexplain(String etcexplain) {
		this.etcexplain = etcexplain;
	}
	public String getMatpkid() {
		return matpkid;
	}
	public void setMatpkid(String matpkid) {
		this.matpkid = matpkid;
	}
	public String getSpherecode() {
		return spherecode;
	}
	public void setSpherecode(String spherecode) {
		this.spherecode = spherecode;
	}
	public String getDpkid() {
		return dpkid;
	}
	public void setDpkid(String dpkid) {
		this.dpkid = dpkid;
	}
	public String getHomepage() {
		return homepage;
	}
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}
	public String getSphereetcname() {
		return sphereetcname;
	}
	public void setSphereetcname(String sphereetcname) {
		this.sphereetcname = sphereetcname;
	}
	public String getSchoolname() {
		return schoolname;
	}
	public void setSchoolname(String schoolname) {
		this.schoolname = schoolname;
	}
	public String getSdeptname() {
		return sdeptname;
	}
	public void setSdeptname(String sdeptname) {
		this.sdeptname = sdeptname;
	}
	public String getSgradename() {
		return sgradename;
	}
	public void setSgradename(String sgradename) {
		this.sgradename = sgradename;
	}
	public String getIntroclob() {
		return introclob;
	}
	public void setIntroclob(String introclob) {
		this.introclob = introclob;
	}
	public String getUselanguage() {
		return uselanguage;
	}
	public void setUselanguage(String uselanguage) {
		this.uselanguage = uselanguage;
	}
	public String getIsopenlanguage() {
		return isopenlanguage;
	}
	public void setIsopenlanguage(String isopenlanguage) {
		this.isopenlanguage = isopenlanguage;
	}
	public String getScrapnum() {
		return scrapnum;
	}
	public void setScrapnum(String scrapnum) {
		this.scrapnum = scrapnum;
	}
	public String getPickupnum() {
		return pickupnum;
	}
	public void setPickupnum(String pickupnum) {
		this.pickupnum = pickupnum;
	}
	public String getIsopeneducate() {
		return isopeneducate;
	}
	public void setIsopeneducate(String isopeneducate) {
		this.isopeneducate = isopeneducate;
	}
	public String getIsopentaketrain() {
		return isopentaketrain;
	}
	public void setIsopentaketrain(String isopentaketrain) {
		this.isopentaketrain = isopentaketrain;
	}
	public String getIsopenjoinorg() {
		return isopenjoinorg;
	}
	public void setIsopenjoinorg(String isopenjoinorg) {
		this.isopenjoinorg = isopenjoinorg;
	}
	public String getIsopenworkplace() {
		return isopenworkplace;
	}
	public void setIsopenworkplace(String isopenworkplace) {
		this.isopenworkplace = isopenworkplace;
	}
	public String getIsopenprize() {
		return isopenprize;
	}
	public void setIsopenprize(String isopenprize) {
		this.isopenprize = isopenprize;
	}
	public String getIsopenlecture() {
		return isopenlecture;
	}
	public void setIsopenlecture(String isopenlecture) {
		this.isopenlecture = isopenlecture;
	}
	public String getIsopenproject() {
		return isopenproject;
	}
	public void setIsopenproject(String isopenproject) {
		this.isopenproject = isopenproject;
	}
	public String getIsopenpublish() {
		return isopenpublish;
	}
	public void setIsopenpublish(String isopenpublish) {
		this.isopenpublish = isopenpublish;
	}
	public String getIsopentreatise() {
		return isopentreatise;
	}
	public void setIsopentreatise(String isopentreatise) {
		this.isopentreatise = isopentreatise;
	}
	public String getIsopendisplay() {
		return isopendisplay;
	}
	public void setIsopendisplay(String isopendisplay) {
		this.isopendisplay = isopendisplay;
	}
	public String getIsaction() {
		return isaction;
	}
	public void setIsaction(String isaction) {
		this.isaction = isaction;
	}
	public String getFkupkid() {
		return fkupkid;
	}
	public void setFkupkid(String fkupkid) {
		this.fkupkid = fkupkid;
	}
	public String getIsopenjudge() {
		return isopenjudge;
	}
	public void setIsopenjudge(String isopenjudge) {
		this.isopenjudge = isopenjudge;
	}
	public String getIsopenhomepage() {
		return isopenhomepage;
	}
	public void setIsopenhomepage(String isopenhomepage) {
		this.isopenhomepage = isopenhomepage;
	}
	public String getIsopenschoolname() {
		return isopenschoolname;
	}
	public void setIsopenschoolname(String isopenschoolname) {
		this.isopenschoolname = isopenschoolname;
	}
	public String getIsopendeptname() {
		return isopendeptname;
	}
	public void setIsopendeptname(String isopendeptname) {
		this.isopendeptname = isopendeptname;
	}
	public String getIsopengradename() {
		return isopengradename;
	}
	public void setIsopengradename(String isopengradename) {
		this.isopengradename = isopengradename;
	}
	public String getItempkid() {
		return itempkid;
	}
	public void setItempkid(String itempkid) {
		this.itempkid = itempkid;
	}
	public String getIsposinout() {
		return isposinout;
	}
	public void setIsposinout(String isposinout) {
		this.isposinout = isposinout;
	}
	public String getGraduatedate() {
		return graduatedate;
	}
	public void setGraduatedate(String graduatedate) {
		this.graduatedate = graduatedate;
	}
	public String getGraduatename() {
		return graduatename;
	}
	public void setGraduatename(String graduatename) {
		this.graduatename = graduatename;
	}
	public String getMajorname() {
		return majorname;
	}
	public void setMajorname(String majorname) {
		this.majorname = majorname;
	}
	public String getDegreegubun() {
		return degreegubun;
	}
	public void setDegreegubun(String degreegubun) {
		this.degreegubun = degreegubun;
	}
	public String getIsuse() {
		return isuse;
	}
	public void setIsuse(String isuse) {
		this.isuse = isuse;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getFkdpkid() {
		return fkdpkid;
	}
	public void setFkdpkid(String fkdpkid) {
		this.fkdpkid = fkdpkid;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getTaketrainname() {
		return taketrainname;
	}
	public void setTaketrainname(String taketrainname) {
		this.taketrainname = taketrainname;
	}
	public String getTaketrainorg() {
		return taketrainorg;
	}
	public void setTaketrainorg(String taketrainorg) {
		this.taketrainorg = taketrainorg;
	}
	public String getJoinorgname() {
		return joinorgname;
	}
	public void setJoinorgname(String joinorgname) {
		this.joinorgname = joinorgname;
	}
	public String getWorkplacename() {
		return workplacename;
	}
	public void setWorkplacename(String workplacename) {
		this.workplacename = workplacename;
	}
	public String getLectureorg() {
		return lectureorg;
	}
	public void setLectureorg(String lectureorg) {
		this.lectureorg = lectureorg;
	}
	public String getLecturename() {
		return lecturename;
	}
	public void setLecturename(String lecturename) {
		this.lecturename = lecturename;
	}
	public String getProjectname() {
		return projectname;
	}
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
	public String getProjectorg() {
		return projectorg;
	}
	public void setProjectorg(String projectorg) {
		this.projectorg = projectorg;
	}
	public String getPublishdate() {
		return publishdate;
	}
	public void setPublishdate(String publishdate) {
		this.publishdate = publishdate;
	}
	public String getWritingsname() {
		return writingsname;
	}
	public void setWritingsname(String writingsname) {
		this.writingsname = writingsname;
	}
	public String getCompublish() {
		return compublish;
	}
	public void setCompublish(String compublish) {
		this.compublish = compublish;
	}
	public String getExpressdate() {
		return expressdate;
	}
	public void setExpressdate(String expressdate) {
		this.expressdate = expressdate;
	}
	public String getTreatisename() {
		return treatisename;
	}
	public void setTreatisename(String treatisename) {
		this.treatisename = treatisename;
	}
	public String getTreatisegubun() {
		return treatisegubun;
	}
	public void setTreatisegubun(String treatisegubun) {
		this.treatisegubun = treatisegubun;
	}
	public String getExpressorg() {
		return expressorg;
	}
	public void setExpressorg(String expressorg) {
		this.expressorg = expressorg;
	}
	public String getDisplaydate() {
		return displaydate;
	}
	public void setDisplaydate(String displaydate) {
		this.displaydate = displaydate;
	}
	public String getDisplayname() {
		return displayname;
	}
	public void setDisplayname(String displayname) {
		this.displayname = displayname;
	}
	public String getDisplayplace() {
		return displayplace;
	}
	public void setDisplayplace(String displayplace) {
		this.displayplace = displayplace;
	}
	public String getJudgedate() {
		return judgedate;
	}
	public void setJudgedate(String judgedate) {
		this.judgedate = judgedate;
	}
	public String getJudgegubun() {
		return judgegubun;
	}
	public void setJudgegubun(String judgegubun) {
		this.judgegubun = judgegubun;
	}
	public String getJudgename() {
		return judgename;
	}
	public void setJudgename(String judgename) {
		this.judgename = judgename;
	}
	public String getPrizedate() {
		return prizedate;
	}
	public void setPrizedate(String prizedate) {
		this.prizedate = prizedate;
	}
	public String getPrizename() {
		return prizename;
	}
	public void setPrizename(String prizename) {
		this.prizename = prizename;
	}
	public String getPrizeorg() {
		return prizeorg;
	}
	public void setPrizeorg(String prizeorg) {
		this.prizeorg = prizeorg;
	}
	
}
