package com.z5.zcms.admsys.tpl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.z5.zcms.admsys.tpl.domain.ZtplUseVo;
import com.z5.zcms.admsys.tpl.dao.ZtplUseDAO;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Transactional
@Service
public class ZtplUseServiceImpl extends AbstractServiceImpl implements ZtplUseService{

	@Autowired
	private ZtplUseDAO ztplUseDAO;
	
	
	public void delete(List<Integer> arrDeleteNo) throws Exception {
		ztplUseDAO.delete(arrDeleteNo);
	}
	
	public Integer listCount(ZtplUseVo vo) {
		return this.ztplUseDAO.listCount(vo);
	}
	
	public void insert(ZtplUseVo vo) throws Exception {
    	ztplUseDAO.insert(vo);
    }

}
