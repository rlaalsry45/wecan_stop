package com.z5.zcms.admsys.module.dao;

import java.util.List;

import com.z5.zcms.admsys.module.domain.ZSurveyResultVo;

public interface ZSurveyResultDAO {

	public int listCount(ZSurveyResultVo zSurveyResultVo);
	public List<ZSurveyResultVo> listSubject(ZSurveyResultVo zSurveyResultVo);
	public void surveyResultDelete(List<Integer> arrDeleteNo);
	public void surveyResultWrite(ZSurveyResultVo zSurveyResultVo);
	public void surveyResultTotalUpdate(ZSurveyResultVo zSurveyResultVo);
	
	public void surveyResultChangeDelete(ZSurveyResultVo zSurveyResultVo);
	public void surveyResultUpdate(ZSurveyResultVo zSurveyResultVo);
	
	
}