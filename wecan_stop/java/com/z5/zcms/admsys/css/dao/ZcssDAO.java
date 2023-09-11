package com.z5.zcms.admsys.css.dao;

import java.util.List;

import com.z5.zcms.admsys.css.domain.ZcssVo;

public interface ZcssDAO {
	public String insert(ZcssVo vo);
    public void update(ZcssVo vo);
    public void delete(List<Integer> arrDeleteNo) ;
    public ZcssVo selectbypk(ZcssVo vo) ;
	public Integer listCount(ZcssVo vo);
	public List<ZcssVo> getlist(ZcssVo vo);
	public List<ZcssVo> getlistAll(ZcssVo vo);
	public List<ZcssVo> getListAllForUpdate(ZcssVo vo);
}
