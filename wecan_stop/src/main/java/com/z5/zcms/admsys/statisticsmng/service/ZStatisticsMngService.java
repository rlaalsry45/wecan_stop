package com.z5.zcms.admsys.statisticsmng.service;

import java.util.List;

import com.z5.zcms.admsys.statisticsmng.domain.ZStatisticsMngVo;

public interface ZStatisticsMngService {
	
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
	
	public List<ZStatisticsMngVo> getDailyList(ZStatisticsMngVo reqVo) throws Exception;
	public List<ZStatisticsMngVo> getMonthlyList(ZStatisticsMngVo reqVo) throws Exception;
	public List<ZStatisticsMngVo> getConsultingList(ZStatisticsMngVo reqVo) throws Exception;
	public List<ZStatisticsMngVo> getConsultingTypeList(ZStatisticsMngVo reqVo) throws Exception;
	public List<ZStatisticsMngVo> getReceivedTypeList(ZStatisticsMngVo reqVo) throws Exception;
	public List<ZStatisticsMngVo> getConsultingReqTypeList(ZStatisticsMngVo reqVo) throws Exception;
	public List<ZStatisticsMngVo> geContactMethodTypeList(ZStatisticsMngVo reqVo) throws Exception;
	public List<ZStatisticsMngVo> getClientGenderList(ZStatisticsMngVo reqVo) throws Exception;
	public List<ZStatisticsMngVo> getClientVictimRelTypeList(ZStatisticsMngVo reqVo) throws Exception;
	public List<ZStatisticsMngVo> getVictimGenderTypeList(ZStatisticsMngVo reqVo) throws Exception;
	public List<ZStatisticsMngVo> getOffenderGenderTypeList(ZStatisticsMngVo reqVo) throws Exception;
	public List<ZStatisticsMngVo> getOffenderVictimRelTypeList(ZStatisticsMngVo reqVo) throws Exception;
	public List<ZStatisticsMngVo> getHarmFirstTypeList(ZStatisticsMngVo reqVo) throws Exception;
	public List<ZStatisticsMngVo> getHarmSecTypeList(ZStatisticsMngVo reqVo) throws Exception;
	public List<ZStatisticsMngVo> getResponseTypeIntroOrgList(ZStatisticsMngVo reqVo) throws Exception;
	public List<ZStatisticsMngVo> getResponseTypeServiceRelList(ZStatisticsMngVo reqVo) throws Exception;
	public List<ZStatisticsMngVo> getActionList(ZStatisticsMngVo reqVo) throws Exception;
	public List<ZStatisticsMngVo> getActionTypeList(ZStatisticsMngVo reqVo) throws Exception;
	public List<ZStatisticsMngVo> getStepStatusList(ZStatisticsMngVo reqVo) throws Exception;
	public List<ZStatisticsMngVo> getActionConsultingTypeList(ZStatisticsMngVo reqVo) throws Exception;
	public List<ZStatisticsMngVo> getActionReceivedTypeList(ZStatisticsMngVo reqVo) throws Exception;
	public List<ZStatisticsMngVo> getActionClientGenderList(ZStatisticsMngVo reqVo) throws Exception;
	public List<ZStatisticsMngVo> getActionClientVictimRelTypeList(ZStatisticsMngVo reqVo) throws Exception;
	public List<ZStatisticsMngVo> getOrgAccidentStepList(ZStatisticsMngVo reqVo) throws Exception;
	public List<ZStatisticsMngVo> getActionTypeOtherOrgList(ZStatisticsMngVo reqVo) throws Exception;
	public List<ZStatisticsMngVo> getActionTypeServiceRelList(ZStatisticsMngVo reqVo) throws Exception;
	public List<ZStatisticsMngVo> getActionTypeContList(ZStatisticsMngVo reqVo) throws Exception;
}
