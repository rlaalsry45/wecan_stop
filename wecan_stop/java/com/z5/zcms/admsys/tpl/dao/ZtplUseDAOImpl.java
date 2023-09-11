package com.z5.zcms.admsys.tpl.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.tpl.domain.ZtplUseVo;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class ZtplUseDAOImpl extends EgovComAbstractDAO implements ZtplUseDAO{
	
	Logger log = Logger.getLogger(this.getClass());
	
	private final String sqlMapNs = "ztplUseDAO.";
	
	public void delete(List<Integer> arrDeleteNo){
        delete(sqlMapNs+"delete", arrDeleteNo);
    }
	
	public void deleteOfSite(ZtplUseVo vo){
        delete(sqlMapNs+"deleteOfSite", vo);
    }
	
	public Integer listCount(ZtplUseVo vo) {
		return (Integer) super.selectByPk(sqlMapNs+"listCount",vo);
	}
	
	public String insert(ZtplUseVo vo) {
        return (String)insert(sqlMapNs+"write", vo);
    }
}
