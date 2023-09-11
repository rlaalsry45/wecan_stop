package com.z5.zcms.admsys.js.service;

import java.util.List;

import com.z5.zcms.admsys.js.domain.ZjsHisVo;
import com.z5.zcms.admsys.js.domain.ZjsVo;


public interface ZjsHisService {
	List<ZjsHisVo> getList(ZjsHisVo vo) throws Exception;
	void insert(ZjsHisVo vo) throws Exception;
	ZjsVo selectbypk(ZjsHisVo vo) throws Exception;
	void delete(ZjsHisVo vo) throws Exception;
}
