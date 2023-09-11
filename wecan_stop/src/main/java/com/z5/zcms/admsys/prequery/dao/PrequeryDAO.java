package com.z5.zcms.admsys.prequery.dao;

import java.util.List;

import com.z5.zcms.admsys.prequery.domain.PrequeryVO;

public interface PrequeryDAO {

	public void insertPrequery(PrequeryVO prequeryVO);
	public List<PrequeryVO> prequeryList(PrequeryVO prequeryVO);
	public int listCount(PrequeryVO prequeryVO);
	public PrequeryVO prequery(PrequeryVO prequeryVO);
	public int getPrequeryCount(PrequeryVO prequeryVO);
}
