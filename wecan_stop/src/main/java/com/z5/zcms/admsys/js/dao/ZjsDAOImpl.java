package com.z5.zcms.admsys.js.dao;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import com.z5.zcms.admsys.js.domain.ZjsVo;
import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class ZjsDAOImpl extends EgovComAbstractDAO implements ZjsDAO {
	
	Logger log = Logger.getLogger(this.getClass());
	
	private final String sqlMapNs = "zjsDAO.";
	
    public String insert(ZjsVo vo) {
        return (String)insert(sqlMapNs+"write", vo);
    }
    
	public Integer listCount(ZjsVo vo) {
		return (Integer) super.selectByPk(sqlMapNs+"listCount",vo);
	}
	
    public void delete(List<Integer> arrDeleteNo){
        delete(sqlMapNs+"delete", arrDeleteNo);
    }
	
    public ZjsVo selectbypk(ZjsVo vo){
        return (ZjsVo)getSqlMapClientTemplate().queryForObject(sqlMapNs+"selectbypk", vo); 
        		
    }
    
    public void update(ZjsVo vo){
        update(sqlMapNs+"update", vo);
    }
    
    @SuppressWarnings("unchecked")
	public List<ZjsVo> getlist(ZjsVo vo) {
		return (List<ZjsVo>) super.list(sqlMapNs+"list", vo);
	}
	
	@SuppressWarnings("unchecked")
	public List<ZjsVo> getlistAll(ZjsVo vo) {
		return (List<ZjsVo>) super.list(sqlMapNs+"listAll", vo);
	}

}
