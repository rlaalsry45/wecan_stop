package com.z5.zcms.admsys.main.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.main.domain.ZmainVo;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class ZmainDAOImpl extends EgovComAbstractDAO implements ZmainDAO {
	
	Logger log = Logger.getLogger(this.getClass());
	
	private final String sqlMapNs = "zmainDAO.";
	
    public String insert(ZmainVo vo) {
        return (String)insert(sqlMapNs+"write", vo);
    }
    
	public Integer listCount(ZmainVo vo) {
		return (Integer) super.selectByPk(sqlMapNs+"listCount",vo);
	}
	
    public void delete(List<Integer> arrDeleteNo){
        delete(sqlMapNs+"delete", arrDeleteNo);
    }
	
    public ZmainVo selectbypk(ZmainVo vo){
        return (ZmainVo)getSqlMapClientTemplate().queryForObject(sqlMapNs+"selectbypk", vo); 
        		
    }
    
	public ZmainVo selectbyfk(ZmainVo vo){
    	return (ZmainVo)getSqlMapClientTemplate().queryForObject(sqlMapNs+"selectbyfk", vo); 
    	
    }
    
    public void update(ZmainVo vo){
        update(sqlMapNs+"update", vo);
    }
    
    @SuppressWarnings("unchecked")
	public List<ZmainVo> getlist(ZmainVo vo) {
		return (List<ZmainVo>) super.list(sqlMapNs+"list", vo);
	}
	
	@SuppressWarnings("unchecked")
	public List<ZmainVo> getlistAll(ZmainVo vo) {
		return (List<ZmainVo>) super.list(sqlMapNs+"listAll", vo);
	}

	@SuppressWarnings("unchecked")
	public List<ZmainVo> getlistCfg(ZmainVo vo) {
		return (List<ZmainVo>) super.list(sqlMapNs+"listCfg", vo);
	}
	
    public void updatesiteno(ZmainVo vo){
        update(sqlMapNs+"updatesiteno", vo);
    }
    
    public void updatesitetitle(ZmainVo vo){
    	update(sqlMapNs+"updatesitetitle", vo);
    }

	public ZmainVo getMaxno(ZmainVo vo) {

		return (ZmainVo)getSqlMapClientTemplate().queryForObject(sqlMapNs+"getMaxno", vo);
	}

	public int getMaxMainno(int mainno) {
		return (Integer) super.selectByPk(sqlMapNs+"getMaxmainno", mainno);
	}
}
