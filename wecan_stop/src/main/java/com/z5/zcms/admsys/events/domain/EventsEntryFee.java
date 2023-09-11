package com.z5.zcms.admsys.events.domain;

public class EventsEntryFee extends Events {

	private static final long serialVersionUID = 1L;

	private String efIdx;
	private String efEvIdx;
	private String efChargeTarget;
	private String efChargeSum;
	private String efTargetLevel;
	private String efTitle;
	
	public String getEfIdx() {
		return efIdx;
	}
	public void setEfIdx(String efIdx) {
		this.efIdx = efIdx;
	}
	public String getEfEvIdx() {
		return efEvIdx;
	}
	public void setEfEvIdx(String efEvIdx) {
		this.efEvIdx = efEvIdx;
	}
	public String getEfChargeTarget() {
		return efChargeTarget;
	}
	public void setEfChargeTarget(String efChargeTarget) {
		this.efChargeTarget = efChargeTarget;
	}
	public String getEfChargeSum() {
		return efChargeSum;
	}
	public void setEfChargeSum(String efChargeSum) {
		this.efChargeSum = efChargeSum;
	}
	public String getEfTargetLevel() {
		return efTargetLevel;
	}
	public void setEfTargetLevel(String efTargetLevel) {
		this.efTargetLevel = efTargetLevel;
	}
	public String getEfTitle() {
		return efTitle;
	}
	public void setEfTitle(String efTitle) {
		this.efTitle = efTitle;
	}

}
