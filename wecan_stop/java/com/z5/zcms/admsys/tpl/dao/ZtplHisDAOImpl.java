package com.z5.zcms.admsys.tpl.dao;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.tpl.domain.ZtplVo;
import com.z5.zcms.admsys.tpl.domain.ZtplHisVo;
import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class ZtplHisDAOImpl extends EgovComAbstractDAO implements ZtplHisDAO{

	Logger log = Logger.getLogger(this.getClass());
	
	private final String sqlMapNs = "ztplHisDAO.";
	
	//list
	@SuppressWarnings("unchecked")
	public List<ZtplHisVo> getlist(ZtplHisVo vo) {
		return (List<ZtplHisVo>) super.list(sqlMapNs+"list", vo);
	}
	
	public String insert(ZtplHisVo vo) {
        return (String)insert(sqlMapNs+"write", vo);
    }
	
	public ZtplVo selectbypk(ZtplHisVo vo){
        return (ZtplVo)getSqlMapClientTemplate().queryForObject(sqlMapNs+"selectbypk", vo); 
    }

	public void delete(ZtplHisVo vo) {
		delete(sqlMapNs+"delete", vo);
	}

}
