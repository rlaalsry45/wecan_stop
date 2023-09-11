package com.z5.zcms.admsys.orgculturedigmng.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.orgculturedigmng.domain.AppActionMergeVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.CommInfoVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.ConInfoRelActionVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.ManagerListVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.WCounselorVo;
import com.z5.zcms.frontsys.front.domain.FrontApplicationVo;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class WOrgCultureDigMngDAOImpl extends EgovComAbstractDAO implements WOrgCultureDigMngDAO {

	private final String sqlMapNs = "orgculturedigmng.";
	private final String sqlMapNsC = "w_counselor.";

	@Override
	public Integer registration(AppActionMergeVo reqVo) {
		return (Integer) super.insert(sqlMapNs + "actionRegistration", reqVo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AppActionMergeVo> getlist(AppActionMergeVo reqVo) {
		return (List<AppActionMergeVo>) super.list(sqlMapNs + "list", reqVo);
	}

	@Override
	public Integer listCount(AppActionMergeVo reqVo) {
		return (Integer) super.select(sqlMapNs + "listCount", reqVo);
	}

	@Override
	public AppActionMergeVo view(AppActionMergeVo reqVo) {
		return (AppActionMergeVo) super.select(sqlMapNs + "view", reqVo);
	}

	@Override
	public Integer actionUpdate(AppActionMergeVo reqVo) {
		return (Integer) super.update(sqlMapNs + "actionUpdate", reqVo);
	}

	@Override
	public Integer deleteRequestByTeacher(AppActionMergeVo reqVo) {
		return (Integer) super.update(sqlMapNs + "deleteRequestByTeacher", reqVo);
		// return (Integer)super.update(sqlMapNs + "TEMPdeleteRequestByTeacher", reqVo);
	}

	@Override
	public Integer delPermanent(AppActionMergeVo reqVo) {
		return (Integer) super.delete(sqlMapNs + "delPermanent", reqVo);
	}

	@Override
	public Integer updDelYn(AppActionMergeVo reqVo) {
		return (Integer) super.update(sqlMapNs + "updDelYn", reqVo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AppActionMergeVo> getDelList(AppActionMergeVo reqVo) {
		return (List<AppActionMergeVo>) super.list(sqlMapNs + "delList", reqVo);
	}

	@Override
	public Integer delListCount(AppActionMergeVo reqVo) {
		return (Integer) super.select(sqlMapNs + "delListCount", reqVo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ManagerListVo> managerList() {
		return (List<ManagerListVo>) super.list(sqlMapNs + "managerList");
	}

	@Override
	public Integer insertRelManager(AppActionMergeVo reqVo) {
		return (Integer) super.insert(sqlMapNs + "insertRelManager", reqVo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ManagerListVo> retrieveManagerListByConsultIngActionNO(String consulting_action_no) {
		return (List<ManagerListVo>) super.list(sqlMapNs + "retrieveManagerListByConsultIngActionNO",
				consulting_action_no);
	}

	@Override
	public int deleteRelManagerByConsultingActionNO(String consulting_action_no) {
		return (int) super.delete(sqlMapNs + "deleteRelManagerByConsultingActionNO", consulting_action_no);
	}

	@Override
	public void insertRelComissioner(AppActionMergeVo reqVo) {
		super.insert(sqlMapNs + "insertRelComissioner", reqVo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CommInfoVo> retrieveCommissionoerList(String consulting_action_no) {
		return (List<CommInfoVo>)super.list(sqlMapNs+"retrieveCommissionoerList", consulting_action_no);
	}

	@Override
	public int deleteRelCommissionerByConsultingActionNO(String consulting_action_no) {
		return (int) super.delete(sqlMapNs+"deleteRelCommissionerByConsultingActionNO", consulting_action_no);
	}

	@Override
	public void insertRelAcWithCon(AppActionMergeVo reqVo) {
		super.insert(sqlMapNs+"insertRelAcWithCon", reqVo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ConInfoRelActionVo> retrieveRelConList(String consulting_action_no) {
		return (List<ConInfoRelActionVo>)super.list(sqlMapNs+"retrieveRelConList",consulting_action_no);
	}

	@Override
	public void deleteRelConsultingByConsultingActionNO(String consulting_action_no) {
		super.delete(sqlMapNs+"deleteRelConsultingByConsultingActionNO", consulting_action_no);		
	}

	@Override
	public int applicationStepChange(FrontApplicationVo vo) {
		return super.update(sqlMapNs+"applicationStepChange", vo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WCounselorVo> linkPopIndex(WCounselorVo reqVo) {
		return (List<WCounselorVo>)super.list(sqlMapNsC+"linkPopIndex", reqVo);
	}

	@Override
	public int linkPopCount(WCounselorVo reqVo) {
		return (int)super.select(sqlMapNsC+"linkPopCount", reqVo);
	}

	@Override
	public int checkCurStat(FrontApplicationVo vo) {
		return (int)super.select(sqlMapNs+"checkCurStat", vo);
	}

	@Override
	public void registrationAppHistory(FrontApplicationVo vo) {
		super.insert(sqlMapNs+"registrationAppHistory", vo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AppActionMergeVo> getScheduleList(AppActionMergeVo reqVo) {
		return (List<AppActionMergeVo>)super.list(sqlMapNs+"allScheduleList", reqVo);
	}

}