package com.z5.zcms.admsys.zmainbanner.dao;

import java.util.List;

import com.z5.zcms.admsys.zmainbanner.domain.ZmainbannerVO;

public interface ZmainbannerDAO {
	public ZmainbannerVO selectbysiteno(int no);
	public void write(ZmainbannerVO zmainbannervo);
	public void insert(ZmainbannerVO zmainbannerVO);
	//public ZmainbannerVO getMaxno(ZmainbannerVO zmainbannerVO);
	public Integer listCount(ZmainbannerVO zmainbannerVO);
	public List<ZmainbannerVO> getList(ZmainbannerVO zmainbannerVO);
	public List<ZmainbannerVO> getListAll(ZmainbannerVO zmainbannerVO);
	public void update(ZmainbannerVO zmainbannerVO);
	public void delete(List<Integer> arrDeleteNo);
	public void updatemainbanner(ZmainbannerVO vo);
	public ZmainbannerVO selectbypk(int no);
	public List<ZmainbannerVO> list(ZmainbannerVO zmainbannerVO);
	public List<ZmainbannerVO> getlistCfg(ZmainbannerVO zmainbannerVO);
	public List<ZmainbannerVO> getzmainbannerfront(ZmainbannerVO zmainbannerVO);
	public void updateUpRank(ZmainbannerVO zmainbannerVO);
	public void updateDownRank(ZmainbannerVO zmainbannerVO);
	public void mobileinsert(ZmainbannerVO zmainbannerVO);
	public void mobileupdateView(ZmainbannerVO zmainbannerVO);
}
