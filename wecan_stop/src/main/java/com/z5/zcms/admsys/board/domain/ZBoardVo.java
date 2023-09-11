package com.z5.zcms.admsys.board.domain;

import com.z5.zcms.admsys.common.domain.CommonVo;
import com.z5.zcms.admsys.validator.BoardCheck;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Digits;
import javax.validation.groups.Default;
import java.util.List;

@BoardCheck
public class ZBoardVo extends CommonVo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private int    boardno;
	
	private String refno;
	private int siteno;
	
	@NotBlank(message="{board.boardtitle}",groups={Default.class,BoardCopy.class})
	private String boardtitle;
	
	@NotEmpty(message="{board.skin}",groups={Default.class})
	private String skin;
	private String type;
	
	private String tblname;
	private String[] tblnames;
	private String cateyn = "0";
	private String secretyn = "0";
	private String confirmyn = "0";
	private String editoryn = "0";
	private String replyyn;
	private String commentyn;
	private String width;
	private String pagecnt;
	
	@Digits(integer=3, fraction=0, message="{board.titlelen}")
	private String titlelen;
	@Digits(integer=3, fraction=0, message="{board.shownew}")
	private String shownew;
	@Range(min=0, max=10, message="{board.uploadcnt}")
	private String uploadcnt;
	private String totalbytes;
	@Range(min=0, max=99, message="{board.uploadbytes}")
	private String uploadbytes;
	private String uploadext = "";
	private String adminid;
	private String auth;
	private String memo;
	private String datereg;
	private String datemod;
	private String userid;
	private String noticeyn;
	private String attachyn;
	private String mailyn;
	private String smsyn;
	private String rsmsyn;
	private String approvalyn;
	private String adminrank;
	private String homeyn;
	private String adminmailyn;
	private String adminmail;
	private String aprovyn;
	private String usepasswordyn;
	private String lang;
	private String authority;
	private String boarduseyn;
	private String adminname;
	private String adminno;
	private String cateno;
	private String skintype = "0";
	
	private String thumbnailw;
	private String thumbnailh;
	private String listimgw;
	private String listimgh;
	
	private String thumbnail;
	private String listimg;
	
	private int groupno = 0;
	private String groupnm = "";
	
	private List<ZBoardAuthVo> authlist;
	private ZBoardAuthVo authVo;
	private List<ZBoardAuthAdminVo> adminlist;
	private List<FrontBoardVo> boardlist;
	
	private List<String> role_no;
	private List<String> role_l;
	private List<String> role_v;
	private List<String> role_w;
	private List<String> role_m;
	private List<String> role_d;
	private List<String> role_m_nm;
	private List<String> role_r;
	private List<String> role_c;
	private List<String> role_n;
	
	private int groupno_org = 0;
	private int boardno_org = 0;
	
	private String[] groupno_dest = null;
	private String[] notCate;
	
	public String[] getNotCate() {
		return notCate;
	}
	public void setNotCate(String[] notCate) {
		this.notCate = notCate;
	}
	public String[] getTblnames() {
		return tblnames;
	}
	public void setTblnames(String[] tblnames) {
		this.tblnames = tblnames;
	}
	public String[] getGroupno_dest() {
		return groupno_dest;
	}
	public void setGroupno_dest(String[] groupno_dest) {
		this.groupno_dest = groupno_dest;
	}
	public ZBoardAuthVo getAuthVo() {
		return authVo;
	}
	public void setAuthVo(ZBoardAuthVo authVo) {
		this.authVo = authVo;
	}
	public String getConfirmyn() {
		return confirmyn;
	}
	public void setConfirmyn(String confirmyn) {
		this.confirmyn = confirmyn;
	}
	public List<FrontBoardVo> getBoardlist() {
		return boardlist;
	}
	public void setBoardlist(List<FrontBoardVo> boardlist) {
		this.boardlist = boardlist;
	}

	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public String getUsepasswordyn() {
		return usepasswordyn;
	}
	public void setUsepasswordyn(String usepasswordyn) {
		this.usepasswordyn = usepasswordyn;
	}
	public String getAprovyn() {
		return aprovyn;
	}
	public void setAprovyn(String aprovyn) {
		this.aprovyn = aprovyn;
	}
	public String getAdminmailyn() {
		return adminmailyn;
	}
	public void setAdminmailyn(String adminmailyn) {
		this.adminmailyn = adminmailyn;
	}
	public String getAdminmail() {
		return adminmail;
	}
	public void setAdminmail(String adminmail) {
		this.adminmail = adminmail;
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
	public int getSiteno() {
		return siteno;
	}
	public void setSiteno(int siteno) {
		this.siteno = siteno;
	}
	public String getBoardtitle() {
		return boardtitle;
	}
	public void setBoardtitle(String boardtitle) {
		this.boardtitle = boardtitle;
	}
	public String getSkin() {
		return skin;
	}
	public void setSkin(String skin) {
		this.skin = skin;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTblname() {
		return tblname;
	}
	public void setTblname(String tblname) {
		this.tblname = tblname;
	}

    public String getCateno() {
        return cateno;
    }

    public void setCateno(String cateno) {
        this.cateno = cateno;
    }

	public String getCateyn() {
		return cateyn;
	}
	public void setCateyn(String cateyn) {
		this.cateyn = cateyn;
	}
	public String getSecretyn() {
		return secretyn;
	}
	public void setSecretyn(String secretyn) {
		this.secretyn = secretyn;
	}
	public String getEditoryn() {
		return editoryn;
	}
	public void setEditoryn(String editoryn) {
		this.editoryn = editoryn;
	}
	public String getReplyyn() {
		return replyyn;
	}
	public void setReplyyn(String replyyn) {
		this.replyyn = replyyn;
	}
	public String getCommentyn() {
		return commentyn;
	}
	public void setCommentyn(String commentyn) {
		this.commentyn = commentyn;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getPagecnt() {
		return pagecnt;
	}
	public void setPagecnt(String pagecnt) {
		this.pagecnt = pagecnt;
	}
	public String getTitlelen() {
		return titlelen;
	}
	public void setTitlelen(String titlelen) {
		this.titlelen = titlelen;
	}
	public String getShownew() {
		return shownew;
	}
	public void setShownew(String shownew) {
		this.shownew = shownew;
	}
	public String getUploadcnt() {
		return uploadcnt;
	}
	public void setUploadcnt(String uploadcnt) {
		this.uploadcnt = uploadcnt;
	}
	public String getTotalbytes() {
		return totalbytes;
	}
	public void setTotalbytes(String totalbytes) {
		this.totalbytes = totalbytes;
	}
	public String getUploadbytes() {
		return uploadbytes;
	}
	public void setUploadbytes(String uploadbytes) {
		this.uploadbytes = uploadbytes;
	}
	public String getUploadext() {
		return uploadext;
	}
	public void setUploadext(String uploadext) {
		this.uploadext = uploadext;
	}
	public String getAdminid() {
		return adminid;
	}
	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
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
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getNoticeyn() {
		return noticeyn;
	}
	public void setNoticeyn(String noticeyn) {
		this.noticeyn = noticeyn;
	}
	public String getAttachyn() {
		return attachyn;
	}
	public void setAttachyn(String attachyn) {
		this.attachyn = attachyn;
	}
	public String getMailyn() {
		return mailyn;
	}
	public void setMailyn(String mailyn) {
		this.mailyn = mailyn;
	}
	public String getSmsyn() {
		return smsyn;
	}
	public void setSmsyn(String smsyn) {
		this.smsyn = smsyn;
	}
	public String getRsmsyn() {
		return rsmsyn;
	}
	public void setRsmsyn(String rsmsyn) {
		this.rsmsyn = rsmsyn;
	}
	public String getApprovalyn() {
		return approvalyn;
	}
	public void setApprovalyn(String approvalyn) {
		this.approvalyn = approvalyn;
	}
	public String getAdminrank() {
		return adminrank;
	}
	public void setAdminrank(String adminrank) {
		this.adminrank = adminrank;
	}
	public String getHomeyn() {
		return homeyn;
	}
	public void setHomeyn(String homeyn) {
		this.homeyn = homeyn;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	public String getBoarduseyn() {
		return boarduseyn;
	}
	public void setBoarduseyn(String boarduseyn) {
		this.boarduseyn = boarduseyn;
	}
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getAdminno() {
		return adminno;
	}
	public void setAdminno(String adminno) {
		this.adminno = adminno;
	}
	public String getSkintype() {
		return skintype;
	}
	public void setSkintype(String skintype) {
		this.skintype = skintype;
	}
	public String getThumbnailw() {
		return thumbnailw;
	}
	public void setThumbnailw(String thumbnailw) {
		this.thumbnailw = thumbnailw;
	}
	public String getThumbnailh() {
		return thumbnailh;
	}
	public void setThumbnailh(String thumbnailh) {
		this.thumbnailh = thumbnailh;
	}
	public String getListimgw() {
		return listimgw;
	}
	public void setListimgw(String listimgw) {
		this.listimgw = listimgw;
	}
	public String getListimgh() {
		return listimgh;
	}
	public void setListimgh(String listimgh) {
		this.listimgh = listimgh;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getListimg() {
		return listimg;
	}
	public void setListimg(String listimg) {
		this.listimg = listimg;
	}
	public int getGroupno() {
		return groupno;
	}
	public void setGroupno(int groupno) {
		this.groupno = groupno;
	}
	public String getGroupnm() {
		return groupnm;
	}
	public void setGroupnm(String groupnm) {
		this.groupnm = groupnm;
	}
	public List<ZBoardAuthVo> getAuthlist() {
		return authlist;
	}
	public void setAuthlist(List<ZBoardAuthVo> authlist) {
		this.authlist = authlist;
	}
	public List<ZBoardAuthAdminVo> getAdminlist() {
		return adminlist;
	}
	public void setAdminlist(List<ZBoardAuthAdminVo> adminlist) {
		this.adminlist = adminlist;
	}
	public List<String> getRole_no() {
		return role_no;
	}
	public void setRole_no(List<String> role_no) {
		this.role_no = role_no;
	}
	public List<String> getRole_l() {
		return role_l;
	}
	public void setRole_l(List<String> role_l) {
		this.role_l = role_l;
	}
	public List<String> getRole_v() {
		return role_v;
	}
	public void setRole_v(List<String> role_v) {
		this.role_v = role_v;
	}
	public List<String> getRole_w() {
		return role_w;
	}
	public void setRole_w(List<String> role_w) {
		this.role_w = role_w;
	}
	public List<String> getRole_m() {
		return role_m;
	}
	public void setRole_m(List<String> role_m) {
		this.role_m = role_m;
	}
	public List<String> getRole_d() {
		return role_d;
	}
	public void setRole_d(List<String> role_d) {
		this.role_d = role_d;
	}
	public List<String> getRole_m_nm() {
		return role_m_nm;
	}
	public void setRole_m_nm(List<String> role_m_nm) {
		this.role_m_nm = role_m_nm;
	}
	public List<String> getRole_r() {
		return role_r;
	}
	public void setRole_r(List<String> role_r) {
		this.role_r = role_r;
	}
	public List<String> getRole_c() {
		return role_c;
	}
	public void setRole_c(List<String> role_c) {
		this.role_c = role_c;
	}
	public List<String> getRole_n() {
		return role_n;
	}
	public void setRole_n(List<String> role_n) {
		this.role_n = role_n;
	}
	public int getGroupno_org() {
		return groupno_org;
	}
	public void setGroupno_org(int groupno_org) {
		this.groupno_org = groupno_org;
	}
	public int getBoardno_org() {
		return boardno_org;
	}
	public void setBoardno_org(int boardno_org) {
		this.boardno_org = boardno_org;
	}

    public interface BoardCopy {}
}
