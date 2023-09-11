package com.z5.zcms.admsys.js.dao;

import java.util.List;

import org.apache.log4j.Logger;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.js.domain.ZjsUseVo;

@Repository
public class ZjsUseDAOImpl extends EgovComAbstractDAO implements ZjsUseDAO {

	Logger log = Logger.getLogger(this.getClass());
	
	private final String sqlMapNs = "zjsUseDAO.";
	
	public void delete(List<Integer> arrDeleteNo){
        delete(sqlMapNs+"delete", arrDeleteNo);
    }
	public void deleteOfSite(ZjsUseVo vo){
        delete(sqlMapNs+"deleteOfSite", vo);
    }
	
	public Integer listCount(ZjsUseVo vo) {
		return (Integer) super.selectByPk(sqlMapNs+"listCount",vo);
	}
	
	public String insert(ZjsUseVo vo) {
        return (String)insert(sqlMapNs+"write", vo);
    }
}
