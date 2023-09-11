package com.z5.zcms.admsys.module.service;

import java.util.List;

import org.springframework.ui.Model;

import com.z5.zcms.admsys.module.domain.ZSurveyHisVo;
import com.z5.zcms.admsys.module.domain.ZSurveyResultVo;
import com.z5.zcms.admsys.module.domain.ZSurveyVo;
import com.z5.zcms.util.DataTable;

public interface SurveyService {

	/*ZSurvey Line*/
	public List<ZSurveyVo> getSurveyList(ZSurveyVo zSurveyVo);
	public void surveyWrite(ZSurveyVo zSurveyVo);
	public int listCount(ZSurveyVo zSurveyVo);
	public Object surveyDetail(Object obj);
	public void surveyDelete(List<Integer> arrDeleteNo);
	public void surveyEdit(ZSurveyVo zSurveyVo);
	
	/*ZSurveyHis Line*/
	public List<ZSurveyHisVo> getSurveyHisList(ZSurveyVo zSurveyVo);
	public void surveyHisDelete(ZSurveyHisVo zSurveyHisVo);
	
	/*ZSurveyResult Line*/
	public Integer listCount(ZSurveyResultVo zSurveyResultVo);
	public List<ZSurveyResultVo> listSubject(ZSurveyResultVo zSurveyResultVo);
	public Model surveyResultWrite(Model model, DataTable input);
	
	public void surveyResultChangeDelete(ZSurveyResultVo zSurveyResultVo);
	public void surveyResultUpdate(ZSurveyResultVo zSurveyResultVo);
	

	public ZSurveyVo latestSurvey(ZSurveyVo zSurveyVo);
	
	public String getSurveyIdSeq();
	public ZSurveyVo getSurveyIdList(ZSurveyVo zSurveyVo);
	
}

