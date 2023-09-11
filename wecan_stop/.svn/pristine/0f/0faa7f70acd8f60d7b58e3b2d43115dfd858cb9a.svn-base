package com.z5.zcms.admsys.css.dao;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import com.z5.zcms.admsys.css.domain.ZcssVo;
import egovframework.com.cmm.service.impl.EgovComAbstractDAO;

@Repository
public class ZcssDAOImpl extends EgovComAbstractDAO implements ZcssDAO {
	
	Logger log = Logger.getLogger(this.getClass());
	
	private final String sqlMapNs = "zcssDAO.";
	
    public String insert(ZcssVo vo) {
        return (String)insert(sqlMapNs+"write", vo);
    }
    
	public Integer listCount(ZcssVo vo) {
		return (Integer) super.selectByPk(sqlMapNs+"listCount",vo);
	}
	
    public void delete(List<Integer> arrDeleteNo){
        delete(sqlMapNs+"delete", arrDeleteNo);
    }
	
    public ZcssVo selectbypk(ZcssVo vo){
        return (ZcssVo)getSqlMapClientTemplate().queryForObject(sqlMapNs+"selectbypk", vo); 
        		
    }
    
    public void update(ZcssVo vo){
        update(sqlMapNs+"update", vo);
    }
    
    @SuppressWarnings("unchecked")
	public List<ZcssVo> getlist(ZcssVo vo) {
		return (List<ZcssVo>) super.list(sqlMapNs+"list", vo);
	}
	
	@SuppressWarnings("unchecked")
	public List<ZcssVo> getlistAll(ZcssVo vo) {
		return (List<ZcssVo>) super.list(sqlMapNs+"listAll", vo);
	}
	
	@SuppressWarnings("unchecked")
	public List<ZcssVo> getListAllForUpdate(ZcssVo vo) {
		return (List<ZcssVo>) super.list(sqlMapNs+"getlistAllForUpdate", vo);
	}

}
