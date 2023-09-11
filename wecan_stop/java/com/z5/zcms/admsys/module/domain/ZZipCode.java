package com.z5.zcms.admsys.module.domain;

public class ZZipCode {

	private String address;
	private String postcd;

	public ZZipCode(String address, String postcd)
	{
		this.address = address;
		this.postcd = postcd;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostcd() {
		return postcd;
	}
	public void setPostcd(String postcd) {
		this.postcd = postcd;
	}

}