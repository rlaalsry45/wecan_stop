package com.z5.zcms.admsys.js.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.z5.zcms.admsys.js.domain.ZjsUseVo;
import com.z5.zcms.admsys.js.dao.ZjsUseDAO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Transactional
@Service
public class ZjsUseServiceImpl extends AbstractServiceImpl implements ZjsUseService{

	@Autowired
	private ZjsUseDAO zjsUseDAO;
	
	public void delete(List<Integer> arrDeleteNo) throws Exception {
		zjsUseDAO.delete(arrDeleteNo);
	}
	public Integer listCount(ZjsUseVo vo) {
		return this.zjsUseDAO.listCount(vo);
	}
	
	public void insert(ZjsUseVo vo) throws Exception {
    	zjsUseDAO.insert(vo);
    }
}
