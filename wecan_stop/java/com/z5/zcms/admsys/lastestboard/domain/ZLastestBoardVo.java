package com.z5.zcms.admsys.lastestboard.domain;

import com.z5.zcms.admsys.common.domain.CommonVo;

/**
 * 
 */
public class ZLastestBoardVo extends CommonVo{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8046118650276335586L;
	private int rowno;
	private int bbsno;
	private int siteno;
	private int siteno2;
	private int boardno;
	private int boardno2;
	private int menuno;
	private int tabno;
	private String bbstitle;
	private String bbsdatereg;
	private String url;
	private String skin;

	public int getRowno() {
		return rowno;
	}
	public void setRowno(int rowno) {
		this.rowno = rowno;
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
	public int getSiteno2() {
		return siteno2;
	}
	public void setSiteno2(int siteno2) {
		this.siteno2 = siteno2;
	}
	public int getBoardno() {
		return boardno;
	}
	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}
	public int getBoardno2() {
		return boardno2;
	}
	public void setBoardno2(int boardno2) {
		this.boardno2 = boardno2;
	}
	public String getBbstitle() {
		return bbstitle;
	}
	public void setBbstitle(String bbstitle) {
		this.bbstitle = bbstitle;
	}
	public String getBbsdatereg() {
		return bbsdatereg;
	}
	public void setBbsdatereg(String bbsdatereg) {
		this.bbsdatereg = bbsdatereg;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getMenuno() {
		return menuno;
	}
	public void setMenuno(int menuno) {
		this.menuno = menuno;
	}
	public String getSkin() {
		return skin;
	}
	public void setSkin(String skin) {
		this.skin = skin;
	}
	public int getTabno() {
		return tabno;
	}
	public void setTabno(int tabno) {
		this.tabno = tabno;
	}
}
	