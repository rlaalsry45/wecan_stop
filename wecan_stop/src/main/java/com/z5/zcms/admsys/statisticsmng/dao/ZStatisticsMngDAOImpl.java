package com.z5.zcms.admsys.statisticsmng.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.statisticsmng.domain.ZStatisticsMngVo;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class ZStatisticsMngDAOImpl extends EgovComAbstractDAO implements ZStatisticsMngDAO {

	private final String sqlMapNs = "statisticsDAO.";
	
	@Override
	public ZStatisticsMngVo getMonthCounsel(ZStatisticsMngVo reqVo) {
		return (ZStatisticsMngVo)select(sqlMapNs+"getMonthCounsel", reqVo);
	}
	
	@Override
	public ZStatisticsMngVo getMonthAction(ZStatisticsMngVo reqVo) {
		return (ZStatisticsMngVo)select(sqlMapNs+"getMonthAction", reqVo);
	}

	@Override
	public ZStatisticsMngVo getYearCounsel(ZStatisticsMngVo reqVo) {
		return (ZStatisticsMngVo)select(sqlMapNs+"getYearCounsel", reqVo);
	}

	@Override
	public ZStatisticsMngVo getClientVictimRelType(ZStatisticsMngVo reqVo) {
		return (ZStatisticsMngVo)select(sqlMapNs+"getClientVictimRelType", reqVo);
	}

	@Override
	public ZStatisticsMngVo getActionTypeServiceRel(ZStatisticsMngVo reqVo) {
		return (ZStatisticsMngVo)select(sqlMapNs+"getActionTypeServiceRel", reqVo);
	}

	@Override
	public ZStatisticsMngVo getYearActionTypeServiceRel(ZStatisticsMngVo reqVo) {
		return (ZStatisticsMngVo)select(sqlMapNs+"getYearActionTypeServiceRel", reqVo);
	}

	@Override
	public ZStatisticsMngVo getActionCode(ZStatisticsMngVo reqVo) {
		return (ZStatisticsMngVo)select(sqlMapNs+"getActionCode", reqVo);
	}

	@Override
	public ZStatisticsMngVo getStep8ActionCode(ZStatisticsMngVo reqVo) {
		return (ZStatisticsMngVo)select(sqlMapNs+"getStep8ActionCode", reqVo);
	}

	@Override
	public ZStatisticsMngVo getOrgType(ZStatisticsMngVo reqVo) {
		return (ZStatisticsMngVo)select(sqlMapNs+"getOrgType", reqVo);
	}

	@Override
	public ZStatisticsMngVo getStep8OrgType(ZStatisticsMngVo reqVo) {
		return (ZStatisticsMngVo)select(sqlMapNs+"getStep8OrgType", reqVo);
	}
	
	@Override
	public ZStatisticsMngVo getOrgTypeGovDetail(ZStatisticsMngVo reqVo) {
		return (ZStatisticsMngVo)select(sqlMapNs+"getOrgTypeGovDetail", reqVo);
	}

	@Override
	public ZStatisticsMngVo getStep8OrgTypeGovDetail(ZStatisticsMngVo reqVo) {
		return (ZStatisticsMngVo)select(sqlMapNs+"getStep8OrgTypeGovDetail", reqVo);
	}

	@Override
	public ZStatisticsMngVo getHamType(ZStatisticsMngVo reqVo) {
		return (ZStatisticsMngVo)select(sqlMapNs+"getHamType", reqVo);
	}

	@Override
	public ZStatisticsMngVo getConsultingType(ZStatisticsMngVo reqVo) {
		return (ZStatisticsMngVo)select(sqlMapNs+"getConsultingType", reqVo);
	}

	@Override
	public ZStatisticsMngVo getWeekActionTypeCont(ZStatisticsMngVo reqVo) {
		return (ZStatisticsMngVo)select(sqlMapNs+"getWeekActionTypeCont", reqVo);
	}

	@Override
	public ZStatisticsMngVo getYearActionTypeCont(ZStatisticsMngVo reqVo) {
		return (ZStatisticsMngVo)select(sqlMapNs+"getYearActionTypeCont", reqVo);
	}

	@Override
	public ZStatisticsMngVo getMasterActionTypeServiceRel(ZStatisticsMngVo reqVo) {
		return (ZStatisticsMngVo)select(sqlMapNs+"getMasterActionTypeServiceRel", reqVo);
	}

	@Override
	public ZStatisticsMngVo getHistoryActionTypeServiceRel(ZStatisticsMngVo reqVo) {
		return (ZStatisticsMngVo)select(sqlMapNs+"getHistoryActionTypeServiceRel", reqVo);
	}

	@Override
	public ZStatisticsMngVo getSatisfaction(ZStatisticsMngVo reqVo) {
		return (ZStatisticsMngVo)select(sqlMapNs+"getSatisfaction", reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getSatisfaction1OpinionList(ZStatisticsMngVo reqVo) {
		return (List<ZStatisticsMngVo>)list(sqlMapNs+"getSatisfaction1OpinionList", reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getSatisfaction2OpinionList(ZStatisticsMngVo reqVo) {
		return (List<ZStatisticsMngVo>)list(sqlMapNs+"getSatisfaction2OpinionList", reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getSatisfaction3OpinionList(ZStatisticsMngVo reqVo) {
		return (List<ZStatisticsMngVo>)list(sqlMapNs+"getSatisfaction3OpinionList", reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getSatisfaction4OpinionList(ZStatisticsMngVo reqVo) {
		return (List<ZStatisticsMngVo>)list(sqlMapNs+"getSatisfaction4OpinionList", reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getSatisfaction5OpinionList(ZStatisticsMngVo reqVo) {
		return (List<ZStatisticsMngVo>)list(sqlMapNs+"getSatisfaction5OpinionList", reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getSatisfaction6OpinionList(ZStatisticsMngVo reqVo) {
		return (List<ZStatisticsMngVo>)list(sqlMapNs+"getSatisfaction6OpinionList", reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getSatisfaction7OpinionList(ZStatisticsMngVo reqVo) {
		return (List<ZStatisticsMngVo>)list(sqlMapNs+"getSatisfaction7OpinionList", reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getSatisfaction8OpinionList(ZStatisticsMngVo reqVo) {
		return (List<ZStatisticsMngVo>)list(sqlMapNs+"getSatisfaction8OpinionList", reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getSatisfaction9List(ZStatisticsMngVo reqVo) {
		return (List<ZStatisticsMngVo>)list(sqlMapNs+"getSatisfaction9List", reqVo);
	}

	@Override
	public ZStatisticsMngVo getSurvey(ZStatisticsMngVo reqVo) {
		return (ZStatisticsMngVo)select(sqlMapNs+"getSurvey", reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getSurvey7OpinionList(ZStatisticsMngVo reqVo) {
		return (List<ZStatisticsMngVo>)list(sqlMapNs+"getSurvey7OpinionList", reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getSurvey7_1_1OpinionList(ZStatisticsMngVo reqVo) {
		return (List<ZStatisticsMngVo>)list(sqlMapNs+"getSurvey7_1_1OpinionList", reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getSurvey7_2_1OpinionList(ZStatisticsMngVo reqVo) {
		return (List<ZStatisticsMngVo>)list(sqlMapNs+"getSurvey7_2_1OpinionList", reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getSurvey10OpinionList(ZStatisticsMngVo reqVo) {
		return (List<ZStatisticsMngVo>)list(sqlMapNs+"getSurvey10OpinionList", reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getSurvey11OpinionList(ZStatisticsMngVo reqVo) {
		return (List<ZStatisticsMngVo>)list(sqlMapNs+"getSurvey11OpinionList", reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getSurvey12OpinionList(ZStatisticsMngVo reqVo) {
		return (List<ZStatisticsMngVo>)list(sqlMapNs+"getSurvey12OpinionList", reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getSurvey13OpinionList(ZStatisticsMngVo reqVo) {
		return (List<ZStatisticsMngVo>)list(sqlMapNs+"getSurvey13OpinionList", reqVo);
	}

	@Override
	public ZStatisticsMngVo getPrequery(ZStatisticsMngVo reqVo) {
		return (ZStatisticsMngVo)select(sqlMapNs+"getPrequery", reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getPrequery2_8OpinionList(ZStatisticsMngVo reqVo) {
		return (List<ZStatisticsMngVo>)list(sqlMapNs+"getPrequery2_8OpinionList", reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getPrequery4List(ZStatisticsMngVo reqVo) {
		return (List<ZStatisticsMngVo>)list(sqlMapNs+"getPrequery4List", reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getPrequery5_8OpinionList(ZStatisticsMngVo reqVo) {
		return (List<ZStatisticsMngVo>)list(sqlMapNs+"getPrequery5_8OpinionList", reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getPrequery6_1_7OpinionList(ZStatisticsMngVo reqVo) {
		return (List<ZStatisticsMngVo>)list(sqlMapNs+"getPrequery6_1_7OpinionList", reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getPrequery6_2_6OpinionList(ZStatisticsMngVo reqVo) {
		return (List<ZStatisticsMngVo>)list(sqlMapNs+"getPrequery6_2_6OpinionList", reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getPrequery6_2_1_6OpinionList(ZStatisticsMngVo reqVo) {
		return (List<ZStatisticsMngVo>)list(sqlMapNs+"getPrequery6_2_1_6OpinionList", reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getPrequery6_3_3OpinionList(ZStatisticsMngVo reqVo) {
		return (List<ZStatisticsMngVo>)list(sqlMapNs+"getPrequery6_3_3OpinionList", reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getPrequery7_4OpinionList(ZStatisticsMngVo reqVo) {
		return (List<ZStatisticsMngVo>)list(sqlMapNs+"getPrequery7_4OpinionList", reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getPrequery9List(ZStatisticsMngVo reqVo) {
		return (List<ZStatisticsMngVo>)list(sqlMapNs+"getPrequery9List", reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getPrequery10List(ZStatisticsMngVo reqVo) {
		return (List<ZStatisticsMngVo>)list(sqlMapNs+"getPrequery10List", reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getPrequery11List(ZStatisticsMngVo reqVo) {
		return (List<ZStatisticsMngVo>)list(sqlMapNs+"getPrequery11List", reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getPrequery13List(ZStatisticsMngVo reqVo) {
		return (List<ZStatisticsMngVo>)list(sqlMapNs+"getPrequery13List", reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getDailyList(ZStatisticsMngVo reqVo) {
		return (List<ZStatisticsMngVo>)list(sqlMapNs+"getDailyList", reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getMonthlyList(ZStatisticsMngVo reqVo) {
		return (List<ZStatisticsMngVo>)list(sqlMapNs+"getMonthlyList", reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getConsultingList(ZStatisticsMngVo reqVo) {
		return (List<ZStatisticsMngVo>)list(sqlMapNs+"getConsultingList", reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getConsultingTypeList(ZStatisticsMngVo reqVo) {
		return (List<ZStatisticsMngVo>)list(sqlMapNs+"getConsultingTypeList", reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getReceivedTypeList(ZStatisticsMngVo reqVo) {
		return (List<ZStatisticsMngVo>)list(sqlMapNs+"getReceivedTypeList", reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getConsultingReqTypeList(ZStatisticsMngVo reqVo) {
		return (List<ZStatisticsMngVo>)list(sqlMapNs+"getConsultingReqTypeList", reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> geContactMethodTypeList(ZStatisticsMngVo reqVo) {
		return (List<ZStatisticsMngVo>)list(sqlMapNs+"getContactMethodTypeList", reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getClientGenderList(ZStatisticsMngVo reqVo) {
		return (List<ZStatisticsMngVo>)list(sqlMapNs+"getClientGenderList", reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getClientVictimRelTypeList(ZStatisticsMngVo reqVo) {
		return (List<ZStatisticsMngVo>)list(sqlMapNs+"getClientVictimRelTypeList", reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getVictimGenderTypeList(ZStatisticsMngVo reqVo) {
		return (List<ZStatisticsMngVo>)list(sqlMapNs+"getVictimGenderTypeList", reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getOffenderGenderTypeList(ZStatisticsMngVo reqVo) {
		return (List<ZStatisticsMngVo>)list(sqlMapNs+"getOffenderGenderTypeList", reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getOffenderVictimRelTypeList(ZStatisticsMngVo reqVo) {
		return (List<ZStatisticsMngVo>)list(sqlMapNs+"getOffenderVictimRelTypeList", reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getHarmFirstTypeList(ZStatisticsMngVo reqVo) {
		return (List<ZStatisticsMngVo>)list(sqlMapNs+"getHarmFirstTypeList", reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getHarmSecTypeList(ZStatisticsMngVo reqVo) {
		return (List<ZStatisticsMngVo>)list(sqlMapNs+"getHarmSecTypeList", reqVo);
	}
	
	@Override
	public List<ZStatisticsMngVo> getResponseTypeIntroOrgList(ZStatisticsMngVo reqVo) {
		return (List<ZStatisticsMngVo>)list(sqlMapNs+"getResponseTypeIntroOrgList", reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getResponseTypeServiceRelList(ZStatisticsMngVo reqVo) {
		return (List<ZStatisticsMngVo>)list(sqlMapNs+"getResponseTypeServiceRelList", reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getActionList(ZStatisticsMngVo reqVo) {
		return (List<ZStatisticsMngVo>)list(sqlMapNs+"getActionList", reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getActionTypeList(ZStatisticsMngVo reqVo) {
		return (List<ZStatisticsMngVo>)list(sqlMapNs+"getActionTypeList", reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getStepStatusList(ZStatisticsMngVo reqVo) {
		return (List<ZStatisticsMngVo>)list(sqlMapNs+"getStepStatusList", reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getActionConsultingTypeList(ZStatisticsMngVo reqVo) {
		return (List<ZStatisticsMngVo>)list(sqlMapNs+"getActionConsultingTypeList", reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getActionReceivedTypeList(ZStatisticsMngVo reqVo) {
		return (List<ZStatisticsMngVo>)list(sqlMapNs+"getActionReceivedTypeList", reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getActionClientGenderList(ZStatisticsMngVo reqVo) {
		return (List<ZStatisticsMngVo>)list(sqlMapNs+"getActionClientGenderList", reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getActionClientVictimRelTypeList(ZStatisticsMngVo reqVo) {
		return (List<ZStatisticsMngVo>)list(sqlMapNs+"getActionClientVictimRelTypeList", reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getOrgAccidentStepList(ZStatisticsMngVo reqVo) {
		return (List<ZStatisticsMngVo>)list(sqlMapNs+"getOrgAccidentStepList", reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getActionTypeOtherOrgList(ZStatisticsMngVo reqVo) {
		return (List<ZStatisticsMngVo>)list(sqlMapNs+"getActionTypeOtherOrgList", reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getActionTypeServiceRelList(ZStatisticsMngVo reqVo) {
		return (List<ZStatisticsMngVo>)list(sqlMapNs+"getActionTypeServiceRelList", reqVo);
	}

	@Override
	public List<ZStatisticsMngVo> getActionTypeContList(ZStatisticsMngVo reqVo) {
		return (List<ZStatisticsMngVo>)list(sqlMapNs+"getActionTypeContList", reqVo);
	}

}