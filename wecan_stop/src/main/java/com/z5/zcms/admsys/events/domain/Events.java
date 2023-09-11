package com.z5.zcms.admsys.events.domain;

import java.io.Serializable;

import com.z5.zcms.admsys.common.domain.CommonVo;

public class Events extends CommonVo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String evIdx;
	private String evTitle;
	private String evCategory;
	private String evStartDate;
	private String evEndDate;
	private String evRegisStartTime;
	private String evRegisEndTime;
	private String evOpenSite;
	private String evOpenDate;
	private String evContents;
	private String evAttFileName;
	private String evAttRealName;
	private String feeTarget;
	private String feeSum;
	private String feeTitle;
	
	public String getEvIdx() {
		return evIdx;
	}
	public void setEvIdx(String evIdx) {
		this.evIdx = evIdx;
	}
	public String getEvTitle() {
		return evTitle;
	}
	public void setEvTitle(String evTitle) {
		this.evTitle = evTitle;
	}
	public String getEvCategory() {
		return evCategory;
	}
	public void setEvCategory(String evCategory) {
		this.evCategory = evCategory;
	}
	public String getEvStartDate() {
		return evStartDate;
	}
	public void setEvStartDate(String evStartDate) {
		this.evStartDate = evStartDate;
	}
	public String getEvEndDate() {
		return evEndDate;
	}
	public void setEvEndDate(String evEndDate) {
		this.evEndDate = evEndDate;
	}
	public String getEvRegisStartTime() {
		return evRegisStartTime;
	}
	public void setEvRegisStartTime(String evRegisStartTime) {
		this.evRegisStartTime = evRegisStartTime;
	}
	public String getEvRegisEndTime() {
		return evRegisEndTime;
	}
	public void setEvRegisEndTime(String evRegisEndTime) {
		this.evRegisEndTime = evRegisEndTime;
	}
	public String getEvOpenSite() {
		return evOpenSite;
	}
	public void setEvOpenSite(String evOpenSite) {
		this.evOpenSite = evOpenSite;
	}
	public String getEvOpenDate() {
		return evOpenDate;
	}
	public void setEvOpenDate(String evOpenDate) {
		this.evOpenDate = evOpenDate;
	}
	public String getEvContents() {
		return evContents;
	}
	public void setEvContents(String evContents) {
		this.evContents = evContents;
	}
	public String getEvAttFileName() {
		return evAttFileName;
	}
	public void setEvAttFileName(String evAttFileName) {
		this.evAttFileName = evAttFileName;
	}
	public String getEvAttRealName() {
		return evAttRealName;
	}
	public void setEvAttRealName(String evAttRealName) {
		this.evAttRealName = evAttRealName;
	}
	public String getFeeTarget() {
		return feeTarget;
	}
	public void setFeeTarget(String feeTarget) {
		this.feeTarget = feeTarget;
	}
	public String getFeeSum() {
		return feeSum;
	}
	public void setFeeSum(String feeSum) {
		this.feeSum = feeSum;
	}
	public String getFeeTitle() {
		return feeTitle;
	}
	public void setFeeTitle(String feeTitle) {
		this.feeTitle = feeTitle;
	}
	
}
