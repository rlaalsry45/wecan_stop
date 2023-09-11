package com.z5.zcms.admsys.board.domain;

import com.z5.zcms.admsys.common.domain.CommonVo;

public class ZBoardGroupMemberVo extends CommonVo {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2904533167366016006L;
	
	private int no;
	private int groupno;
	private int boardno;
	private String boardtitle;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getGroupno() {
		return groupno;
	}
	public void setGroupno(int groupno) {
		this.groupno = groupno;
	}
	public int getBoardno() {
		return boardno;
	}
	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}
	public String getBoardtitle() {
		return boardtitle;
	}
	public void setBoardtitle(String boardtitle) {
		this.boardtitle = boardtitle;
	}
}
