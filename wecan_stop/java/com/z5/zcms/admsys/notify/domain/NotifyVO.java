package com.z5.zcms.admsys.notify.domain;

import com.z5.zcms.admsys.common.domain.CommonVo;

public class NotifyVO extends CommonVo{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2401911797622660245L;

	private int notifyNo;
	private String counselNo;
	private String notifyBusiness;
	private String notifyCounselclassification;
	private String notifyContent;
	private String notifyConfirmyn;
	private String regId;
	private String regDate;
	private String updId;	
	private int notifyCnt;
	
	public int getNotifyNo() {
		return notifyNo;
	}
	public void setNotifyNo(int notifyNo) {
		this.notifyNo = notifyNo;
	}
	public String getNotifyBusiness() {
		return notifyBusiness;
	}
	public void setNotifyBusiness(String notifyBusiness) {
		this.notifyBusiness = notifyBusiness;
	}
	public String getNotifyCounselclassification() {
		return notifyCounselclassification;
	}
	public void setNotifyCounselclassification(String notifyCounselclassification) {
		this.notifyCounselclassification = notifyCounselclassification;
	}
	public String getNotifyContent() {
		return notifyContent;
	}
	public void setNotifyContent(String notifyContent) {
		this.notifyContent = notifyContent;
	}
	public String getNotifyConfirmyn() {
		return notifyConfirmyn;
	}
	public void setNotifyConfirmyn(String notifyConfirmyn) {
		this.notifyConfirmyn = notifyConfirmyn;
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
	public int getNotifyCnt() {
		return notifyCnt;
	}
	public void setNotifyCnt(int notifyCnt) {
		this.notifyCnt = notifyCnt;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getCounselNo() {
		return counselNo;
	}
	public void setCounselNo(String counselNo) {
		this.counselNo = counselNo;
	}
	
}
