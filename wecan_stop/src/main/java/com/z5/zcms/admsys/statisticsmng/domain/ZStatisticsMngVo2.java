package com.z5.zcms.admsys.statisticsmng.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ZStatisticsMngVo2 implements Serializable {
	
	private static final long serialVersionUID = -3121095837173846435L;
		
	
	private String sdate;
	private String edate;
	private String range;
	private String days;
	private String months;
	private String regDate;
	private String counselCnt;
	private String consultingTypePublicCnt;
	private String consultingTypeCivilCnt;
	private String consultingTypePersonalCnt;
	private String consultingTypeEtcCnt;
	private String receivedTypeTelCnt;
	private String receivedTypeMailCnt;
	private String receivedTypeVisitCnt;
	private String receivedTypeMoveCnt;
	private String consultingReqTypeRelCnt;
	private String consultingReqTypeSimCnt;
	private String cconsultingReqTypeEtcCnt;
	private String contactMethodTypeIntCnt;
	private String contactMethodTypeSupCnt;
	private String contactMethodTypeGovCnt;
	private String contactMethodTypeEtcCnt;
	private String contactMethodTypeUnkCnt;
	private String clientGenderFemaleCnt;
	private String clientGenderMaleCnt;
	private String clientGenderUnknownCnt;
	private String clientVictimRelTypeMeCnt;
	private String clientVictimRelTypeAgeCnt;
	private String clientVictimRelTypeRelCnt;
	private String clientVictimRelTypeDoerCnt;
	private String clientVictimRelTypeEtcCnt;
	private String victimGenderTypeFemaleCnt;
	private String victimGenderTypeMaleCnt;
	private String victimGenderTypeUnknownCnt;
	private String victimGenderTypeNoneCnt;
	private String offenderGenderTypeFemaleCnt;
	private String offenderGenderTypeMaleCnt;
	private String offenderGenderTypeUnkownCnt;
	private String offenderGenderTypeNoneCnt;
	private String offenderVictimRelTypeBossCnt;
	private String offenderVictimRelTypeSenCnt;
	private String offenderVictimRelTypePartCnt;
	private String offenderVictimRelTypeOthCnt;
	private String offenderVictimRelTypeEtcCnt;
	private String offenderVictimRelTypeUnkCnt;
	
	private List<String> consultingTypeCbx;
	private List<String> receivedTypeCbx;
	private List<String> consultingReqTypeCbx;
	private List<String> contactMethodTypeCbx;
	private List<String> clientGenderCbx;
	private List<String> clientVictimRelTypeCbx; 
	private List<String> victimGenderTypeCbx;
	private List<String> offenderGenderTypeCbx;
	private List<String> offenderVictimRelTypeCbx;
	private List<String> harmFirstTypeCbx;
	private List<String> harmSecTypeCbx;
	private List<String> responseTypeIntroOrgCbx;
	private List<String> responseTypeServiceRelCbx;
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getCounselCnt() {
		return counselCnt;
	}
	public void setCounselCnt(String counselCnt) {
		this.counselCnt = counselCnt;
	}
	public String getConsultingTypePublicCnt() {
		return consultingTypePublicCnt;
	}
	public void setConsultingTypePublicCnt(String consultingTypePublicCnt) {
		this.consultingTypePublicCnt = consultingTypePublicCnt;
	}
	public String getConsultingTypeCivilCnt() {
		return consultingTypeCivilCnt;
	}
	public void setConsultingTypeCivilCnt(String consultingTypeCivilCnt) {
		this.consultingTypeCivilCnt = consultingTypeCivilCnt;
	}
	public String getConsultingTypePersonalCnt() {
		return consultingTypePersonalCnt;
	}
	public void setConsultingTypePersonalCnt(String consultingTypePersonalCnt) {
		this.consultingTypePersonalCnt = consultingTypePersonalCnt;
	}
	public String getConsultingTypeEtcCnt() {
		return consultingTypeEtcCnt;
	}
	public void setConsultingTypeEtcCnt(String consultingTypeEtcCnt) {
		this.consultingTypeEtcCnt = consultingTypeEtcCnt;
	}
	public String getReceivedTypeTelCnt() {
		return receivedTypeTelCnt;
	}
	public void setReceivedTypeTelCnt(String receivedTypeTelCnt) {
		this.receivedTypeTelCnt = receivedTypeTelCnt;
	}
	public String getReceivedTypeMailCnt() {
		return receivedTypeMailCnt;
	}
	public void setReceivedTypeMailCnt(String receivedTypeMailCnt) {
		this.receivedTypeMailCnt = receivedTypeMailCnt;
	}
	public String getReceivedTypeVisitCnt() {
		return receivedTypeVisitCnt;
	}
	public void setReceivedTypeVisitCnt(String receivedTypeVisitCnt) {
		this.receivedTypeVisitCnt = receivedTypeVisitCnt;
	}
	public String getReceivedTypeMoveCnt() {
		return receivedTypeMoveCnt;
	}
	public void setReceivedTypeMoveCnt(String receivedTypeMoveCnt) {
		this.receivedTypeMoveCnt = receivedTypeMoveCnt;
	}
	public String getConsultingReqTypeRelCnt() {
		return consultingReqTypeRelCnt;
	}
	public void setConsultingReqTypeRelCnt(String consultingReqTypeRelCnt) {
		this.consultingReqTypeRelCnt = consultingReqTypeRelCnt;
	}
	public String getConsultingReqTypeSimCnt() {
		return consultingReqTypeSimCnt;
	}
	public void setConsultingReqTypeSimCnt(String consultingReqTypeSimCnt) {
		this.consultingReqTypeSimCnt = consultingReqTypeSimCnt;
	}
	public String getCconsultingReqTypeEtcCnt() {
		return cconsultingReqTypeEtcCnt;
	}
	public void setCconsultingReqTypeEtcCnt(String cconsultingReqTypeEtcCnt) {
		this.cconsultingReqTypeEtcCnt = cconsultingReqTypeEtcCnt;
	}
	public String getContactMethodTypeIntCnt() {
		return contactMethodTypeIntCnt;
	}
	public void setContactMethodTypeIntCnt(String contactMethodTypeIntCnt) {
		this.contactMethodTypeIntCnt = contactMethodTypeIntCnt;
	}
	public String getContactMethodTypeSupCnt() {
		return contactMethodTypeSupCnt;
	}
	public void setContactMethodTypeSupCnt(String contactMethodTypeSupCnt) {
		this.contactMethodTypeSupCnt = contactMethodTypeSupCnt;
	}
	public String getContactMethodTypeGovCnt() {
		return contactMethodTypeGovCnt;
	}
	public void setContactMethodTypeGovCnt(String contactMethodTypeGovCnt) {
		this.contactMethodTypeGovCnt = contactMethodTypeGovCnt;
	}
	public String getContactMethodTypeEtcCnt() {
		return contactMethodTypeEtcCnt;
	}
	public void setContactMethodTypeEtcCnt(String contactMethodTypeEtcCnt) {
		this.contactMethodTypeEtcCnt = contactMethodTypeEtcCnt;
	}
	public String getContactMethodTypeUnkCnt() {
		return contactMethodTypeUnkCnt;
	}
	public void setContactMethodTypeUnkCnt(String contactMethodTypeUnkCnt) {
		this.contactMethodTypeUnkCnt = contactMethodTypeUnkCnt;
	}
	public String getClientGenderFemaleCnt() {
		return clientGenderFemaleCnt;
	}
	public void setClientGenderFemaleCnt(String clientGenderFemaleCnt) {
		this.clientGenderFemaleCnt = clientGenderFemaleCnt;
	}
	public String getClientGenderMaleCnt() {
		return clientGenderMaleCnt;
	}
	public void setClientGenderMaleCnt(String clientGenderMaleCnt) {
		this.clientGenderMaleCnt = clientGenderMaleCnt;
	}
	public String getClientGenderUnknownCnt() {
		return clientGenderUnknownCnt;
	}
	public void setClientGenderUnknownCnt(String clientGenderUnknownCnt) {
		this.clientGenderUnknownCnt = clientGenderUnknownCnt;
	}
	public String getClientVictimRelTypeMeCnt() {
		return clientVictimRelTypeMeCnt;
	}
	public void setClientVictimRelTypeMeCnt(String clientVictimRelTypeMeCnt) {
		this.clientVictimRelTypeMeCnt = clientVictimRelTypeMeCnt;
	}
	public String getClientVictimRelTypeAgeCnt() {
		return clientVictimRelTypeAgeCnt;
	}
	public void setClientVictimRelTypeAgeCnt(String clientVictimRelTypeAgeCnt) {
		this.clientVictimRelTypeAgeCnt = clientVictimRelTypeAgeCnt;
	}
	public String getClientVictimRelTypeRelCnt() {
		return clientVictimRelTypeRelCnt;
	}
	public void setClientVictimRelTypeRelCnt(String clientVictimRelTypeRelCnt) {
		this.clientVictimRelTypeRelCnt = clientVictimRelTypeRelCnt;
	}
	public String getClientVictimRelTypeDoerCnt() {
		return clientVictimRelTypeDoerCnt;
	}
	public void setClientVictimRelTypeDoerCnt(String clientVictimRelTypeDoerCnt) {
		this.clientVictimRelTypeDoerCnt = clientVictimRelTypeDoerCnt;
	}
	public String getClientVictimRelTypeEtcCnt() {
		return clientVictimRelTypeEtcCnt;
	}
	public void setClientVictimRelTypeEtcCnt(String clientVictimRelTypeEtcCnt) {
		this.clientVictimRelTypeEtcCnt = clientVictimRelTypeEtcCnt;
	}
	public String getVictimGenderTypeFemaleCnt() {
		return victimGenderTypeFemaleCnt;
	}
	public void setVictimGenderTypeFemaleCnt(String victimGenderTypeFemaleCnt) {
		this.victimGenderTypeFemaleCnt = victimGenderTypeFemaleCnt;
	}
	public String getVictimGenderTypeMaleCnt() {
		return victimGenderTypeMaleCnt;
	}
	public void setVictimGenderTypeMaleCnt(String victimGenderTypeMaleCnt) {
		this.victimGenderTypeMaleCnt = victimGenderTypeMaleCnt;
	}
	public String getVictimGenderTypeUnknownCnt() {
		return victimGenderTypeUnknownCnt;
	}
	public void setVictimGenderTypeUnknownCnt(String victimGenderTypeUnknownCnt) {
		this.victimGenderTypeUnknownCnt = victimGenderTypeUnknownCnt;
	}
	public String getVictimGenderTypeNoneCnt() {
		return victimGenderTypeNoneCnt;
	}
	public void setVictimGenderTypeNoneCnt(String victimGenderTypeNoneCnt) {
		this.victimGenderTypeNoneCnt = victimGenderTypeNoneCnt;
	}
	public String getOffenderGenderTypeFemaleCnt() {
		return offenderGenderTypeFemaleCnt;
	}
	public void setOffenderGenderTypeFemaleCnt(String offenderGenderTypeFemaleCnt) {
		this.offenderGenderTypeFemaleCnt = offenderGenderTypeFemaleCnt;
	}
	public String getOffenderGenderTypeMaleCnt() {
		return offenderGenderTypeMaleCnt;
	}
	public void setOffenderGenderTypeMaleCnt(String offenderGenderTypeMaleCnt) {
		this.offenderGenderTypeMaleCnt = offenderGenderTypeMaleCnt;
	}
	public String getOffenderGenderTypeUnkownCnt() {
		return offenderGenderTypeUnkownCnt;
	}
	public void setOffenderGenderTypeUnkownCnt(String offenderGenderTypeUnkownCnt) {
		this.offenderGenderTypeUnkownCnt = offenderGenderTypeUnkownCnt;
	}
	public String getOffenderGenderTypeNoneCnt() {
		return offenderGenderTypeNoneCnt;
	}
	public void setOffenderGenderTypeNoneCnt(String offenderGenderTypeNoneCnt) {
		this.offenderGenderTypeNoneCnt = offenderGenderTypeNoneCnt;
	}
	public String getOffenderVictimRelTypeBossCnt() {
		return offenderVictimRelTypeBossCnt;
	}
	public void setOffenderVictimRelTypeBossCnt(String offenderVictimRelTypeBossCnt) {
		this.offenderVictimRelTypeBossCnt = offenderVictimRelTypeBossCnt;
	}
	public String getOffenderVictimRelTypeSenCnt() {
		return offenderVictimRelTypeSenCnt;
	}
	public void setOffenderVictimRelTypeSenCnt(String offenderVictimRelTypeSenCnt) {
		this.offenderVictimRelTypeSenCnt = offenderVictimRelTypeSenCnt;
	}
	public String getOffenderVictimRelTypePartCnt() {
		return offenderVictimRelTypePartCnt;
	}
	public void setOffenderVictimRelTypePartCnt(String offenderVictimRelTypePartCnt) {
		this.offenderVictimRelTypePartCnt = offenderVictimRelTypePartCnt;
	}
	public String getOffenderVictimRelTypeOthCnt() {
		return offenderVictimRelTypeOthCnt;
	}
	public void setOffenderVictimRelTypeOthCnt(String offenderVictimRelTypeOthCnt) {
		this.offenderVictimRelTypeOthCnt = offenderVictimRelTypeOthCnt;
	}
	public String getOffenderVictimRelTypeEtcCnt() {
		return offenderVictimRelTypeEtcCnt;
	}
	public void setOffenderVictimRelTypeEtcCnt(String offenderVictimRelTypeEtcCnt) {
		this.offenderVictimRelTypeEtcCnt = offenderVictimRelTypeEtcCnt;
	}
	public String getOffenderVictimRelTypeUnkCnt() {
		return offenderVictimRelTypeUnkCnt;
	}
	public void setOffenderVictimRelTypeUnkCnt(String offenderVictimRelTypeUnkCnt) {
		this.offenderVictimRelTypeUnkCnt = offenderVictimRelTypeUnkCnt;
	}
	public List<String> getConsultingTypeCbx() {
		return consultingTypeCbx;
	}
	public void setConsultingTypeCbx(List<String> consultingTypeCbx) {
		this.consultingTypeCbx = consultingTypeCbx;
	}
	public List<String> getReceivedTypeCbx() {
		return receivedTypeCbx;
	}
	public void setReceivedTypeCbx(List<String> receivedTypeCbx) {
		this.receivedTypeCbx = receivedTypeCbx;
	}
	public List<String> getConsultingReqTypeCbx() {
		return consultingReqTypeCbx;
	}
	public void setConsultingReqTypeCbx(List<String> consultingReqTypeCbx) {
		this.consultingReqTypeCbx = consultingReqTypeCbx;
	}
	public List<String> getContactMethodTypeCbx() {
		return contactMethodTypeCbx;
	}
	public void setContactMethodTypeCbx(List<String> contactMethodTypeCbx) {
		this.contactMethodTypeCbx = contactMethodTypeCbx;
	}
	public List<String> getClientGenderCbx() {
		return clientGenderCbx;
	}
	public void setClientGenderCbx(List<String> clientGenderCbx) {
		this.clientGenderCbx = clientGenderCbx;
	}
	public List<String> getClientVictimRelTypeCbx() {
		return clientVictimRelTypeCbx;
	}
	public void setClientVictimRelTypeCbx(List<String> clientVictimRelTypeCbx) {
		this.clientVictimRelTypeCbx = clientVictimRelTypeCbx;
	}
	public List<String> getVictimGenderTypeCbx() {
		return victimGenderTypeCbx;
	}
	public void setVictimGenderTypeCbx(List<String> victimGenderTypeCbx) {
		this.victimGenderTypeCbx = victimGenderTypeCbx;
	}
	public List<String> getOffenderGenderTypeCbx() {
		return offenderGenderTypeCbx;
	}
	public void setOffenderGenderTypeCbx(List<String> offenderGenderTypeCbx) {
		this.offenderGenderTypeCbx = offenderGenderTypeCbx;
	}
	public List<String> getOffenderVictimRelTypeCbx() {
		return offenderVictimRelTypeCbx;
	}
	public void setOffenderVictimRelTypeCbx(List<String> offenderVictimRelTypeCbx) {
		this.offenderVictimRelTypeCbx = offenderVictimRelTypeCbx;
	}
	public List<String> getHarmFirstTypeCbx() {
		return harmFirstTypeCbx;
	}
	public void setHarmFirstTypeCbx(List<String> harmFirstTypeCbx) {
		this.harmFirstTypeCbx = harmFirstTypeCbx;
	}
	public List<String> getHarmSecTypeCbx() {
		return harmSecTypeCbx;
	}
	public void setHarmSecTypeCbx(List<String> harmSecTypeCbx) {
		this.harmSecTypeCbx = harmSecTypeCbx;
	}
	public List<String> getResponseTypeIntroOrgCbx() {
		return responseTypeIntroOrgCbx;
	}
	public void setResponseTypeIntroOrgCbx(List<String> responseTypeIntroOrgCbx) {
		this.responseTypeIntroOrgCbx = responseTypeIntroOrgCbx;
	}
	public List<String> getResponseTypeServiceRelCbx() {
		return responseTypeServiceRelCbx;
	}
	public void setResponseTypeServiceRelCbx(List<String> responseTypeServiceRelCbx) {
		this.responseTypeServiceRelCbx = responseTypeServiceRelCbx;
	}
	public String getSdate() {
		return sdate;
	}
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}
	public String getEdate() {
		return edate;
	}
	public void setEdate(String edate) {
		this.edate = edate;
	}
	public String getRange() {
		return range;
	}
	public void setRange(String range) {
		this.range = range;
	}
	public String getDays() {
		return days;
	}
	public void setDays(String days) {
		this.days = days;
	}
	public String getMonths() {
		return months;
	}
	public void setMonths(String months) {
		this.months = months;
	}
	
	
	
}