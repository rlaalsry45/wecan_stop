package com.z5.zcms.admsys.zmainbanner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.z5.zcms.admsys.common.domain.CommonVo;
import com.z5.zcms.admsys.zmainbanner.dao.ZmainbannerDAO;
import com.z5.zcms.admsys.zmainbanner.domain.ZmainbannerVO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service
public class ZmainbannerServiceImpl extends AbstractServiceImpl implements ZmainbannerService {

	@Autowired
	private ZmainbannerDAO zmainbannerDAO;
	 
	
	public ZmainbannerVO selectbysiteno(int no) throws Exception {
		ZmainbannerVO resultVO =zmainbannerDAO.selectbysiteno(no);
		return resultVO;
	}

	public void write(ZmainbannerVO zmainbannerVO) throws Exception {
		zmainbannerDAO.write(zmainbannerVO);
	}

	@Override
	public void insert(ZmainbannerVO zmainbannerVO) throws Exception {
		zmainbannerDAO.updateDownRank(zmainbannerVO);
		zmainbannerDAO.insert(zmainbannerVO); 
	}

/*	@Override
	public ZmainbannerVO getMaxno(ZmainbannerVO zmainbannerVO) {
		return (ZmainbannerVO) zmainbannerDAO.getMaxno(zmainbannerVO);
	}*/

	@Override
	public Integer listCount(ZmainbannerVO zmainbannerVO) {
		return this.zmainbannerDAO.listCount(zmainbannerVO);
	}

	@Override
	public List<ZmainbannerVO> getList(ZmainbannerVO zmainbannerVO) {
		return this.zmainbannerDAO.getList(zmainbannerVO);
	}

	@Override
	public void delete(List<Integer> arrDeleteNo) throws Exception {
		zmainbannerDAO.delete(arrDeleteNo);
	}

	@Override
	public List<ZmainbannerVO> getListAll(ZmainbannerVO zmainbannerVO) {
		return this.zmainbannerDAO.getListAll(zmainbannerVO);
	}

	@Override
	public void update(ZmainbannerVO zmainbannerVO) throws Exception {
		zmainbannerDAO.updateUpRank(zmainbannerVO);
		zmainbannerDAO.updateDownRank(zmainbannerVO);
		zmainbannerDAO.update(zmainbannerVO);  
	}
	
	@Override
	public void updaterank(ZmainbannerVO zmainbannerVO) throws Exception {
		zmainbannerDAO.updateUpRank(zmainbannerVO); 
	}

	@Override
	public ZmainbannerVO selectbypk(int no) {
		return (ZmainbannerVO)zmainbannerDAO.selectbypk(no);
	}

	@Override
	public List<ZmainbannerVO> getzmainbannerfront(ZmainbannerVO zmainbannerVO) {
		return zmainbannerDAO.getzmainbannerfront(zmainbannerVO);
	}

	@Override
	public List<ZmainbannerVO> getlistCfg(ZmainbannerVO zmainbannerVO) {
		return this.zmainbannerDAO.getlistCfg(zmainbannerVO);
	}

	@Override
	public void mobileinsert(ZmainbannerVO zmainbannerVO) throws Exception {
		zmainbannerDAO.mobileinsert(zmainbannerVO);
		
	}

	 
	

}
