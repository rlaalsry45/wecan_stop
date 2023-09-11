package com.z5.zcms.admsys.module.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.module.domain.ZSurveyResultVo;
import com.z5.zcms.admsys.module.domain.ZSurveyVo;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class ZSurveyResultDAOImpl extends EgovComAbstractDAO implements ZSurveyResultDAO {

	//@Autowired
	//private ZSurveyVo zSurveyVo;
	
	Logger log = Logger.getLogger(this.getClass());
	
	private final String sqlMapNs = "ZSurveyResult.";

	public int listCount(ZSurveyResultVo zSurveyResultVo) {
		return (Integer) super.selectByPk(sqlMapNs + "listCount", zSurveyResultVo);
	}
	
	@SuppressWarnings("unchecked")
	public List<ZSurveyResultVo> listSubject(ZSurveyResultVo zSurveyResultVo) {
		return (List<ZSurveyResultVo>) super.list(sqlMapNs + "listSubject", zSurveyResultVo);
	}

	public void surveyResultDelete(List<Integer> arrDeleteNo) {
		delete(sqlMapNs + "surveyResultDelete", arrDeleteNo);
	}
	
	public void surveyResultWrite(ZSurveyResultVo zSurveyResultVo) {
		insert(sqlMapNs + "surveyResultWrite",  zSurveyResultVo);
	}
	
	public void surveyResultTotalUpdate(ZSurveyResultVo zSurveyResultVo) {
		delete(sqlMapNs + "surveyResultTotalUpdate",  zSurveyResultVo);
	}
	
	public void surveyResultChangeDelete(ZSurveyResultVo zSurveyResultVo) {
		delete(sqlMapNs + "surveyResultChangeDelete",  zSurveyResultVo);
	}
	public void surveyResultUpdate(ZSurveyResultVo zSurveyResultVo) {
		update(sqlMapNs + "surveyResultUpdate",  zSurveyResultVo);
	}

	@Override
	public List<ZSurveyResultVo> surveyResultList(ZSurveyResultVo zSurveyResultVo) {
		 return (List<ZSurveyResultVo>) list(sqlMapNs + "surveyResultList", zSurveyResultVo);
	}

	@Override
	public int resultListCount(ZSurveyResultVo zSurveyResultVo) {
		return (Integer) super.selectByPk(sqlMapNs + "resultListCount", zSurveyResultVo);
	}

	@Override
	public ZSurveyResultVo surveyResult(ZSurveyResultVo zSurveyResultVo) {
		return (ZSurveyResultVo) select(sqlMapNs + "surveyResult", zSurveyResultVo);
	}
	

}