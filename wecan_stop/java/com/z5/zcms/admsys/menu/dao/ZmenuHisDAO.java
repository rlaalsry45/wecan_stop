package com.z5.zcms.admsys.menu.dao;

import java.util.List;

import com.z5.zcms.admsys.menu.domain.ZmenuHisVo;
import com.z5.zcms.admsys.menu.domain.ZmenuVo;


public interface ZmenuHisDAO {
	public List<ZmenuHisVo> getlist(ZmenuHisVo vo);
	public String insert(ZmenuHisVo vo);
	public ZmenuVo selectbypk(ZmenuHisVo vo) ;
	public List<ZmenuHisVo> getHisListbySitenoAndMenuno(ZmenuHisVo vo) ;
	public void delete(ZmenuHisVo vo);
	public void deleteAll(List<String> vo);
	public void deleteMenuWithSiteno(ZmenuHisVo vo);
	public Integer historylistCount(ZmenuHisVo vo);
	public List<ZmenuHisVo> historylist(ZmenuHisVo vo);
}
