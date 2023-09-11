package com.z5.zcms.admsys.prequery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.z5.zcms.admsys.prequery.dao.PrequeryDAO;
import com.z5.zcms.admsys.prequery.domain.PrequeryVO;

@Service
public class PrequeryServiceImpl implements PrequeryService{
	
	@Autowired
    private PrequeryDAO prequeryDAO;

	@Override
	public void insertPrequery(PrequeryVO prequeryVO) {
		prequeryDAO.insertPrequery(prequeryVO);
	}

	@Override
	public List<PrequeryVO> prequeryList(PrequeryVO prequeryVO) {
		return prequeryDAO.prequeryList(prequeryVO);
	}

	@Override
	public int listCount(PrequeryVO prequeryVO) {
		return prequeryDAO.listCount(prequeryVO);
	}

	@Override
	public PrequeryVO prequery(PrequeryVO prequeryVO) {
		return prequeryDAO.prequery(prequeryVO);
	}

	@Override
	public int getPrequeryCount(PrequeryVO prequeryVO) {
		return this.prequeryDAO.getPrequeryCount(prequeryVO);
	}
	
}
