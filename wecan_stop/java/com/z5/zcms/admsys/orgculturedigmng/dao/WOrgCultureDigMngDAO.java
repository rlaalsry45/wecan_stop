package com.z5.zcms.admsys.orgculturedigmng.dao;

import java.util.List;

import com.z5.zcms.admsys.orgculturedigmng.domain.CommInfoVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.ConInfoRelActionVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.ManagerListVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.WOrgCultureDigMngVo;

public interface WOrgCultureDigMngDAO {

	public Integer registration(WOrgCultureDigMngVo reqVo);
	public List<WOrgCultureDigMngVo> getlist(WOrgCultureDigMngVo reqVo);
	public Integer listCount(WOrgCultureDigMngVo reqVo);
	public WOrgCultureDigMngVo view(WOrgCultureDigMngVo reqVo);
	public Integer actionUpdate(WOrgCultureDigMngVo reqVo);
	public Integer deleteRequestByTeacher(WOrgCultureDigMngVo reqVo);
	public Integer delPermanent(WOrgCultureDigMngVo reqVo);
	public Integer updDelYn(WOrgCultureDigMngVo reqVo);
	public List<WOrgCultureDigMngVo> getDelList(WOrgCultureDigMngVo reqVo);
	public Integer delListCount(WOrgCultureDigMngVo reqVo);
	public List<ManagerListVo> managerList();
	public Integer insertRelManager(WOrgCultureDigMngVo reqVo);
	public List<ManagerListVo> retrieveManagerListByConsultIngActionNO(String consulting_action_no);
	public int deleteRelManagerByConsultingActionNO(String consulting_action_no);
	public void insertRelComissioner(WOrgCultureDigMngVo reqVo);
	public List<CommInfoVo> retrieveCommissionoerList(String consulting_action_no);
	public int deleteRelCommissionerByConsultingActionNO(String consulting_action_no);
	public void insertRelAcWithCon(WOrgCultureDigMngVo reqVo);
	public List<ConInfoRelActionVo> retrieveRelConList(String consulting_action_no);
	public void deleteRelConsultingByConsultingActionNO(String consulting_action_no);
}