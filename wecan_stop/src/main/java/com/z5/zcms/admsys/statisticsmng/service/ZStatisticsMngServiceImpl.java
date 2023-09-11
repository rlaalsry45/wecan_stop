package com.z5.zcms.admsys.statisticsmng.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.z5.zcms.admsys.statisticsmng.dao.ZStatisticsMngDAO;
import com.z5.zcms.admsys.statisticsmng.domain.ZStatisticsMngVo;
import com.z5.zcms.util.DataTable;
import com.z5.zcms.util.StringUtil;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service
public class ZStatisticsMngServiceImpl extends EgovAbstractServiceImpl implements ZStatisticsMngService {

	@Autowired
	private ZStatisticsMngDAO zStatisticsMngDAO;

	@Override
	public ZStatisticsMngVo getMonthCounsel(ZStatisticsMngVo reqVo) {
		return zStatisticsMngDAO.getMonthCounsel(reqVo);
	}
	
	@Override
	public ZStatisticsMngVo getMonthAction(ZStatisticsMngVo reqVo) {
		return zStatisticsMngDAO.getMonthAction(reqVo);
	}

	@Override
	public ZStatisticsMngVo getYearCounsel(ZStatisticsMngVo reqVo) {
		return zStatisticsMngDAO.getYearCounsel(reqVo);
	}

	@Override
	public ZStatisticsMngVo getClientVictimRelType(ZStatisticsMngVo reqVo) {
		return zStatisticsMngDAO.getClientVictimRelType(reqVo);
	}

	@Override
	public ZStatisticsMngVo getActionTypeServiceRel(ZStatisticsMngVo reqVo) {
		return zStatisticsMngDAO.getActionTypeServiceRel(reqVo);
	}

	@Override
	public ZStatisticsMngVo getYearActionTypeServiceRel(ZStatisticsMngVo reqVo) {
		return zStatisticsMngDAO.getYearActionTypeServiceRel(reqVo);
	}

	@Override
	public ZStatisticsMngVo getActionCode(ZStatisticsMngVo reqVo) {
		return zStatisticsMngDAO.getActionCode(reqVo);
	}

	@Override
	public ZStatisticsMngVo getStep8ActionCode(ZStatisticsMngVo reqVo) {
		return zStatisticsMngDAO.getStep8ActionCode(reqVo);
	}

	@Override
	public ZStatisticsMngVo getOrgType(ZStatisticsMngVo reqVo) {
		return zStatisticsMngDAO.getOrgType(reqVo);
	}

	@Override
	public ZStatisticsMngVo getStep8OrgType(ZStatisticsMngVo reqVo) {
		return zStatisticsMngDAO.getStep8OrgType(reqVo);
	}
	
	@Override
	public ZStatisticsMngVo getOrgTypeGovDetail(ZStatisticsMngVo reqVo) {
		return zStatisticsMngDAO.getOrgTypeGovDetail(reqVo);
	}

	@Override
	public ZStatisticsMngVo getStep8OrgTypeGovDetail(ZStatisticsMngVo reqVo) {
		return zStatisticsMngDAO.getStep8OrgTypeGovDetail(reqVo);
	}

	@Override
	public ZStatisticsMngVo getHamType(ZStatisticsMngVo reqVo) {
		return zStatisticsMngDAO.getHamType(reqVo);
	}

	@Override
	public ZStatisticsMngVo getConsultingType(ZStatisticsMngVo reqVo) {
		return zStatisticsMngDAO.getConsultingType(reqVo);
	}

	@Override
	public ZStatisticsMngVo getWeekActionTypeCont(ZStatisticsMngVo reqVo) {
		return zStatisticsMngDAO.getWeekActionTypeCont(reqVo);
	}

	@Override
	public ZStatisticsMngVo getYearActionTypeCont(ZStatisticsMngVo reqVo) {
		return zStatisticsMngDAO.getYearActionTypeCont(reqVo);
	}

	@Override
	public ZStatisticsMngVo getMasterActionTypeServiceRel(ZStatisticsMngVo reqVo) {
		return zStatisticsMngDAO.getMasterActionTypeServiceRel(reqVo);
	}

	@Override
	public ZStatisticsMngVo getHistoryActionTypeServiceRel(ZStatisticsMngVo reqVo) {
		return zStatisticsMngDAO.getHistoryActionTypeServiceRel(reqVo);
	}

	@Override
	public ZStatisticsMngVo getSatisfaction(ZStatisticsMngVo reqVo) {
		return zStatisticsMngDAO.getSatisfaction(reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getSatisfaction1OpinionList(ZStatisticsMngVo reqVo) {
		return zStatisticsMngDAO.getSatisfaction1OpinionList(reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getSatisfaction2OpinionList(ZStatisticsMngVo reqVo) {
		return zStatisticsMngDAO.getSatisfaction2OpinionList(reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getSatisfaction3OpinionList(ZStatisticsMngVo reqVo) {
		return zStatisticsMngDAO.getSatisfaction3OpinionList(reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getSatisfaction4OpinionList(ZStatisticsMngVo reqVo) {
		return zStatisticsMngDAO.getSatisfaction4OpinionList(reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getSatisfaction5OpinionList(ZStatisticsMngVo reqVo) {
		return zStatisticsMngDAO.getSatisfaction5OpinionList(reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getSatisfaction6OpinionList(ZStatisticsMngVo reqVo) {
		return zStatisticsMngDAO.getSatisfaction6OpinionList(reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getSatisfaction7OpinionList(ZStatisticsMngVo reqVo) {
		return zStatisticsMngDAO.getSatisfaction7OpinionList(reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getSatisfaction8OpinionList(ZStatisticsMngVo reqVo) {
		return zStatisticsMngDAO.getSatisfaction8OpinionList(reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getSatisfaction9List(ZStatisticsMngVo reqVo) {
		return zStatisticsMngDAO.getSatisfaction9List(reqVo);
	}

	@Override
	public ZStatisticsMngVo getSurvey(ZStatisticsMngVo reqVo) {
		return zStatisticsMngDAO.getSurvey(reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getSurvey7OpinionList(ZStatisticsMngVo reqVo) {
		return zStatisticsMngDAO.getSurvey7OpinionList(reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getSurvey7_1_1OpinionList(ZStatisticsMngVo reqVo) {
		return zStatisticsMngDAO.getSurvey7_1_1OpinionList(reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getSurvey7_2_1OpinionList(ZStatisticsMngVo reqVo) {
		return zStatisticsMngDAO.getSurvey7_2_1OpinionList(reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getSurvey10OpinionList(ZStatisticsMngVo reqVo) {
		return zStatisticsMngDAO.getSurvey10OpinionList(reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getSurvey11OpinionList(ZStatisticsMngVo reqVo) {
		return zStatisticsMngDAO.getSurvey11OpinionList(reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getSurvey12OpinionList(ZStatisticsMngVo reqVo) {
		return zStatisticsMngDAO.getSurvey12OpinionList(reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getSurvey13OpinionList(ZStatisticsMngVo reqVo) {
		return zStatisticsMngDAO.getSurvey13OpinionList(reqVo);
	}

	@Override
	public ZStatisticsMngVo getPrequery(ZStatisticsMngVo reqVo) {
		return zStatisticsMngDAO.getPrequery(reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getPrequery2_8OpinionList(ZStatisticsMngVo reqVo) {
		return zStatisticsMngDAO.getPrequery2_8OpinionList(reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getPrequery4List(ZStatisticsMngVo reqVo) {
		return zStatisticsMngDAO.getPrequery4List(reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getPrequery5_8OpinionList(ZStatisticsMngVo reqVo) {
		return zStatisticsMngDAO.getPrequery5_8OpinionList(reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getPrequery6_1_7OpinionList(ZStatisticsMngVo reqVo) {
		return zStatisticsMngDAO.getPrequery6_1_7OpinionList(reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getPrequery6_2_6OpinionList(ZStatisticsMngVo reqVo) {
		return zStatisticsMngDAO.getPrequery6_2_6OpinionList(reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getPrequery6_2_1_6OpinionList(ZStatisticsMngVo reqVo) {
		return zStatisticsMngDAO.getPrequery6_2_1_6OpinionList(reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getPrequery6_3_3OpinionList(ZStatisticsMngVo reqVo) {
		return zStatisticsMngDAO.getPrequery6_3_3OpinionList(reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getPrequery7_4OpinionList(ZStatisticsMngVo reqVo) {
		return zStatisticsMngDAO.getPrequery7_4OpinionList(reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getPrequery9List(ZStatisticsMngVo reqVo) {
		return zStatisticsMngDAO.getPrequery9List(reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getPrequery10List(ZStatisticsMngVo reqVo) {
		return zStatisticsMngDAO.getPrequery10List(reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getPrequery11List(ZStatisticsMngVo reqVo) {
		return zStatisticsMngDAO.getPrequery11List(reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getPrequery13List(ZStatisticsMngVo reqVo) {
		return zStatisticsMngDAO.getPrequery13List(reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getDailyList(ZStatisticsMngVo reqVo) throws Exception {
		return zStatisticsMngDAO.getDailyList(reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getMonthlyList(ZStatisticsMngVo reqVo) throws Exception {
		return zStatisticsMngDAO.getMonthlyList(reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getConsultingList(ZStatisticsMngVo reqVo) throws Exception {
		return zStatisticsMngDAO.getConsultingList(reqVo);
	}
	
	@Override
	public List<ZStatisticsMngVo> getConsultingTypeList(ZStatisticsMngVo reqVo) throws Exception {
		return zStatisticsMngDAO.getConsultingTypeList(reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getReceivedTypeList(ZStatisticsMngVo reqVo) throws Exception {
		return zStatisticsMngDAO.getReceivedTypeList(reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getConsultingReqTypeList(ZStatisticsMngVo reqVo) throws Exception {
		return zStatisticsMngDAO.getConsultingReqTypeList(reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> geContactMethodTypeList(ZStatisticsMngVo reqVo) throws Exception {
		return zStatisticsMngDAO.geContactMethodTypeList(reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getClientGenderList(ZStatisticsMngVo reqVo) throws Exception {
		return zStatisticsMngDAO.getClientGenderList(reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getClientVictimRelTypeList(ZStatisticsMngVo reqVo) throws Exception {
		return zStatisticsMngDAO.getClientVictimRelTypeList(reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getVictimGenderTypeList(ZStatisticsMngVo reqVo) throws Exception {
		return zStatisticsMngDAO.getVictimGenderTypeList(reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getOffenderGenderTypeList(ZStatisticsMngVo reqVo) throws Exception {
		return zStatisticsMngDAO.getOffenderGenderTypeList(reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getOffenderVictimRelTypeList(ZStatisticsMngVo reqVo) throws Exception {
		return zStatisticsMngDAO.getOffenderVictimRelTypeList(reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getHarmFirstTypeList(ZStatisticsMngVo reqVo) throws Exception {
		return zStatisticsMngDAO.getHarmFirstTypeList(reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getHarmSecTypeList(ZStatisticsMngVo reqVo) throws Exception {
		return zStatisticsMngDAO.getHarmSecTypeList(reqVo);
	}
	
	@Override
	public List<ZStatisticsMngVo> getResponseTypeIntroOrgList(ZStatisticsMngVo reqVo) throws Exception {
		return zStatisticsMngDAO.getResponseTypeIntroOrgList(reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getResponseTypeServiceRelList(ZStatisticsMngVo reqVo) throws Exception {
		return zStatisticsMngDAO.getResponseTypeServiceRelList(reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getActionList(ZStatisticsMngVo reqVo) throws Exception {
		return zStatisticsMngDAO.getActionList(reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getActionTypeList(ZStatisticsMngVo reqVo) throws Exception {
		return zStatisticsMngDAO.getActionTypeList(reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getStepStatusList(ZStatisticsMngVo reqVo) throws Exception {
		return zStatisticsMngDAO.getStepStatusList(reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getActionConsultingTypeList(ZStatisticsMngVo reqVo) throws Exception {
		return zStatisticsMngDAO.getActionConsultingTypeList(reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getActionReceivedTypeList(ZStatisticsMngVo reqVo) throws Exception {
		return zStatisticsMngDAO.getActionReceivedTypeList(reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getActionClientGenderList(ZStatisticsMngVo reqVo) throws Exception {
		return zStatisticsMngDAO.getActionClientGenderList(reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getActionClientVictimRelTypeList(ZStatisticsMngVo reqVo) throws Exception {
		return zStatisticsMngDAO.getActionClientVictimRelTypeList(reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getOrgAccidentStepList(ZStatisticsMngVo reqVo) throws Exception {
		return zStatisticsMngDAO.getOrgAccidentStepList(reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getActionTypeOtherOrgList(ZStatisticsMngVo reqVo) throws Exception {
		return zStatisticsMngDAO.getActionTypeOtherOrgList(reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getActionTypeServiceRelList(ZStatisticsMngVo reqVo) throws Exception {
		return zStatisticsMngDAO.getActionTypeServiceRelList(reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getActionTypeContList(ZStatisticsMngVo reqVo) throws Exception {
		return zStatisticsMngDAO.getActionTypeContList(reqVo);
	}

}