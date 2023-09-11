package com.z5.zcms.admsys.site.domain;

import com.z5.zcms.admsys.common.domain.CommonVo;

public class ZsiteVo extends CommonVo {

    /**
     *
     */
    private static final long serialVersionUID = -2904533167366016006L;

    private String nos;
    private String origindomain;
    private String sitedatemod;
    private String sitedatereg;
    private int siteno;
    private int siteorder;
    private String sitestatus;
    private String sitewebtitle;
    private String table;
    private String userid;

    private String redirectuse;
    private String redirectmenuno;

    private String underCNumber;
    private int mainmaxno;


    public int getMainmaxno() {
        return mainmaxno;
    }

    public void setMainmaxno(int mainmaxno) {
        this.mainmaxno = mainmaxno;
    }

    public String getUnderCNumber() {
        return underCNumber;
    }

    public void setUnderCNumber(String underCNumber) {
        this.underCNumber = underCNumber;
    }

    public String getRedirectuse() {
        return redirectuse;
    }

    public void setRedirectuse(String redirectuse) {
        this.redirectuse = redirectuse;
    }


    public String getRedirectmenuno() {
        return redirectmenuno;
    }

    public void setRedirectmenuno(String redirectmenuno) {
        this.redirectmenuno = redirectmenuno;
    }

    public String getNos() {
        return nos;
    }

    public void setNos(String nos) {
        this.nos = nos;
    }

    public String getOrigindomain() {
        return origindomain;
    }

    public void setOrigindomain(String origindomain) {
        this.origindomain = origindomain;
    }

    public String getSitedatemod() {
        return sitedatemod;
    }

    public void setSitedatemod(String sitedatemod) {
        this.sitedatemod = sitedatemod;
    }

    public String getSitedatereg() {
        return sitedatereg;
    }

    public void setSitedatereg(String sitedatereg) {
        this.sitedatereg = sitedatereg;
    }

    public int getSiteno() {
        return siteno;
    }

    public void setSiteno(int siteno) {
        this.siteno = siteno;
    }

    public int getSiteorder() {
        return siteorder;
    }

    public void setSiteorder(int siteorder) {
        this.siteorder = siteorder;
    }

    public String getSitestatus() {
        return sitestatus;
    }

    public void setSitestatus(String sitestatus) {
        this.sitestatus = sitestatus;
    }

    public String getSitewebtitle() {
        return sitewebtitle;
    }

    public void setSitewebtitle(String sitewebtitle) {
        this.sitewebtitle = sitewebtitle;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "ZsiteVo{" +
                "nos='" + nos + '\'' +
                ", origindomain='" + origindomain + '\'' +
                ", sitedatemod='" + sitedatemod + '\'' +
                ", sitedatereg='" + sitedatereg + '\'' +
                ", siteno=" + siteno +
                ", siteorder=" + siteorder +
                ", sitestatus='" + sitestatus + '\'' +
                ", sitewebtitle='" + sitewebtitle + '\'' +
                ", table='" + table + '\'' +
                ", userid='" + userid + '\'' +
                ", redirectuse='" + redirectuse + '\'' +
                ", redirectmenuno='" + redirectmenuno + '\'' +
                ", underCNumber='" + underCNumber + '\'' +
                ", mainmaxno=" + mainmaxno +
                '}';
    }
}
