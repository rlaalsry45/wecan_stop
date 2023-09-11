package com.z5.zcms.admsys.tpl.dao;

import java.util.List;

import com.z5.zcms.admsys.tpl.domain.ZtplVo;

public interface ZtplDAO  {

    public String insert(ZtplVo vo);
    public void update(ZtplVo vo);
    public void delete(List<Integer> arrDeleteTplNo) ;
    public ZtplVo selectbypk(ZtplVo vo) ;
	public Integer listCount(ZtplVo vo);
	public List<ZtplVo> getlist(ZtplVo vo);
	public List<ZtplVo> getlistAll(ZtplVo vo);
	public ZtplVo selectbyTitleAndPosition(ZtplVo vo);
}
