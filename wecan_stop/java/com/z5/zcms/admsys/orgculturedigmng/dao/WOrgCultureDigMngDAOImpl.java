package com.z5.zcms.admsys.orgculturedigmng.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.orgculturedigmng.domain.CommInfoVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.ConInfoRelActionVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.ManagerListVo;
import com.z5.zcms.admsys.orgculturedigmng.domain.WOrgCultureDigMngVo;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class WOrgCultureDigMngDAOImpl extends EgovComAbstractDAO implements WOrgCultureDigMngDAO {

	private final String sqlMapNs = "orgculturedigmng.";

	@Override
	public Integer registration(WOrgCultureDigMngVo reqVo) {
		return (Integer) super.insert(sqlMapNs + "actionRegistration", reqVo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WOrgCultureDigMngVo> getlist(WOrgCultureDigMngVo reqVo) {
		return (List<WOrgCultureDigMngVo>) super.list(sqlMapNs + "list", reqVo);
	}

	@Override
	public Integer listCount(WOrgCultureDigMngVo reqVo) {
		return (Integer) super.select(sqlMapNs + "listCount", reqVo);
	}

	@Override
	public WOrgCultureDigMngVo view(WOrgCultureDigMngVo reqVo) {
		return (WOrgCultureDigMngVo) super.select(sqlMapNs + "view", reqVo);
	}

	@Override
	public Integer actionUpdate(WOrgCultureDigMngVo reqVo) {
		return (Integer) super.update(sqlMapNs + "actionUpdate", reqVo);
	}

	@Override
	public Integer deleteRequestByTeacher(WOrgCultureDigMngVo reqVo) {
		return (Integer) super.update(sqlMapNs + "deleteRequestByTeacher", reqVo);
		// return (Integer)super.update(sqlMapNs + "TEMPdeleteRequestByTeacher", reqVo);
	}

	@Override
	public Integer delPermanent(WOrgCultureDigMngVo reqVo) {
		return (Integer) super.delete(sqlMapNs + "delPermanent", reqVo);
	}

	@Override
	public Integer updDelYn(WOrgCultureDigMngVo reqVo) {
		return (Integer) super.update(sqlMapNs + "updDelYn", reqVo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<WOrgCultureDigMngVo> getDelList(WOrgCultureDigMngVo reqVo) {
		return (List<WOrgCultureDigMngVo>) super.list(sqlMapNs + "delList", reqVo);
	}

	@Override
	public Integer delListCount(WOrgCultureDigMngVo reqVo) {
		return (Integer) super.select(sqlMapNs + "delListCount", reqVo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ManagerListVo> managerList() {
		return (List<ManagerListVo>) super.list(sqlMapNs + "managerList");
	}

	@Override
	public Integer insertRelManager(WOrgCultureDigMngVo reqVo) {
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
	public void insertRelComissioner(WOrgCultureDigMngVo reqVo) {
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
	public void insertRelAcWithCon(WOrgCultureDigMngVo reqVo) {
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
}