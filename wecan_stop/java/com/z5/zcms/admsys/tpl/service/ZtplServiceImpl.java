package com.z5.zcms.admsys.tpl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.z5.zcms.admsys.tpl.dao.ZtplDAO;
import com.z5.zcms.admsys.tpl.domain.ZtplVo;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Transactional
@Service
public class ZtplServiceImpl extends AbstractServiceImpl implements ZtplService {

	@Autowired
	private ZtplDAO ztplDAO;

	public void delete(List<Integer> arrDeleteTplNo) throws Exception {
		ztplDAO.delete(arrDeleteTplNo);
	}

	public List<ZtplVo> getList(ZtplVo vo) {
		return ztplDAO.getlist(vo);
	}

	public List<ZtplVo> getListAll(ZtplVo vo) {
		return ztplDAO.getlistAll(vo);
	}

	public void insert(ZtplVo vo) throws Exception {
		ztplDAO.insert(vo);
	}

	public Integer listCount(ZtplVo vo) {
		return ztplDAO.listCount(vo);
	}

	public ZtplVo selectbypk(ZtplVo vo) throws Exception {
		final ZtplVo resultVO = ztplDAO.selectbypk(vo);
		if (resultVO == null)
			throw processException("info.nodata.msg");
		return resultVO;
	}

	public void update(ZtplVo vo) throws Exception {
		ztplDAO.update(vo);
	}

	public ZtplVo selectbyTitleAndPosition(ZtplVo vo) {
		return (ZtplVo)ztplDAO.selectbyTitleAndPosition(vo);
	}
	
	

}
