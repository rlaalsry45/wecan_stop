package com.z5.zcms.admsys.tpl.service;

import java.util.List;

import com.z5.zcms.admsys.tpl.domain.ZtplVo;
import com.z5.zcms.admsys.tpl.domain.ZtplHisVo;

public interface ZtplHisService {
	List<ZtplHisVo> getList(ZtplHisVo vo) throws Exception;
	void insert(ZtplHisVo vo) throws Exception;
	ZtplVo selectbypk(ZtplHisVo vo) throws Exception;
	void delete(ZtplHisVo vo) throws Exception;
}
