package com.z5.zcms.admsys.tpl.dao;

import java.util.List;

import com.z5.zcms.admsys.tpl.domain.ZtplUseVo;

public interface ZtplUseDAO {
	public void delete(List<Integer> arrDeleteNo) ;
	public void deleteOfSite(ZtplUseVo vo);
	public Integer listCount(ZtplUseVo vo);
	public String insert(ZtplUseVo vo);
}
