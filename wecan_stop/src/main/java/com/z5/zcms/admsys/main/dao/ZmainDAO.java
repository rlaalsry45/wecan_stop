package com.z5.zcms.admsys.main.dao;

import java.util.List;

import com.z5.zcms.admsys.main.domain.ZmainVo;

public interface ZmainDAO {
	public String insert(ZmainVo vo);
    public void update(ZmainVo vo);
    public void delete(List<Integer> arrDeleteNo) ;
    public ZmainVo selectbypk(ZmainVo vo) ;
    public ZmainVo selectbyfk(ZmainVo vo) ;
	public Integer listCount(ZmainVo vo);
	public List<ZmainVo> getlist(ZmainVo vo);
	public List<ZmainVo> getlistAll(ZmainVo vo);
	public List<ZmainVo> getlistCfg(ZmainVo vo);
    public void updatesiteno(ZmainVo vo);
    public void updatesitetitle(ZmainVo vo);
	public ZmainVo getMaxno(ZmainVo vo);
	public int getMaxMainno(int mainno);
}
