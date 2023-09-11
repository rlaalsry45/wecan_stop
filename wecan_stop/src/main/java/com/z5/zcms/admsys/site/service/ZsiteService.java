package com.z5.zcms.admsys.site.service;

import com.z5.zcms.admsys.site.domain.ZsiteVo;

import java.util.List;
import java.util.Map;

public interface ZsiteService {

    public void batchDelete(List<ZsiteVo> dataList);

    public int copy(ZsiteVo vo);

    public void delete(String no);

    public List<ZsiteVo> getList(ZsiteVo vo);

    public List<ZsiteVo> getListAll();

    public int dupCheck(String sitedomain);

    public void insert(ZsiteVo vo);

    public int listCount(ZsiteVo vo);

    public ZsiteVo selectbypk(ZsiteVo vo);

    public void update(ZsiteVo vo);

    public void updatedate(ZsiteVo vo);

    public int siteSwapNum(Map<String, String> map);

    public void siteOrder(Map<String, String> map);
}
