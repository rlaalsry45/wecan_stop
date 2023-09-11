package com.z5.zcms.admsys.board.domain;



public class BoardVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2401911797622660241L;

	private String boardNo;
	private String boardUsername;
	private String boardPasswd;
	private String boardTitle;
	private String boardConts;
	private String boardIp;
	private String boardAnswer;
	private String boardAnswerId;
	
	private int boardfileBoardno;
	private String boardfileOriginal;
	private String boardfileSave;
	private String boardfileType;
	private String boardfileDescription;
	
	private String regId;
	private String updId;
	
	
	public String getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(String boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardUsername() {
		return boardUsername;
	}
	public void setBoardUsername(String boardUsername) {
		this.boardUsername = boardUsername;
	}
	public String getBoardPasswd() {
		return boardPasswd;
	}
	public void setBoardPasswd(String boardPasswd) {
		this.boardPasswd = boardPasswd;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardConts() {
		return boardConts;
	}
	public void setBoardConts(String boardConts) {
		this.boardConts = boardConts;
	}
	public String getBoardIp() {
		return boardIp;
	}
	public void setBoardIp(String boardIp) {
		this.boardIp = boardIp;
	}
	public String getBoardAnswer() {
		return boardAnswer;
	}
	public void setBoardAnswer(String boardAnswer) {
		this.boardAnswer = boardAnswer;
	}
	public String getBoardAnswerId() {
		return boardAnswerId;
	}
	public void setBoardAnswerId(String boardAnswerId) {
		this.boardAnswerId = boardAnswerId;
	}
	public String getRegId() {
		return regId;
	}
	public void setRegId(String regId) {
		this.regId = regId;
	}
	public String getUpdId() {
		return updId;
	}
	public void setUpdId(String updId) {
		this.updId = updId;
	}
	public int getBoardfileBoardno() {
		return boardfileBoardno;
	}
	public void setBoardfileBoardno(int boardfileBoardno) {
		this.boardfileBoardno = boardfileBoardno;
	}
	public String getBoardfileOriginal() {
		return boardfileOriginal;
	}
	public void setBoardfileOriginal(String boardfileOriginal) {
		this.boardfileOriginal = boardfileOriginal;
	}
	public String getBoardfileSave() {
		return boardfileSave;
	}
	public void setBoardfileSave(String boardfileSave) {
		this.boardfileSave = boardfileSave;
	}
	public String getBoardfileType() {
		return boardfileType;
	}
	public void setBoardfileType(String boardfileType) {
		this.boardfileType = boardfileType;
	}
	public String getBoardfileDescription() {
		return boardfileDescription;
	}
	public void setBoardfileDescription(String boardfileDescription) {
		this.boardfileDescription = boardfileDescription;
	}
	
}

