package com.z5.zcms.admsys.module.dao;

import java.util.List;

import com.z5.zcms.admsys.module.domain.ZSurveyVo;

public interface ZSurveyDAO {

	public List<ZSurveyVo> list(ZSurveyVo zSurveyVo);
	public void surveyWrite(ZSurveyVo zSurveyVo);
	public int listCount(ZSurveyVo zSurveyVo);
	public ZSurveyVo detail(ZSurveyVo zSurveyVo);
	public void surveyDelete(List<Integer> arrDeleteNo);
	public void surveyUseDelete(List<Integer> arrDeleteNo);
	public void update(ZSurveyVo zSurveyVo);
	public ZSurveyVo latestSurvey(ZSurveyVo zSurveyVo);

	public String getSurveyIdSeq();
	public ZSurveyVo getSurveyIdList(ZSurveyVo zSurveyVo);
}