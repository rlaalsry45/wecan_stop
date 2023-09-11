package com.z5.zcms.admsys.prequery.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.module.domain.ZSurveyResultVo;
import com.z5.zcms.admsys.prequery.domain.PrequeryVO;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class PrequeryDAOImpl extends EgovComAbstractDAO implements PrequeryDAO{
	
	Logger log = Logger.getLogger(this.getClass());
	
	private final String sqlMapNs = "PrequeryDAO.";
	
	@Override
	public void insertPrequery(PrequeryVO prequeryVO) {
		insert(sqlMapNs+"insertPrequery",prequeryVO);
	}

	@Override
	public List<PrequeryVO> prequeryList(PrequeryVO prequeryVO) {
		 return (List<PrequeryVO>) list(sqlMapNs + "prequeryList", prequeryVO);
	}

	@Override
	public int listCount(PrequeryVO prequeryVO) {
		return (Integer) super.selectByPk(sqlMapNs + "listCount", prequeryVO);
	}

	@Override
	public PrequeryVO prequery(PrequeryVO prequeryVO) {
		return (PrequeryVO) select(sqlMapNs + "prequery", prequeryVO);
	}

	@Override
	public int getPrequeryCount(PrequeryVO prequeryVO) {
		return (Integer) super.selectByPk(sqlMapNs + "getPrequeryCount", prequeryVO);
	}
	
}
