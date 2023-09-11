package com.z5.zcms.admsys.orgculturedigmng.dao;

import java.util.List;

import com.z5.zcms.admsys.orgculturedigmng.domain.AppActionMergeVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.CommInfoVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.ConInfoRelActionVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.ManagerListVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.WConsultingActionOldApplicationVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.WConsultingActionOldDeclarationVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.WCounselorVo;
import com.z5.zcms.frontsys.front.domain.FrontApplicationVo;

public interface WOrgCultureDigMngDAO {

	public Integer registration(AppActionMergeVo reqVo);
	public List<AppActionMergeVo> getlist(AppActionMergeVo reqVo);
	public Integer listCount(AppActionMergeVo reqVo);
	public AppActionMergeVo view(AppActionMergeVo reqVo);
	public Integer actionUpdate(AppActionMergeVo reqVo);
	public Integer deleteRequestByTeacher(AppActionMergeVo reqVo);
	public Integer delPermanent(AppActionMergeVo reqVo);
	public Integer updDelYn(AppActionMergeVo reqVo);
	public List<AppActionMergeVo> getDelList(AppActionMergeVo reqVo);
	public Integer delListCount(AppActionMergeVo reqVo);
	public List<ManagerListVo> managerList();
	public Integer insertRelManager(AppActionMergeVo reqVo);
	public List<ManagerListVo> retrieveManagerListByConsultIngActionNO(String consulting_action_no);
	public int deleteRelManagerByConsultingActionNO(String consulting_action_no);
	public void insertRelComissioner(AppActionMergeVo reqVo);
	public List<CommInfoVo> retrieveCommissionoerList(String consulting_action_no);
	public int deleteRelCommissionerByConsultingActionNO(String consulting_action_no);
	public void insertRelAcWithCon(AppActionMergeVo reqVo);
	public List<ConInfoRelActionVo> retrieveRelConList(String consulting_action_no);
	public void deleteRelConsultingByConsultingActionNO(String consulting_action_no);
	public int applicationStepChange(FrontApplicationVo vo);
	public List<WCounselorVo> linkPopIndex(WCounselorVo reqVo);
	public int linkPopCount(WCounselorVo reqVo);
	public int checkCurStat(FrontApplicationVo vo);
	public void registrationAppHistory(FrontApplicationVo vo);
	public List<AppActionMergeVo> getScheduleList(AppActionMergeVo reqVo);	
}