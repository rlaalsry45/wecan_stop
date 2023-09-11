package com.z5.zcms.admsys.board.domain;

import com.z5.zcms.admsys.common.domain.CommonVo;

public class ZFileVo extends CommonVo{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2904533167366016006L;
	
	private int fno;
	private String forg;
	private String fsave;
	private String fhit;
	private String datereg;
	private String falt;
	private String ftype;
	private int bbsno;
	private int boardno;

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
	public String getFhit() {
		return fhit;
	}
	public void setFhit(String fhit) {
		this.fhit = fhit;
	}
	public String getDatereg() {
		return datereg;
	}
	public void setDatereg(String datereg) {
		this.datereg = datereg;
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
	public int getBbsno() {
		return bbsno;
	}
	public void setBbsno(int bbsno) {
		this.bbsno = bbsno;
	}
	public int getBoardno() {
		return boardno;
	}
	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}	
}
