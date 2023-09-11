package com.z5.zcms.admsys.main.dao;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.main.domain.ZmainHisVo;
import com.z5.zcms.admsys.main.domain.ZmainVo;
import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class ZmainHisDAOImpl extends EgovComAbstractDAO implements ZmainHisDAO{

	Logger log = Logger.getLogger(this.getClass());
	
	private final String sqlMapNs = "zmainHisDAO.";
	
	//list
		@SuppressWarnings("unchecked")
		public List<ZmainHisVo> getlist(ZmainHisVo vo) {
			return (List<ZmainHisVo>) super.list(sqlMapNs+"list", vo);
		}
		
		public String insert(ZmainHisVo vo) {
	        return (String)insert(sqlMapNs+"write", vo);
	    }
		
		public ZmainVo selectbypk(ZmainHisVo vo){
	        return (ZmainVo)getSqlMapClientTemplate().queryForObject(sqlMapNs+"selectbypk", vo); 
	    }

		public void delete(ZmainHisVo vo) {
			delete(sqlMapNs+"delete", vo);
		}
		
}
