package com.z5.zcms.admsys.main.service;

import java.util.List;

import com.z5.zcms.admsys.main.domain.ZmainVo;

public interface ZmainService {

	void insert(ZmainVo vo) throws Exception;
    void update(ZmainVo vo) throws Exception;
    void delete(List<Integer> arrDeleteNo) throws Exception;
    ZmainVo selectbypk(ZmainVo vo) throws Exception;
    ZmainVo selectbyfk(ZmainVo vo) throws Exception;
    public Integer listCount(ZmainVo vo);
	List<ZmainVo> getList(ZmainVo vo);
	List<ZmainVo> getListAll(ZmainVo vo);
	List<ZmainVo> getListCfg(ZmainVo vo);
    void updatesiteno(ZmainVo vo) throws Exception;
    void updatesitetitle(ZmainVo vo) throws Exception;
	ZmainVo getMaxno(ZmainVo zmainVo);
	int getMaxMainno(int mainno) throws Exception;
}
