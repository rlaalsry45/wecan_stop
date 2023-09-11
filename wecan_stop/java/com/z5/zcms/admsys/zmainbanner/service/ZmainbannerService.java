package com.z5.zcms.admsys.zmainbanner.service;

import java.util.List;

import com.z5.zcms.admsys.zmainbanner.domain.ZmainbannerVO;

public interface ZmainbannerService {
	ZmainbannerVO selectbysiteno(int num) throws Exception;
	void write(ZmainbannerVO zmainbannerVO) throws Exception;
	void insert(ZmainbannerVO zmainbannerVO) throws Exception;
	//ZmainbannerVO getMaxno(ZmainbannerVO zmainbannerVO);
	Integer listCount(ZmainbannerVO zmainbannerVO);
	List<ZmainbannerVO> getList(ZmainbannerVO zmainbannerVO);
	void delete(List<Integer> arrDeleteNo) throws Exception;
	List<ZmainbannerVO> getListAll(ZmainbannerVO zmainbannerVO);
	void update(ZmainbannerVO zmainbannerVO) throws Exception;
	ZmainbannerVO selectbypk(int no);
	List<ZmainbannerVO> getlistCfg(ZmainbannerVO zmainbannerVO);
	List<ZmainbannerVO> getzmainbannerfront(ZmainbannerVO zmainbannerVO);
	void updaterank(ZmainbannerVO zmainbannerVO) throws Exception;
	void mobileinsert(ZmainbannerVO zmainbannerVO) throws Exception;
	 
}
