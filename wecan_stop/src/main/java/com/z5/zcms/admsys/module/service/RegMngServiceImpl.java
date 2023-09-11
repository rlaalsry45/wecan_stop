package com.z5.zcms.admsys.module.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.z5.zcms.admsys.module.dao.ZRegMngDAO;
import com.z5.zcms.admsys.module.domain.ZRegMngVo;

import egovframework.com.cmm.EgovMessageSource;
import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Service
@Transactional
public class RegMngServiceImpl extends AbstractServiceImpl implements RegMngService {

	@Autowired
	private ZRegMngDAO zRegMngDAO;
	@Autowired
	private EgovMessageSource egovMessageSource;
	
	@Transactional
	public void write(ZRegMngVo zRegMngVo) {
		zRegMngDAO.write(zRegMngVo);
	}

	public List<ZRegMngVo> list(ZRegMngVo zRegMngVo) {
		return zRegMngDAO.list(zRegMngVo);
	}

	public int listCount(ZRegMngVo zRegMngVo) {
		return zRegMngDAO.listCount(zRegMngVo);
	}
	
	public ZRegMngVo detail(ZRegMngVo zRegMngVo) {
		return zRegMngDAO.detail(zRegMngVo);
	}
	@Transactional
	public void delete(List<Integer> arrDeleteNo) {
		zRegMngDAO.delete(arrDeleteNo);
	}
}

