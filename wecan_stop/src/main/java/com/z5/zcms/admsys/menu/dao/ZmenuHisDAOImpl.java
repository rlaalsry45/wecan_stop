package com.z5.zcms.admsys.menu.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.menu.domain.ZmenuHisVo;
import com.z5.zcms.admsys.menu.domain.ZmenuVo;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class ZmenuHisDAOImpl extends EgovComAbstractDAO implements ZmenuHisDAO{

	Logger log = Logger.getLogger(this.getClass());
	
	private final String sqlMapNs = "zmenuHisDAO.";
	
	//list
		@SuppressWarnings("unchecked")
		public List<ZmenuHisVo> getlist(ZmenuHisVo vo) {
			return (List<ZmenuHisVo>) super.list(sqlMapNs+"list", vo);
		}
		
		public String insert(ZmenuHisVo vo) {
	        return (String)insert(sqlMapNs+"write", vo);
	    }
		
		public ZmenuVo selectbypk(ZmenuHisVo vo){
	        return (ZmenuVo)getSqlMapClientTemplate().queryForObject(sqlMapNs+"selectbypk", vo); 
	    }
		
		@SuppressWarnings("unchecked")
		public List<ZmenuHisVo> getHisListbySitenoAndMenuno(ZmenuHisVo vo){
	        return (List<ZmenuHisVo>) super.list(sqlMapNs+"getHisListbySitenoAndMenuno", vo); 
	    }

		public void delete(ZmenuHisVo vo) {
			delete(sqlMapNs+"delete", vo);
		}
		
		public void deleteAll(List<String> arrDeleteNo) {
			delete(sqlMapNs+"deleteAll", arrDeleteNo);
		}
		
		public void deleteMenuWithSiteno(ZmenuHisVo vo) {
			delete(sqlMapNs+"deleteMenuWithSiteno", vo);
		}
		
		public Integer historylistCount(ZmenuHisVo vo) {
			return (Integer) super.selectByPk(sqlMapNs+"historylistCount",vo);
		}
		@SuppressWarnings("unchecked")
		public List<ZmenuHisVo> historylist(ZmenuHisVo vo) {
			return (List<ZmenuHisVo>) super.list(sqlMapNs+"historylist", vo);
		}
		
}
