package com.z5.zcms.admsys.site.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.z5.zcms.admsys.site.dao.ZsiteDAO;
import com.z5.zcms.admsys.site.domain.ZsiteVo;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Transactional
@Service
public class ZsiteServiceImpl extends AbstractServiceImpl implements
		ZsiteService {

	@Autowired
	private ZsiteDAO zsiteDAO;

	public void delete(String no) {
		zsiteDAO.del(no);
	}

	public List<ZsiteVo> getList(ZsiteVo vo) {
		return zsiteDAO.getlist(vo);
	}
	
	public List<ZsiteVo> getListAll() {
		return zsiteDAO.getlistAll();
	}
	
	public int dupCheck(String sitedomain){
		return zsiteDAO.dupCheck(sitedomain);
	}

	public void batchDelete(List<ZsiteVo> dataList) {
		zsiteDAO.batchDelete(dataList);
	}

	public void insert(ZsiteVo vo) {
		zsiteDAO.insert(vo);
	}
	
	public int copy(ZsiteVo vo) {
		return zsiteDAO.copy(vo);
	}

	public int listCount(ZsiteVo vo) {
		return zsiteDAO.listCount(vo);
	}

	public ZsiteVo selectbypk(ZsiteVo vo) {
		return zsiteDAO.selectbypk(vo);
	}

	public void update(ZsiteVo vo) {
		zsiteDAO.update(vo);
	}
	
	public void updatedate(ZsiteVo vo) {
		zsiteDAO.updatedate(vo);
	}
	
	public int siteSwapNum(Map<String, String> map) {
		return zsiteDAO.siteSwapNum(map);
	}
	
	public void siteOrder(Map<String, String> map) {
		zsiteDAO.siteOrder(map);
	}
}