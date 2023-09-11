package com.z5.zcms.frontsys.search.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.z5.zcms.frontsys.search.dao.FrontSearchDAO;
import com.z5.zcms.frontsys.search.domain.FrontSearchVO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service
public class FrontSearchServiceImpl extends AbstractServiceImpl implements FrontSearchService{
	
	@Autowired
	private FrontSearchDAO frontSearchDAO;
	
	
	@Override
	public  int getSearchListCount(FrontSearchVO vo) throws Exception{
		return this.frontSearchDAO.getSearchListCount(vo);		
	}
	
	
	@Override
	public List<FrontSearchVO> selectSearchList(FrontSearchVO vo) throws Exception{
		return this.frontSearchDAO.selectSearchList(vo);
	}
	

	
}