package com.z5.zcms.frontsys.front.domain;

import java.io.Serializable;

public class GovSessCheckVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3763471661258149777L;

	String whatStepFST = "";
	String firstStepYN = "N";
	String secondStepYN = "N";
	String thirdStepYN = "N";

	public String getWhatStepFST() {
		return whatStepFST;
	}

	public void setWhatStepFST(String whatStepFST) {
		this.whatStepFST = whatStepFST;
	}

	public String getFirstStepYN() {
		return firstStepYN;
	}

	public void setFirstStepYN(String firstStepYN) {
		this.firstStepYN = firstStepYN;
	}

	public String getSecondStepYN() {
		return secondStepYN;
	}

	public void setSecondStepYN(String secondStepYN) {
		this.secondStepYN = secondStepYN;
	}

	public String getThirdStepYN() {
		return thirdStepYN;
	}

	public void setThirdStepYN(String thirdStepYN) {
		this.thirdStepYN = thirdStepYN;
	}

}
