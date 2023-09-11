package com.z5.zcms.admsys.module.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.module.domain.ZSurveyHisVo;
import com.z5.zcms.admsys.module.domain.ZSurveyVo;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class ZSurveyHisDAOImpl extends EgovComAbstractDAO implements ZSurveyHisDAO {

	private final String sqlMapNs = "ZSurveyHis.";
	
	@SuppressWarnings("unchecked")
	public List<ZSurveyHisVo> list(ZSurveyVo zSurveyVo) {
		//return this.getSqlMapClientTemplate().queryForList(sqlMapNs + "list", zSurveyVo);

		return (List<ZSurveyHisVo>) list(sqlMapNs + "list", zSurveyVo);
	}

	public ZSurveyHisVo detail(ZSurveyHisVo zSurveyHisVo) {
		return (ZSurveyHisVo)selectByPk(sqlMapNs + "getByPk", zSurveyHisVo);
	}
	public void insert(ZSurveyVo zSurveyVo)
	{
		insert(sqlMapNs + "insert", zSurveyVo);
	}
	public void delete(ZSurveyHisVo zSurveyHisVo)
	{
		insert(sqlMapNs + "delete", zSurveyHisVo);
	}
	public void surveyHisDelete(List<Integer> arrDeleteNo)
	{
		insert(sqlMapNs + "deleteMuti", arrDeleteNo);
	}

}