package com.z5.zcms.admsys.board.domain;

import com.z5.zcms.admsys.common.domain.CommonVo;
import com.z5.zcms.admsys.validator.BoardCheck;

@BoardCheck
public class ZBoardInfoVo extends CommonVo {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String no;
    private String bbsno;
    private String boardno;
    private String storename;
    private String ownername;
    private String tel;
    private String addr;
    private String homepage;
    private String regdate;


    public String getBoardno() {
        return boardno;
    }

    public void setBoardno(String boardno) {
        this.boardno = boardno;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getBbsno() {
        return bbsno;
    }

    public void setBbsno(String bbsno) {
        this.bbsno = bbsno;
    }

    public String getStorename() {
        return storename;
    }

    public void setStorename(String storename) {
        this.storename = storename;
    }

    public String getOwnername() {
        return ownername;
    }

    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

}
