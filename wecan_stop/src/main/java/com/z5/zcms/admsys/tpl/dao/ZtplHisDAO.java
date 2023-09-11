package com.z5.zcms.admsys.tpl.dao;

import java.util.List;

import com.z5.zcms.admsys.tpl.domain.ZtplVo;
import com.z5.zcms.admsys.tpl.domain.ZtplHisVo;

public interface ZtplHisDAO {
	public List<ZtplHisVo> getlist(ZtplHisVo vo);
	public String insert(ZtplHisVo vo);
	public ZtplVo selectbypk(ZtplHisVo vo) ;
	public void delete(ZtplHisVo vo);
}
