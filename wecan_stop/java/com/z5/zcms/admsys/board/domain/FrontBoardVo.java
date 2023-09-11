package com.z5.zcms.admsys.board.domain;

import com.z5.zcms.admsys.common.domain.CommonVo;

import java.util.Arrays;

public class FrontBoardVo extends CommonVo {

    /**
     *
     */
    private static final long serialVersionUID = 1735228258034918201L;

    private int    bbsno;
    private int    siteno;
    private int    boardno;
    private String refno;
    private int    bbstopno;
    private int    bbslevel;
    private int    bbsstep;
    private int    bbsparentno;
    private String userid;
    private String bbspasswd;
    private String bbsip;
    private int    bbshit;
    private String bbstitle;
    private String bbsconts;
    private String bbscontstype;
    private String bbscatenos;
    private String bbsnotice;
    private String bbssecret;
    private String bbsdatereg;
    private String bbsdatemod;
    private String bbsusername;
    private String bbsusercode;
    private String bbsuseremail;
    private String bbsuserhomepage;
    private String bbsusertel;
    private String bbsusermobile;
    private String bbsuseraddr;
    private String sponsor;
    private String place;
    private String joinnum;
    private String approval;
    private int    shw_yn;
    private int    isadmin;
    private String seqname;

    private String commentYN;

    private String   etc1;
    private String   etc2;
    private String   etc3;
    private String   etc4;
    private String   etc5;
    private String   etc6;
    private String   etc7;
    private String   etc8;
    private String   etc9;
    private String   etc10;
    private String   appYN;
    private int      fno;
    private String   forg;
    private String   fsave;
    private String   fpath;
    private String   fhit;
    private String   falt;
    private String   ftype;
    private int      cno;
    private String   cname;
    private String   cstatus;
    private String   datereg;
    private String   datemod;
    private int      ctopno;
    private int      clevel;
    private int      cstep;
    private int      cparentno;
    private String   confirmyn;
    private String   no;
    private String   bbsreg;
    private String   bbsfile;
    private String   fnos;
    private String   ftypes;
    private String   falts;
    private String   fsaves;
    private String   bbsnew;
    private String   autoryn;
    private String   commentautoryn;
    private int      prevno;
    private int      nextno;
    private String   act;
    private String   fulltitle;
    private String[] catenames;
    private String   goal;
    private String   adminyn;
	private String   homeyn;
    private String   bbsopen;
    private String   bbsclose;
    private String   bbsfileicon;
    private String   prevtitle;
    private String   nexttitle;
    private String   puserid;
    private String   menuno;
    private String   adminid;
    private String   secretyn;
    private String   imgurl;
    
    public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public String getAdminid() {
		return adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

	public String getSecretyn() {
		return secretyn;
	}

	public void setSecretyn(String secretyn) {
		this.secretyn = secretyn;
	}
   
    public String getMenuno() {
		return menuno;
	}

	public void setMenuno(String menuno) {
		this.menuno = menuno;
	}

	public String getAppYN() {
		return appYN;
	}

	public void setAppYN(String appYN) {
		this.appYN = appYN;
	}

	public String getEtc7() {
        return etc7;
    }

    public void setEtc7(String etc7) {
        this.etc7 = etc7;
    }

    public String getEtc8() {
        return etc8;
    }

    public void setEtc8(String etc8) {
        this.etc8 = etc8;
    }

    public String getEtc9() {
        return etc9;
    }

    public void setEtc9(String etc9) {
        this.etc9 = etc9;
    }

    public String getEtc10() {
        return etc10;
    }

    public void setEtc10(String etc10) {
        this.etc10 = etc10;
    }

    public String getEtc1() {
        return etc1;
    }

    public void setEtc1(String etc1) {
        this.etc1 = etc1;
    }

    public String getEtc2() {
        return etc2;
    }

    public void setEtc2(String etc2) {
        this.etc2 = etc2;
    }

    public String getEtc3() {
        return etc3;
    }

    public void setEtc3(String etc3) {
        this.etc3 = etc3;
    }

    public String getEtc4() {
        return etc4;
    }

    public void setEtc4(String etc4) {
        this.etc4 = etc4;
    }

    public String getEtc5() {
        return etc5;
    }

    public void setEtc5(String etc5) {
        this.etc5 = etc5;
    }

    public String getEtc6() {
        return etc6;
    }

    public void setEtc6(String etc6) {
        this.etc6 = etc6;
    }

    public String getCommentYN() {
        return commentYN;
    }

    public void setCommentYN(String commentYN) {
        this.commentYN = commentYN;
    }

    public String getSeqname() {
        return seqname;
    }

    public void setSeqname(String seqname) {
        this.seqname = seqname;
    }

    public int getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(int isadmin) {
        this.isadmin = isadmin;
    }

    public int getShw_yn() {
        return shw_yn;
    }

    public void setShw_yn(int shw_yn) {
        this.shw_yn = shw_yn;
    }

    public int getBbsno() {
        return bbsno;
    }

    public void setBbsno(int bbsno) {
        this.bbsno = bbsno;
    }

    public int getSiteno() {
        return siteno;
    }

    public void setSiteno(int siteno) {
        this.siteno = siteno;
    }

    public int getBoardno() {
        return boardno;
    }

    public void setBoardno(int boardno) {
        this.boardno = boardno;
    }

    public String getRefno() {
        return refno;
    }

    public void setRefno(String refno) {
        this.refno = refno;
    }

    public int getBbstopno() {
        return bbstopno;
    }

    public void setBbstopno(int bbstopno) {
        this.bbstopno = bbstopno;
    }

    public int getBbslevel() {
        return bbslevel;
    }

    public void setBbslevel(int bbslevel) {
        this.bbslevel = bbslevel;
    }

    public int getBbsstep() {
        return bbsstep;
    }

    public void setBbsstep(int bbsstep) {
        this.bbsstep = bbsstep;
    }

    public int getBbsparentno() {
        return bbsparentno;
    }

    public void setBbsparentno(int bbsparentno) {
        this.bbsparentno = bbsparentno;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getBbspasswd() {
        return bbspasswd;
    }

    public void setBbspasswd(String bbspasswd) {
        this.bbspasswd = bbspasswd;
    }

    public String getBbsip() {
        return bbsip;
    }

    public void setBbsip(String bbsip) {
        this.bbsip = bbsip;
    }

    public int getBbshit() {
        return bbshit;
    }

    public void setBbshit(int bbshit) {
        this.bbshit = bbshit;
    }

    public String getBbstitle() {
        return bbstitle;
    }

    public void setBbstitle(String bbstitle) {
        this.bbstitle = bbstitle;
    }

    public String getBbsconts() {
        return bbsconts;
    }

    public void setBbsconts(String bbsconts) {
        this.bbsconts = bbsconts;
    }

    public String getBbscontstype() {
        return bbscontstype;
    }

    public void setBbscontstype(String bbscontstype) {
        this.bbscontstype = bbscontstype;
    }

    public String getBbscatenos() {
        return bbscatenos;
    }

    public void setBbscatenos(String bbscatenos) {
        this.bbscatenos = bbscatenos;
    }

    public String getBbsnotice() {
        return bbsnotice;
    }

    public void setBbsnotice(String bbsnotice) {
        this.bbsnotice = bbsnotice;
    }

    public String getBbssecret() {
        return bbssecret;
    }

    public void setBbssecret(String bbssecret) {
        this.bbssecret = bbssecret;
    }

    public String getBbsdatereg() {
        return bbsdatereg;
    }

    public void setBbsdatereg(String bbsdatereg) {
        this.bbsdatereg = bbsdatereg;
    }

    public String getBbsdatemod() {
        return bbsdatemod;
    }

    public void setBbsdatemod(String bbsdatemod) {
        this.bbsdatemod = bbsdatemod;
    }

    public String getBbsusername() {
        return bbsusername;
    }

    public void setBbsusername(String bbsusername) {
        this.bbsusername = bbsusername;
    }

    public String getBbsusercode() {
        return bbsusercode;
    }

    public void setBbsusercode(String bbsusercode) {
        this.bbsusercode = bbsusercode;
    }

    public String getBbsuseremail() {
        return bbsuseremail;
    }

    public void setBbsuseremail(String bbsuseremail) {
        this.bbsuseremail = bbsuseremail;
    }

    public String getBbsuserhomepage() {
        return bbsuserhomepage;
    }

    public void setBbsuserhomepage(String bbsuserhomepage) {
        this.bbsuserhomepage = bbsuserhomepage;
    }

    public String getBbsusertel() {
        return bbsusertel;
    }

    public void setBbsusertel(String bbsusertel) {
        this.bbsusertel = bbsusertel;
    }

    public String getBbsusermobile() {
        return bbsusermobile;
    }

    public void setBbsusermobile(String bbsusermobile) {
        this.bbsusermobile = bbsusermobile;
    }

    public String getBbsuseraddr() {
        return bbsuseraddr;
    }

    public void setBbsuseraddr(String bbsuseraddr) {
        this.bbsuseraddr = bbsuseraddr;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getJoinnum() {
        return joinnum;
    }

    public void setJoinnum(String joinnum) {
        this.joinnum = joinnum;
    }

    public int getFno() {
        return fno;
    }

    public void setFno(int fno) {
        this.fno = fno;
    }

    public String getForg() {
        return forg;
    }

    public void setForg(String forg) {
        this.forg = forg;
    }

    public String getFsave() {
        return fsave;
    }

    public void setFsave(String fsave) {
        this.fsave = fsave;
    }

    public String getFpath() {
        return fpath;
    }

    public void setFpath(String fpath) {
        this.fpath = fpath;
    }

    public String getFhit() {
        return fhit;
    }

    public void setFhit(String fhit) {
        this.fhit = fhit;
    }

    public String getFalt() {
        return falt;
    }

    public void setFalt(String falt) {
        this.falt = falt;
    }

    public String getFtype() {
        return ftype;
    }

    public void setFtype(String ftype) {
        this.ftype = ftype;
    }

    public int getCno() {
        return cno;
    }

    public void setCno(int cno) {
        this.cno = cno;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCstatus() {
        return cstatus;
    }

    public void setCstatus(String cstatus) {
        this.cstatus = cstatus;
    }

    public String getDatereg() {
        return datereg;
    }

    public void setDatereg(String datereg) {
        this.datereg = datereg;
    }

    public String getDatemod() {
        return datemod;
    }

    public void setDatemod(String datemod) {
        this.datemod = datemod;
    }

    public int getCtopno() {
        return ctopno;
    }

    public void setCtopno(int ctopno) {
        this.ctopno = ctopno;
    }

    public int getClevel() {
        return clevel;
    }

    public void setClevel(int clevel) {
        this.clevel = clevel;
    }

    public int getCstep() {
        return cstep;
    }

    public void setCstep(int cstep) {
        this.cstep = cstep;
    }

    public int getCparentno() {
        return cparentno;
    }

    public void setCparentno(int cparentno) {
        this.cparentno = cparentno;
    }

    public String getConfirmyn() {
        return confirmyn;
    }

    public void setConfirmyn(String confirmyn) {
        this.confirmyn = confirmyn;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getBbsfile() {
        return bbsfile;
    }

    public void setBbsfile(String bbsfile) {
        this.bbsfile = bbsfile;
    }

    public String getBbsreg() {
        return bbsreg;
    }

    public void setBbsreg(String bbsreg) {
        this.bbsreg = bbsreg;
    }

    public String getFnos() {
        return fnos;
    }

    public void setFnos(String fnos) {
        this.fnos = fnos;
    }

    public String getFtypes() {
        return ftypes;
    }

    public void setFtypes(String ftypes) {
        this.ftypes = ftypes;
    }

    public String getFalts() {
        return falts;
    }

    public void setFalts(String falts) {
        this.falts = falts;
    }

    public String getFsaves() {
        return fsaves;
    }

    public void setFsaves(String fsaves) {
        this.fsaves = fsaves;
    }

    public String getBbsnew() {
        return bbsnew;
    }

    public void setBbsnew(String bbsnew) {
        this.bbsnew = bbsnew;
    }

    public String getAutoryn() {
        return autoryn;
    }

    public void setAutoryn(String autoryn) {
        this.autoryn = autoryn;
    }

    public String getCommentautoryn() {
        return commentautoryn;
    }

    public void setCommentautoryn(String commentautoryn) {
        this.commentautoryn = commentautoryn;
    }

    @Override
	public int getPrevno() {
        return prevno;
    }

    @Override
	public void setPrevno(int prevno) {
        this.prevno = prevno;
    }

    @Override
	public int getNextno() {
        return nextno;
    }

    @Override
	public void setNextno(int nextno) {
        this.nextno = nextno;
    }

    public String getAct() {
        return act;
    }

    public void setAct(String act) {
        this.act = act;
    }

    public String getFulltitle() {
        return fulltitle;
    }

    public void setFulltitle(String fulltitle) {
        this.fulltitle = fulltitle;
    }

    public String[] getCatenames() {
        return catenames;
    }

    public void setCatenames(String[] catenames) {
        this.catenames = catenames;
    }

    public String getGoal() {
        return goal;
    }

    public void setGoal(String goal) {
        this.goal = goal;
    }

    public String getApproval() {
        return approval;
    }

    public void setApproval(String approval) {
        this.approval = approval;
    }

    public void seApproval(String approval) {
        this.approval = approval;
    }

    public String getAdminyn() {
        return adminyn;
    }

    public void setAdminyn(String adminyn) {
        this.adminyn = adminyn;
    }

    public String getHomeyn() {
        return homeyn;
    }

    public void setHomeyn(String homeyn) {
        this.homeyn = homeyn;
    }

    public String getPrevtitle() {
        return prevtitle;
    }

    public void setPrevtitle(String prevtitle) {
        this.prevtitle = prevtitle;
    }

    public String getNexttitle() {
        return nexttitle;
    }

    public void setNexttitle(String nexttitle) {
        this.nexttitle = nexttitle;
    }

    public String getBbsfileicon() {
        return bbsfileicon;
    }

    public void setBbsfileicon(String bbsfileicon) {
        this.bbsfileicon = bbsfileicon;
    }

    public String getBbsopen() {
        return bbsopen;
    }

    public void setBbsopen(String bbsopen) {
        this.bbsopen = bbsopen;
    }

    public String getBbsclose() {
        return bbsclose;
    }

    public void setBbsclose(String bbsclose) {
        this.bbsclose = bbsclose;
    }

    public String getPuserid() {
        return puserid;
    }

    public void setPuserid(String puserid) {
        this.puserid = puserid;
    }

    @Override
    public String toString() {
        return "FrontBoardVo{" +
            "bbsno=" + bbsno +
            ", siteno=" + siteno +
            ", boardno=" + boardno +
            ", refno='" + refno + '\'' +
            ", bbstopno=" + bbstopno +
            ", bbslevel=" + bbslevel +
            ", bbsstep=" + bbsstep +
            ", bbsparentno=" + bbsparentno +
            ", userid='" + userid + '\'' +
            ", bbspasswd='" + bbspasswd + '\'' +
            ", bbsip='" + bbsip + '\'' +
            ", bbshit=" + bbshit +
            ", bbstitle='" + bbstitle + '\'' +
            ", bbsconts='" + bbsconts + '\'' +
            ", bbscontstype='" + bbscontstype + '\'' +
            ", bbscatenos='" + bbscatenos + '\'' +
            ", bbsnotice='" + bbsnotice + '\'' +
            ", bbssecret='" + bbssecret + '\'' +
            ", bbsdatereg='" + bbsdatereg + '\'' +
            ", bbsdatemod='" + bbsdatemod + '\'' +
            ", bbsusername='" + bbsusername + '\'' +
            ", bbsusercode='" + bbsusercode + '\'' +
            ", bbsuseremail='" + bbsuseremail + '\'' +
            ", bbsuserhomepage='" + bbsuserhomepage + '\'' +
            ", bbsusertel='" + bbsusertel + '\'' +
            ", bbsusermobile='" + bbsusermobile + '\'' +
            ", bbsuseraddr='" + bbsuseraddr + '\'' +
            ", sponsor='" + sponsor + '\'' +
            ", place='" + place + '\'' +
            ", joinnum='" + joinnum + '\'' +
            ", approval='" + approval + '\'' +
            ", shw_yn=" + shw_yn +
            ", isadmin=" + isadmin +
            ", seqname='" + seqname + '\'' +
            ", commentYN='" + commentYN + '\'' +
            ", etc1='" + etc1 + '\'' +
            ", etc2='" + etc2 + '\'' +
            ", etc3='" + etc3 + '\'' +
            ", etc4='" + etc4 + '\'' +
            ", etc5='" + etc5 + '\'' +
            ", etc6='" + etc6 + '\'' +
            ", etc7='" + etc7 + '\'' +
            ", etc8='" + etc8 + '\'' +
            ", etc9='" + etc9 + '\'' +
            ", etc10='" + etc10 + '\'' +
            ", fno=" + fno +
            ", forg='" + forg + '\'' +
            ", fsave='" + fsave + '\'' +
            ", fhit='" + fhit + '\'' +
            ", falt='" + falt + '\'' +
            ", ftype='" + ftype + '\'' +
            ", cno=" + cno +
            ", cname='" + cname + '\'' +
            ", cstatus='" + cstatus + '\'' +
            ", datereg='" + datereg + '\'' +
            ", datemod='" + datemod + '\'' +
            ", ctopno=" + ctopno +
            ", clevel=" + clevel +
            ", cstep=" + cstep +
            ", cparentno=" + cparentno +
            ", confirmyn='" + confirmyn + '\'' +
            ", no='" + no + '\'' +
            ", bbsreg='" + bbsreg + '\'' +
            ", bbsfile='" + bbsfile + '\'' +
            ", fnos='" + fnos + '\'' +
            ", ftypes='" + ftypes + '\'' +
            ", falts='" + falts + '\'' +
            ", fsaves='" + fsaves + '\'' +
            ", bbsnew='" + bbsnew + '\'' +
            ", autoryn='" + autoryn + '\'' +
            ", commentautoryn='" + commentautoryn + '\'' +
            ", prevno=" + prevno +
            ", nextno=" + nextno +
            ", act='" + act + '\'' +
            ", fulltitle='" + fulltitle + '\'' +
            ", catenames=" + Arrays.toString(catenames) +
            ", goal='" + goal + '\'' +
            ", adminyn='" + adminyn + '\'' +
            ", homeyn='" + homeyn + '\'' +
            ", bbsopen='" + bbsopen + '\'' +
            ", bbsclose='" + bbsclose + '\'' +
            ", bbsfileicon='" + bbsfileicon + '\'' +
            ", prevtitle='" + prevtitle + '\'' +
            ", nexttitle='" + nexttitle + '\'' +
            ", puserid='" + puserid + '\'' +
            '}';
    }
}
