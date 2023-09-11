package com.z5.zcms.admsys.user.domain;

import java.io.Serializable;

import com.z5.zcms.admsys.common.domain.CommonVo;

public class ZCompanyVo extends CommonVo implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4658153289227675576L;
	
	private String cpkid;
	private String comname;
	private String combnum;
	private String homepage;
	private String reprekname;
	private String faxnum;
	private String isopenfax;
	private String cdate;
	private String comstaffnum;
	private String comintroduce;
	private String fkupkid;
	private String isdesigncom;
	private String pickupnum;
	private String scrapnum;
	private String wm018_ename;
	private String wm018_repreename;
	private String wm018_zipcode1;
	private String wm018_address1;
	private String wm018_eaddress1;
	private String wm018_uptae;
	private String wm018_jongmok;
	private String wm018_reprehname;
	private String wm018_address2;
	private String wm018_tel2;
	private String isopencomname;
	private String isopenaddr;
	private String isopendate;
	private String isopennum;
	private String isopentel;
	private String isopenfaxnew;
	private String isopenemailaddr;
	
	//companycode
	private String catpkid;
	private String catpatpkid;
	private String catname;
	private String ordernum;
	private String isuse;
	
	private String matpkid;
	private String regdate;
	private String fkcatpkid;
	
	private String attpkid;
	private String imgcate;
	private String imgorgname;
	private String imgsavename;
	private String imgwidth;
	private String imgheight;
	private String imgweight;
	
	private String userid;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getAttpkid() {
		return attpkid;
	}
	public void setAttpkid(String attpkid) {
		this.attpkid = attpkid;
	}
	public String getImgcate() {
		return imgcate;
	}
	public void setImgcate(String imgcate) {
		this.imgcate = imgcate;
	}
	public String getImgorgname() {
		return imgorgname;
	}
	public void setImgorgname(String imgorgname) {
		this.imgorgname = imgorgname;
	}
	public String getImgsavename() {
		return imgsavename;
	}
	public void setImgsavename(String imgsavename) {
		this.imgsavename = imgsavename;
	}
	public String getImgwidth() {
		return imgwidth;
	}
	public void setImgwidth(String imgwidth) {
		this.imgwidth = imgwidth;
	}
	public String getImgheight() {
		return imgheight;
	}
	public void setImgheight(String imgheight) {
		this.imgheight = imgheight;
	}
	public String getImgweight() {
		return imgweight;
	}
	public void setImgweight(String imgweight) {
		this.imgweight = imgweight;
	}
	public String getMatpkid() {
		return matpkid;
	}
	public void setMatpkid(String matpkid) {
		this.matpkid = matpkid;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public String getFkcatpkid() {
		return fkcatpkid;
	}
	public void setFkcatpkid(String fkcatpkid) {
		this.fkcatpkid = fkcatpkid;
	}
	public String getCatpkid() {
		return catpkid;
	}
	public void setCatpkid(String catpkid) {
		this.catpkid = catpkid;
	}
	public String getCatpatpkid() {
		return catpatpkid;
	}
	public void setCatpatpkid(String catpatpkid) {
		this.catpatpkid = catpatpkid;
	}
	public String getCatname() {
		return catname;
	}
	public void setCatname(String catname) {
		this.catname = catname;
	}
	public String getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}
	public String getIsuse() {
		return isuse;
	}
	public void setIsuse(String isuse) {
		this.isuse = isuse;
	}
	
	
	public String getCpkid() {
		return cpkid;
	}
	public void setCpkid(String cpkid) {
		this.cpkid = cpkid;
	}
	public String getComname() {
		return comname;
	}
	public void setComname(String comname) {
		this.comname = comname;
	}
	public String getCombnum() {
		return combnum;
	}
	public void setCombnum(String combnum) {
		this.combnum = combnum;
	}
	public String getHomepage() {
		return homepage;
	}
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}
	public String getReprekname() {
		return reprekname;
	}
	public void setReprekname(String reprekname) {
		this.reprekname = reprekname;
	}
	public String getFaxnum() {
		return faxnum;
	}
	public void setFaxnum(String faxnum) {
		this.faxnum = faxnum;
	}
	public String getIsopenfax() {
		return isopenfax;
	}
	public void setIsopenfax(String isopenfax) {
		this.isopenfax = isopenfax;
	}
	public String getCdate() {
		return cdate;
	}
	public void setCdate(String cdate) {
		this.cdate = cdate;
	}
	public String getComstaffnum() {
		return comstaffnum;
	}
	public void setComstaffnum(String comstaffnum) {
		this.comstaffnum = comstaffnum;
	}
	public String getComintroduce() {
		return comintroduce;
	}
	public void setComintroduce(String comintroduce) {
		this.comintroduce = comintroduce;
	}
	public String getFkupkid() {
		return fkupkid;
	}
	public void setFkupkid(String fkupkid) {
		this.fkupkid = fkupkid;
	}
	public String getIsdesigncom() {
		return isdesigncom;
	}
	public void setIsdesigncom(String isdesigncom) {
		this.isdesigncom = isdesigncom;
	}
	public String getPickupnum() {
		return pickupnum;
	}
	public void setPickupnum(String pickupnum) {
		this.pickupnum = pickupnum;
	}
	public String getScrapnum() {
		return scrapnum;
	}
	public void setScrapnum(String scrapnum) {
		this.scrapnum = scrapnum;
	}
	public String getWm018_ename() {
		return wm018_ename;
	}
	public void setWm018_ename(String wm018_ename) {
		this.wm018_ename = wm018_ename;
	}
	public String getWm018_repreename() {
		return wm018_repreename;
	}
	public void setWm018_repreename(String wm018_repreename) {
		this.wm018_repreename = wm018_repreename;
	}
	public String getWm018_zipcode1() {
		return wm018_zipcode1;
	}
	public void setWm018_zipcode1(String wm018_zipcode1) {
		this.wm018_zipcode1 = wm018_zipcode1;
	}
	public String getWm018_address1() {
		return wm018_address1;
	}
	public void setWm018_address1(String wm018_address1) {
		this.wm018_address1 = wm018_address1;
	}
	public String getWm018_eaddress1() {
		return wm018_eaddress1;
	}
	public void setWm018_eaddress1(String wm018_eaddress1) {
		this.wm018_eaddress1 = wm018_eaddress1;
	}
	public String getWm018_uptae() {
		return wm018_uptae;
	}
	public void setWm018_uptae(String wm018_uptae) {
		this.wm018_uptae = wm018_uptae;
	}
	public String getWm018_jongmok() {
		return wm018_jongmok;
	}
	public void setWm018_jongmok(String wm018_jongmok) {
		this.wm018_jongmok = wm018_jongmok;
	}
	public String getWm018_reprehname() {
		return wm018_reprehname;
	}
	public void setWm018_reprehname(String wm018_reprehname) {
		this.wm018_reprehname = wm018_reprehname;
	}
	public String getWm018_address2() {
		return wm018_address2;
	}
	public void setWm018_address2(String wm018_address2) {
		this.wm018_address2 = wm018_address2;
	}
	public String getWm018_tel2() {
		return wm018_tel2;
	}
	public void setWm018_tel2(String wm018_tel2) {
		this.wm018_tel2 = wm018_tel2;
	}
	public String getIsopencomname() {
		return isopencomname;
	}
	public void setIsopencomname(String isopencomname) {
		this.isopencomname = isopencomname;
	}
	public String getIsopenaddr() {
		return isopenaddr;
	}
	public void setIsopenaddr(String isopenaddr) {
		this.isopenaddr = isopenaddr;
	}
	public String getIsopendate() {
		return isopendate;
	}
	public void setIsopendate(String isopendate) {
		this.isopendate = isopendate;
	}
	public String getIsopennum() {
		return isopennum;
	}
	public void setIsopennum(String isopennum) {
		this.isopennum = isopennum;
	}
	public String getIsopentel() {
		return isopentel;
	}
	public void setIsopentel(String isopentel) {
		this.isopentel = isopentel;
	}
	public String getIsopenfaxnew() {
		return isopenfaxnew;
	}
	public void setIsopenfaxnew(String isopenfaxnew) {
		this.isopenfaxnew = isopenfaxnew;
	}
	public String getIsopenemailaddr() {
		return isopenemailaddr;
	}
	public void setIsopenemailaddr(String isopenemailaddr) {
		this.isopenemailaddr = isopenemailaddr;
	}
	
	
}
