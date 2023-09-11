package com.z5.zcms.admsys.js.dao;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.js.domain.ZjsHisVo;
import com.z5.zcms.admsys.js.domain.ZjsVo;
import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class ZjsHisDAOImpl extends EgovComAbstractDAO implements ZjsHisDAO{

	Logger log = Logger.getLogger(this.getClass());
	
	private final String sqlMapNs = "zjsHisDAO.";
	
	//list
		@SuppressWarnings("unchecked")
		public List<ZjsHisVo> getlist(ZjsHisVo vo) {
			return (List<ZjsHisVo>) super.list(sqlMapNs+"list", vo);
		}
		
		public String insert(ZjsHisVo vo) {
	        return (String)insert(sqlMapNs+"write", vo);
	    }
		
		public ZjsVo selectbypk(ZjsHisVo vo){
	        return (ZjsVo)getSqlMapClientTemplate().queryForObject(sqlMapNs+"selectbypk", vo); 
	    }

		public void delete(ZjsHisVo vo) {
			delete(sqlMapNs+"delete", vo);
		}
		
}
