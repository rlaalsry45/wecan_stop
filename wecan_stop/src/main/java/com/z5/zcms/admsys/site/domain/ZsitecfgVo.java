package com.z5.zcms.admsys.site.domain;

import com.z5.zcms.admsys.common.domain.CommonVo;

/**
 * @author &#xae40;&#xbb38;&#xc11d;
 * @version 1.0
 * @Class Name : ZsitecfgVO.java
 * @Description : Zsitecfg VO class
 * @Modification Information
 * @see Copyright (C) All right reserved.
 * @since 2013
 */
public class ZsitecfgVo extends CommonVo {

    private static final long serialVersionUID = 5798060727136268098L;

    private int    sitecfgno;
    private String sitecfgzoom;
    private String sitecfgprint;
    private String sitecfgemail;
    private String sitecfgscrap;
    private String sitecfgval;
    private int    sitecfgvalstep;
    private int    sitecfgvalmax;
    private int    sitecfgvalmin;
    private String sitecfgvalway;
    private String sitecfgvalimgorg;
    private String sitecfgvalimgsave;
    private String sitecfgopinion;
    private String sitecfgopinionuser;
    private int    siteno;
    private String sitecfgmaincss;
    private String sitecfgmainjs;
    private String sitecfgsubcss;
    private String sitecfgsubjs;
    private String sitecfgtoptpl;
    private String sitecfglefttpl;
    private String sitecfgrighttpl;
    private String sitecfgbottomtpl;
    private int    sitecfgmain;
    private String userid;
    private String sitecfgdatemod;
    private String sitecfgdatereg;
    private String sitecfgdtd;
    private String sitecfghtm;
    private String sitecfgmeta;
    private int    isuseheadtag;//헤더부분 메타테그를 사용할지 말지를 선택한다. 1:삽입, 0:삽입안함

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getSitecfgno() {
        return sitecfgno;
    }

    public void setSitecfgno(int sitecfgno) {
        this.sitecfgno = sitecfgno;
    }

    public String getSitecfgzoom() {
        return sitecfgzoom;
    }

    public void setSitecfgzoom(String sitecfgzoom) {
        this.sitecfgzoom = sitecfgzoom;
    }

    public String getSitecfgprint() {
        return sitecfgprint;
    }

    public void setSitecfgprint(String sitecfgprint) {
        this.sitecfgprint = sitecfgprint;
    }

    public String getSitecfgemail() {
        return sitecfgemail;
    }

    public void setSitecfgemail(String sitecfgemail) {
        this.sitecfgemail = sitecfgemail;
    }

    public String getSitecfgscrap() {
        return sitecfgscrap;
    }

    public void setSitecfgscrap(String sitecfgscrap) {
        this.sitecfgscrap = sitecfgscrap;
    }

    public String getSitecfgval() {
        return sitecfgval;
    }

    public void setSitecfgval(String sitecfgval) {
        this.sitecfgval = sitecfgval;
    }

    public int getSitecfgvalstep() {
        return sitecfgvalstep;
    }

    public void setSitecfgvalstep(int sitecfgvalstep) {
        this.sitecfgvalstep = sitecfgvalstep;
    }

    public int getSitecfgvalmax() {
        return sitecfgvalmax;
    }

    public void setSitecfgvalmax(int sitecfgvalmax) {
        this.sitecfgvalmax = sitecfgvalmax;
    }

    public int getSitecfgvalmin() {
        return sitecfgvalmin;
    }

    public void setSitecfgvalmin(int sitecfgvalmin) {
        this.sitecfgvalmin = sitecfgvalmin;
    }

    public String getSitecfgvalway() {
        return sitecfgvalway;
    }

    public void setSitecfgvalway(String sitecfgvalway) {
        this.sitecfgvalway = sitecfgvalway;
    }

    public String getSitecfgvalimgorg() {
        return sitecfgvalimgorg;
    }

    public void setSitecfgvalimgorg(String sitecfgvalimgorg) {
        this.sitecfgvalimgorg = sitecfgvalimgorg;
    }

    public String getSitecfgvalimgsave() {
        return sitecfgvalimgsave;
    }

    public void setSitecfgvalimgsave(String sitecfgvalimgsave) {
        this.sitecfgvalimgsave = sitecfgvalimgsave;
    }

    public String getSitecfgopinion() {
        return sitecfgopinion;
    }

    public void setSitecfgopinion(String sitecfgopinion) {
        this.sitecfgopinion = sitecfgopinion;
    }

    public String getSitecfgopinionuser() {
        return sitecfgopinionuser;
    }

    public void setSitecfgopinionuser(String sitecfgopinionuser) {
        this.sitecfgopinionuser = sitecfgopinionuser;
    }

    public int getSiteno() {
        return siteno;
    }

    public void setSiteno(int siteno) {
        this.siteno = siteno;
    }

    public String getSitecfgmaincss() {
        return sitecfgmaincss;
    }

    public void setSitecfgmaincss(String sitecfgmaincss) {
        this.sitecfgmaincss = sitecfgmaincss;
    }

    public String getSitecfgmainjs() {
        return sitecfgmainjs;
    }

    public void setSitecfgmainjs(String sitecfgmainjs) {
        this.sitecfgmainjs = sitecfgmainjs;
    }

    public String getSitecfgsubcss() {
        return sitecfgsubcss;
    }

    public void setSitecfgsubcss(String sitecfgsubcss) {
        this.sitecfgsubcss = sitecfgsubcss;
    }

    public String getSitecfgsubjs() {
        return sitecfgsubjs;
    }

    public void setSitecfgsubjs(String sitecfgsubjs) {
        this.sitecfgsubjs = sitecfgsubjs;
    }

    public String getSitecfgtoptpl() {
        return sitecfgtoptpl;
    }

    public void setSitecfgtoptpl(String sitecfgtoptpl) {
        this.sitecfgtoptpl = sitecfgtoptpl;
    }

    public String getSitecfglefttpl() {
        return sitecfglefttpl;
    }

    public void setSitecfglefttpl(String sitecfglefttpl) {
        this.sitecfglefttpl = sitecfglefttpl;
    }

    public String getSitecfgrighttpl() {
        return sitecfgrighttpl;
    }

    public void setSitecfgrighttpl(String sitecfgrighttpl) {
        this.sitecfgrighttpl = sitecfgrighttpl;
    }

    public String getSitecfgbottomtpl() {
        return sitecfgbottomtpl;
    }

    public void setSitecfgbottomtpl(String sitecfgbottomtpl) {
        this.sitecfgbottomtpl = sitecfgbottomtpl;
    }

    public int getSitecfgmain() {
        return sitecfgmain;
    }

    public void setSitecfgmain(int sitecfgmain) {
        this.sitecfgmain = sitecfgmain;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getSitecfgdatemod() {
        return sitecfgdatemod;
    }

    public void setSitecfgdatemod(String sitecfgdatemod) {
        this.sitecfgdatemod = sitecfgdatemod;
    }

    public String getSitecfgdatereg() {
        return sitecfgdatereg;
    }

    public void setSitecfgdatereg(String sitecfgdatereg) {
        this.sitecfgdatereg = sitecfgdatereg;
    }

    public String getSitecfgdtd() {
        return sitecfgdtd;
    }

    public void setSitecfgdtd(String sitecfgdtd) {
        this.sitecfgdtd = sitecfgdtd;
    }

    public String getSitecfghtm() {
        return sitecfghtm;
    }

    public void setSitecfghtm(String sitecfghtm) {
        this.sitecfghtm = sitecfghtm;
    }

    public String getSitecfgmeta() {
        return sitecfgmeta;
    }

    public void setSitecfgmeta(String sitecfgmeta) {
        this.sitecfgmeta = sitecfgmeta;
    }

    public int getIsuseheadtag() {
        return isuseheadtag;
    }

    public void setIsuseheadtag(int isuseheadtag) {
        this.isuseheadtag = isuseheadtag;
    }

    @Override
    public String toString() {
        return "ZsitecfgVo{" +
                "sitecfgno=" + sitecfgno +
                ", sitecfgzoom='" + sitecfgzoom + '\'' +
                ", sitecfgprint='" + sitecfgprint + '\'' +
                ", sitecfgemail='" + sitecfgemail + '\'' +
                ", sitecfgscrap='" + sitecfgscrap + '\'' +
                ", sitecfgval='" + sitecfgval + '\'' +
                ", sitecfgvalstep=" + sitecfgvalstep +
                ", sitecfgvalmax=" + sitecfgvalmax +
                ", sitecfgvalmin=" + sitecfgvalmin +
                ", sitecfgvalway='" + sitecfgvalway + '\'' +
                ", sitecfgvalimgorg='" + sitecfgvalimgorg + '\'' +
                ", sitecfgvalimgsave='" + sitecfgvalimgsave + '\'' +
                ", sitecfgopinion='" + sitecfgopinion + '\'' +
                ", sitecfgopinionuser='" + sitecfgopinionuser + '\'' +
                ", siteno=" + siteno +
                ", sitecfgmaincss='" + sitecfgmaincss + '\'' +
                ", sitecfgmainjs='" + sitecfgmainjs + '\'' +
                ", sitecfgsubcss='" + sitecfgsubcss + '\'' +
                ", sitecfgsubjs='" + sitecfgsubjs + '\'' +
                ", sitecfgtoptpl='" + sitecfgtoptpl + '\'' +
                ", sitecfglefttpl='" + sitecfglefttpl + '\'' +
                ", sitecfgrighttpl='" + sitecfgrighttpl + '\'' +
                ", sitecfgbottomtpl='" + sitecfgbottomtpl + '\'' +
                ", sitecfgmain=" + sitecfgmain +
                ", userid='" + userid + '\'' +
                ", sitecfgdatemod='" + sitecfgdatemod + '\'' +
                ", sitecfgdatereg='" + sitecfgdatereg + '\'' +
                ", sitecfgdtd='" + sitecfgdtd + '\'' +
                ", sitecfghtm='" + sitecfghtm + '\'' +
                ", sitecfgmeta='" + sitecfgmeta + '\'' +
                ", isuseheadtag=" + isuseheadtag +
                '}';
    }
}

