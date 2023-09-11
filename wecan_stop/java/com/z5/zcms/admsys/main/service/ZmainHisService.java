package com.z5.zcms.admsys.main.service;

import java.util.List;

import com.z5.zcms.admsys.main.domain.ZmainHisVo;
import com.z5.zcms.admsys.main.domain.ZmainVo;


public interface ZmainHisService {
	List<ZmainHisVo> getList(ZmainHisVo vo) throws Exception;
	void insert(ZmainHisVo vo) throws Exception;
	ZmainVo selectbypk(ZmainHisVo vo) throws Exception;
	void delete(ZmainHisVo vo) throws Exception;
}
