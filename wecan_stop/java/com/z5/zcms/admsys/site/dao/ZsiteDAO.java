package com.z5.zcms.admsys.site.dao;

import java.util.List;
import java.util.Map;

import com.z5.zcms.admsys.site.domain.ZsiteVo;

public interface ZsiteDAO {
	public void batchDelete(List<ZsiteVo> dataList);

	public int copy(ZsiteVo vo);

	public void del(String no);

	public List<ZsiteVo> getlist(ZsiteVo vo);

	public List<ZsiteVo> getlistAll();
	
	public int dupCheck(String sitedomain);

	// public String insert(ZsiteVo vo);
	public Integer insert(ZsiteVo vo);

	public Integer listCount(ZsiteVo vo);

	public ZsiteVo selectbypk(ZsiteVo vo);

	public void update(ZsiteVo vo);
	
	public void updatedate(ZsiteVo vo);
	
	public int siteSwapNum(Map<String, String> map);
	
	public void siteOrder(Map<String, String> map);
}
