package com.z5.zcms.admsys.css.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.z5.zcms.admsys.css.dao.ZcssUseDAO;
import com.z5.zcms.admsys.css.domain.ZcssUseVo;

import egovframework.rte.fdl.cmmn.AbstractServiceImpl;

@Transactional
@Service
public class ZcssUseServiceImpl extends AbstractServiceImpl implements ZcssUseService{

	@Autowired
	private ZcssUseDAO zcssUseDAO;
	
	public void delete(List<Integer> arrDeleteNo) throws Exception {
		zcssUseDAO.delete(arrDeleteNo);
	}
	
	public Integer listCount(ZcssUseVo vo) {
		return this.zcssUseDAO.listCount(vo);
	}
	
	public void insert(ZcssUseVo vo) throws Exception {
    	//log.debug(vo.toString());
    	zcssUseDAO.insert(vo);
    }
}
