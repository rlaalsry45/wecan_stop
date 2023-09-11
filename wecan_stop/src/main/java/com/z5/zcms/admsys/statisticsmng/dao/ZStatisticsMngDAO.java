package com.z5.zcms.admsys.statisticsmng.dao;

import java.util.List;

import com.z5.zcms.admsys.statisticsmng.domain.ZStatisticsMngVo;

public interface ZStatisticsMngDAO {

	public ZStatisticsMngVo getMonthCounsel(ZStatisticsMngVo reqVo);
	public ZStatisticsMngVo getMonthAction(ZStatisticsMngVo reqVo);
	public ZStatisticsMngVo getYearCounsel(ZStatisticsMngVo reqVo);
	public ZStatisticsMngVo getClientVictimRelType(ZStatisticsMngVo reqVo);
	public ZStatisticsMngVo getActionTypeServiceRel(ZStatisticsMngVo reqVo);
	public ZStatisticsMngVo getYearActionTypeServiceRel(ZStatisticsMngVo reqVo);

	public ZStatisticsMngVo getActionCode(ZStatisticsMngVo reqVo);
	public ZStatisticsMngVo getStep8ActionCode(ZStatisticsMngVo reqVo);
	public ZStatisticsMngVo getOrgType(ZStatisticsMngVo reqVo);
	public ZStatisticsMngVo getStep8OrgType(ZStatisticsMngVo reqVo);
	public ZStatisticsMngVo getOrgTypeGovDetail(ZStatisticsMngVo reqVo);
	public ZStatisticsMngVo getStep8OrgTypeGovDetail(ZStatisticsMngVo reqVo);
	public ZStatisticsMngVo getHamType(ZStatisticsMngVo reqVo);
	public ZStatisticsMngVo getConsultingType(ZStatisticsMngVo reqVo);
	public ZStatisticsMngVo getWeekActionTypeCont(ZStatisticsMngVo reqVo);
	public ZStatisticsMngVo getYearActionTypeCont(ZStatisticsMngVo reqVo);
	public ZStatisticsMngVo getMasterActionTypeServiceRel(ZStatisticsMngVo reqVo);
	public ZStatisticsMngVo getHistoryActionTypeServiceRel(ZStatisticsMngVo reqVo);
	
	public ZStatisticsMngVo getSatisfaction(ZStatisticsMngVo reqVo);
	
	public List<ZStatisticsMngVo> getSatisfaction1OpinionList(ZStatisticsMngVo reqVo);
	public List<ZStatisticsMngVo> getSatisfaction2OpinionList(ZStatisticsMngVo reqVo);
	public List<ZStatisticsMngVo> getSatisfaction3OpinionList(ZStatisticsMngVo reqVo);
	public List<ZStatisticsMngVo> getSatisfaction4OpinionList(ZStatisticsMngVo reqVo);
	public List<ZStatisticsMngVo> getSatisfaction5OpinionList(ZStatisticsMngVo reqVo);
	public List<ZStatisticsMngVo> getSatisfaction6OpinionList(ZStatisticsMngVo reqVo);
	public List<ZStatisticsMngVo> getSatisfaction7OpinionList(ZStatisticsMngVo reqVo);
	public List<ZStatisticsMngVo> getSatisfaction8OpinionList(ZStatisticsMngVo reqVo);
	public List<ZStatisticsMngVo> getSatisfaction9List(ZStatisticsMngVo reqVo);

	public ZStatisticsMngVo getSurvey(ZStatisticsMngVo reqVo);

	public List<ZStatisticsMngVo> getSurvey7OpinionList(ZStatisticsMngVo reqVo);
	public List<ZStatisticsMngVo> getSurvey7_1_1OpinionList(ZStatisticsMngVo reqVo);
	public List<ZStatisticsMngVo> getSurvey7_2_1OpinionList(ZStatisticsMngVo reqVo);
	public List<ZStatisticsMngVo> getSurvey10OpinionList(ZStatisticsMngVo reqVo);
	public List<ZStatisticsMngVo> getSurvey11OpinionList(ZStatisticsMngVo reqVo);
	public List<ZStatisticsMngVo> getSurvey12OpinionList(ZStatisticsMngVo reqVo);
	public List<ZStatisticsMngVo> getSurvey13OpinionList(ZStatisticsMngVo reqVo);
	
	public ZStatisticsMngVo getPrequery(ZStatisticsMngVo reqVo);
	
	public List<ZStatisticsMngVo> getPrequery2_8OpinionList(ZStatisticsMngVo reqVo);
	public List<ZStatisticsMngVo> getPrequery4List(ZStatisticsMngVo reqVo);
	public List<ZStatisticsMngVo> getPrequery5_8OpinionList(ZStatisticsMngVo reqVo);
	public List<ZStatisticsMngVo> getPrequery6_1_7OpinionList(ZStatisticsMngVo reqVo);
	public List<ZStatisticsMngVo> getPrequery6_2_6OpinionList(ZStatisticsMngVo reqVo);
	public List<ZStatisticsMngVo> getPrequery6_2_1_6OpinionList(ZStatisticsMngVo reqVo);
	public List<ZStatisticsMngVo> getPrequery6_3_3OpinionList(ZStatisticsMngVo reqVo);
	public List<ZStatisticsMngVo> getPrequery7_4OpinionList(ZStatisticsMngVo reqVo);
	public List<ZStatisticsMngVo> getPrequery9List(ZStatisticsMngVo reqVo);
	public List<ZStatisticsMngVo> getPrequery10List(ZStatisticsMngVo reqVo);
	public List<ZStatisticsMngVo> getPrequery11List(ZStatisticsMngVo reqVo);
	public List<ZStatisticsMngVo> getPrequery13List(ZStatisticsMngVo reqVo);
	
	public List<ZStatisticsMngVo> getDailyList(ZStatisticsMngVo reqVo);
	public List<ZStatisticsMngVo> getMonthlyList(ZStatisticsMngVo reqVo);
	public List<ZStatisticsMngVo> getConsultingList(ZStatisticsMngVo reqVo);
	public List<ZStatisticsMngVo> getConsultingTypeList(ZStatisticsMngVo reqVo);
	public List<ZStatisticsMngVo> getReceivedTypeList(ZStatisticsMngVo reqVo);
	public List<ZStatisticsMngVo> getConsultingReqTypeList(ZStatisticsMngVo reqVo);
	public List<ZStatisticsMngVo> geContactMethodTypeList(ZStatisticsMngVo reqVo);
	public List<ZStatisticsMngVo> getClientGenderList(ZStatisticsMngVo reqVo);
	public List<ZStatisticsMngVo> getClientVictimRelTypeList(ZStatisticsMngVo reqVo);
	public List<ZStatisticsMngVo> getVictimGenderTypeList(ZStatisticsMngVo reqVo);
	public List<ZStatisticsMngVo> getOffenderGenderTypeList(ZStatisticsMngVo reqVo);
	public List<ZStatisticsMngVo> getOffenderVictimRelTypeList(ZStatisticsMngVo reqVo);
	public List<ZStatisticsMngVo> getHarmFirstTypeList(ZStatisticsMngVo reqVo);
	public List<ZStatisticsMngVo> getHarmSecTypeList(ZStatisticsMngVo reqVo);
	public List<ZStatisticsMngVo> getResponseTypeIntroOrgList(ZStatisticsMngVo reqVo);
	public List<ZStatisticsMngVo> getResponseTypeServiceRelList(ZStatisticsMngVo reqVo);
	public List<ZStatisticsMngVo> getActionList(ZStatisticsMngVo reqVo);
	public List<ZStatisticsMngVo> getActionTypeList(ZStatisticsMngVo reqVo);
	public List<ZStatisticsMngVo> getStepStatusList(ZStatisticsMngVo reqVo);
	public List<ZStatisticsMngVo> getActionConsultingTypeList(ZStatisticsMngVo reqVo);
	public List<ZStatisticsMngVo> getActionReceivedTypeList(ZStatisticsMngVo reqVo);
	public List<ZStatisticsMngVo> getActionClientGenderList(ZStatisticsMngVo reqVo);
	public List<ZStatisticsMngVo> getActionClientVictimRelTypeList(ZStatisticsMngVo reqVo);
	public List<ZStatisticsMngVo> getOrgAccidentStepList(ZStatisticsMngVo reqVo);
	public List<ZStatisticsMngVo> getActionTypeOtherOrgList(ZStatisticsMngVo reqVo);
	public List<ZStatisticsMngVo> getActionTypeServiceRelList(ZStatisticsMngVo reqVo);
	public List<ZStatisticsMngVo> getActionTypeContList(ZStatisticsMngVo reqVo);
	
}