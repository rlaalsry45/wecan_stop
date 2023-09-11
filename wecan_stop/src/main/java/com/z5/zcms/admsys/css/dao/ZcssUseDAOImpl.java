package com.z5.zcms.admsys.css.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.css.domain.ZcssUseVo;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class ZcssUseDAOImpl extends EgovComAbstractDAO implements ZcssUseDAO {

	Logger log = Logger.getLogger(this.getClass());
	
	private final String sqlMapNs = "zcssUseDAO.";
	
	public void delete(List<Integer> arrDeleteNo){
        delete(sqlMapNs+"delete", arrDeleteNo);
    }
	
	public void deleteOfSite(ZcssUseVo vo){
        delete(sqlMapNs+"deleteOfSite", vo);
    }
	
	public Integer listCount(ZcssUseVo vo) {
		return (Integer) super.selectByPk(sqlMapNs+"listCount",vo);
	}
	
	public String insert(ZcssUseVo vo) {
        return (String)insert(sqlMapNs+"write", vo);
    }
}
