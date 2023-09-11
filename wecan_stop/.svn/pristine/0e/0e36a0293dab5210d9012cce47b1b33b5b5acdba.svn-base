package com.z5.zcms.admsys.menu.service;

import java.util.List;

import com.z5.zcms.admsys.menu.domain.ZmenuHisVo;
import com.z5.zcms.admsys.menu.domain.ZmenuVo;


public interface ZmenuHisService {
	List<ZmenuHisVo> getList(ZmenuHisVo vo) throws Exception;
	void insert(ZmenuHisVo vo) throws Exception;
	ZmenuVo selectbypk(ZmenuHisVo vo) throws Exception;
	List<ZmenuHisVo> getHisListbySitenoAndMenuno(ZmenuHisVo vo) throws Exception;
	void delete(ZmenuHisVo vo) throws Exception;
	void deleteAll(List<String> vo) throws Exception;
	void deleteMenuWithSiteno(ZmenuHisVo vo);
}
