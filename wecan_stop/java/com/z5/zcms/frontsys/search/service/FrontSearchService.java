package com.z5.zcms.frontsys.search.service;

import java.util.List;

import com.z5.zcms.frontsys.search.domain.FrontSearchVO;

public interface FrontSearchService {
	
	int getSearchListCount(FrontSearchVO vo) throws Exception;
	List<FrontSearchVO> selectSearchList(FrontSearchVO vo)  throws Exception;
}