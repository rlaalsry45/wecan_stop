package com.z5.zcms.admsys.tpl.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.z5.zcms.admsys.tpl.domain.ZtplVo;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;


@Repository
public class ZtplDAOImpl extends EgovComAbstractDAO implements ZtplDAO{

	Logger log = Logger.getLogger(this.getClass());
	
	private final String sqlMapNs = "ztplDAO.";
	
    public String insert(ZtplVo vo) {
        return (String)insert(sqlMapNs+"write", vo);
    }
	
	public Integer listCount(ZtplVo vo) {
		return (Integer) super.selectByPk(sqlMapNs+"listCount",vo);
	}
	
    public void delete(List<Integer> arrDeleteNo){
        delete(sqlMapNs+"delete", arrDeleteNo);
    }
	
    public ZtplVo selectbypk(ZtplVo vo){
        return (ZtplVo)getSqlMapClientTemplate().queryForObject(sqlMapNs+"selectbypk", vo); 
        		
    }
    
    public void update(ZtplVo vo){
        update(sqlMapNs+"update", vo);
    }

    
   	@SuppressWarnings("unchecked")
   	public List<ZtplVo> getlist(ZtplVo vo) {
   		return (List<ZtplVo>) super.list(sqlMapNs+"list", vo);
   	}
   	
    
   	@SuppressWarnings("unchecked")
   	public List<ZtplVo> getlistAll(ZtplVo vo) {
   		return (List<ZtplVo>) super.list(sqlMapNs+"listAll", vo);
   	}

	public ZtplVo selectbyTitleAndPosition(ZtplVo vo) {
		// TODO Auto-generated method stub
		return (ZtplVo)getSqlMapClientTemplate().queryForObject(sqlMapNs+"selectbyTitleAndPosition", vo); 
	}


	


}
