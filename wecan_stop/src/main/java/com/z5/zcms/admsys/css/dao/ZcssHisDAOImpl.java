package com.z5.zcms.admsys.css.dao;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.css.domain.ZcssHisVo;
import com.z5.zcms.admsys.css.domain.ZcssVo;
import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class ZcssHisDAOImpl extends EgovComAbstractDAO implements ZcssHisDAO{

	Logger log = Logger.getLogger(this.getClass());
	
	private final String sqlMapNs = "zcssHisDAO.";
	
	//list
		@SuppressWarnings("unchecked")
		public List<ZcssHisVo> getlist(ZcssHisVo vo) {
			return (List<ZcssHisVo>) super.list(sqlMapNs+"list", vo);
		}
		
		public String insert(ZcssHisVo vo) {
	        return (String)insert(sqlMapNs+"write", vo);
	    }
		
		public ZcssVo selectbypk(ZcssHisVo vo){
	        return (ZcssVo)getSqlMapClientTemplate().queryForObject(sqlMapNs+"selectbypk", vo); 
	    }

		public void delete(ZcssHisVo vo) {
			delete(sqlMapNs+"delete", vo);
		}
		
}
