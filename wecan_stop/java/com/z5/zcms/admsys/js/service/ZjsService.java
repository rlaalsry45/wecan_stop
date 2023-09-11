package com.z5.zcms.admsys.js.service;

import java.util.List;

import com.z5.zcms.admsys.js.domain.ZjsVo;

public interface ZjsService {

	void insert(ZjsVo vo) throws Exception;
    void update(ZjsVo vo) throws Exception;
    void delete(List<Integer> arrDeleteNo) throws Exception;
    ZjsVo selectbypk(ZjsVo vo) throws Exception;
    public Integer listCount(ZjsVo vo);
	List<ZjsVo> getList(ZjsVo vo);
	List<ZjsVo> getListAll(ZjsVo vo);
	
}
